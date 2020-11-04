package com.example.credit_card;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class GlobalVariable extends Application {
    public ArrayList<Integer> user_statistics;

    public void initializationProperties() {
        user_statistics = new ArrayList<>();                       // 1  redpoint_money
        for (Integer i = 0; i < 16; i++)                           // 2  redpoint_mile         // 3  point_mutiple
            user_statistics.add(0);                                // 4  first_mile_back       // 5  forign_cost_mile
    }                                                              // 6  domestic_cost_mile    // 7  digital_bak_max
                                                                   // 8  internet_cost         // 9  year_cost
                                                                   // 10 week_movie            // 11 workday_movie
                                                                   // 12 gas_money
                                                                   // 13 gas_return money          // 14 gas_discount
                                                                   // 15 domestic_money_back
    public void setProperties(Integer index, Integer value){
        user_statistics.set(index, user_statistics.get(index)+value);
    }
    public void printProperties(){
        for (Integer i = 1; i < 16; i++)                           // 2  redpoint_mile         // 3  point_mutiple
            Log.e("Properties", i+"  "+user_statistics.get(i)+"\n");
    }
}