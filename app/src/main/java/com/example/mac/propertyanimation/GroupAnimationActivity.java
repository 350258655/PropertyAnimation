package com.example.mac.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GroupAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_animation);
        final TextView tvgroup = (TextView) findViewById(R.id.tv_group);
        Button btnstartgroup = (Button) findViewById(R.id.btn_start_group);

        btnstartgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator moveIn = ObjectAnimator.ofFloat(tvgroup, "translationX", -500f, 0f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(tvgroup, "rotation", 0f, 360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(tvgroup, "alpha", 1f, 0f, 1f);

                AnimatorSet animatorSet = new AnimatorSet();
                //在平移到屏幕中央的时候，开始旋转和像素变化
                animatorSet.play(rotate).with(fadeInOut).after(moveIn);
                animatorSet.setDuration(5000);
                animatorSet.start();

                /**
                 * 动画监听器
                 */
                fadeInOut.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Toast.makeText(GroupAnimationActivity.this, "动画结束了", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
