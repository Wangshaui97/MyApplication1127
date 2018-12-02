package com.bawei.www.day2lianxi1.weektest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.bawei.www.day2lianxi1.R;

public class WeekTitleViewGroup extends LinearLayout{
    Context mContext;

    public WeekTitleViewGroup(Context context) {
        super(context);
        mContext = context;
    }

    public WeekTitleViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.group_name_week, null);

    }
}
