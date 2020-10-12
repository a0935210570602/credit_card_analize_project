package com.example.credit_card;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class WhichChart extends AppCompatActivity {
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.which_chart);
//        Bundle bundle = getIntent().getExtras();
//        String card_num = bundle.getString("index");
//        intent.putExtra("index", card_num);
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.but1:
                intent.setClass(this , chart.class);
                break;
            case R.id.but2:
                intent.setClass(this , chart2.class);
                break;
        }

        startActivity(intent);
    }
}