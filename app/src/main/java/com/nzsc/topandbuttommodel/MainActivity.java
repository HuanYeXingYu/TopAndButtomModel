package com.nzsc.topandbuttommodel;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.nzsc.topandbuttommodel.Fragment.ApplicationCenterFragment;
import com.nzsc.topandbuttommodel.Fragment.HomePageFragment;
import com.nzsc.topandbuttommodel.Fragment.InteractionCenterFragment;
import com.nzsc.topandbuttommodel.Fragment.PersonalCenterFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;


//                //        .SCREEN_ORIENTATION_LANDSCAPE);// 横屏
//                //setRequestedOrientation(ActivityInfo
//                .SCREEN_ORIENTATION_PORTRAIT);//竖屏
//        setContentView(R.layout.activity_main);
public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    //  private ArrayList<Fragment> fragments;
    FragmentTransaction transaction;
    FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        assert bottomNavigationBar != null;
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
//        BadgeItem numberBadgeItem = new BadgeItem()
//                .setBorderWidth(4)
//                .setBackgroundColor(Color.RED)
//               .setText("5")
//                .setHideOnSelect(true);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.btn_dhl_fhzy, "首页").setActiveColorResource(R.color.orange)
                //     .setBadgeItem(numberBadgeItem)
        )
                .addItem(new BottomNavigationItem(R.mipmap.otherservice_selected, "应用中心").setActiveColorResource(R.color.grey))
                .addItem(new BottomNavigationItem(R.mipmap.xl_btn_bqdh_hd_h, "互动中心").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.mipmap.personcenter_selected, "个人中心").setActiveColorResource(R.color.brown))

                //   .addItem(new BottomNavigationItem(R.mipmap.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey)
                //     .setBadgeItem(numberBadgeItem)
                //   )
                .setFirstSelectedPosition(0)

                .initialise();

        // fragments = getFragments();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);


    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        fm = getSupportFragmentManager();
        transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, HomePageFragment.newInstance("首页"));
        transaction.commit();
    }


    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                transaction = fm.beginTransaction();
                transaction.replace(R.id.layFrame, HomePageFragment.newInstance("首页"));
                transaction.commit();
                break;
            case 1:
                transaction = fm.beginTransaction();
                transaction.replace(R.id.layFrame, ApplicationCenterFragment.newInstance("应用中心"));
                transaction.commit();

                break;
            case 2:
                transaction = fm.beginTransaction();
                transaction.replace(R.id.layFrame, InteractionCenterFragment.newInstance("互动中心"));
                transaction.commit();
                break;
            case 3:
                transaction = fm.beginTransaction();
                transaction.replace(R.id.layFrame, PersonalCenterFragment.newInstance("个人中心"));
                transaction.commit();
                break;


        }



    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}

