package com.example.dns.translateapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by dns on 12.04.2017.
 */
public class SQLDataBase extends SQLiteOpenHelper {

    public SQLDataBase(Context context){
        super(context,"history",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Заряжаем", "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table mytable ("
                + "id integer primary key autoincrement,"
                + "word text,"
                + "wordtransed text" + ");");
        db.execSQL("create table mytable1 ("
                + "id integer primary key autoincrement,"
                + "word text,"
                + "wordtransed text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
