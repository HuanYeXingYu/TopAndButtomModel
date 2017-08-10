package com.nzsc.mylibrary.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.nzsc.mylibrary.Base.BaseUpdatableFragmentPagerAdapter;
import com.nzsc.mylibrary.Base.MyBaseFragment;
import com.nzsc.mylibrary.Entity.FragmAndIndex;

import java.util.List;

/**
 * Created by 夜墨 on 2017/8/10.
 */

public class UpdatableFragAdapter extends BaseUpdatableFragmentPagerAdapter {

    private final List<FragmAndIndex> mItems;

    UpdatableFragAdapter(FragmentManager fm, List<FragmAndIndex> items) {
        super(fm);
        mItems = items;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putInt("position", position);
        mItems.get(position).getFragment().setArguments(args);
        return mItems.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public long getItemId(int position) {
        return mItems.get(position).getIndex();
    }

    @Override
    public int getItemPosition(Object object) {
        MyBaseFragment item = (MyBaseFragment) object;

        return item.getSomeIdentifier();
    }
}
