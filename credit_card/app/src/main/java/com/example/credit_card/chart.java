package com.example.credit_card;

import android.content.Intent;
import android.os.Bundle;
import android.provider.FontsContract;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.ui.table.Column;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class chart extends AppCompatActivity implements View.OnTouchListener, GestureDetector.OnGestureListener {

    AnyChartView anyChartView;
    String[] mon = {"紅利折抵金", "紅利換里程", "最高基點倍數",
            "首刷里程回饋", "國外消費累積哩程", "國內消費累積哩程",
            "周末電影折扣", "平日電影折扣", "加油現金回饋",
            "加油優惠", "國外消費線回饋", "國內消費現金回饋",
            "數位通路回饋上限", "網購回饋"};
    int[] wei = {30,40,80,
            70,55,44,
            90,30,10,
            50,88,47,
            10,58};
    private ConstraintLayout cs;
    private GestureDetector gd;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);

        cs = (ConstraintLayout)findViewById(R.id.co);
        cs.setOnTouchListener(this);
        cs.setLongClickable(true);
        anyChartView = findViewById(R.id.any_chart_view);

        setupChart();
    }

    public  void  OnClick(View V){
        chart.this.finish();
    }

    public void setupChart(){
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i =0; i<mon.length; i++){
            dataEntries.add(new ValueDataEntry(mon[i], wei[i]));
        }

        pie.data(dataEntries);
        anyChartView.setChart(pie);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        final int FLING_MIN_DISTANCE=100;
        final int FLING_MIN_VELOCITY=200;

        Log.e("99", "99");
        if(e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY){
            Intent intent = new Intent(this, chart2.class);
            startActivity(intent);
        }

        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gd.onTouchEvent(event);
//        return false;
    }
}
