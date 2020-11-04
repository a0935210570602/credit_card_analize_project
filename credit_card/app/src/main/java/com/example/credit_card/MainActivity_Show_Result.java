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


//        credit_card.put("銀行", "花旗銀行");
//        credit_card.put("信用卡名", "現金回饋PLUS卡");
//        credit_card.put("使用人數", "100000");
////        credit_card.put("回饋點數", "0");
////        credit_card.put("回饋現金(國內)", "2%");
////        credit_card.put("回饋現金(國外)", "0.5%");
////        credit_card.put("年費", "-1");
//        credit_card.put("圖片", String.valueOf(R.drawable.card_01));
//        credit_card.put("星星", String.valueOf(R.drawable.star5));
//        credit_list.add(credit_card);
//
//        credit_card = new HashMap<>();
//        credit_card.put("銀行", "滙豐銀行");
//        credit_card.put("信用卡名", "現金回饋御璽卡");
//        credit_card.put("使用人數", "78000");
////        credit_card.put("回饋點數", "0");
////        credit_card.put("回饋現金(國內)", "1.22%");
////        credit_card.put("回饋現金(國外)", "2.22%");
////        credit_card.put("年費", "-1"); //首年免年費"
//        credit_card.put("圖片", String.valueOf(R.drawable.card_02));
//        credit_card.put("星星", String.valueOf(R.drawable.star5));
//        credit_list.add(credit_card);
//
//        credit_card = new HashMap<>();
//        credit_card.put("銀行", "中國信託");
//        credit_card.put("信用卡名", "TAIPEI_101_夜光聯名卡");
//        credit_card.put("使用人數", "10000");
////        credit_card.put("回饋點數", "0");
////        credit_card.put("回饋現金(國內)", "2%");
////        credit_card.put("回饋現金(國外)", "0.5%");
////        credit_card.put("年費", "-1");
//        credit_card.put("圖片", String.valueOf(R.drawable.card_03));
//        credit_card.put("星星", String.valueOf(R.drawable.star4));
//        credit_list.add(credit_card);
//
//
//        credit_card = new HashMap<>();
//        credit_card.put("銀行", "國泰世華");
//        credit_card.put("信用卡名", "蝦皮購物聯名卡");
//        credit_card.put("使用人數", "7600");
////        credit_card.put("回饋點數", "0");
////        credit_card.put("回饋現金(國內)", "0.5%");
////        credit_card.put("回饋現金(國外)", "0.5%");
////        credit_card.put("年費", "-1");
//        credit_card.put("圖片", String.valueOf(R.drawable.card_04));
//        credit_card.put("星星", String.valueOf(R.drawable.star2));
//        credit_list.add(credit_card);
//
//        credit_card = new HashMap<>();
//        credit_card.put("銀行", "台灣樂天");
//        credit_card.put("信用卡名", "樂天信用卡");
//        credit_card.put("使用人數", "70000");
////        credit_card.put("回饋點數", "0");
////        credit_card.put("回饋現金(國內)", "1.25%");
////        credit_card.put("回饋現金(國外)", "0%");
////        credit_card.put("年費", "0");
//        credit_card.put("圖片", String.valueOf(R.drawable.card_05));
//        credit_card.put("星星", String.valueOf(R.drawable.star4));
//        credit_list.add(credit_card);
//
//        bundle1.putString("index", "0");
//        bundle2.putString("index", "1");
//        bundle3.putString("index", "2");



        reference();

    }

    public void reference() {
        viewPager.removeAllViewsInLayout();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                pageAdapter = new PageAdapter(getSupportFragmentManager());

                pageAdapter.addFragment(new Top1Fragment(), "No1");
                pageAdapter.addFragment(new Top2Fragment(), "No2");
                pageAdapter.addFragment(new Top3Fragment(), "No3");

                viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

                viewPager.setAdapter(pageAdapter);

                tabLayout.setupWithViewPager(viewPager);
            }
        };
        handler.post(runnable);
    }

    public void chart(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                pageAdapter = new PageAdapter(getSupportFragmentManager());
                pageAdapter.addFragment(new pieChartFragment(), "圓餅圖");
                pageAdapter.addFragment(new histogramFragment(), "直方圖");

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