package com.example.moodplus.db;

import static com.example.moodplus.db.MyDataBase.GET_TODAY_RECORD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.moodplus.date.DayMood;

import java.util.ArrayList;
import java.util.List;

public class MyDBManager {
    private Context context;
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;

    public MyDBManager(Context context) {
        this.context = context;
        myDBHelper = new MyDBHelper(context);
    }

    public void openDB() {
        db = myDBHelper.getWritableDatabase();
    }

    public void insertToDB(int mood, String date) {
        ContentValues cv = new ContentValues();
        cv.put(MyDataBase._MOOD, mood);
        cv.put(MyDataBase._DATE, date);
        db.insert(MyDataBase.TABLE_NAME, null, cv);
    }

    public List<DayMood> getFromDB() {
        List<DayMood> tempList = new ArrayList<>();
        Cursor cursor = db.query(MyDataBase.TABLE_NAME, null, null, null,
                null, null, null);

        while (cursor.moveToNext()) {
            int mood = cursor.getInt(cursor.getColumnIndexOrThrow(MyDataBase._MOOD));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(MyDataBase._DATE));
            tempList.add(new DayMood(date, mood));
        }
        cursor.close();
        return tempList;
    }

    public List<DayMood> getFromDB_7() {
        List<DayMood> tempList = new ArrayList<>();

        String[] arr = {};
        Cursor cursor = db.rawQuery("SELECT *  FROM Mood WHERE _date BETWEEN date('now', '-" + (7 - 1) + " days') AND date('now', '-" + 7 + " days') ORDER BY _date", arr);

        while (cursor.moveToNext()) {
            int mood = cursor.getInt(cursor.getColumnIndexOrThrow(MyDataBase._MOOD));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(MyDataBase._DATE));
            tempList.add(new DayMood(date, mood));
        }
        cursor.close();
        return tempList;
    }

    public List<DayMood> getFromDB_30() {
        List<DayMood> tempList = new ArrayList<>();

        String[] arr = {};
        Cursor cursor = db.rawQuery("SELECT *  FROM Mood WHERE _date BETWEEN date('now', '-" + (30 - 1) + " days') AND date('now', '-" + 30 + " days') ORDER BY _date", arr);

        while (cursor.moveToNext()) {
            int mood = cursor.getInt(cursor.getColumnIndexOrThrow(MyDataBase._MOOD));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(MyDataBase._DATE));
            tempList.add(new DayMood(date, mood));
        }
        cursor.close();
        return tempList;
    }

    public List<DayMood> getFromDB_all() {
        List<DayMood> tempList = new ArrayList<>();

        String[] arr = {};
        Cursor cursor = db.rawQuery("SELECT *  FROM Mood  ORDER BY _date", arr);

        while (cursor.moveToNext()) {
            int mood = cursor.getInt(cursor.getColumnIndexOrThrow(MyDataBase._MOOD));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(MyDataBase._DATE));
            tempList.add(new DayMood(date, mood));
        }
        cursor.close();
        return tempList;
    }

    public Boolean hasTodayRecord() {

        String[] arr = {};
        Cursor cursor = db.rawQuery(GET_TODAY_RECORD, arr);

        if (cursor.getCount() != 0) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }

    public void closeDB() {
        myDBHelper.close();
    }
}
