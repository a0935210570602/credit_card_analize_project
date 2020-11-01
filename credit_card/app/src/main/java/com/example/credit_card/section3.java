package com.example.credit_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class section3 extends AppCompatActivity {

    Button result, back;
    TextView input_salary, fee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section3);

        input_salary = findViewById(R.id.input_salary);
        fee = findViewById(R.id.year_fee);
        result = findViewById(R.id.result);
        back = findViewById(R.id.back);
    }

    public void showResult(View view){
        GlobalVariable credit_data = (GlobalVariable)getApplicationContext();
        credit_data.initializationProperties();



//        credit_data.setProperties(17, input_salary.getText());
//        credit_data.setProperties(18, fee.getText());

        startActivity(new Intent(section3.this, MainActivity_Show_Result.class));
    }

    public void back2(View view){
        startActivity(new Intent(section3.this, section2.class));
        section3.this.finish();
    }
}