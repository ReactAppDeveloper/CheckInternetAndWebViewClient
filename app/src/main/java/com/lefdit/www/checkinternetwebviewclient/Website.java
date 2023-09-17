package com.lefdit.www.checkinternetwebviewclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Website extends AppCompatActivity {

    String url="http://www.lefdit.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website);

        WebView siteview=(WebView)findViewById(R.id.webView);

        siteview.getSettings().setJavaScriptEnabled(true);
        siteview.getSettings().setLoadWithOverviewMode(true);
        siteview.getSettings().setUseWideViewPort(true);

        siteview.setWebViewClient(new MywebViewClient());

        siteview.loadUrl(url);


    }



    private class MywebViewClient extends WebViewClient {
        @Override
        public  boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
}
