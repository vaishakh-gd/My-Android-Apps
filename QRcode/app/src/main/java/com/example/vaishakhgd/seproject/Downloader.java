package com.example.vaishakhgd.seproject;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by vaishakh g d on 14-10-2017.
 */
public class Downloader extends AsyncTask<Void,Void,Void> {
    String myString = "";
    @Override
    protected Void doInBackground(Void... arg0) {
        try {
           // String p="host=ec2-107-22-160-199.compute-1.amazonaws.com port=5432 dbname=d4g0u6alpfr93h user=okdddtuimwkwre password=78ae3831414769bc68dc7b281f970db0d6e24b94edc2a40462a371800c2d6b2d";
            URL myURL = new URL("http://192.168.1.4/connect_psql.php");
            URLConnection ucon = myURL.openConnection();
            InputStream is = ucon.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));


            String s = "";
            // ByteArrayBuffer baf = new ByteArrayBuffer(50);
            int current = 0;
            while (s != null) {
                // baf.append((byte)current);
                s = bis.readLine();
                myString += s;
            }

        } catch (Exception e) {
            myString = e.getMessage();
        }

        return null;
    }
    @Override
    protected void onPostExecute(Void result){
        //.setText(result);
        super.onPostExecute(result);
        MainActivity.textViewAddress.setText(myString);
    }
}