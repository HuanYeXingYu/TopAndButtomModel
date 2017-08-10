package com.nzsc.topandbuttommodel.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nzsc.mylibrary.Base.MyBaseFragment;
import com.nzsc.mylibrary.Entity.FragmAndIndex;
import com.nzsc.mylibrary.RecycleView.AdapterAndOther.ChannelItem;
import com.nzsc.mylibrary.horViewpager.view.indicator.IndicatorViewPager;
import com.nzsc.mylibrary.horViewpager.view.indicator.ScrollIndicatorView;
import com.nzsc.mylibrary.horViewpager.view.indicator.slidebar.DrawableBar;
import com.nzsc.mylibrary.horViewpager.view.indicator.slidebar.ScrollBar;
import com.nzsc.mylibrary.horViewpager.view.indicator.transition.OnTransitionTextListener;
import com.nzsc.topandbuttommodel.Activity.ChannelActivity;
import com.nzsc.topandbuttommodel.Adapter.ChildFrgAdapter;
import com.nzsc.topandbuttommodel.Application.MyApplication;
import com.nzsc.topandbuttommodel.ChildFragment.MoreFragment;
import com.nzsc.topandbuttommodel.ChildFragment.PageFragment1;
import com.nzsc.topandbuttommodel.ChildFragment.PageFragment2;
import com.nzsc.topandbuttommodel.ChildFragment.PageFragment3;
import com.nzsc.topandbuttommodel.ChildFragment.PageFragment4;
import com.nzsc.topandbuttommodel.ChildFragment.PageFragment5;
import com.nzsc.topandbuttommodel.R;
import com.nzsc.topandbuttommodel.View.MyTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.nzsc.mylibrary.Utils.FrIntentTo.dipToPix;
import static com.nzsc.mylibrary.Utils.FrIntentTo.myStartActivity;
import static com.nzsc.topandbuttommodel.Application.MyApplication.getUserSelectedList;

/**
 * Created by WangChang on 2016/5/15.
 */
public class HomePageFragment extends MyBaseFragment implements View.OnClickListener {


    @BindView(R.id.tab_indicator)
    ScrollIndicatorView scrollIndicatorView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.imag_add_channel)
    ImageView imagAddChannel;


    private IndicatorViewPager indicatorViewPager;

    private int size = MyApplication.userSelectedList.size();

    private String[] names;
    private int unSelectTextColor;
    //
