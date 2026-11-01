package com.hesabati.app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends Activity {
    WebView w;
    protected void onCreate(Bundle b){
        super.onCreate(b);
        w=new WebView(this);
        w.getSettings().setJavaScriptEnabled(true);
        w.getSettings().setDomStorageEnabled(true);
        w.setWebViewClient(new WebViewClient());
        w.loadUrl("file:///android_asset/index.html");
        setContentView(w);
    }
    public void onBackPressed(){ if(w.canGoBack()) w.goBack(); else super.onBackPressed(); }
}
