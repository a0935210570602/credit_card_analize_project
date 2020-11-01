package com.example.credit_card;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link histogramFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class histogramFragment extends Fragment {

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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public histogramFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment histogramFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static histogramFragment newInstance(String param1, String param2) {
        histogramFragment fragment = new histogramFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        anyChartView = view.findViewById(R.id.any_chart_view);
        setupColumnChart();

        return view;
    }

    public void setupColumnChart() {
        Cartesian column = AnyChart.column();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < mon.length; i++) {
            dataEntries.add(new ValueDataEntry(mon[i], wei[i]));
        }

        column.data(dataEntries);
        anyChartView.setChart(column);
    }
}