//    @BindView(R.id.view_pager)
//    ViewPager viewPager;
//    private List<String> titleList = new ArrayList<>();
//    private List<Fragment> fragmentList = new ArrayList<>();
//    public static MyViewPagerAdapter adapter;
//    HomePageFragment fragment;
    @BindView(R.id.myTitleView)
    MyTitleView titleView;
    List<FragmAndIndex> pagerList = new ArrayList<>();
    ChildFrgAdapter adapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.frag_home_page;
    }

    @Override
    protected void initData() {


        scrollIndicatorView.setBackgroundColor(Color.RED);
        scrollIndicatorView.setScrollBar(new DrawableBar(context, R.drawable.round_border_white_selector, ScrollBar.Gravity.CENTENT_BACKGROUND) {
            @Override
            public int getHeight(int tabHeight) {
                return tabHeight - dipToPix(getContext(), 12);
            }

            @Override
            public int getWidth(int tabWidth) {
                return tabWidth - dipToPix(getContext(), 12);
            }
        });

        unSelectTextColor = Color.WHITE;
        // 设置滚动监听
        scrollIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.RED, unSelectTextColor));

        viewPager.setOffscreenPageLimit(2);
        indicatorViewPager = new IndicatorViewPager(scrollIndicatorView, viewPager);

        names = new String[size];

        for (int i = 0; i < size; i++) {
            names[i] = MyApplication.userSelectedList.get(i).getName();
        }
        pagerList.add(new FragmAndIndex(new PageFragment1(), 1));
        pagerList.add(new FragmAndIndex(new PageFragment2(), 2));
        pagerList.add(new FragmAndIndex(new PageFragment3(), 3));
        pagerList.add(new FragmAndIndex(new PageFragment4(), 4));
        pagerList.add(new FragmAndIndex(new PageFragment5(), 5));
        pagerList.add(new FragmAndIndex(new PageFragment1(), 6));
        pagerList.add(new FragmAndIndex(new PageFragment2(), 7));
        pagerList.add(new FragmAndIndex(new PageFragment3(), 8));
        pagerList.add(new FragmAndIndex(new PageFragment4(), 9));
        pagerList.add(new FragmAndIndex(new PageFragment5(), 10));
        pagerList.add(new FragmAndIndex(new PageFragment1(), 11));
        pagerList.add(new FragmAndIndex(new PageFragment2(), 12));
        pagerList.add(new FragmAndIndex(new PageFragment3(), 13));
        pagerList.add(new FragmAndIndex(new PageFragment4(), 14));
        pagerList.add(new FragmAndIndex(new PageFragment5(), 15));
        pagerList.add(new FragmAndIndex(new PageFragment1(), 16));
        pagerList.add(new FragmAndIndex(new PageFragment2(), 17));
        pagerList.add(new FragmAndIndex(new PageFragment3(), 18));
        pagerList.add(new FragmAndIndex(new PageFragment4(), 19));
        pagerList.add(new FragmAndIndex(new PageFragment5(), 20));


        adapter = new ChildFrgAdapter(getContext(), getChildFragmentManager(), names, getSelectedFragment(getContext(), pagerList));

        // 设置是否自动布局
        //    scrollIndicatorView.setSplitAuto(true);
        indicatorViewPager.setAdapter(adapter);

        scrollIndicatorView.setPinnedTabView(true);
        // 设置固定tab的shadow，这里不设置的话会使用默认的shadow绘制
        scrollIndicatorView.setPinnedShadow(R.drawable.tabshadow, dipToPix(getContext(), 4));
        scrollIndicatorView.setPinnedTabBgColor(Color.YELLOW);


//        //   TextView tv = (TextView) getActivity().findViewById(R.id.tv);
//        //   tv.setText(getArguments().getString("ARGS"));
//        titleList.add("总体用电");
//       // titleList.add("变压器");
//      //  titleList.add("监测点");
//     //   titleList.add("电能质量");
//     //   titleList.add("电力总量");

        titleView.setTitle("配用电检测体验");
        titleView.setRightImageRes(R.mipmap.xl_btn_hd_kf);
        titleView.setLeftImageRes(R.mipmap.xl_logo_hd);


    }

    @Override
    protected void initListener() {
        imagAddChannel.setOnClickListener(this);

    }


    public static HomePageFragment newInstance(String content) {
        args.putString("ARGS", content);
        HomePageFragment fragment = new HomePageFragment();
        // HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imag_add_channel:
                myStartActivity(getActivity(), ChannelActivity.class);
                break;
        }
    }


    @Override
    public void onStart() {


        super.onStart();
        size = getUserSelectedList(getContext()).size();
        names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = MyApplication.userSelectedList.get(i).getName();
        }
        adapter.setNames(names);
        adapter.setPagerList(getSelectedFragment(getContext(), pagerList));
        indicatorViewPager.getAdapter().notifyDataSetChanged();

    }

    public List<Fragment> getSelectedFragment(Context context, List<FragmAndIndex> fragmentList) {
        List<Fragment> pagerList = new ArrayList<>();
        List<ChannelItem> selectedItem = MyApplication.getUserSelectedList(context);
        for (ChannelItem channel : selectedItem) {
            int index = channel.getId();
            for (FragmAndIndex fai : fragmentList) {
                if (index == fai.getIndex()) {
                    pagerList.add(fai.getFragment());
                    break;
                }
            }
        }


        return pagerList;
    }

}
