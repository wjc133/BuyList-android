package com.elite.buylist.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.elite.buylist.R;
import com.elite.core.loader.callback.FilterDataLoaderCallback;
import com.elite.core.loader.callback.FilterDataLoaderCallbackAdapter;

/**
 * Create by wjc133
 * Date: 2015/11/9
 * Time: 11:15
 */
public abstract class BaseFragment extends Fragment implements LoaderController {
    private View mContentView;
    private SparseArray<FilterDataLoaderCallbackAdapter> mFilterDataLoaderCallbackAdapters = new SparseArray<>();

    @SuppressWarnings("unchecked")
    private FilterDataLoaderCallbackAdapter getFilterDataLoaderCallbackAdapter(int loaderId, FilterDataLoaderCallback callback, LoaderManager manager) {
        if (mFilterDataLoaderCallbackAdapters.indexOfKey(loaderId) < 0) {
            mFilterDataLoaderCallbackAdapters.put(loaderId, new FilterDataLoaderCallbackAdapter<>(callback, manager));
        }

        return mFilterDataLoaderCallbackAdapters.get(loaderId);
    }

    @Override
    public void initLoader(int loaderId, Bundle bundle, FilterDataLoaderCallback callback) {
        getLoaderManager().initLoader(loaderId, bundle, getFilterDataLoaderCallbackAdapter(loaderId, callback, getLoaderManager()));
    }

    @Override
    public <D> void restartLoader(boolean isForceLoad, int loaderId, Bundle bundle, FilterDataLoaderCallback<D> callback) {
        getLoaderManager().restartLoader(loaderId, bundle, getFilterDataLoaderCallbackAdapter(loaderId, callback, getLoaderManager()));
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        //can do sth common...
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.container);
        mContentView = inflater.inflate(getContentView(), frameLayout, true);
        initData();
        findView();
        configView();
        return view;
    }

    protected abstract void initData();

    protected abstract void configView();

    protected abstract void findView();

    protected abstract int getContentView();

    public View findViewById(int id) {
        return mContentView.findViewById(id);
    }

}
