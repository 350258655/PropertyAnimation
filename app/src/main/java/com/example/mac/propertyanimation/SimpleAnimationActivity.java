package com.example.mac.propertyanimation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_animation);

        final TextView tvsimple = (TextView) findViewById(R.id.tv_simple);
        Button btnstartsimple = (Button) findViewById(R.id.btn_rotation);
        Button btnscale = (Button) findViewById(R.id.btn_scale);
        Button btntranslation = (Button) findViewById(R.id.btn_translation);
        Button btnalpha = (Button) findViewById(R.id.btn_alpha);
        Button btnrotation = (Button) findViewById(R.id.btn_rotation);

        /**
         * 旋转动画
         */
        btnstartsimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取ObjectAnimator对象
                ObjectAnimator animator = ObjectAnimator.ofFloat(tvsimple,"rotation",0f,360f);
                animator.setDuration(5000);
                animator.start();

            }
        });


        /**
         * 像素动画
         */
        btnalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取ObjectAnimator对象
                ObjectAnimator animator = ObjectAnimator.ofFloat(tvsimple,"alpha",1f,0f,1f);
                animator.setDuration(5000);
                animator.start();
            }
        });


        /**
         * 平移动画
         */
        btntranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取水平方向上的位置
                float currentX = tvsimple.getTranslationX();
                //获取ObjectAnimator对象
                ObjectAnimator animator = ObjectAnimator.ofFloat(tvsimple,"translationX",currentX,-500f,currentX);
                animator.setDuration(5000);
                animator.start();

            }
        });

        /**
         * 缩放动画
         */
        btnscale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(tvsimple,"scaleY",1f,3f,1f);
                animator.setDuration(5000);
                animator.start();
            }
        });

    }
}
