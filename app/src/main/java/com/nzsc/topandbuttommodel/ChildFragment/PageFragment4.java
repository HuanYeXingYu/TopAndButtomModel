package com.nzsc.topandbuttommodel.ChildFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nzsc.mylibrary.Base.MyBaseFragment;
import com.nzsc.topandbuttommodel.R;

import java.util.Locale;

import butterknife.BindView;

public class PageFragment4 extends MyBaseFragment {

     @BindView(R.id.fragment_title)
     TextView title;
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_page;
    }

    @Override
    protected void initData() {
        title.setText("PageFragment4");
    }

    @Override
    protected void initListener() {

    }

}
