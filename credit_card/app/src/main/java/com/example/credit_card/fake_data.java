package com.example.credit_card;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;
import static java.lang.System.out;

public class fake_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fake_layout);

        Map<String, String> credit_card = new HashMap<>();
        credit_card.put("銀行", "花旗銀行");
        credit_card.put("信用卡名", "現金回饋PLUS卡");
        credit_card.put("回饋點數", "");
        credit_card.put("回饋現金(國內)", "2%");
        credit_card.put("回饋現金(國外)", "0.5%");
        credit_card.put("年費", "首年免年費");
//     credit_card.put("食", "合作廠商");
//     credit_card.put("住", "合作網站");
//     credit_card.put("交通", "搭乘工具");
//     credit_card.put("線上購物", "");

        Map<String, String> credit_card2 = new HashMap<>();
        credit_card2.put("銀行", "滙豐銀行");
        credit_card2.put("信用卡名", "現金回饋御璽卡");
        credit_card2.put("回饋點數", "");
        credit_card2.put("回饋現金(國內)", "1.22%");
        credit_card2.put("回饋現金(國外)", "2.22%");
        credit_card2.put("年費", "首年免年費");

        Map<String, String> credit_card3 = new HashMap<>();
        credit_card3.put("銀行", "中國信託");
        credit_card3.put("信用卡名", "TAIPEI_101_夜光聯名卡");
        credit_card3.put("回饋點數", "");
        credit_card3.put("回饋現金(國內)", "2%");
        credit_card3.put("回饋現金(國外)", "0.5%");
        credit_card3.put("年費", "首年免年費");

        Map<String, String> credit_card4 = new HashMap<>();
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
        credit_card5.put("回饋現金(國內)", "10%");
        credit_card5.put("回饋現金(國外)", "10%");
        credit_card5.put("年費", "0");

    }



}
