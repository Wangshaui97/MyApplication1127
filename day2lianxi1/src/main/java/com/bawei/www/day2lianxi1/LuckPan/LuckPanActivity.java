package com.bawei.www.day2lianxi1.LuckPan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;

import com.bawei.www.day2lianxi1.R;

public class LuckPanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_pan);

        initView();

    }

    private void initView() {
        final LuckPanView luckPanView = findViewById(R.id.mcustom);
        findViewById(R.id.mcustom_inside).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float degrees = (float) (720 + Math.random() * 1000);

                RotateAnimation rotateAnimation = new RotateAnimation(0,-degrees,225,225);
                rotateAnimation.setDuration(5000);
                rotateAnimation.setFillAfter(true);
                luckPanView.startAnimation(rotateAnimation);
            }
        });

//        float[] angles = new float[]{
//                100,60,100,50,20,30
//        };


    }
}
