package com.brownie.collaborated_cowork.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.brownie.collaborated_cowork.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "Splash Activity";

    private static final int SPLASH_SCREEN_DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        showSplash();
    }

    private void showSplash()
    {
        Log.d(TAG, "showSplash: called");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                Log.d(TAG, "run: showSplash Going to HomeActivity");

                startActivity(new Intent(SplashActivity.this, HomeActivity.class));

                finish();
            }
        }, SPLASH_SCREEN_DURATION);
    }
}
