package com.bawei.www.day2lianxi1.weektest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bawei.www.day2lianxi1.R;

@SuppressLint("AppCompatCustomView")
public class WeekGroupNameLayout extends TextView{


    public WeekGroupNameLayout(Context context) {
        super(context);
    }

    public WeekGroupNameLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WeekFlowLayout);
        int color = typedArray.getColor(R.styleable.WeekFlowLayout_textColor, Color.BLACK);

        setTextColor(color);
    }


}
