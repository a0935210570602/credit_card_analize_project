package com.example.credit_card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity_Show_Result extends AppCompatActivity {

    Toolbar toolbartab;
    ViewPager viewPager;
    TabLayout tabLayout;
    ImageView img1, img2, img3, img4;
    Handler handler;
    Runnable runnable;
    PageAdapter pageAdapter;

//    ArrayList<Map<String, String>> credit_list = new ArrayList<Map<String, String>>();
//    Map<String, String> credit_card= new HashMap<>();
//
//    Bundle bundle1 = new Bundle();
//    Bundle bundle2 = new Bundle();
//    Bundle bundle3 = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__show__result);

        toolbartab = findViewById(R.id.toolbartab);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);

        reference();
    }

    public void reference() {
        viewPager.removeAllViewsInLayout();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                pageAdapter = new PageAdapter(getSupportFragmentManager());
                pageAdapter.addFragment(new Top1Fragment(), "Top1");
                pageAdapter.addFragment(new Top2Fragment(), "Top2");
                pageAdapter.addFragment(new Top3Fragment(), "Top3");

                viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

                viewPager.setAdapter(pageAdapter);

                tabLayout.setupWithViewPager(viewPager);
            }
        };
        handler.post(runnable);
    }

    public void chart(){
        handler = new Handler();
        final GlobalVariable credit_data = (GlobalVariable)getApplicationContext();
        runnable = new Runnable() {
            @Override
            public void run() {
                histogramFragment his = new histogramFragment();
                his.getData(credit_data);
                pieChartFragment pie = new  pieChartFragment();
                pie.getData(credit_data);
                pageAdapter = new PageAdapter(getSupportFragmentManager());
                pageAdapter.addFragment(pie, "圓餅圖");
                pageAdapter.addFragment(his, "直方圖");

                viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
                viewPager.setAdapter(pageAdapter);

                tabLayout.setupWithViewPager(viewPager);
            }
        };
        handler.post((runnable));
    }

    public void showInfo(){
        viewPager.removeAllViewsInLayout();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                pageAdapter = new PageAdapter(getSupportFragmentManager());
                pageAdapter.addFragment(new infoFragment(), "卡卡神探製作團隊");

                viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

                viewPager.setAdapter(pageAdapter);

                tabLayout.setupWithViewPager(viewPager);
            }
        };
        handler.post(runnable);
    }

    public void btn1(View view){
        if (handler != null) {
            handler.removeCallbacks(runnable);
            viewPager.removeAllViewsInLayout();
            reference();
            img1.setEnabled(false);
            img2.setEnabled(true);
            img3.setEnabled(true);
        }
    }
    public void btn2(View view){
        if (handler != null) {
            handler.removeCallbacks(runnable);
            chart();
            img1.setEnabled(true);
            img2.setEnabled(false);
            img3.setEnabled(true);
        }
    }
    public void btn3(View view){
        if (handler != null) {
            handler.removeCallbacks(runnable);
            showInfo();
            img1.setEnabled(true);
            img2.setEnabled(true);
            img3.setEnabled(false);
        }
    }
    public void btn4(View view){
        if (handler != null) {
            handler.removeCallbacks(runnable);
            startActivity(new Intent(MainActivity_Show_Result.this, MainActivity.class));
            MainActivity_Show_Result.this.finish();
        }
    }
}