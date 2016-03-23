package com.elite.core.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private RequestQueue requestQueue;

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    public <T> T getSync(String url, Map<String, String> params, Class<T> clazz) {
        return this.getSync(url, params, null, clazz);
    }

    public <T> T getSync(String url, Map<String, String> params, final Map<String, String> headers, Class<T> clazz) {
        url = url + encodeParameters(params, DEFAULT_PARAMS_ENCODING);
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.GET, url, future, future) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (headers == null) {
                    return super.getHeaders();
                }
                return headers;
            }
        };
        HttpUtils.INSTANCE.getRequestQueue().add(request);
        try {
            String response = future.get();
            JsonUtils.getGson().fromJson(response, clazz);
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

    private String encodeParameters(Map<String, String> params, String paramsEncoding) {
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                encodedParams.append('=');
                encodedParams.append(URLEncoder.encode(entry.getValue(), paramsEncoding));
                encodedParams.append('&');
            }
            return encodedParams.toString();
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }
}
