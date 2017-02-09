package com.reddyz.mbbtutorials;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Reddyz on 30-11-2016.
 */

public class TutorialOne extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    EditText textInput;
    TextView textOutput;
    RadioGroup gravityG, styleG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorialone);

        textInput = (EditText) findViewById(R.id.etInput);
        textOutput = (TextView) findViewById(R.id.tvOutput);
        gravityG = (RadioGroup) findViewById(R.id.rgGravity);
        styleG = (RadioGroup) findViewById(R.id.rgStyle);

        gravityG.setOnCheckedChangeListener(this);
        styleG.setOnCheckedChangeListener(this);

        Button buttonGen = (Button) findViewById(R.id.bGenerate);
        buttonGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr = textInput.getText().toString();
                textOutput.setText(inputStr);
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.rgGravity :
            {
                switch (checkedId) {
                    case R.id.rbLeft:
                        textOutput.setGravity(Gravity.LEFT);
                        break;

                    case R.id.rbCenter:
                        textOutput.setGravity(Gravity.CENTER);
                        break;

                    case R.id.rbRight:
                        textOutput.setGravity(Gravity.RIGHT);
                        break;
                }
                break;
            }

            case R.id.rgStyle :
            {
                switch (checkedId) {
                    case R.id.rbNormal:
                        //textOutput.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL), Typeface.NORMAL);
                        textOutput.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                        break;

                    case R.id.rbItalic:
                        //textOutput.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC), Typeface.ITALIC);
                        textOutput.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                        break;

                    case R.id.rbBold:
                        //textOutput.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD), Typeface.BOLD);
                        textOutput.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                        break;
                }
                break;
            }
        }
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
                Toast.makeText(this, "Millionaire and Billionaire \n        @TutorialOne", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}
