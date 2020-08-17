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
    Button send_out;
    TextView show;
    String result;

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

    private Runnable mutiThread = new Runnable(){
        public void run()
        {
            try {
                URL url = new URL("http://192.168.1.58/GetData.php");
                // 開始宣告 HTTP 連線需要的物件，這邊通常都是一綑的
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // 建立 Google 比較挺的 HttpURLConnection 物件
                connection.setRequestMethod("POST");
                // 設定連線方式為 POST
                connection.setDoOutput(true); // 允許輸出
                connection.setDoInput(true); // 允許讀入
                connection.setUseCaches(false); // 不使用快取
                connection.connect(); // 開始連線

                int responseCode =
                        connection.getResponseCode();
                // 建立取得回應的物件
                if(responseCode ==
                        HttpURLConnection.HTTP_OK){
                    // 如果 HTTP 回傳狀態是 OK ，而不是 Error
                    InputStream inputStream =
                            connection.getInputStream();
                    // 取得輸入串流
                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
                    // 讀取輸入串流的資料
                    String box = ""; // 宣告存放用字串
                    String line = null; // 宣告讀取用的字串
                    while((line = bufReader.readLine()) != null) {
                        box += line + "\n";
                        // 每當讀取出一列，就加到存放字串後面
                    }
                    inputStream.close(); // 關閉輸入串流
                    result = box; // 把存放用字串放到全域變數
                }
                // 讀取輸入串流並存到字串的部分
                // 取得資料後想用不同的格式
                // 例如 Json 等等，都是在這一段做處理

            } catch(Exception e) {
                result = e.toString(); // 如果出事，回傳錯誤訊息
            }

            // 當這個執行緒完全跑完後執行
            runOnUiThread(new Runnable() {
                public void run() {
                    show.setText(result); // 更改顯示文字
                }
            });
        }
    };
}