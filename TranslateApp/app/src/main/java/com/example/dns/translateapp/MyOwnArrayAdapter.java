package com.example.dns.translateapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MyOwnArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private  String[] values;
    private final String []extras;
    private final String []unTransExtra;


    public MyOwnArrayAdapter(Context context,String[] input,String[] extra, String[] unTrans) {
        super(context, R.layout.translatedlist,input);
        this.context = context;
        this.values = input;
        this.extras = extra;
        this.unTransExtra = unTrans;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.translatedlist,parent,false);
        TextView textView = (TextView)rowView.findViewById(R.id.transWord);
        TextView newTextView = (TextView)rowView.findViewById(R.id.examplesGet);
        TextView lalaTextView = (TextView)rowView.findViewById(R.id.getSynonims);


        textView.setText("Вар. перевода: "+values[position]);
        newTextView.setText("Вар. использования: " + extras[position]);
        lalaTextView.setText("Пер. вар. исп.: " + unTransExtra[position]);

        /**Весьма интересно вышло, но часть слов
         * остается неиспользованной из-за обрезания по позиции. Можно
         * пофиксить, но выглядит не очень красиво, а так выглядит гармонично.
         * Хотя можно добавить онКлик, который будет записывать в текстовый файл
         * все варианты использования. Ну так, для красоты - ежели всё это нужно.
         * Но есть вариант вообще разделить всё на три стиля, в каждом из которых
         * будут записаны варианты, а потом менять по клику. Но стоит ли так превозмогать
         * во время теста, когда впереди ещё SQL?
         */

        return rowView;


    }



}
