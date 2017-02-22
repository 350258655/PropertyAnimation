package com.example.mac.propertyanimation.interpolator;

import android.animation.TimeInterpolator;

/**
 * Created by shake on 17-2-22.
 */
public class MyInterpolator implements TimeInterpolator {

    /**
     * 实现先加速，后减速，再加速
     *
     * @param input
     * @return
     */
    @Override
    public float getInterpolation(float input) {

        float result;

        if (input <= 0.5) {
            result = (float) (Math.sin(Math.PI * input)) / 2;
        } else {
            result = (float) (2 - Math.sin(Math.PI * input)) / 2;
        }

        return result;
    }
}
