package com.example.credit_card;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.*;

public class fake_data extends AppCompatActivity {

    Bundle bundle1 = new Bundle();
    Bundle bundle2 = new Bundle();
    Bundle bundle3 = new Bundle();

    ArrayList<Map<String, String>> credit_list = new ArrayList<Map<String, String>>();
    Map<String, String> credit_card= new HashMap<>();

    Spinner spinner;
    TextView showNO1, showNO2 ,showNO3;
    ImageView img1, img2, img3, img4, img5, img6;
    ScrollView scrollView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fake_layout);

        credit_card.put("銀行", "花旗銀行");
        credit_card.put("信用卡名", "現金回饋PLUS卡");
        credit_card.put("使用人數", "100000");
//        credit_card.put("回饋點數", "0");
//        credit_card.put("回饋現金(國內)", "2%");
//        credit_card.put("回饋現金(國外)", "0.5%");
//        credit_card.put("年費", "-1");
        credit_card.put("圖片", String.valueOf(R.drawable.card_01));
        credit_card.put("星星", String.valueOf(R.drawable.star5));
        credit_list.add(credit_card);

        credit_card = new HashMap<>();
        credit_card.put("銀行", "滙豐銀行");
        credit_card.put("信用卡名", "現金回饋御璽卡");
        credit_card.put("使用人數", "78000");
//        credit_card.put("回饋點數", "0");
//        credit_card.put("回饋現金(國內)", "1.22%");
//        credit_card.put("回饋現金(國外)", "2.22%");
//        credit_card.put("年費", "-1"); //首年免年費"
        credit_card.put("圖片", String.valueOf(R.drawable.card_02));
        credit_card.put("星星", String.valueOf(R.drawable.star5));
        credit_list.add(credit_card);

        credit_card = new HashMap<>();
        credit_card.put("銀行", "中國信託");
        credit_card.put("信用卡名", "TAIPEI_101_夜光聯名卡");
        credit_card.put("使用人數", "10000");
//        credit_card.put("回饋點數", "0");
//        credit_card.put("回饋現金(國內)", "2%");
//        credit_card.put("回饋現金(國外)", "0.5%");
//        credit_card.put("年費", "-1");
        credit_card.put("圖片", String.valueOf(R.drawable.card_03));
        credit_card.put("星星", String.valueOf(R.drawable.star4));
        credit_list.add(credit_card);


        credit_card = new HashMap<>();
        credit_card.put("銀行", "國泰世華");
        credit_card.put("信用卡名", "蝦皮購物聯名卡");
        credit_card.put("使用人數", "7600");
//        credit_card.put("回饋點數", "0");
//        credit_card.put("回饋現金(國內)", "0.5%");
//        credit_card.put("回饋現金(國外)", "0.5%");
//        credit_card.put("年費", "-1");
        credit_card.put("圖片", String.valueOf(R.drawable.card_04));
        credit_card.put("星星", String.valueOf(R.drawable.star2));
        credit_list.add(credit_card);

        credit_card = new HashMap<>();
        credit_card.put("銀行", "台灣樂天");
        credit_card.put("信用卡名", "樂天信用卡");
        credit_card.put("使用人數", "70000");
//        credit_card.put("回饋點數", "0");
//        credit_card.put("回饋現金(國內)", "1.25%");
//        credit_card.put("回饋現金(國外)", "0%");
//        credit_card.put("年費", "0");
        credit_card.put("圖片", String.valueOf(R.drawable.card_05));
        credit_card.put("星星", String.valueOf(R.drawable.star4));
        credit_list.add(credit_card);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> myadapter = new ArrayAdapter<>(fake_data.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.want_options));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);

        showNO1 = findViewById(R.id.showNO1);
        showNO2 = findViewById(R.id.showNO2);
        showNO3 = findViewById(R.id.showNO3);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        scrollView = findViewById(R.id.scrollView);
