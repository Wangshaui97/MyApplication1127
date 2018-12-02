package com.bawei.www.day2lianxi1.weektest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.www.day2lianxi1.R;

public class TitleBarView extends LinearLayout {
    Context mContext;

    public TitleBarView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TitleBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.title, null);
        final EditText editText = view.findViewById(R.id.edit_title);
        view.findViewById(R.id.search_title).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnButtonClickListener != null){
                    mOnButtonClickListener.onButtonClick(editText.getText().toString());
                }
            }
        });
        addView(view);
    }

    OnBuutonClickListener mOnButtonClickListener;

    public void  setButtonClickListener(OnBuutonClickListener onBuutonClickListener){
        mOnButtonClickListener = onBuutonClickListener;
    }

    public interface OnBuutonClickListener{
        void onButtonClick(String str);
    }
}
