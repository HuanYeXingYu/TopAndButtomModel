package com.nzsc.mylibrary.Utils;

import android.content.Context;
import android.content.Intent;
import android.util.TypedValue;

/**
 * Created by 夜墨 on 2017/8/9.
 */

public class FrIntentTo {
    public static void myStartActivity(Context fromClass, Class toClass) {
        Intent intent = new Intent();
        intent.setClass(fromClass, toClass);
        fromClass.startActivity(intent);


    }
    /**
     * 根据dip值转化成px值
     *
     * @param dip
     * @return
     */
    public static int dipToPix(Context context,float dip) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, context.getResources().getDisplayMetrics());
    }
}
