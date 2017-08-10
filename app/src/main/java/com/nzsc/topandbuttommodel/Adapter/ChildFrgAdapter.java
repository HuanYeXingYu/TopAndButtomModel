package com.nzsc.topandbuttommodel.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nzsc.mylibrary.horViewpager.view.indicator.IndicatorViewPager;
import com.nzsc.topandbuttommodel.R;

import java.util.List;

import static com.nzsc.mylibrary.Utils.FrIntentTo.dipToPix;

/**
 * Created by 夜墨 on 2017/8/10.
 */


public class ChildFrgAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

    private String[] names;
    private LayoutInflater inflate;
    private Context context;


    private List<Fragment> pagerList;

    public ChildFrgAdapter(Context context, FragmentManager fragmentManager, String[] names, List<Fragment> pagerList) {
        super(fragmentManager);
        this.names = names;
        inflate = LayoutInflater.from(context);
        this.pagerList = pagerList;
        this.context = context;
    }
    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
    public void setPagerList(List<Fragment> pagerList) {
        this.pagerList = pagerList;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public View getViewForTab(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.tab_top, container, false);
        }
        TextView textView = (TextView) convertView;
        textView.setText(names[position % names.length]);
        int padding = dipToPix(context, 10);
        textView.setPadding(padding, 0, padding, 0);
        return convertView;
    }

    @Override
    public Fragment getFragmentForPage(int position) {
        // Bundle args = new Bundle();
        //   args.putInt("position", position);
        //     pagerList.get(position).getFragment().setArguments(args);
        return pagerList.get(position);
//            MoreFragment fragment = new MoreFragment();
//            Bundle bundle = new Bundle();
//            bundle.putInt(MoreFragment.INTENT_INT_INDEX, position);
//            fragment.setArguments(bundle);
        //return MyApplication.userSelectedList.get(position).getId();
    }

    @Override
    public int getItemPosition(Object object) {
        //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
        // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage

        return PagerAdapter.POSITION_NONE;
    }

}


