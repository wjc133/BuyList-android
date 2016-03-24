package com.elite.buylist.ui.sticky;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.elite.buylist.R;
import com.elite.buylist.ui.common.BaseActivity;

/**
 * Created by wjc133.
 * Date: 2016/3/24
 * Time: 23:22
 * Description: 创建Sticky的页面
 */
public class CreateStickyActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_sticky_create);
    }
}