//        LinearLayout show_card = (LinearLayout)findViewById(R.id.show_card);

        img1.setImageResource(Integer.parseInt(credit_list.get(0).get("圖片")));
        showNO1.setText("銀行 " + credit_list.get(0).get("銀行") + "\n" +
                "信用卡名 " + credit_list.get(0).get("信用卡名") + "\n" +
                "使用人數 " + credit_list.get(0).get("使用人數") + "\n");
        img4.setImageResource(Integer.parseInt(credit_list.get(0).get("星星")));
        bundle1.putString("index", "0");

        img2.setImageResource(Integer.parseInt(credit_list.get(1).get("圖片")));
        showNO2.setText("銀行 " + credit_list.get(1).get("銀行") + "\n" +
                "信用卡名 " + credit_list.get(1).get("信用卡名") + "\n" +
                "使用人數 " + credit_list.get(1).get("使用人數") + "\n");
        img5.setImageResource(Integer.parseInt(credit_list.get(1).get("星星")));
        bundle2.putString("index", "1");


        img3.setImageResource(Integer.parseInt(credit_list.get(2).get("圖片")));
        showNO3.setText("銀行 " + credit_list.get(2).get("銀行") + "\n" +
                "信用卡名 " + credit_list.get(2).get("信用卡名") + "\n" +
                "使用人數 " + credit_list.get(2).get("使用人數") + "\n");
        img6.setImageResource(Integer.parseInt(credit_list.get(2).get("星星")));
        bundle3.putString("index", "2");

//        for(Integer i=0;i<credit_list.size();i++){
//            ImageView img = new ImageView(this);
//            img.setMaxHeight(500);
//            img.setAdjustViewBounds(true);
//            img.setMaxWidth(700);
//            img.setImageResource(Integer.parseInt(credit_list.get(i).get("圖片")));
//
//            TextView tv = new TextView(this);
//            Log.e("qq",credit_list.get(i).get("銀行"));
//            tv.setTextSize(20);
//            tv.setWidth(250);   //設定寬度
//            tv.setHeight(500);
//            tv.setGravity(Gravity.LEFT);
//            tv.setTextColor(Color.rgb(255 ,255 ,255));
//            tv.setText("銀行 " + credit_list.get(i).get("銀行") + "\n" +
//                    "信用卡名 " + credit_list.get(i).get("信用卡名") + "\n" +
//                    "國內現金回饋 " + credit_list.get(i).get("回饋現金(國內)") + "\n" +
//                    "國外現金回饋 " + credit_list.get(i).get("回饋現金(國外)") + "\n" +
//                    "年費 " + credit_list.get(i).get("年費") + "\n" +
//                    "熱門度:");


