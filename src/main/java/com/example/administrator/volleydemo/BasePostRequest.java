package com.example.administrator.volleydemo;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/11.
 */
public class BasePostRequest extends Request {
    private String params;
    public BaseCallback callback;
    public final String TAG = "VolleyRequest";
    public final String contentType_JSON = "application/json";
    public final String contentType_form_urlencoded="application/x-www-form-urlencoded";
    private String Authorization_Basic = "Basic MzUzYjMwMmM0NDU3NGY1NjUwNDU2ODdlNTM0ZTdkNmE6Mjg2OTI0Njk3ZTYxNWE2NzJhNjQ2YTQ5MzU0NTY0NmM=";

    public BasePostRequest(String url, String params, BaseCallback callback) {
        super(Method.POST, url, callback);
        this.callback = callback;
        this.params = params;
        Log.e(TAG, "request:" + params);
        setShouldCache(false);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Charset", "UTF-8");
//        if(TextUtils.isEmpty(Authorization)){
//            headers.put("Content-Type", contentType_form_urlencoded);
//        }else{
//            headers.put("Content-Type", contentType_JSON);
//        }
//        if(TextUtils.isEmpty(Authorization)){
//            headers.put("Authorization", MyApplication.getInstance().Authorization_Basic);
//        }else{
            headers.put("Authorization", Authorization_Basic);
//        }
        return headers;
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse networkResponse) {
        return null;
    }

    @Override
    protected void deliverResponse(Object o) {

    }

    @Override
    public int compareTo(Object another) {
        return 0;
    }


    @Override
    public byte[] getBody() throws AuthFailureError {
        return params == null ? super.getBody() : params.getBytes();
    }
}
