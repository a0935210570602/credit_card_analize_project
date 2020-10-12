package com.example.credit_card;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Info extends AppCompatActivity {

    ArrayList<Map<String, String>> credit_list = new ArrayList<Map<String, String>>();
    Map<String, String> credit_card= new HashMap<>();
    TextView show_info;
    ImageView card_sample;
    Button back;
    LinearLayout se_li;
    ArrayList<String> say_array = new ArrayList<String>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        back = findViewById(R.id.back);
        String ti = "匿名：";
        Intent intent = getIntent();
        String card_num = intent.getStringExtra("index");

        credit_card.put("銀行", "花旗銀行");
        credit_card.put("信用卡名", "現金回饋PLUS卡");
        credit_card.put("回饋點數", "0");
        credit_card.put("回饋現金(國內)", "2%");
        credit_card.put("回饋現金(國外)", "0.5%");
        credit_card.put("年費", "0");
        credit_card.put("圖片", String.valueOf(R.drawable.card_01));
        credit_card.put("星星", String.valueOf(R.drawable.star5));
        credit_list.add(credit_card);

        credit_card = new HashMap<>();
        credit_card.put("銀行", "滙豐銀行");
        credit_card.put("信用卡名", "現金回饋御璽卡");
        credit_card.put("回饋點數", "0");
        credit_card.put("回饋現金(國內)", "1.22%");
        credit_card.put("回饋現金(國外)", "2.22%");
        credit_card.put("年費", "0"); //首年免年費"
        credit_card.put("圖片", String.valueOf(R.drawable.card_02));
        credit_card.put("星星", String.valueOf(R.drawable.star4));
        credit_list.add(credit_card);

        credit_card = new HashMap<>();
        credit_card.put("銀行", "中國信託");
        credit_card.put("信用卡名", "TAIPEI_101_夜光聯名卡");
        credit_card.put("回饋點數", "0");
        credit_card.put("回饋現金(國內)", "2%");
        credit_card.put("回饋現金(國外)", "0.5%");
        credit_card.put("年費", "0");
        credit_card.put("圖片", String.valueOf(R.drawable.card_03));
        credit_card.put("星星", String.valueOf(R.drawable.star5));
        credit_list.add(credit_card);


        credit_card = new HashMap<>();
        credit_card.put("銀行", "國泰世華");
        credit_card.put("信用卡名", "蝦皮購物聯名卡");
        credit_card.put("回饋點數", "0");
        credit_card.put("回饋現金(國內)", "0.5%");
        credit_card.put("回饋現金(國外)", "0.5%");
        credit_card.put("年費", "0");
        credit_card.put("圖片", String.valueOf(R.drawable.card_04));
        credit_card.put("星星", String.valueOf(R.drawable.star3));
        credit_list.add(credit_card);

        credit_card = new HashMap<>();
        credit_card.put("銀行", "台灣樂天");
        credit_card.put("信用卡名", "樂天信用卡");
        credit_card.put("回饋點數", "0");
        credit_card.put("回饋現金(國內)", "1.25%");
        credit_card.put("回饋現金(國外)", "0%");
        credit_card.put("年費", "0");
        credit_card.put("圖片", String.valueOf(R.drawable.card_05));
        credit_card.put("星星", String.valueOf(R.drawable.star1));
        credit_list.add(credit_card);

        show_info = findViewById(R.id.showInfo);
        card_sample = findViewById(R.id.card_sample);

        card_sample.setImageResource(Integer.parseInt(credit_list.get(Integer.parseInt(card_num)).get("圖片")));
        card_sample.setAdjustViewBounds(true);
        card_sample.setMaxHeight(400);
        card_sample.setMaxWidth(600);
        show_info.setTextColor(Color.parseColor("#000000"));
        show_info.setText("銀行：" + credit_list.get(Integer.parseInt(card_num)).get("銀行") + "\n" +
                          "信用卡名：" + credit_list.get(Integer.parseInt(card_num)).get("信用卡名") + "\n" +
                          "國內現金回饋：" + credit_list.get(Integer.parseInt(card_num)).get("回饋現金(國內)") + "\n" +
                          "國外現金回饋：" + credit_list.get(Integer.parseInt(card_num)).get("回饋現金(國外)") + "\n" +
                          "年費：" + credit_list.get(Integer.parseInt(card_num)).get("年費"));
        se_li = (LinearLayout)findViewById(R.id.see_li);

        say_array.add("這張卡真划算！");
        say_array.add("感謝神探讓我買到好卡！");
        say_array.add("其實這張卡沒有想像中好用");
        say_array.add("他的年費其實有點高");
        say_array.add("自從有了這張卡，我快樂似神仙");
        say_array.add("上個月才刷了50000元，好爽:)");
        say_array.add("謝謝神探");
        say_array.add("謝謝神探");
        say_array.add("謝謝神探");
        say_array.add("謝謝神探");
        say_array.add("這張卡好好用，推薦給大家");
        TextView tv =new TextView(this);
        tv.setTextSize(50);
        tv.setTextColor(Color.parseColor("#006030"));
        tv.setWidth(350);   //設定寬度
        tv.setHeight(400);
        tv.setGravity(Gravity.CENTER);
        tv.setText("評論專區\n------------------------------------".replace("\"", ""));
        se_li.addView(tv);
        for(int i=0;i<say_array.size();i++){
            TextView tv1 =new TextView(this);
            tv1.setTextSize(30);
            tv1.setTextColor(Color.parseColor("#019858"));
            tv1.setWidth(350);   //設定寬度
            tv1.setHeight(240);
            tv1.setGravity(Gravity.CENTER);
            tv1.setText(ti + say_array.get(i).replace("\"", ""));
            se_li.addView(tv1);

        }
    }
    public void eraser(View view){
        EditText et = (EditText)findViewById(R.id.editTextTextPersonName);
        et.setText("");
    }
    public void goback(View view){
        finish();
    }
}