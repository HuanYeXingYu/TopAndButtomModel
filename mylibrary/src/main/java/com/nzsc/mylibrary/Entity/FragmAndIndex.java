package com.nzsc.mylibrary.Entity;

import android.support.v4.app.Fragment;

import com.nzsc.mylibrary.Base.MyBaseFragment;

/**
 * Created by 夜墨 on 2017/8/10.
 */

public class FragmAndIndex {
    private int index;
    private MyBaseFragment fragment;

    public FragmAndIndex(MyBaseFragment fragment, int index) {
        this.index = index;
        this.fragment = fragment;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(MyBaseFragment fragment) {
        this.fragment = fragment;
    }
}

