package com.example.credit_card;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class chart2 extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart2);

        anyChartView = findViewById(R.id.any_chart_view);

        setupRegtChart();
    }

    public  void  OnClick(View V){
        chart2.this.finish();
    }
    public void setupRegtChart() {
        Cartesian column = AnyChart.column();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < mon.length; i++) {
            dataEntries.add(new ValueDataEntry(mon[i], wei[i]));
        }


        column.data(dataEntries);
        anyChartView.setChart(column);

    }
}
