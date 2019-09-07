package com.example.vaishakhgd.seproject;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import android.os.AsyncTask;
import java.util.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
public class MainActivity extends AppCompatActivity implements View.OnClickListener  {


    private Button buttonScan;
    public static TextView textViewName, textViewAddress;
    private IntentIntegrator qrScan;
    private  String JSON_URL="http://192.168.1.4/connect_psql.php";
    int count=0;
    RequestQueue requestQueue;
   // private ZXingScannerView ob1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy =new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonScan = (Button) findViewById(R.id.button1);
        textViewName = (TextView) findViewById(R.id.textView);
        textViewAddress = (TextView) findViewById(R.id.textView2);
        Cache cache=new DiskBasedCache(getCacheDir(),2048*2048);
        Network network=new BasicNetwork(new HurlStack());

        qrScan = new IntentIntegrator(this);

        //attaching onclick listener

        buttonScan.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        Downloader ob=new Downloader();
        ob.execute();
        if (result != null) {
            //if qrcode has nothing in it
            JSON_URL=result.getContents();
            textViewName.setText(result.getContents());
           /* try {
                URL myURL = new URL(result.getContents());
                URLConnection ucon = myURL.openConnection();
                String p= (String) ucon.getContent();
                String o= (String) myURL.getContent();
                textViewAddress.setText(o+p);
            }
            catch(Exception e){
               String myString = e.getMessage();
            }*/
           f1();
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    textViewName.setText(obj.getString("name"));
                    textViewAddress.setText(obj.getString("address"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onClick(View view) {
        qrScan.initiateScan();

    }


    public void f1() {

        requestQueue=Volley.newRequestQueue(MainActivity.this);

        requestQueue.start();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // loading.dismiss();

                textViewAddress.setText(response);
               // showJSON(response);
                requestQueue.stop();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error.getMessage()==null){
                            Toast.makeText(MainActivity.this, "Failed to retrieve data", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }

                        //Toast.makeText(Main2Activity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                        if(count<6) {
                            count++;
                            f1();
                        }
                        else
                            requestQueue.stop();
                    }
                });

       // RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void showJSON(String response){
        String name="";
        String address="";
        String vc = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("result");
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString("name");
            textViewAddress.setText("Name:\t"+name);

        } catch (JSONException e) {
            e.printStackTrace();
            textViewAddress.setText("lose");
        }

    }
}
