package com.example.moodplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.moodplus.date.DayMood;
import com.example.moodplus.db.MyDBManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyDBManager myDBManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDBManager = new MyDBManager(this);
    }

    private void hideEverything() {
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
        findViewById(R.id.mood_scale).setVisibility(View.INVISIBLE);
        findViewById(R.id.imageView).setVisibility(View.INVISIBLE);
        findViewById(R.id.imageView2).setVisibility(View.INVISIBLE);
        ((TextView) findViewById(R.id.textView)).setText("Вы уже отметили ваше самочувствие");
    }

    @Override
    protected void onResume() {
        super.onResume();
        myDBManager.openDB();

        if (myDBManager.hasTodayRecord()) {
            hideEverything();
        } else {
            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int value = ((SeekBar) findViewById(R.id.mood_scale)).getProgress();
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String strDate = formatter.format(date);
                    myDBManager.insertToDB(value, strDate);

                    hideEverything();
                }
            });
        }

//        List<DayMood> values = myDBManager.getFromDB(0);
//        for (int i = 0; i < values.size(); i++) {
//            Log.d("HI!!!!!", "mood: " + values.get(i).getMood() + ", day: " + values.get(i).getCalendar());
//        }
    }

    public void newMain(View view) {
        Intent intent = new Intent(this,MainActivity_Graph.class);
        startActivity(intent);
    }
}