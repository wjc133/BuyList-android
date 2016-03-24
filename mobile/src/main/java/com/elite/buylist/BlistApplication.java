package com.elite.buylist;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.elite.buylist.common.Env;
import com.elite.core.base.CoreRegisterCenter;
import com.elite.core.utils.BasicConfig;
import com.elite.core.utils.HttpUtils;

/**
 * Create by wjc133
 * Date: 2016/3/21
 * Time: 13:03
 */
public class BlistApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        BasicConfig.INSTANCE.setAppContext(getApplicationContext());
        HttpUtils.INSTANCE.setRequestQueue(requestQueue);
        Env.instance().init();

        CoreRegisterCenter.registerCore();
    }
}
