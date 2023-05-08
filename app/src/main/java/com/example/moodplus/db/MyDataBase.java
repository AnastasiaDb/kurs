package com.example.moodplus.db;

public class MyDataBase {
    public static final String TABLE_NAME = "Mood";
    public static final String _ID = "_id";
    public static final String _TITLE = "_title";
    public static final String _DATE = "_date";
    public static final String DB_NAME = "mood_db.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY, " + _TITLE + " TEXT," + _DATE + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

}
