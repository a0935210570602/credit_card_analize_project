package com.example.credit_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class section1 extends AppCompatActivity {

    RadioGroup func1, func2;
    Integer check_is_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section1);

        func1 = findViewById(R.id.func1);
        func2 = findViewById(R.id.func2);
    }


    public void send(View view){
        check_is_done = 0;
        GlobalVariable credit_data = (GlobalVariable)getApplicationContext();
        credit_data.initializationProperties();
        switch (func1.getCheckedRadioButtonId()){
            case R.id.radioButton1:
                check_is_done += 1;
                credit_data.setProperties(16, 20);
                credit_data.setProperties(15, 20);
                credit_data.setProperties(8, 3);
                credit_data.setProperties(12, 3);
                break;
            case R.id.radioButton2:
                check_is_done += 1;
                credit_data.setProperties(1, 20);
                credit_data.setProperties(2, 5);
                credit_data.setProperties(3, 3);
                credit_data.setProperties(8, 3);
                break;
            case R.id.radioButton3:
                check_is_done += 1;
                credit_data.setProperties(16, 10);
                credit_data.setProperties(1, 10);
                break;
        }

        switch (func2.getCheckedRadioButtonId()){
            case R.id.radioButton4:
                check_is_done += 1;
                credit_data.setProperties(16, 20);
                break;
            case R.id.radioButton5:
                check_is_done += 1;
                credit_data.setProperties(15, 20);
                break;
            case R.id.radioButton6:
                check_is_done += 1;
                credit_data.setProperties(16, 10);
                credit_data.setProperties(15, 10);
                break;
        }
        if(check_is_done == 2){
            startActivity(new Intent(section1.this, section2.class));
            section1.this.finish();
        }
        else
            Toast.makeText(this, "還有問題未作答喔", Toast.LENGTH_SHORT).show();
    }
}