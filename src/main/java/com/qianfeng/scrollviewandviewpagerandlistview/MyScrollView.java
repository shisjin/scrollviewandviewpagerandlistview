package com.qianfeng.scrollviewandviewpagerandlistview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/11/15 0015.
 */
public class MyScrollView extends ScrollView{
    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //重写ScrollView
    @Override
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

}
