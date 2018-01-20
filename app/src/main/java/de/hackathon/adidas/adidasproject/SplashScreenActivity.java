package de.hackathon.adidas.adidasproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    private static int splashScreenDelay = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        ActivityStarter starter = new ActivityStarter();
        starter.start();
    }


    private class ActivityStarter extends Thread {
        @Override
        public void run() {
            try {
                // Execute any task in background during init. BD connection etc.*
                Thread.sleep(splashScreenDelay);
            } catch (Exception e) {
                Log.e("SplashScreen", e.getMessage());
            }
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);  // replace null with new Activity (tabbed one)
            SplashScreenActivity.this.startActivity(intent);
            SplashScreenActivity.this.finish();
        }
    }
}