package com.example.credit_card;

import android.os.Bundle;
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
    String[] mon = {"A", "B", "C"};
    int[] wei = {500, 800, 300};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart2);

        anyChartView = findViewById(R.id.any_chart_view);

        setupRegtChart();
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
