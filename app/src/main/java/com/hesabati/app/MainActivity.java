package com.hesabati.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);
    }

    @Override
    public void onBackPressed() {
        if (webView != null) {
            webView.evaluateJavascript("window.handleAndroidBack ? handleAndroidBack().toString() : 'false'", value -> {
                // value = "true" اذا تم الرجوع داخل التطبيق، "false" اذا وصلنا للرئيسية
                String cleanValue = value.replace("\"", "");
                if (cleanValue.equals("false")) {
                    // في الصفحة الرئيسية، اغلق التطبيق
                    MainActivity.super.onBackPressed();
                }
                // اذا true، لا نغلق، تم الرجوع داخل index.html
            });
        } else {
            super.onBackPressed();
        }
    }
}
