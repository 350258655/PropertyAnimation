package com.example.mac.propertyanimation.evaluator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shake on 17-2-22.
 * 在自定义View的构造方法当中初始化了一个Paint对象作为画笔，并将画笔颜色设置为蓝色，
 * 接着在onDraw()方法当中进行绘制。这里我们绘制的逻辑是由currentPoint这个对象控制的，
 * 如果currentPoint对象是空，那么就调用drawCircle()方法在currentPoint的坐标位置画出一个半径为50的圆，
 * 如果currentPoint对象不为空，那么就调用startAnimation()方法来启动动画
 */
public class MyView extends View {

    //当前的point
    private Point currentPoint;

    //画笔
    private Paint paint;

    public static final float RADIUS = 50f;


    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        //假如currentPoint是空的，那就证明此时没有圆，所以先创建一个原始的Point
        //再根据原始的Point去创建一个圆，然后开始动画
        if(currentPoint == null){
            currentPoint = new Point(RADIUS,RADIUS);
            drawCircle(canvas);
            startAnimation();
        }else {
            //假如currentPoint不是空的，那就证明此时圆是已经存在的了，再根据现在的ponit去画现在的圆
            drawCircle(canvas);
        }


    }

    /**
     * 开始动画
     */
    private void startAnimation() {
        //开始的point
        Point startPoint = new Point(RADIUS,RADIUS);
        //结束的Point
        Point entPoint = new Point(getWidth()-RADIUS,getHeight()-RADIUS);

        //创建一个ValueAnimator
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(),startPoint,entPoint);

        //加一个变化的监听器
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取最新的point
                currentPoint = (Point) animation.getAnimatedValue();
                //重新绘制，就会重新调用onDraw方法
                invalidate();
            }
        });

        //开始动画
        animator.setDuration(5000);
        animator.start();
    }

    /**
     * 画圆
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        //获取现在的x坐标
        float x = currentPoint.getX();
        //获取现在的y坐标
        float y = currentPoint.getY();
        //根据现在的x坐标和y坐标画圆
        canvas.drawCircle(x,y,50f,paint);
    }
}
