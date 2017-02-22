package com.example.mac.propertyanimation.evaluator;

/**
 * Created by shake on 17-2-22.
 * x和y两个变量用于记录坐标的位置，提供构造方法设置坐标，以及get方法获取坐标
 */
public class Point {

    private float x;

    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

}
