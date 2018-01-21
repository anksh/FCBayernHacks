package de.hackathon.adidas.adidasproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    private static int splashScreenDelay = 4300;

    @BindView(R.id.videoView2)
    protected VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        prepareVide();

        ActivityStarter starter = new ActivityStarter();
        starter.start();
    }

    private void prepareVide(){

       /* String path = "android.resource://" + getPackageName() + "/source.mp4";
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();*/

        //https://i.giphy.com/media/3ohc141pmuGI2Vkp7W/source.mp4
        Uri uri=Uri.parse("https://i.giphy.com/media/l49JUSG1JinjhobBK/source.mp4");
        videoView.setVideoURI(uri);
        videoView.playSoundEffect(0);
        videoView.requestFocus();
      //  videoView.start();

    }
    private class ActivityStarter extends Thread {
        @Override
        public void run() {
            //prepareVide();
            videoView.start();
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