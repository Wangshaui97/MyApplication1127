package com.bawei.www.day3rikao;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.Collection;

public class BallView extends View {

    public float moveX = 150;
    public float moveY = 150;
    //    private int screenW ;
//    private int screenH ;
    Context context;

    private Paint mpaint;

    public BallView(Context context) {
        super(context);
        this.context = context;
    }

    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mpaint = new Paint();
        mpaint.setStrokeWidth(10);
        mpaint.setStyle(Paint.Style.FILL);


        canvas.drawColor(R.color.colorBack);


        mpaint.setColor(Color.BLUE);
        canvas.drawCircle(moveX, moveY, 60, mpaint);



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moveX = event.getX();
                moveY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = event.getX();
                moveY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                moveX = event.getX();
                moveY = event.getY();
                break;
        }
//
//        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//
//        int width = manager.getDefaultDisplay().getWidth();
//        int height = manager.getDefaultDisplay().getHeight();
//
//        if (moveX >= 150 && moveY >= 150 && moveX <= width - 150 && moveY <= height - 150) {
//            postInvalidate();
//        }
        invalidate();
        return true;
    }
}
