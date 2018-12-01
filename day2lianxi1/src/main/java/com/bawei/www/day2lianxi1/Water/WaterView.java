package com.bawei.www.day2lianxi1.Water;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.www.day2lianxi1.R;

import java.util.ArrayList;
import java.util.List;

public class WaterView extends LinearLayout {

    final int MAXSIZE = 22;

    List<String> stringList = new ArrayList<>();
    Context context;

    public WaterView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
    }

    public void setData(List<String> strList) {
        this.stringList = strList;
        showData();
    }

    private void showData() {
        removeAllViews();

        LinearLayout linearLayout_h = (LinearLayout) View.inflate(context, R.layout.water_item_h, null);
        addView(linearLayout_h);

        int len = 0;

        for (String str : stringList) {
            len += str.length();

            if (len > MAXSIZE) {
                linearLayout_h = (LinearLayout) View.inflate(context, R.layout.water_item_h, null);
                addView(linearLayout_h);

                len = str.length();
            }

            View view = View.inflate(context, R.layout.water_item_fall, null);
            TextView textView = view.findViewById(R.id.tv_item_fall);
            textView.setText(str);
            linearLayout_h.addView(view);

            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams.weight = 1;
            view.setLayoutParams(layoutParams);
        }

    }


}
