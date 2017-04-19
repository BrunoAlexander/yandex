package com.example.dns.translateapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Best_Act extends AppCompatActivity {

    ListView listView;
    historyAdapter ha;

    ContentValues cv;
    SQLDataBase sqlDataBase;
    SQLiteDatabase db;
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_);
        listView = (ListView) findViewById(R.id.ListOfBest);

        getFromSql gf = new getFromSql();
        gf.execute();

    }

    ArrayList<String> niceList = new ArrayList<String>();
    ArrayList<String> anotherList = new ArrayList<String>();

    class getFromSql extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            cv = new ContentValues();
            sqlDataBase = new SQLDataBase(getBaseContext());
            db = sqlDataBase.getWritableDatabase();
        }

        @Override
        protected Void doInBackground(Void... params) {
            c = db.query("mytable1", null, null, null, null, null, null);
            if (c.moveToFirst()) {
                int getWord = c.getColumnIndex("word");
                int getUnTransWord = c.getColumnIndex("wordtransed");
                do {
                    niceList.add(c.getString(getWord));
                    anotherList.add(c.getString(getUnTransWord));

                } while (c.moveToNext());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            String[] words = new String[niceList.size()];
            niceList.toArray(words);
            String[] anotherWords = new String[anotherList.size()];
            anotherList.toArray(anotherWords);
            ha = new historyAdapter(getBaseContext(), anotherWords, words);
            listView.setAdapter(ha);
        }
    }
}
