package com.example.mac.propertyanimation.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by shake on 17-2-22.
 */
public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {

        //根据startValue和endValue构造Point
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;

        //得到x坐标上的动画值,fraction表示动画的完成度
        float x = startPoint.getX() + fraction*(endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction*(endPoint.getY() - startPoint.getY());

        Point point = new Point(x,y);
        return point;
    }
}
