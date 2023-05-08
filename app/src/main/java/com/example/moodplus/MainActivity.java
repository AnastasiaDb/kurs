package com.example.moodplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.moodplus.db.MyDBManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private MyDBManager myDBManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDBManager = new MyDBManager(this);
    }

    @Override
    protected void onResume() {

        super.onResume();
        myDBManager.openDB();
    }

    public void onClickAngry(View view) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String time = cal.toString();
        myDBManager.insertToDB("angry", time);
    }

    public void onClickSad(View view) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String time = cal.toString();
        myDBManager.insertToDB("sad", time);
    }

    public void onClickSmile(View view) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String time = cal.toString();
        myDBManager.insertToDB("smile", time);
    }

    public void onClickOkey(View view) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        String time = cal.toString();
        myDBManager.insertToDB("okey", time);
    }
}