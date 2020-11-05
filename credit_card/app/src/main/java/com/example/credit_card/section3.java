package com.example.credit_card;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class section3 extends AppCompatActivity {

    Button result, back;
    TextView input_salary, fee;
    String res = "";
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
//        Thread thread = new Thread(mutiThread);
//        thread.start(); // 開始執行
        GlobalVariable credit_data = (GlobalVariable)getApplicationContext();
        startActivity(new Intent(section3.this, MainActivity_Show_Result.class));
    }

    public void back2(View view){
        startActivity(new Intent(section3.this, section2.class));
        section3.this.finish();
    }
    private Runnable mutiThread = new Runnable(){
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public void run() { try {
                URL url = new URL("http://192.168.0.116/Server/server.php");
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
                String jsonInputString = "{\"request_code\":200 }";     ///
//                String jsonInputString = "8888888888";                                             ///
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
                    Log.e("box", box);

                    res = box; // 把存放用字串放到全域變數
                    Log.e("result", res);

                    if(res.equals("200\n")){
                        startActivity(new Intent(section3.this, MainActivity_Show_Result.class));
                    }
                }
                // 讀取輸入串流並存到字串的部分
                // 取得資料後想用不同的格式
                // 例如 Json 等等，都是在這一段做處理
            } catch (Exception e) {
                res = e.toString(); // 如果出事，回傳錯誤訊息
            }
        }
    };
}