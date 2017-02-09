package com.reddyz.mbbtutorials;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.reddyz.mbbtutorials.R;

/**
 * Created by Reddyz on 29-11-2016.
 */

public class MyMenu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1, b2;

        b1 = (Button) findViewById(R.id.bMenu1);
        final MediaPlayer buttonSound1 = MediaPlayer.create(this, R.raw.button_3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound1.start();
                Intent newIntent = new Intent("com.reddyz.mbbtutorials.TutorialOne");
                startActivity(newIntent);
            }
        });

        b2 = (Button) findViewById(R.id.bMenu2);
        final MediaPlayer buttonSound2 = MediaPlayer.create(this, R.raw.button_6);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound2.start();
                Intent newIntent = new Intent("com.reddyz.mbbtutorials.TutorialOne");
                startActivity(newIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInfl = getMenuInflater();
        menuInfl.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSweet :
                startActivity(new Intent("com.reddyz.mbbtutorials.Sweet"));
                return  true;
            case R.id.menuToast :
                Toast.makeText(this, "Millionaire and Billionaire \n       @MyMenu", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}
