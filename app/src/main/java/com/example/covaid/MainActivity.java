package com.example.covaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=5000;
    Animation imageAnim, textAnim;
    ImageView image;
    TextView logo, tagline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);



        //making animations
        imageAnim = AnimationUtils.loadAnimation(this,R.anim.anim1);
        textAnim = AnimationUtils.loadAnimation(this,R.anim.anim2);

        image = findViewById(R.id.imageView);
        logo  = findViewById(R.id.textView2);
        tagline = findViewById(R.id.textView3);

        image.setAnimation(imageAnim);
        logo.setAnimation(textAnim);
        tagline.setAnimation(textAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,StartActivity.class));
                finish();
            }
        },SPLASH_SCREEN);


    }
}