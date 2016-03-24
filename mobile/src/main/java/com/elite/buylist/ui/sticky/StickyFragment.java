package com.elite.buylist.ui.sticky;

import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.elite.buylist.R;
import com.elite.buylist.ui.common.BaseFragment;
import com.elite.buylist.utils.NavigationUtils;

/**
 * Create by wjc133
 * Date: 2016/3/24
 * Time: 11:01
 */
public class StickyFragment extends BaseFragment {
    private FloatingActionButton fab;

    @Override
    protected void initData() {

    }

    @Override
    protected void configView() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationUtils.toCreateStickyActivity(getActivity());
            }
        });
    }

    @Override
    protected void findView() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_sticky;
    }
}
