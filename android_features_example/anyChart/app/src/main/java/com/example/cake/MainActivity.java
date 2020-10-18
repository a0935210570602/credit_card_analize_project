package com.example.cake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.provider.FontsContractCompat;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AnyChartView anyChartView, anyChartView1;
    String[] mon = {"A", "B", "C"};
    int[] wei = {500, 800, 300};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anyChartView = findViewById(R.id.any_chart_view);
        anyChartView1 = findViewById(R.id.any_chart_view_2);

        setupPieChart();
    }

    public void setupPieChart() {
        Pie pie = AnyChart.pie();
        Cartesian column = AnyChart.column();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < mon.length; i++) {
            dataEntries.add(new ValueDataEntry(mon[i], wei[i]));
        }


        column.data(dataEntries);
        anyChartView.setChart(column);
        pie.data(dataEntries);
        anyChartView1.setChart(pie);
    }
}