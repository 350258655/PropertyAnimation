package com.example.mac.propertyanimation.interpolator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.mac.propertyanimation.evaluator.Point;
import com.example.mac.propertyanimation.evaluator.PointEvaluator;

/**
 * Created by shake on 17-2-22.
 */
public class MyInterpolatorView extends View {

    private Point currentPonit;

    private Paint paint;

    public static final float RADIUS = 50f;

    public MyInterpolatorView(Context context) {
        this(context, null);
    }

    public MyInterpolatorView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if(currentPonit == null){
            currentPonit = new Point(RADIUS,RADIUS);
            drawCicle(canvas);
            startAnimation();
        }else {
            drawCicle(canvas);
        }
    }

    /**
     * 开始动画
     */
    private void startAnimation() {
        Point startPoint = new Point(getWidth()/2 ,RADIUS);
        Point endPoint = new Point(getWidth()/2 ,getHeight() - RADIUS);

        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(),startPoint,endPoint);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取当前的Ponit
                currentPonit = (Point) animation.getAnimatedValue();
                //重新绘制，即重新调用onDraw方法
                invalidate();
            }
        });

        /**
         * 设置自定义的插值器
         */
        animator.setInterpolator(new MyInterpolator());
        animator.setDuration(5000);
        animator.start();


    }

    /**
     * 画圆
     * @param canvas
     */
    private void drawCicle(Canvas canvas) {
        float x = currentPonit.getX();
        float y = currentPonit.getY();
        canvas.drawCircle(x,y,RADIUS,paint);

    }
}
