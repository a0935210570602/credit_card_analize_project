package com.example.credit_card;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    RadioGroup funcGroup, location_foreign;
    CheckBox chk;
    int[] id = {R.id.checkBox1, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5, R.id.checkBox6
            , R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10, R.id.checkBox11, R.id.checkBox12};
    EditText input_salary;
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

//        for(int i=1;i<12;i++){
//            String radioID = "checkBox" + i;
//            chk[i] = findViewById(this.getResources().getIdentifier(radioID, "id", getPackageName()));
//        }

        input_salary = findViewById(R.id.input_salary);
        send_out = findViewById(R.id.send_out);
//        send_out.setOnClickListener(new View.OnClickListener() {
//            @Override
//            // 按鈕事件
//            public void onClick(View view) {
//                // 按下之後會執行的程式碼
//                // 宣告執行緒
//                Thread thread = new Thread(mutiThread);
//                thread.start(); // 開始執行
//            }
//        });
    }

    int money_redp;
    int in_loc_fore;
    ArrayList<String> sel = new ArrayList<>();
    private void sendPOST() {
//        TextView tvRes = findViewById(R.id.text_Respond);
        /**建立連線*/
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();
        /**設置傳送所需夾帶的內容*/
        FormBody formBody = new FormBody.Builder()
                .add("userId", "1")
                .add("id", "1")
                .add("title", "Test okHttp")
                .build();
        /**設置傳送需求*/
        Request request = new Request.Builder()
                .url("http://192.168.0.103/test/is_data_the_last.php")
                .post(formBody)
                .build();
        /**設置回傳*/
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                /**如果傳送過程有發生錯誤*/
                tvRes.setText(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                /**取得回傳*/
                if(response.body().string().equals("success") == true){
                    startActivity(new Intent(MainActivity.this, fake_data.class));
                }
            }
        });
    }
}