package com.e.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String bank_name = "銀行";
    private int gMapZoom = 2;
    private WebView gWebView;
    public static String MAP_URL = null;
    LocationManager locationManager;
    public static final int MY_PERMISSION_ACCESS_COARSE_LOCATION = 11;

    private String commanStr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWebView();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        commanStr = LocationManager.GPS_PROVIDER;

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(commanStr, 1000, 0, locationListener);
        Location location = locationManager.getLastKnownLocation(commanStr);
        MAP_URL = "https://www.google.com.tw/maps/search/" + bank_name + "/@" + location.getLatitude() + "," + location.getLongitude() + ",12z/data=!3m1!4b1?hl=zh-TW";
        gWebView.loadUrl(MAP_URL);
    }

    public LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            MAP_URL = "https://www.google.com.tw/maps/search/" + bank_name + "/@" + location.getLatitude() + "," + location.getLongitude() + ",12z/data=!3m1!4b1?hl=zh-TW";
            gWebView.loadUrl(MAP_URL);
        }
    };


    private void setupWebView(){
        final String centerURL = "javascript:initialize();"
                + "centerAt(" + -34.397 + "," + 150.644 + ");"
                + "map.setZoom(" + gMapZoom + ");";

        gWebView = (WebView)findViewById(R.id.webview);

        // JavaScript 啟用
        gWebView.getSettings().setJavaScriptEnabled(true);

        gWebView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

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