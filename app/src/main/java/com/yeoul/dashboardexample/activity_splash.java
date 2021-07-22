package com.yeoul.dashboardexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_splash extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    Animation topAnim, bottomAnim;
    ImageView imageView;
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        /* --- Hooks --- */
        imageView = findViewById(R.id.splash_imageView9);
        textView1 = findViewById(R.id.splash_textView11);
        textView2 = findViewById(R.id.splash_textView12);

        /* --- animation --- */
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        imageView.setAnimation(topAnim);
        textView1.setAnimation(bottomAnim);
        textView2.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(activity_splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}