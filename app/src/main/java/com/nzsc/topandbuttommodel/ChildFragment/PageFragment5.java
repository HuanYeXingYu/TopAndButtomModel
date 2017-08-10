package com.nzsc.topandbuttommodel.ChildFragment;

import android.widget.TextView;

import com.nzsc.mylibrary.Base.MyBaseFragment;
import com.nzsc.topandbuttommodel.R;

import java.util.Locale;

import butterknife.BindView;

public class PageFragment5 extends MyBaseFragment {

     @BindView(R.id.fragment_title)
     TextView title;
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_page;
    }

    @Override
    protected void initData() {
        title.setText("PageFragment5" );
    }

    @Override
    protected void initListener() {

    }

}
