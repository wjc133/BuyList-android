package com.elite.core.utils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;

import org.json.JSONObject;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by wjc133.
 * Date: 2016/1/17
 * Time: 2:25
 * Description:Http请求工具
 */
public enum HttpUtils {
    INSTANCE;

    private RequestQueue requestQueue;

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    public <T> T getSync(String url, Map<String, String> params) {
        return this.getSync(url, params, null);
    }

    public <T> T getSync(String url, Map<String, String> params, final Map<String, String> headers) {
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, future, future) {
            @Override
            public Map<String, String> getHeaders() {
                return headers;
            }
        };
        HttpUtils.INSTANCE.getRequestQueue().add(request);
        try {
            JSONObject response = future.get();
//            return response;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T postSync(String url, Map<String, String> params, final Map<String, String> headers) {
        return this.postSync(url, params, headers, false);
    }

    public <T> T postSync(String url, Map<String, String> params, final Map<String, String> headers, boolean isJson) {
        return null;
    }
}
