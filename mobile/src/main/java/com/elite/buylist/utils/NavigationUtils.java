package com.elite.buylist.utils;

import android.content.Context;
import android.content.Intent;

import com.elite.buylist.ui.sticky.CreateStickyActivity;

/**
 * Create by wjc133
 * Date: 2015/11/9
 * Time: 17:11
 */
public class NavigationUtils {
    public static void toCreateStickyActivity(Context context) {
        Intent intent = new Intent(context, CreateStickyActivity.class);
        context.startActivity(intent);
    }
}