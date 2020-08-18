package com.example.credit_card;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;
import static java.lang.System.out;

public class fake_data extends AppCompatActivity {

    Spinner spinner;
    Button showMe;
    ImageView showCard;
    TextView cardInfo;

    Map<String, String> credit_card1 = new HashMap<>();
    Map<String, String> credit_card2 = new HashMap<>();
    Map<String, String> credit_card3 = new HashMap<>();
    Map<String, String> credit_card4 = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fake_layout);

        credit_card1.put("銀行", "花旗銀行");
        credit_card1.put("信用卡名", "現金回饋PLUS卡");
        credit_card1.put("回饋點數", "");
        credit_card1.put("回饋現金(國內)", "2%");
        credit_card1.put("回饋現金(國外)", "0.5%");
        credit_card1.put("年費", "首年免年費");
//     credit_card.put("食", "合作廠商");
//     credit_card.put("住", "合作網站");
//     credit_card.put("交通", "搭乘工具");
//     credit_card.put("線上購物", "");

        credit_card2.put("銀行", "滙豐銀行");
        credit_card2.put("信用卡名", "現金回饋御璽卡");
        credit_card2.put("回饋點數", "");
        credit_card2.put("回饋現金(國內)", "1.22%");
        credit_card2.put("回饋現金(國外)", "2.22%");
        credit_card2.put("年費", "首年免年費");

        credit_card3.put("銀行", "中國信託");
        credit_card3.put("信用卡名", "TAIPEI_101_夜光聯名卡");
        credit_card3.put("回饋點數", "");
        credit_card3.put("回饋現金(國內)", "2%");
        credit_card3.put("回饋現金(國外)", "0.5%");
        credit_card3.put("年費", "首年免年費");

        credit_card4.put("銀行", "國泰世華");
        credit_card4.put("信用卡名", "蝦皮購物聯名卡");
        credit_card4.put("回饋點數", "");
        credit_card4.put("回饋現金(國內)", "0.5%");
        credit_card4.put("回饋現金(國外)", "0.5%");
        credit_card4.put("年費", "首年免年費");

        Map<String, String> credit_card5 = new HashMap<>();
        credit_card5.put("銀行", "台灣樂天");
        credit_card5.put("信用卡名", "樂天信用卡");
        credit_card5.put("回饋點數", "");
        credit_card5.put("回饋現金(國內)", "1.25%");
        credit_card5.put("回饋現金(國外)", "0%");
        credit_card5.put("年費", "0");

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(fake_data.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.options));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        showMe = findViewById(R.id.showbutton);
        showCard = findViewById(R.id.showCard);
        cardInfo = findViewById(R.id.cardInfo);
    }

    public void showMe(View v){
        if(spinner.getSelectedItemPosition()==0){
            showCard.setImageResource(R.drawable.white);
            cardInfo.setText("請先選擇分類主題");
        }
        else if(spinner.getSelectedItemPosition()==1) {
            showCard.setImageResource(R.drawable.card_01);
            cardInfo.setText("銀行 " + credit_card1.get("銀行") +"\n"+
                    "信用卡名 " + credit_card1.get("信用卡名") +"\n"+
                    "國內現金回饋 " + credit_card1.get("回饋現金(國內)") + "\n"+
                    "國外現金回饋 " + credit_card1.get("回饋現金(國外)") + "\n"+
                    "年費 " + credit_card1.get("年費"));
        }
        else if(spinner.getSelectedItemPosition()==2) {
            showCard.setImageResource(R.drawable.card_02);
            cardInfo.setText("銀行 " + credit_card2.get("銀行") +"\n"+
                    "信用卡名 " + credit_card2.get("信用卡名") +"\n"+
                    "國內現金回饋 " + credit_card2.get("回饋現金(國內)") + "\n"+
                    "國外現金回饋 " + credit_card2.get("回饋現金(國外)") + "\n"+
                    "年費 " + credit_card2.get("年費"));
        }
        else if(spinner.getSelectedItemPosition()==3) {
            showCard.setImageResource(R.drawable.card_03);
            cardInfo.setText("銀行 " + credit_card3.get("銀行") +"\n"+
                    "信用卡名 " + credit_card3.get("信用卡名") +"\n"+
                    "國內現金回饋 " + credit_card3.get("回饋現金(國內)") + "\n"+
                    "國外現金回饋 " + credit_card3.get("回饋現金(國外)") + "\n"+
                    "年費 " + credit_card3.get("年費"));
        }
        else if(spinner.getSelectedItemPosition()==4) {
            showCard.setImageResource(R.drawable.card_04);
            cardInfo.setText("銀行 " + credit_card4.get("銀行") +"\n"+
                    "信用卡名 " + credit_card4.get("信用卡名") +"\n"+
                    "國內現金回饋 " + credit_card4.get("回饋現金(國內)") + "\n"+
                    "國外現金回饋 " + credit_card4.get("回饋現金(國外)") + "\n"+
                    "年費 " + credit_card4.get("年費"));
        }
        else if(spinner.getSelectedItemPosition()==5) {
            showCard.setImageResource(R.drawable.card_05);
//            cardInfo.setText("銀行 " + credit_card5.get("銀行") +"\n"+
//                    "信用卡名 " + credit_card5.get("信用卡名") +"\n"+
//                    "國內現金回饋 " + credit_card5.get("回饋現金(國內)") + "\n"+
//                    "國外現金回饋 " + credit_card5.get("回饋現金(國外)") + "\n"+
//                    "年費 " + credit_card5.get("年費"));
        }
    }
}
