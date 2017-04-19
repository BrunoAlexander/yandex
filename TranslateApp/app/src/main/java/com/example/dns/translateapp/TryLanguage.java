package com.example.dns.translateapp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

//весь этот класс создан онли для установки
//связи с сервером и получения запроса и ответа

public class TryLanguage {
    int count = 0;
    public String translatedWord(String language, String text){
        String urlYandex = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20170321T082425Z.e533abe9050dd485.cbb0d68db8729aca17aff447b7ae7af1cae7b6c6";
        try {
            URL url = new URL(urlYandex);
            HttpsURLConnection connect = (HttpsURLConnection)url.openConnection();//открывается коннекшн
            connect.setRequestMethod("POST");
            connect.setDoOutput(true);
            DataOutputStream dst = new DataOutputStream(connect.getOutputStream());
            dst.writeBytes("text="+ URLEncoder.encode(text,"UTF-8")+"&lang="+language);
            //послали запрос, теперь получаем ©
            InputStream answer = connect.getInputStream();
            //теперь сканер и получаем нередактированный ответ
            Scanner scn = new Scanner(answer);
            String answString = null;
            while(scn.hasNext()){
                answString = scn.nextLine();
            }
            int startWord = answString.indexOf("[");
            int endWord = answString.indexOf("]");
            String finalAnswer = answString.substring(startWord+2,endWord-1);

            return finalAnswer;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
