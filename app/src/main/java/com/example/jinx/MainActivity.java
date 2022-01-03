package com.example.jinx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private ImageView splash,imgS;
private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash = findViewById(R.id.lol);
        imgS=findViewById(R.id.lol);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.boom);
        imgS.startAnimation(animation);

        MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.jinxsong);
        ring.start();


        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {


            @Override

            public void run() {
                //This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(MainActivity.this, jinx.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 5000);
    }
}