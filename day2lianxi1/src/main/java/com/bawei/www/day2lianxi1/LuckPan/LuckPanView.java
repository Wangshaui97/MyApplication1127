package com.bawei.www.day2lianxi1.LuckPan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class LuckPanView extends View {


    private Paint mpaint;
    int mCircleCount = 6;
    float mStartAngle = 0;
    private RectF rectF;

    public LuckPanView(Context context) {
        super(context);
        init();
    }

    public LuckPanView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mpaint = new Paint();
        mpaint.setColor(Color.BLACK);
        mpaint.setStrokeWidth(10);
        mpaint.setTextSize(30);
        mpaint.setStyle(Paint.Style.FILL);

        rectF = new RectF();
        rectF.bottom=400;
        rectF.top=50;
        rectF.left=50;
        rectF.right=400;
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

        for (int i = 0; i < mCircleCount; i++) {
            if (i % 2 == 0) {
                mpaint.setColor(Color.RED);
            }else{
                mpaint.setColor(Color.GREEN);
            }
            canvas.drawArc(rectF,mStartAngle,60,true,mpaint);
            mStartAngle +=60;

        }

        mpaint.setColor(Color.BLACK);
        canvas.drawText("开始",200,235,mpaint);

    }
}
