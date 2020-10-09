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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    RadioGroup funcGroup, location_foreign;
    CheckBox chk;
    int[] id = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5, R.id.checkBox6
            , R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10, R.id.checkBox11, R.id.checkBox12
            , R.id.checkBox13, R.id.checkBox14, R.id.checkBox15, R.id.checkBox16};
//    TextInputEditText input_salary, year_fee;
    String income;
    Button send_out;
    TextView show, show1;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        funcGroup = findViewById(R.id.func);
        location_foreign = findViewById(R.id.loc_for);
        show = findViewById(R.id.show);
        show1 = findViewById(R.id.show1);

//        year_fee = findViewById(R.id.year_fee);

//        for(int i=1;i<12;i++){
//            String radioID = "checkBox" + i;
//            chk[i] = findViewById(this.getResources().getIdentifier(radioID, "id", getPackageName()));
//        }

//        input_salary = findViewById(R.id.input_salary);
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

    int base_point = 10;
    int redpoint_money, redpoint_mile, point_mutiple, first_mile_back, forign_cost_mile, domestic_cost_mile, digital_cost_mile, digital_bak_max,
        internet_cost, year_cost, week_movie, workday_movie, gas_money, gas_discount, forign_money_back, domestic_money_back = 1;
    String card_price;

    Map<String, Integer> find = new HashMap<>();

    private Runnable mutiThread = new Runnable(){
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public void run() {
            try {
                URL url = new URL("http://192.168.0.101/test/test.php");
                // 開始宣告 HTTP 連線需要的物件，這邊通常都是一綑的
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // 建立 Google 比較挺的 HttpURLConnection 物件
                connection.setRequestMethod("POST");
                // 設定連線方式為 POST
                connection.setDoOutput(true); // 允許輸出
                connection.setDoInput(true);  // 允許讀入
                connection.setUseCaches(false); // 不使用快取
                connection.setReadTimeout(10000);
                connection.setConnectTimeout(15000);
             /////////////////////////////////////////////////////////////////////////////////////////
                connection.setRequestProperty("Content-Type", "application/json; utf-8");          ///
                connection.setRequestProperty("Accept", "application/json");                       ///https://www.baeldung.com/httpurlconnection-post
//                String jsonInputString = "{\"name\": \"Upendra\", \"job\": \"Programmer\"}";     ///
                String jsonInputString = "8888888888";                                             ///
                try(OutputStream os = connection.getOutputStream()) {                              ///
                    byte[] input = jsonInputString.getBytes("utf-8");                 ///
                    os.write(input, 0, input.length);                                         ///
                }                                                                                 ///
            /////////////////////////////////////////////////////////////////////////////////////////
                connection.connect(); // 開始連線

                int responseCode =
                        connection.getResponseCode();
                // 建立取得回應的物件
                if (responseCode ==
                        HttpURLConnection.HTTP_OK) {
                    // 如果 HTTP 回傳狀態是 OK ，而不是 Error
                    InputStream inputStream =
                            connection.getInputStream();
                    // 取得輸入串流
                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
                    // 讀取輸入串流的資料
                    String box = ""; // 宣告存放用字串
                    String line = null; // 宣告讀取用的字串
                    while ((line = bufReader.readLine()) != null) {
                        box += line + "\n";
                        // 每當讀取出一列，就加到存放字串後面
                    }
                    inputStream.close(); // 關閉輸入串流
                    result = box; // 把存放用字串放到全域變數
                }
                // 讀取輸入串流並存到字串的部分
                // 取得資料後想用不同的格式
                // 例如 Json 等等，都是在這一段做處理

            } catch (Exception e) {
                result = e.toString(); // 如果出事，回傳錯誤訊息
            }


            // 當這個執行緒完全跑完後執行
            runOnUiThread(new Runnable() {
                public void run() {
                    show.setText(result); // 更改顯示文字
                }
            });

            switch (funcGroup.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    domestic_money_back += 20;
                    forign_money_back += 20;
                    internet_cost += 3;
                    gas_money += 3;
                    year_cost += 2;
                    break;
                case R.id.radioButton2:
                    redpoint_money += 20;
                    redpoint_mile += 5;
                    point_mutiple += 3;
                    internet_cost += 3;
                    year_cost += 2;
                    break;
                case R.id.radioButton:
                    domestic_money_back += 10;
                    redpoint_money += 10;
                    break;
            }


            switch (location_foreign.getCheckedRadioButtonId()){
                case R.id.radioButton5:
                    domestic_money_back += 20;
                    break;
                case R.id.radioButton6:
                    forign_money_back += 20;
                    break;
                case R.id.radioButton7:
                    domestic_money_back += 10;
                    forign_money_back += 10;
                    break;
            }

            for(int i:id){
                chk = findViewById(i);
                switch (chk.getId()){
                    case R.id.checkBox1:
                        if (chk.isChecked()){
                            domestic_money_back += 5;
                            redpoint_money += 5;
                            break;
                        }
                    case R.id.checkBox2:
                        if (chk.isChecked()) {
                            domestic_money_back += 5;
                            forign_money_back += 5;
                            redpoint_money += 5;
                            first_mile_back += 2;
                            domestic_cost_mile += 2;
                            forign_cost_mile += 2;
                            break;
                        }
                    case R.id.checkBox3:
                        if (chk.isChecked()){
                            domestic_money_back += 5;
                            forign_money_back += 5;
                            redpoint_money += 5;
                            first_mile_back += 2;
                            break;
                        }
                    case R.id.checkBox4:
                        if (chk.isChecked()){
                            domestic_money_back += 2;
                            forign_money_back += 2;
                            week_movie += 20;
                            workday_movie += 15;
                            redpoint_money += 2;
                            first_mile_back += 2;
                            point_mutiple += 2;
                            break;
                        }
                    case R.id.checkBox13:
                        if (chk.isChecked()){
                            gas_money += 20;
                            gas_discount += 20;
                            domestic_money_back += 2;
                            forign_money_back += 2;
                            redpoint_money += 2;
                            first_mile_back += 2;
                            point_mutiple += 3;
                            break;
                        }
                    case R.id.checkBox14:
                        if (chk.isChecked()){
                            internet_cost += 20;
                            digital_bak_max += 10;
                            digital_cost_mile += 10;
                            domestic_money_back += 2;
                            forign_money_back += 2;
                            redpoint_money += 2;
                            first_mile_back += 2;
                            point_mutiple += 5;
                            break;
                        }
                    case R.id.checkBox15:
                        if (chk.isChecked()){
                            year_cost += 5;
                            domestic_money_back += 1;
                            forign_money_back += 1;
                            redpoint_money += 1;
                            first_mile_back += 10;
                            break;
                        }
                    case R.id.checkBox16:
                        if (chk.isChecked()){
                            domestic_money_back += 10;
                            forign_money_back += 8;
                            redpoint_money += 10;
                            break;
                        }
                    case R.id.checkBox5:
                        if (chk.isChecked()){
                            domestic_money_back += 10;
                            forign_money_back += 6;
                            redpoint_money += 10;
                            break;
                        }
                    case R.id.checkBox6:
                        if (chk.isChecked()){
                            redpoint_mile += 15;
                            redpoint_money += 20;
                            forign_cost_mile += 6;
                            domestic_cost_mile += 6;
                            domestic_money_back += 2;
                            forign_money_back += 2;
                            redpoint_money += 2;
                            break;
                        }
                    case R.id.checkBox7:
                        if (chk.isChecked()){
                            domestic_money_back += 2;
                            forign_money_back += 2;
                            redpoint_money += 5;
                            break;
                        }
                    case R.id.checkBox8:
                        if (chk.isChecked()){
                            domestic_money_back += 10;
                            domestic_cost_mile += 8;
                            forign_money_back += 10;
                            forign_cost_mile += 8;
                            redpoint_money += 10;
                            redpoint_mile += 4;
                            break;
                        }
                    case R.id.checkBox9:
                        if (chk.isChecked()){
                            gas_discount += 20;
                            gas_money += 20;
                            redpoint_mile += 5;
                            first_mile_back += 5;
                            domestic_money_back += 2;
                            forign_money_back += 2;
                            redpoint_money += 2;
                            break;
                        }
                    case R.id.checkBox10:
                        if (chk.isChecked()){
                            domestic_money_back += 10;
                            forign_money_back += 8;
                            redpoint_money += 10;
                            internet_cost += 10;
                            point_mutiple += 10;
                            break;
                        }
                    case R.id.checkBox11:
                        if (chk.isChecked()){
                            domestic_money_back += 15;
                            forign_money_back += 10;
                            redpoint_money += 15;
                            internet_cost += 10;
                            gas_money += 5;
                            gas_discount += 5;
                            break;
                        }
                    case R.id.checkBox12:
                        if (chk.isChecked()){
                            domestic_money_back += 5;
                            forign_money_back += 5;
                            redpoint_money += 5;
                            internet_cost +=5;
                            break;
                        }
                }
            }

            find.put("redpoint_money", redpoint_money);
            find.put("redpoint_mile", redpoint_mile);
            find.put("point_mutiple", point_mutiple);
            find.put("first_mile_back", first_mile_back);
            find.put("forign_cost_mile", forign_cost_mile);
            find.put("domestic_cost_mile", domestic_cost_mile);
            find.put("digital_bak_max", digital_bak_max);
            find.put("internet_cost", internet_cost);
            find.put("year_cost", year_cost);
            find.put("week_movie", week_movie);
            find.put("gas_money", gas_money);
            find.put("workday_movie", workday_movie);
            find.put("gas_discount", gas_discount);
            find.put("forign_money_back", forign_money_back);
            find.put("domestic_money_back", domestic_money_back);
            find.put("digital_cost_mile", digital_cost_mile);


//            income = input_salary.getText().toString();

//            card_price = year_fee.getText().toString();
            show1.setText(income + " " + card_price);

            // 檢查選擇的職有無正常抓取
            for (Map.Entry<String, Integer> entry : find.entrySet()) {
                System.out.println(entry);
            }

            startActivity(new Intent(MainActivity.this, fake_data.class));

            if(result.equalsIgnoreCase("success\n") ){
                startActivity(new Intent(MainActivity.this, fake_data.class));
            }
            else
                Log.d("TAG", "update fall ");
                Log.d("TAG", result);
                Log.i("tag", String.valueOf(result.equalsIgnoreCase("success") ));

        }
    };
}