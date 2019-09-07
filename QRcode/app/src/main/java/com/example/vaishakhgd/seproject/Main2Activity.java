package com.example.vaishakhgd.seproject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    Context context;
    private static final String JSON_URL = "http://192.168.0.172/se/2.php";//49.207.51.85   192.168.0.172
    List<Hero> heroList;
    TextView t1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        heroList = new ArrayList<Hero>();
        t1 = (TextView) findViewById(R.id.textView3);
       f1();
    }


    public void f1() {

            StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // loading.dismiss();


                    if(1==1)

                    showJSON(response);
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if(error.getMessage()==null){
                                Toast.makeText(Main2Activity.this, "Failed to retrieve data", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(Main2Activity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                            }
                            //Toast.makeText(Main2Activity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
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
            t1.setText("Name:\t"+name);

        } catch (JSONException e) {
            e.printStackTrace();
            t1.setText("lose");
        }

    }
    }


