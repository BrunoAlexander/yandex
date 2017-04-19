package com.example.dns.translateapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by dns on 11.04.2017.
 */
public class AnotherAdapter extends ArrayAdapter<String> {
    private final Context context;
    private String [] translated;

    public AnotherAdapter(Context context, String [] tran) {
        super(context,R.layout.trans ,tran);
        this.context = context;
        this.translated = tran;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.trans,parent,false);
        TextView textView = (TextView)rowView.findViewById(R.id.helloString);
        textView.setText("Вар.перевода: " + translated[position]);

        return rowView;
    }


}
