package com.example.moodplus.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    public void insertToDB(String title, String date) {
        ContentValues cv = new ContentValues();
        cv.put(MyDataBase._TITLE, title);
        cv.put(MyDataBase._DATE, date);
        db.insert(MyDataBase.TABLE_NAME, null, cv);
    }

    public List<String> getFromDB(){
        List<String> tempList = new ArrayList<>();
        Cursor cursor = db.query(MyDataBase.TABLE_NAME,null,null,null,
                null,null,null);

        while (cursor.moveToNext()){
            String text = cursor.getString(cursor.getColumnIndexOrThrow(MyDataBase._TITLE));
            tempList.add(text);
        }
        cursor.close();
        return tempList;
    }

    public void closeDB(){
        myDBHelper.close();
    }
}
