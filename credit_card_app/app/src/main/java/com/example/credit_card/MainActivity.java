package com.example.credit_card;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup funcGroup, location_foreign;
    CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
    CheckBox[] a = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12};
    EditText input_salary;
    Button send_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        funcGroup = findViewById(R.id.func);
        location_foreign = findViewById(R.id.loc_for);


        for(int i=1;i<13;i++){
            String radioID = "radioButtom"
            a[i] = findViewById(R.id.radioButton[i]);
        }


    }
}