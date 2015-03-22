package com.android.alex.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lvxin on 3/19/15.
 */
public class MyLayout extends ViewGroup {
    public static final String TAG = "com.android.alex.customlayout.Mylayout";

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        if(0 < childCount) {
            for(int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        if(0 < childCount) {
            //两个TextView,水平放置
            for(int i = 0; i< childCount; i++) {
                View childView = getChildAt(i);
                //
                int top = 100;
                int left = 0 == i ? 0 : getChildAt(i - 1).getMeasuredWidth();
                int right = left + childView.getMeasuredWidth();
                childView.layout(left, top, right, childView.getMeasuredHeight());
            }
        }
    }
}
