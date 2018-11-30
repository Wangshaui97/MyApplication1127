package com.bawei.www.day2lianxi1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class CustomView extends View {

    Paint mpaint;
    private int[] top;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public void setData(int[] num) {
            int aa =num[0];
            int bb = num[1];
            int cc = num[2];
          top = new int[]{aa,bb,cc};

    }



    private void init() {
        mpaint = new Paint();
        mpaint.setColor(Color.BLUE);
        mpaint.setStrokeWidth(10);
        mpaint.setStyle(Paint.Style.FILL);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //矩形
        mpaint.setColor(Color.RED);
        canvas.drawRect(50, 300 - top[0], 160, 300, mpaint);
        mpaint.setColor(Color.BLACK);
        canvas.drawRect(200, 300 - top[1], 330, 300, mpaint);
        mpaint.setColor(Color.GREEN);
        canvas.drawRect(370, 300 - top[2], 480, 300, mpaint);

        //X轴
        mpaint.setColor(Color.BLACK);
        canvas.drawLine(10, 300, 700, 300, mpaint);
        //Y轴
        canvas.drawLine(10, 10, 10, 300, mpaint);

    }


}
