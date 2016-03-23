package com.elite.core.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Create by wjc133
 * Date: 2016/3/23
 * Time: 19:40
 */
public class JsonUtils {
    private static final Gson GSON = new GsonBuilder().create();

    private JsonUtils() {

    }

    public static Gson getGson() {
        return GSON;
    }
}
