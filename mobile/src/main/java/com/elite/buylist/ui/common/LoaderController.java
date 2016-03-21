package com.elite.buylist.ui.common;

import android.os.Bundle;

import com.elite.core.loader.callback.FilterDataLoaderCallback;


/**
 * Create by wjc133
 * Date: 2016/1/19
 * Time: 18:43
 */
public interface LoaderController {
    void initLoader(int loaderId, Bundle bundle, FilterDataLoaderCallback callback);

    <D> void restartLoader(boolean isForceLoad, int loaderId, Bundle bundle, FilterDataLoaderCallback<D> callback);
}