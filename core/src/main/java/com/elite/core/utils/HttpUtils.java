package com.elite.core.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
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

    private RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

    public <T> T getSync(String url, Map<String, String> params, Class<T> clazz) {
        return this.getSync(url, params, null, clazz);
    }

    public <T> T getSync(String url, Map<String, String> params, Type typeOfT) {
        return this.getSync(url, params, null, typeOfT);
    }

    public <T> T getSync(String url, Map<String, String> params, final Map<String, String> headers, Class<T> clazz) {
        String response = doGet(url, params, headers);
        if (response != null) {
            return JsonUtils.getGson().fromJson(response, clazz);
        }
        return null;
    }

    public <T> T getSync(String url, Map<String, String> params, Map<String, String> headers, Type typeOfT) {
        String response = doGet(url, params, headers);
        if (response != null) {
            return JsonUtils.getGson().fromJson(response, typeOfT);
        }
        return null;
    }

    private String doGet(String url, Map<String, String> params, final Map<String, String> headers) {
        url = url + "?" + encodeParameters(params, DEFAULT_PARAMS_ENCODING);
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
        getRequestQueue().add(request);
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T postSync(String url, Map<String, String> params, boolean isJson, Class<T> clazz) {
        return this.postSync(url, params, null, isJson, clazz);
    }

    public <T> T postSync(String url, Map<String, String> params, Map<String, String> headers, Class<T> clazz) {
        return this.postSync(url, params, headers, false, clazz);
    }

    public <T> T postSync(String url, Map<String, String> params, final Map<String, String> headers, boolean isJson, Class<T> clazz) {
        String response;
        if (isJson) {
            response = doPostWithJsonBody(url, params, headers);
        } else {
            response = doPost(url, params, headers);
        }
        if (response != null) {
            return JsonUtils.getGson().fromJson(response, clazz);
        }
        return null;
    }

    public <T> T postSync(String url, Map<String, String> params, boolean isJson, Type typeOfT) {
        return this.postSync(url, params, null, isJson, typeOfT);
    }

    public <T> T postSync(String url, Map<String, String> params, Map<String, String> headers, Type typeOfT) {
        return this.postSync(url, params, headers, false, typeOfT);
    }

    public <T> T postSync(String url, Map<String, String> params, Map<String, String> headers, boolean isJson, Type typeOfT) {
        String response;
        if (isJson) {
            response = doPostWithJsonBody(url, params, headers);
        } else {
            response = doPost(url, params, headers);
        }
        if (response != null) {
            return JsonUtils.getGson().fromJson(response, typeOfT);
        }
        return null;
    }

    private String doPostWithJsonBody(String url, final Map<String, String> params, final Map<String, String> headers) {
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.POST, url, future, future) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                String json = JsonUtils.getGson().toJson(params);
                try {
                    return json.getBytes(DEFAULT_PARAMS_ENCODING);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return super.getBody();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        getRequestQueue().add(request);
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String doPost(String url, final Map<String, String> params, final Map<String, String> headers) {
        RequestFuture<String> future = RequestFuture.newFuture();
        StringRequest request = new StringRequest(Request.Method.POST, url, future, future) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        getRequestQueue().add(request);
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
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
