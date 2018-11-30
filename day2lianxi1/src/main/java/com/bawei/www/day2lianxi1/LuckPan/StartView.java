package com.bawei.www.day2lianxi1.LuckPan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class StartView extends View {

    private Paint mpaint;
    private RectF rectF;

    public StartView(Context context) {
        super(context);
        init();
    }



    public StartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        mpaint = new Paint();
        mpaint.setColor(Color.RED);
        mpaint.setStrokeWidth(10);
        mpaint.setTextSize(30);
        mpaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF = new RectF();
        rectF.top = 50;
        rectF.bottom = 200;
        rectF.right = 275;
        rectF.left = 175;

        mpaint.setColor(Color.BLACK);
        canvas.drawArc(rectF,60,60,true,mpaint);
        mpaint.setColor(Color.BLUE);
        canvas.drawCircle(225,225,50,mpaint);
        mpaint.setColor(Color.BLACK);
        canvas.drawText("开始",200,235,mpaint);


    }
}
