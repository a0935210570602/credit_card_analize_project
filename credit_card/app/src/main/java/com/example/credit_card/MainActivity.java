package com.example.credit_card;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    RadioGroup funcGroup, location_foreign;
    CheckBox chk;
    int[] id = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5, R.id.checkBox6
            , R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10, R.id.checkBox11, R.id.checkBox12};
    EditText input_salary;
    Button send_out;
    TextView show,show1,show2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        funcGroup = findViewById(R.id.func);
        location_foreign = findViewById(R.id.loc_for);
        show = findViewById(R.id.show);

//        for(int i=1;i<12;i++){
//            String radioID = "checkBox" + i;
//            chk[i] = findViewById(this.getResources().getIdentifier(radioID, "id", getPackageName()));
//        }


        input_salary = findViewById(R.id.input_salary);
        send_out = findViewById(R.id.send_out);

    }

    int money_redp, in_loc_fore;
    ArrayList<String> sel = new ArrayList<>();
    public void send(View view){
        if(funcGroup.getCheckedRadioButtonId() == R.id.radioButton1)
            money_redp = 1;
        else if(funcGroup.getCheckedRadioButtonId() == R.id.radioButton2)
            money_redp = 2;

        if(location_foreign.getCheckedRadioButtonId() == R.id.radioButton5)
            in_loc_fore = 1;
        else if(location_foreign.getCheckedRadioButtonId() == R.id.radioButton6)
            in_loc_fore = 2;
        else if(location_foreign.getCheckedRadioButtonId() == R.id.radioButton7)
            in_loc_fore = 3;

        for(int i:id){
            chk = findViewById(i);
            if(chk.isChecked())
                sel.add((String) chk.getText());
            else
                sel.remove(chk.getText());
        }
    }
}