package com.bawei.www.day2lianxi1.weektest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bawei.www.day2lianxi1.R;

public class WeekTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_test);

        init();
    }

    private void init(){
        final WeekFlowLayout fl_search = findViewById(R.id.fl_search);
        WeekFlowLayout fl_hot = findViewById(R.id.fl_hot);

        TitleBarView title = findViewById(R.id.title);
        title.setButtonClickListener(new TitleBarView.OnBuutonClickListener() {
            @Override
            public void onButtonClick(String str) {
                TextView tv = new TextView(WeekTestActivity.this);
                tv.setText(str);
                tv.setBackgroundResource(R.drawable.edit_bg);
                fl_search.addView(tv);
            }
        });

        for(int i = 0; i < 15; i++){
            TextView tv = new TextView(WeekTestActivity.this);
            tv.setText("热门" + i);
            tv.setBackgroundResource(R.drawable.edit_bg);
            fl_hot.addView(tv);
        }
    }
}
