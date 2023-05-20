package com.example.moodplus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

public class MainActivity_Graph extends AppCompatActivity {
    private LineChart lineChart;
   private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_graph);

        // Получить ссылку на LineChart
        lineChart = findViewById(R.id.lineChart);

        // настройка осей
        XAxis xAxis = lineChart.getXAxis();
        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setAxisMinimum(1f); // установка минимального значения для оси Y
       // lineChart.getAxisRight().setEnabled(false); // отключение правой оси

        // добавление данных на график
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 60)); // точка 1, x=0, y=60
        entries.add(new Entry(1, 80)); // точка 2, x=1, y=80
        entries.add(new Entry(2, 70)); // точка 3, x=2, y=70
        LineDataSet lineDataSet = new LineDataSet(entries, "Line Chart");
        lineDataSet.setDrawValues(true); // включение отображения значений точек на графике

        // настройка цвета линии и маркера для точек
        lineDataSet.setColor(Color.RED);
        lineDataSet.setCircleColor(Color.RED);

        // создание объекта LineData и установка его на график
        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);

        // форматирование значений оси X (для примера, установим месяца в качестве меток на оси X)
        final String[] week = new String[]{"Пн","Вт","Ср","Чт","Пт","Сб","Вс"};
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                int index = Math.round(value);
                if (index >= 0 && index < week.length) {
                    return week[index];
                }
                return "";
            }
        });

        // обновление графика
        lineChart.invalidate();
    }
}