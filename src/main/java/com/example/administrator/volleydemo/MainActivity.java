package com.example.administrator.volleydemo;

import android.app.Activity;
import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    public final static String suffix = "-test";
    public final static String URL_HOST = "http://platform-api" + suffix+".1yd.me";//测试
    public static final String Authorization_Basic = "Basic MzUzYjMwMmM0NDU3NGY1NjUwNDU2ODdlNTM0ZTdkNmE6Mjg2OTI0Njk3ZTYxNWE2NzJhNjQ2YTQ5MzU0NTY0NmM=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String CITY__USE_URL="http://tenant-api-test.1yd.me/api/open/cities/?is_Available=true";//城市测试(可用的)
        getData(CITY__USE_URL,"13916539504","123456");

    }
    public void getData(String url, final String username, final String password){
        final String myurl=URL_HOST+"/oauth/token";
        final HashMap<String, String> params = new HashMap<String, String>();
        params.put("username",username);
        params.put("password",password);
        params.put("grant_type","password");
//        String url = URL_HOST + "/oauth/token?username="+ encode(username) + "&password=" + encode(password)+ "&grant_type=password";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, myurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("onResponse==Log===",s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(volleyError.getMessage()!=null){
                    Log.e("onErrorResponse==Log===",volleyError.getMessage());
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> params = new HashMap<String, String>();
//                params.put("username",username);
//                params.put("password",password);
//                params.put("grant_type","password");
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String ,String>headers=new HashMap<String ,String>();
                headers.put("Authorization", Authorization_Basic);
                return headers;
            }
        };
//
        JsonObjectRequest request=new JsonObjectRequest(myurl, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("onResponse==Log===",jsonObject.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("onErrorResponse==Log===",volleyError.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String ,String>headers=new HashMap<String ,String>();
                headers.put("Authorization", Authorization_Basic);
                return headers;
            }
        };
//        BasePostRequest basePostRequest=new BasePostRequest(myurl,params,new BaseCallback());
//        BaseGetRequest basePostRequest=new BaseGetRequest(url,new JSONObject(params).toString(),new BaseCallback());
        App.getInstance().addToRequestQueue(request);
    }
}
