package com.nzsc.topandbuttommodel.Fragment;

import com.nzsc.mylibrary.Base.MyBaseFragment;
import com.nzsc.topandbuttommodel.R;

/**
 * Created by WangChang on 2016/5/15.
 */
public class ApplicationCenterFragment extends MyBaseFragment {



    @Override
    protected int getLayoutRes() {
        return R.layout.frag_application_center;
    }

    @Override
    protected void initData() {
        // TextView tv = (TextView) getActivity().findViewById(R.id.tv);
        //   tv.setText(getArguments().getString("ARGS"));
    }

    @Override
    protected void initListener() {

    }


    public static ApplicationCenterFragment newInstance(String content) {

        args.putString("ARGS", content);
        ApplicationCenterFragment fragment = new ApplicationCenterFragment();


        fragment.setArguments(args);
        return fragment;
    }
}
