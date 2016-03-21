package com.elite.buylist.common;

import android.content.Context;

import com.elite.buylist.R;
import com.elite.buylist.constant.EnvType;
import com.elite.core.UriProvider;


/**
 * Create by wjc133
 * Date: 2016/1/6
 * Time: 22:35
 */
public class UriManager {
    private static Context appContext;

    public static void init(EnvType envType, Context context) {
        if (null == envType || null == context) {
            return;
        }

        appContext = context;
        if (envType == EnvType.DEV) {//开发环境地址
            initDevUri();
        } else if (envType == EnvType.PRODUCT) {//生产环境地址
            initProductUri();
        } else if (envType == EnvType.TEST) {//测试环境地址
            initTestUri();
        }
    }

    private static void initTestUri() {
        UriProvider.init(appContext.getString(R.string.test_data_host),
                appContext.getString(R.string.test_baidu_host));
    }

    private static void initProductUri() {
        UriProvider.init(appContext.getString(R.string.product_data_host),
                appContext.getString(R.string.product_baidu_host));
    }

    public static void initDevUri() {
        UriProvider.init(appContext.getString(R.string.dev_data_host),
                appContext.getString(R.string.dev_baidu_host));
    }
}
