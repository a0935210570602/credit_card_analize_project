package com.e.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private  static String location = "匯豐銀行";
    private static final String MAP_URL = "https://www.google.com.tw/maps/search/" +location + "/@25.0461016,121.5255809,15z/data=!3m1!4b1?hl=zh-TW";
    private int      gMapZoom = 8;
    private WebView gWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWebView();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void setupWebView(){
        final String centerURL = "javascript:initialize();"
                + "centerAt(" + -34.397 + "," + 150.644 + ");"
                + "map.setZoom(" + gMapZoom + ");";

        gWebView = (WebView)findViewById(R.id.webview);

        // JavaScript 啟用
        gWebView.getSettings().setJavaScriptEnabled(true);

        // 網頁執行完成後, 接著要執行的網頁 (也可是 JavaScript)
        gWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url){
                view.loadUrl(centerURL);
            }
        });

        gWebView.loadUrl(MAP_URL);
    }
}