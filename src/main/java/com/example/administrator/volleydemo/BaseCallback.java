package com.example.administrator.volleydemo;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;


/**
 * Created by Administrator on 2015/8/11.
 */
public class BaseCallback implements Response.Listener, Response.ErrorListener{
    @Override
    public void onErrorResponse(VolleyError volleyError) {
        if(volleyError.getMessage()!=null){
            Log.e("onErrorResponse",volleyError.getMessage());
        }else{
            Log.e("onErrorResponse",volleyError.toString());
        }
    }

    @Override
    public void onResponse(Object o) {
        Log.e("onResponse",o.toString());
    }
}
