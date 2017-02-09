package com.reddyz.mbbtutorials;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer splashMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        splashMusic = MediaPlayer.create(MainActivity.this, R.raw.businessman);
        splashMusic.start();

        Thread logoTimer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent menuIntent = new Intent("com.reddyz.mbbtutorials.MENU");
                    startActivity(menuIntent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };

        logoTimer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashMusic.release();
    }
}