//            ImageView star = new ImageView(this);
//            star.setMaxHeight(32);
//            star.setAdjustViewBounds(true);
//            star.setMaxWidth(160);
//            star.setImageResource(Integer.parseInt(credit_list.get(i).get("星星")));
//            show_card.addView(img);
//            show_card.addView(tv);
//            show_card.addView(star);
//        }
    }

    public void verify(View v){
        scrollView.scrollTo(0,0);
        switch (spinner.getSelectedItemPosition())
        {
            case 0:
                img1.setImageResource(Integer.parseInt(credit_list.get(3).get("圖片")));
                showNO1.setText("銀行 " + credit_list.get(3).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(3).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(3).get("使用人數") + "\n");
                img4.setImageResource(Integer.parseInt(credit_list.get(3).get("星星")));
                bundle1.putString("index", "3");

                img2.setImageResource(Integer.parseInt(credit_list.get(0).get("圖片")));
                showNO2.setText("銀行 " + credit_list.get(0).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(0).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(0).get("使用人數") + "\n");
                img5.setImageResource(Integer.parseInt(credit_list.get(0).get("星星")));
                bundle2.putString("index", "0");

                img3.setImageResource(Integer.parseInt(credit_list.get(2).get("圖片")));
                showNO3.setText("銀行 " + credit_list.get(2).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(2).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(2).get("使用人數") + "\n");
                img6.setImageResource(Integer.parseInt(credit_list.get(2).get("星星")));
                bundle1.putString("index", "2");
                break;
            case 1:
                img1.setImageResource(Integer.parseInt(credit_list.get(0).get("圖片")));
                showNO1.setText("銀行 " + credit_list.get(0).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(0).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(0).get("使用人數") + "\n");
                img4.setImageResource(Integer.parseInt(credit_list.get(0).get("星星")));
                bundle1.putString("index", "0");

                img2.setImageResource(Integer.parseInt(credit_list.get(5).get("圖片")));
                showNO2.setText("銀行 " + credit_list.get(5).get("銀行") + "\n" +
                    "信用卡名 " + credit_list.get(5).get("信用卡名") + "\n" +
                    "使用人數 " + credit_list.get(5).get("使用人數") + "\n");
                img5.setImageResource(Integer.parseInt(credit_list.get(5).get("星星")));
                bundle1.putString("index", "5");

                img3.setImageResource(Integer.parseInt(credit_list.get(2).get("圖片")));
                showNO3.setText("銀行 " + credit_list.get(2).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(2).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(2).get("使用人數") + "\n");
                img6.setImageResource(Integer.parseInt(credit_list.get(2).get("星星")));
                bundle1.putString("index", "2");

                break;
            case 2:
                img1.setImageResource(Integer.parseInt(credit_list.get(4).get("圖片")));
                showNO1.setText("銀行 " + credit_list.get(4).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(4).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(4).get("使用人數") + "\n");
                img4.setImageResource(Integer.parseInt(credit_list.get(4).get("星星")));
                bundle1.putString("index", "4");

                img2.setImageResource(Integer.parseInt(credit_list.get(3).get("圖片")));
                showNO2.setText("銀行 " + credit_list.get(3).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(3).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(3).get("使用人數") + "\n");
                img5.setImageResource(Integer.parseInt(credit_list.get(3).get("星星")));
                bundle1.putString("index", "3");

                img3.setImageResource(Integer.parseInt(credit_list.get(5).get("圖片")));
                showNO3.setText("銀行 " + credit_list.get(5).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(5).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(5).get("使用人數") + "\n");
                img6.setImageResource(Integer.parseInt(credit_list.get(5).get("星星")));
                bundle1.putString("index", "5");
                break;
            case 3:
                img1.setImageResource(Integer.parseInt(credit_list.get(3).get("圖片")));
                showNO1.setText("銀行 " + credit_list.get(3).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(3).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(3).get("使用人數") + "\n");
                img4.setImageResource(Integer.parseInt(credit_list.get(3).get("星星")));
                bundle1.putString("index", "3");

                img2.setImageResource(Integer.parseInt(credit_list.get(5).get("圖片")));
                showNO2.setText("銀行 " + credit_list.get(5).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(5).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(5).get("使用人數") + "\n");
                img5.setImageResource(Integer.parseInt(credit_list.get(5).get("星星")));
                bundle1.putString("index", "5");

                img3.setImageResource(Integer.parseInt(credit_list.get(2).get("圖片")));
                showNO3.setText("銀行 " + credit_list.get(2).get("銀行") + "\n" +
                        "信用卡名 " + credit_list.get(2).get("信用卡名") + "\n" +
                        "使用人數 " + credit_list.get(2).get("使用人數") + "\n");
                img6.setImageResource(Integer.parseInt(credit_list.get(2).get("星星")));
                bundle1.putString("index", "2");
                break;
                default:
                    showNO1.setText("不再範圍值內");
        }
    }

    public void showInfo1(View view){
        Intent intent = new Intent(fake_data.this, info.class);
        intent.putExtras(bundle1);
        startActivity(new Intent(intent));

    }

    public void showInfo2(View view){
        Intent intent = new Intent(fake_data.this, info.class);
        intent.putExtras(bundle2);
        startActivity(new Intent(intent));
    }

    public void showInfo3(View view){
        Intent intent = new Intent(fake_data.this, info.class);
        intent.putExtras(bundle3);
        startActivity(new Intent(intent));
    }

}
