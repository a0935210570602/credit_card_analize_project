package com.example.credit_card;

import android.os.Bundle;
import android.provider.FontsContract;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

public class chart extends AppCompatActivity {

    AnyChartView anyChartView;
    String[] mon = {"A", "B", "C"};
    int[] wei = {500, 800, 300};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);

        anyChartView = findViewById(R.id.any_chart_view);

        setupChart();
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

}
