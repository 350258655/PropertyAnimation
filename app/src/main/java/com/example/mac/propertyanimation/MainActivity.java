package com.example.mac.propertyanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnbyxml = (Button) findViewById(R.id.btn_byxml);
        Button btngroup = (Button) findViewById(R.id.btn_group);
        Button btnsimple = (Button) findViewById(R.id.btn_simple);

        btnsimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SimpleAnimationActivity.class));
            }
        });


        btngroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GroupAnimationActivity.class));
            }
        });

        btnbyxml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,XMLAnimationActivity.class));
            }
        });

    }
}
