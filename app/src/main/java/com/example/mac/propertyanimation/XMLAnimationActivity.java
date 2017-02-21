package com.example.mac.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class XMLAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlanimation);
        final TextView tvxml = (TextView) findViewById(R.id.tv_xml);
        Button btnxml = (Button) findViewById(R.id.btn_xml);

        btnxml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过XML文件加载Animator
                Animator animator = AnimatorInflater.loadAnimator(XMLAnimationActivity.this,R.animator.group);
                //设置目标
                animator.setTarget(tvxml);
                animator.start();
            }
        });

    }
}
