package com.nzsc.topandbuttommodel.Fragment;


import com.nzsc.mylibrary.Base.MyBaseFragment;
import com.nzsc.topandbuttommodel.R;

/**
 * Created by WangChang on 2016/5/15.
 */
public class InteractionCenterFragment extends MyBaseFragment {
    @Override
    protected int getLayoutRes() {
        return R.layout.frag_interaction_center;
    }

    @Override
    protected void initData() {
        //   TextView tv = (TextView) getActivity().findViewById(R.id.tv);
        //   tv.setText(getArguments().getString("ARGS"));
    }

    @Override
    protected void initListener() {

    }



    public static InteractionCenterFragment newInstance(String content) {

        args.putString("ARGS", content);
        InteractionCenterFragment fragment = new InteractionCenterFragment();

        fragment.setArguments(args);
        return fragment;
    }
}
