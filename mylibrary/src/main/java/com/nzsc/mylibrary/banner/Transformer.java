package com.nzsc.mylibrary.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.nzsc.mylibrary.banner.transformer.AccordionTransformer;
import com.nzsc.mylibrary.banner.transformer.BackgroundToForegroundTransformer;
import com.nzsc.mylibrary.banner.transformer.CubeInTransformer;
import com.nzsc.mylibrary.banner.transformer.CubeOutTransformer;
import com.nzsc.mylibrary.banner.transformer.DefaultTransformer;
import com.nzsc.mylibrary.banner.transformer.DepthPageTransformer;
import com.nzsc.mylibrary.banner.transformer.FlipHorizontalTransformer;
import com.nzsc.mylibrary.banner.transformer.FlipVerticalTransformer;
import com.nzsc.mylibrary.banner.transformer.ForegroundToBackgroundTransformer;
import com.nzsc.mylibrary.banner.transformer.RotateDownTransformer;
import com.nzsc.mylibrary.banner.transformer.RotateUpTransformer;
import com.nzsc.mylibrary.banner.transformer.ScaleInOutTransformer;
import com.nzsc.mylibrary.banner.transformer.StackTransformer;
import com.nzsc.mylibrary.banner.transformer.TabletTransformer;
import com.nzsc.mylibrary.banner.transformer.ZoomInTransformer;
import com.nzsc.mylibrary.banner.transformer.ZoomOutSlideTransformer;
import com.nzsc.mylibrary.banner.transformer.ZoomOutTranformer;


public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
