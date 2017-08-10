package com.nzsc.mylibrary.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 夜墨 on 2017/8/2.
 * Base
 */

public abstract class MyBaseActivity extends AppCompatActivity {

    protected abstract int getLayoutID();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initEvent();

    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
        initEvent();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
