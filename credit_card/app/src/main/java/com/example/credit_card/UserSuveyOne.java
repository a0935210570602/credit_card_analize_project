package com.example.credit_card;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

//import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UserSuveyOne extends AppCompatActivity{

    RadioGroup funcGroup, location_foreign;
    CheckBox chk;
    int[] id = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5, R.id.checkBox6
            , R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10, R.id.checkBox11, R.id.checkBox12
            , R.id.checkBox13, R.id.checkBox14, R.id.checkBox15, R.id.checkBox16};
//    TextInputEditText input_salary, year_fee;
    String income;
    Button send_out, back;
    TextView show, show1;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_suvey_one_);

        funcGroup = findViewById(R.id.func);
        location_foreign = findViewById(R.id.loc_for);
        show = findViewById(R.id.show);
        show1 = findViewById(R.id.show1);

        back = findViewById(R.id.back);


        send_out = findViewById(R.id.send_out);
        send_out.setOnClickListener(new View.OnClickListener() {
            @Override
            // 按鈕事件
            public void onClick(View view) {
                // 按下之後會執行的程式碼
                // 宣告執行緒
                Thread thread = new Thread(mutiThread);
                thread.start(); // 開始執行
            }
        });
    }

    public void goback(View view){
        finish();
    }

    int base_point = 10;
    int redpoint_money, redpoint_mile, point_mutiple, first_mile_back, forign_cost_mile, domestic_cost_mile, digital_cost_mile, digital_bak_max,
        internet_cost, year_cost, week_movie, workday_movie, gas_money, gas_discount, forign_money_back, domestic_money_back = 1;
    String card_price;

    Map<String, Integer> find = new HashMap<>();

    private Runnable mutiThread = new Runnable(){
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public void run() {
//            try {
//                URL url = new URL("http://192.168.0.101/test/make_database_update.php");
//                // 開始宣告 HTTP 連線需要的物件，這邊通常都是一綑的
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                // 建立 Google 比較挺的 HttpURLConnection 物件
//                connection.setRequestMethod("POST");
//                // 設定連線方式為 POST
//                connection.setDoOutput(true); // 允許輸出
//                connection.setDoInput(true);  // 允許讀入
//                connection.setUseCaches(false); // 不使用快取
//                connection.setReadTimeout(10000);
//                connection.setConnectTimeout(15000);
//             /////////////////////////////////////////////////////////////////////////////////////////
//                connection.setRequestProperty("Content-Type", "application/json; utf-8");          ///
//                connection.setRequestProperty("Accept", "application/json");                       ///https://www.baeldung.com/httpurlconnection-post
////                String jsonInputString = "{\"name\": \"Upendra\", \"job\": \"Programmer\"}";     ///
//                String jsonInputString = "8888888888";                                             ///
////                try(OutputStream os = connection.getOutputStream()) {                              ///
////                    byte[] input = jsonInputString.getBytes("utf-8");                 ///
////                    os.write(input, 0, input.length);                                         ///
////                }                                                                                 ///
//            /////////////////////////////////////////////////////////////////////////////////////////
//                connection.connect(); // 開始連線
//
//                int responseCode =
//                        connection.getResponseCode();
//                // 建立取得回應的物件
//                if (responseCode ==
//                        HttpURLConnection.HTTP_OK) {
//                    // 如果 HTTP 回傳狀態是 OK ，而不是 Error
//                    InputStream inputStream =
//                            connection.getInputStream();
//                    // 取得輸入串流
//                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
//                    // 讀取輸入串流的資料
//                    String box = ""; // 宣告存放用字串
//                    String line = null; // 宣告讀取用的字串
//                    while ((line = bufReader.readLine()) != null) {
//                        box += line + "\n";
//                        // 每當讀取出一列，就加到存放字串後面
//                    }
//                    inputStream.close(); // 關閉輸入串流
//                    Log.e("box", box);
//
//                    result = box; // 把存放用字串放到全域變數
//                    Log.e("result", result);
//                }
//                // 讀取輸入串流並存到字串的部分
//                // 取得資料後想用不同的格式
//                // 例如 Json 等等，都是在這一段做處理
//
//            } catch (Exception e) {
//                result = e.toString(); // 如果出事，回傳錯誤訊息
//            }


            // 當這個執行緒完全跑完後執行
            runOnUiThread(new Runnable() {
                public void run() {
                    show.setText(result); // 更改顯示文字
                }
            });
            GlobalVariable credit_data = (GlobalVariable)getApplicationContext();
            credit_data.initializationProperties();
            switch (funcGroup.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    credit_data.setProperties(16, 20);
                    credit_data.setProperties(15, 20);
                    credit_data.setProperties(8, 3);
                    credit_data.setProperties(12, 3);
                    break;
                case R.id.radioButton2:
                    credit_data.setProperties(1, 20);
                    credit_data.setProperties(2, 5);
                    credit_data.setProperties(3, 3);
                    credit_data.setProperties(8, 3);
                    break;
                case R.id.radioButton:
                    credit_data.setProperties(16, 10);
                    credit_data.setProperties(1, 10);
                    break;
            }


            switch (location_foreign.getCheckedRadioButtonId()){
                case R.id.radioButton5:
                    credit_data.setProperties(16, 20);
                    break;
                case R.id.radioButton6:
                    credit_data.setProperties(15, 20);
                    break;
                case R.id.radioButton7:
                    credit_data.setProperties(16, 10);
                    credit_data.setProperties(15, 10);
                    break;
            }

            for(int i:id){
                chk = findViewById(i);
                switch (chk.getId()){
                    case R.id.checkBox1:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 5);
                            credit_data.setProperties(1, 5);
                            break;
                        }
                    case R.id.checkBox2:
                        if (chk.isChecked()) {
                            credit_data.setProperties(16, 5);
                            credit_data.setProperties(15, 5);
                            credit_data.setProperties(1, 5);
                            credit_data.setProperties(4, 5);
                            credit_data.setProperties(6, 2);
                            credit_data.setProperties(5, 2);
                            break;
                        }
                    case R.id.checkBox3:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 5);
                            credit_data.setProperties(15, 5);
                            credit_data.setProperties(1, 5);
                            credit_data.setProperties(4, 2);
                            break;
                        }
                    case R.id.checkBox4:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 2);
                            credit_data.setProperties(15, 5);
                            credit_data.setProperties(10, 20);
                            credit_data.setProperties(11, 15);
                            credit_data.setProperties(1, 2);
                            credit_data.setProperties(4, 2);
                            credit_data.setProperties(3, 2);
                            break;
                        }
                    case R.id.checkBox13:
                        if (chk.isChecked()){
                            credit_data.setProperties(12, 20);
                            credit_data.setProperties(14, 20);
                            credit_data.setProperties(16, 2);
                            credit_data.setProperties(15, 2);
                            credit_data.setProperties(3, 2);
                            credit_data.setProperties(4, 2);
                            credit_data.setProperties(3, 3);
                            break;
                        }
                    case R.id.checkBox14:
                        if (chk.isChecked()){
                            credit_data.setProperties(8, 20);
                            credit_data.setProperties(7, 10);
                            credit_data.setProperties(6, 10);
                            credit_data.setProperties(16, 2);
                            credit_data.setProperties(15, 2);
                            credit_data.setProperties(1, 2);
                            credit_data.setProperties(4, 2);
                            credit_data.setProperties(3, 5);
                            break;
                        }
                    case R.id.checkBox15:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 1);
                            credit_data.setProperties(15, 1);
                            credit_data.setProperties(1, 1);
                            credit_data.setProperties(4, 10);
                            break;
                        }
                    case R.id.checkBox16:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 8);
                            credit_data.setProperties(15, 8);
                            credit_data.setProperties(1, 10);
                            break;
                        }
                    case R.id.checkBox5:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 10);
                            credit_data.setProperties(15, 6);
                            credit_data.setProperties(1, 10);
                            break;
                        }
                    case R.id.checkBox6:
                        if (chk.isChecked()){
                            credit_data.setProperties(2, 15);
                            credit_data.setProperties(1, 20);
                            credit_data.setProperties(5, 6);
                            credit_data.setProperties(6, 6);
                            credit_data.setProperties(16, 2);
                            credit_data.setProperties(15, 2);
                            credit_data.setProperties(1, 2);
                            break;
                        }
                    case R.id.checkBox7:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 2);
                            credit_data.setProperties(15, 2);
                            credit_data.setProperties(1, 5);
                            break;
                        }
                    case R.id.checkBox8:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 10);
                            credit_data.setProperties(6, 8);
                            credit_data.setProperties(15, 10);
                            credit_data.setProperties(5, 8);
                            credit_data.setProperties(1, 10);
                            credit_data.setProperties(2, 4);
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
                            credit_data.setProperties(16, 10);
                            credit_data.setProperties(15, 8);
                            credit_data.setProperties(1, 10);
                            credit_data.setProperties(8, 10);
                            credit_data.setProperties(3, 10);
                            break;
                        }
                    case R.id.checkBox11:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 15);
                            credit_data.setProperties(15, 10);
                            credit_data.setProperties(1, 15);
                            credit_data.setProperties(8, 10);
                            credit_data.setProperties(12, 5);
                            credit_data.setProperties(14, 5);
                            break;
                        }
                    case R.id.checkBox12:
                        if (chk.isChecked()){
                            credit_data.setProperties(16, 5);
                            credit_data.setProperties(15, 5);
                            credit_data.setProperties(1, 5);
                            credit_data.setProperties(8, 5);
                            break;
                        }
                }
            }

            show1.setText(income + " " + card_price);

            startActivity(new Intent(UserSuveyOne.this, WhichToSee.class));

            if(result.equalsIgnoreCase("success\n") ){
                startActivity(new Intent(UserSuveyOne.this, WhichToSee.class));
            }
            else{
                Log.d("TAG", "update fall ");
                Log.d("TAG", result);
                Log.i("tag", String.valueOf(result.equalsIgnoreCase("success") ));
            }
        }
    };
}