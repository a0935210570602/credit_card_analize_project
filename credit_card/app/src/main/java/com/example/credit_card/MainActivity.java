package com.example.credit_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        switch(v.getId()){
            case R.id.f_btu:
                intent.setClass(this , UserSuveyOne.class);
                break;
            case R.id.s_btu:
                intent.setClass(this, UserSuveyOne.class);
                break;
            case R.id.detail_btu:
                intent.setClass(this , UserSuveyOne.class);
                break;
            case R.id.group_btu:
                intent.setClass(this , UserSuveyOne.class);
                break;
        }
        startActivity(intent);
    }
}