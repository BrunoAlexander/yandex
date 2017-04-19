package com.example.dns.translateapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by dns on 18.04.2017.
 */
public class historyAdapter extends ArrayAdapter<String> {
    private final Context context;
    private String[]nonTrans;
    private String[]ttrans;


    public historyAdapter(Context context,String [] word,String[]unWord) {
        super(context,R.layout.best_of,word);
        this.context = context;
        this.nonTrans=unWord;
        this.ttrans = word;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.best_of,parent,false);
        TextView textView = (TextView)rowView.findViewById(R.id.unTranslatedWordFor);
        TextView textView1 = (TextView)rowView.findViewById(R.id.translatedWordHistory);
        textView.setText(nonTrans[position]);
        textView1.setText(ttrans[position]);


        return rowView;
    }
}
