package com.android.alex.customviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by lvxin on 3/19/15.
 */
public class HeaderView extends FrameLayout {

    private TextView mTitleText;
    private Button mBackBtn;

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.header_layout, this);
        mTitleText = (TextView)findViewById(R.id.tv_title);
        mBackBtn = (Button)findViewById(R.id.btn_back);
        mBackBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }

    public void setTitleText(String text) {
        mTitleText.setText(text);
    }

    public void setBackButtonText(String text) {
        mBackBtn.setText(text);
    }

    public void setBackButtonListener(OnClickListener l) {
        mBackBtn.setOnClickListener(l);
    }
}
