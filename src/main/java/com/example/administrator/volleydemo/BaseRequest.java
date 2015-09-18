package com.example.administrator.volleydemo;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by Administrator on 2015/9/18.
 */
public class BaseRequest extends StringRequest {
    private int method;
    private String url;
    public BaseRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

}
