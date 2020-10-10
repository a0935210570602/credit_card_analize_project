package com.example.credit_card;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class info extends AppCompatActivity {

    ArrayList<Map<String, String>> credit_list = new ArrayList<Map<String, String>>();
    Map<String, String> credit_card= new HashMap<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

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

        switch (spinner.getSelectedItemPosition())
        {
            case 0:
                img1.setImageResource(R.drawable.card_04);
                showNO1.setText("銀行 " + credit_list.get(3).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(3).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(3).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(3).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(3).get("年費"));
                img4.setImageResource(R.drawable.star4);

                img2.setImageResource(R.drawable.card_01);
                showNO1.setText("銀行 " + credit_list.get(0).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(0).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(0).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(0).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(0).get("年費"));
                img5.setImageResource(R.drawable.star5);

                img3.setImageResource(R.drawable.card_03);
                showNO3.setText("銀行 " + credit_list.get(2).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(2).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(2).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(2).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(2).get("年費"));
                img6.setImageResource(R.drawable.star3);
                break;
            case 1:
                img1.setImageResource(R.drawable.card_01);
                showNO1.setText("銀行 " + credit_list.get(0).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(0).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(0).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(0).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(0).get("年費"));
                img4.setImageResource(R.drawable.star2);

                img2.setImageResource(R.drawable.card_02);
                showNO2.setText("銀行 " + credit_list.get(1).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(1).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(1).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(1).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(1).get("年費"));
                img5.setImageResource(R.drawable.star1);

                img3.setImageResource(R.drawable.card_03);
                showNO3.setText("銀行 " + credit_list.get(2).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(2).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(2).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(2).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(2).get("年費"));
                img6.setImageResource(R.drawable.star5);

                break;
            case 2:
                img1.setImageResource(R.drawable.card_05);
                showNO1.setText("銀行 " + credit_list.get(4).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(4).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(4).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(4).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(4).get("年費"));
                img4.setImageResource(R.drawable.star5);

                img2.setImageResource(R.drawable.card_04);
                showNO2.setText("銀行 " + credit_list.get(3).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(3).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(3).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(3).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(3).get("年費"));
                img5.setImageResource(R.drawable.star2);

                img3.setImageResource(R.drawable.card_03);
                showNO3.setText("銀行 " + credit_list.get(2).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(2).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(2).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(2).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(2).get("年費"));
                img6.setImageResource(R.drawable.star3);
                break;
            case 3:
                img1.setImageResource(R.drawable.card_04);
                showNO1.setText("銀行 " + credit_list.get(3).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(3).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(3).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(3).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(3).get("年費"));
                img4.setImageResource(R.drawable.star3);

                img2.setImageResource(R.drawable.card_01);
                showNO2.setText("銀行 " + credit_list.get(0).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(0).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(0).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(0).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(0).get("年費"));
                img5.setImageResource(R.drawable.star5);

                img3.setImageResource(R.drawable.card_03);
                showNO3.setText("銀行 " + credit_list.get(2).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(2).get("信用卡名") + "\n" +
                        "國內現金回饋 " + credit_list.get(2).get("回饋現金(國內)") + "\n" +
                        "國外現金回饋 " + credit_list.get(2).get("回饋現金(國外)") + "\n" +
                        "年費 " + credit_list.get(2).get("年費"));
                img6.setImageResource(R.drawable.star2);
                break;
            default:
                showNO1.setText("不再範圍值內");
        }
    }
}