package com.example.moodplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.security.KeyStore;
import java.util.ArrayList;

public class MainActivity_Graph extends AppCompatActivity {
LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_graph);

        lineChart= (LineChart) findViewById(R.id.line_chart);
        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(),"Data Set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        LineData data = new LineData( dataSets);
        lineChart.setData(data);
        lineChart.invalidate();
    }

    private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,20));
        dataVals.add(new Entry(1,24));
        dataVals.add(new Entry(2,2));
        dataVals.add(new Entry(3,10));
        dataVals.add(new Entry(4,10));
        dataVals.add(new Entry(5,10));
        dataVals.add(new Entry(6,10));
        dataVals.add(new Entry(7,10));
        dataVals.add(new Entry(8,10));
        dataVals.add(new Entry(9,10));
        dataVals.add(new Entry(10,10));

        return dataVals;
    }

}