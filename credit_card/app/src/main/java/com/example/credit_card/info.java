package com.example.credit_card;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class info extends AppCompatActivity {

    ArrayList<Map<String, String>> credit_list = new ArrayList<Map<String, String>>();
    Map<String, String> credit_card= new HashMap<>();

    TextView show_info;
    ImageView card_sample;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String card_num = bundle.getString("index");

        credit_card.put("銀行", "花旗銀行");
        credit_card.put("信用卡名", "現金回饋PLUS卡");
        credit_card.put("回饋點數", "0");
        credit_card.put("回饋現金(國內)", "2%");
        credit_card.put("回饋現金(國外)", "0.5%");
        credit_card.put("年費", "-1");
        credit_card.put("圖片", String.valueOf(R.drawable.card_01));
        credit_card.put("星星", String.valueOf(R.drawable.star5));
        credit_list.add(credit_card);

        credit_card = new HashMap<>();
        credit_card.put("銀行", "滙豐銀行");
        credit_card.put("信用卡名", "現金回饋御璽卡");
        credit_card.put("回饋點數", "0");
        credit_card.put("回饋現金(國內)", "1.22%");
        credit_card.put("回饋現金(國外)", "2.22%");
        credit_card.put("年費", "-1"); //首年免年費"
        credit_card.put("圖片", String.valueOf(R.drawable.card_02));
        credit_card.put("星星", String.valueOf(R.drawable.star4));
        credit_list.add(credit_card);

        credit_card = new HashMap<>();
        credit_card.put("銀行", "中國信託");
        credit_card.put("信用卡名", "TAIPEI_101_夜光聯名卡");
        credit_card.put("回饋點數", "0");
        credit_card.put("回饋現金(國內)", "2%");
        credit_card.put("回饋現金(國外)", "0.5%");
        credit_card.put("年費", "-1");
        credit_card.put("圖片", String.valueOf(R.drawable.card_03));
        credit_card.put("星星", String.valueOf(R.drawable.star5));
        credit_list.add(credit_card);


        credit_card = new HashMap<>();
        credit_card.put("銀行", "國泰世華");
        credit_card.put("信用卡名", "蝦皮購物聯名卡");
        credit_card.put("回饋點數", "0");
        credit_card.put("回饋現金(國內)", "0.5%");
        credit_card.put("回饋現金(國外)", "0.5%");
        credit_card.put("年費", "-1");
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
        show_info.setText("銀行 " + credit_list.get(Integer.parseInt(card_num)).get("銀行") + "\n" +
                          "信用卡名 " + credit_list.get(Integer.parseInt(card_num)).get("信用卡名") + "\n" +
                          "國內現金回饋 " + credit_list.get(Integer.parseInt(card_num)).get("回饋現金(國內)") + "\n" +
                          "國外現金回饋 " + credit_list.get(Integer.parseInt(card_num)).get("回饋現金(國外)") + "\n" +
                          "年費 " + credit_list.get(Integer.parseInt(card_num)).get("年費"));

    }
}