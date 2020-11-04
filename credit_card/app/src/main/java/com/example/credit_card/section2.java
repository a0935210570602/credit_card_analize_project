package com.example.credit_card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class section2 extends AppCompatActivity {
    CheckBox chk;
    int[] id = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5, R.id.checkBox6
            , R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10, R.id.checkBox11, R.id.checkBox12
            };
    Button send, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2);

        back = findViewById(R.id.back);
        send = findViewById(R.id.send2);
    }

    public void send2(View view){
        GlobalVariable credit_data = (GlobalVariable)getApplicationContext();
        for(int i:id){
            chk = findViewById(i);
            switch (chk.getId()){
                case R.id.checkBox1:
                    if (chk.isChecked()){
                        credit_data.setProperties(14, 5);
                        credit_data.setProperties(1, 5);
                        break;
                    }
                case R.id.checkBox2:
                    if (chk.isChecked()) {
                        credit_data.setProperties(15, 5);
                        credit_data.setProperties(15, 5);
                        credit_data.setProperties(1, 5);
                        credit_data.setProperties(4, 5);
                        credit_data.setProperties(6, 2);
                        credit_data.setProperties(5, 2);
                        break;
                    }
                case R.id.checkBox3:
                    if (chk.isChecked()){
                        credit_data.setProperties(15, 5);
                        credit_data.setProperties(15, 5);
                        credit_data.setProperties(1, 5);
                        credit_data.setProperties(4, 2);
                        break;
                    }
                case R.id.checkBox4:
                    if (chk.isChecked()){
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(15, 5);
                        credit_data.setProperties(10, 20);
                        credit_data.setProperties(11, 15);
                        credit_data.setProperties(1, 2);
                        credit_data.setProperties(4, 2);
                        credit_data.setProperties(3, 2);
                        break;
                    }
                case R.id.checkBox5:
                    if (chk.isChecked()){
                        credit_data.setProperties(12, 20);
                        credit_data.setProperties(14, 20);
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(3, 2);
                        credit_data.setProperties(4, 2);
                        credit_data.setProperties(3, 3);
                        break;
                    }
                case R.id.checkBox6:
                    if (chk.isChecked()){
                        credit_data.setProperties(8, 20);
                        credit_data.setProperties(7, 10);
                        credit_data.setProperties(6, 10);
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(1, 2);
                        credit_data.setProperties(4, 2);
                        credit_data.setProperties(3, 5);
                        break;
                    }
                case R.id.checkBox7:
                    if (chk.isChecked()){
                        credit_data.setProperties(15, 1);
                        credit_data.setProperties(15, 1);
                        credit_data.setProperties(1, 1);
                        credit_data.setProperties(4, 10);
                        break;
                    }
                case R.id.checkBox8:
                    if (chk.isChecked()){
                        credit_data.setProperties(1, 10);
                        credit_data.setProperties(6, 3);
                        credit_data.setProperties(15, 1);
                        credit_data.setProperties(15, 1);
                        break;
                    }
                case R.id.checkBox9:
                    if (chk.isChecked()){
                        credit_data.setProperties(14, 20);
                        credit_data.setProperties(12, 20);
                        credit_data.setProperties(2, 5);
                        credit_data.setProperties(4, 5);
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(1, 2);
                        break;
                    }
                case R.id.checkBox10:
                    if (chk.isChecked()){
                        credit_data.setProperties(2, 15);
                        credit_data.setProperties(1, 20);
                        credit_data.setProperties(5, 6);
                        credit_data.setProperties(6, 6);
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(1, 2);
                        break;
                    }
                case R.id.checkBox11:
                    if (chk.isChecked()){
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(15, 2);
                        credit_data.setProperties(1, 5);
                        break;
                    }
                case R.id.checkBox12:
                    if (chk.isChecked()){
                        credit_data.setProperties(15, 10);
                        credit_data.setProperties(6, 8);
                        credit_data.setProperties(15, 10);
                        credit_data.setProperties(5, 8);
                        credit_data.setProperties(1, 10);
                        credit_data.setProperties(2, 4);
                        break;
                    }
                default:
                    break;
            }
        }
        startActivity(new Intent(section2.this, section3.class));
    }

    public void goBack(View view){
        startActivity(new Intent(section2.this, section1.class));
        section2.this.finish();
    }
}