package com.nzsc.mylibrary.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 夜墨 on 2017/8/2.
 */

public abstract class MyBaseFragment extends Fragment {


    public Unbinder unbinder;
    public View rootView; // 缓存Fragment view
    public Context context ;
    public static Bundle args = new Bundle();
    /**
     * 初始化布局
     */
    protected abstract int getLayoutRes();

    protected abstract void initData();

    protected abstract void initListener();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutRes(), container, false);
            unbinder = ButterKnife.bind(this, rootView);
            context = getActivity();
            initData();
            initListener();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onDestroy() {
     //   unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public int getSomeIdentifier() {
        return getArguments().getInt("position");
    }
}
