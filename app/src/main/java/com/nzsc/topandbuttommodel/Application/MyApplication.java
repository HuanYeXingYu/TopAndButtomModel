package com.nzsc.topandbuttommodel.Application;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nzsc.mylibrary.RecycleView.AdapterAndOther.ChannelItem;
import com.nzsc.mylibrary.RecycleView.AdapterAndOther.ChannelManage;
import com.nzsc.mylibrary.RecycleView.db.SQLHelper;
import com.nzsc.topandbuttommodel.MainActivity;
import com.nzsc.topandbuttommodel.R;
import com.zxy.recovery.core.Recovery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 夜墨 on 2017/8/9.
 */

public class MyApplication extends Application {
    public static List<?> images = new ArrayList<>();
    public static List<String> titles = new ArrayList<>();
    public static int H, W;
    public static MyApplication app;

    public static List<ChannelItem> getUserSelectedList(Context context) {
        SQLHelper sqlHelper = new SQLHelper(context);
        ChannelManage channelManage = ChannelManage.getManage(sqlHelper);
        userSelectedList = channelManage.getUserChannel();
        return userSelectedList;
    }

    public static List<ChannelItem> userSelectedList;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        getScreen(this);
        Fresco.initialize(this);
        Recovery.getInstance()
                .debug(true)
                .recoverInBackground(false)
                .recoverStack(true)
                .mainPage(MainActivity.class)
                .init(this);
        String[] urls = getResources().getStringArray(R.array.url);
        String[] tips = getResources().getStringArray(R.array.title);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        List list1 = Arrays.asList(tips);
        titles = new ArrayList(list1);
        SQLHelper sqlHelper = new SQLHelper(this);
        ChannelManage channelManage = ChannelManage.getManage(sqlHelper);
        userSelectedList = channelManage.getUserChannel();
    }

    public void getScreen(Context aty) {
        DisplayMetrics dm = aty.getResources().getDisplayMetrics();
        H = dm.heightPixels;
        W = dm.widthPixels;
    }
}
