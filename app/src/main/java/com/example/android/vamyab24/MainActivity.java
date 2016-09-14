package com.example.android.vamyab24;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android.vamyab24.Back.MyActivityManager;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public MyActivityManager myActivityManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();

        TextView textView;
        textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.textView2);
        textView.setOnClickListener(this);

        TextView tv;
        textView = (TextView)findViewById(R.id.textView);
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/BNazanin+Bold.ttf");
        textView.setTypeface(tf);
        textView = (TextView)findViewById(R.id.textView2);
        textView.setTypeface(tf);

    }

    @Override
    public void onClick(View v) {

        Intent intent;
        myActivityManager = new MyActivityManager();
        switch (v.getId()) {

            case R.id.textView:
                intent = new Intent(this, myActivityManager.getSoodYabActivity().getClass());
                startActivity(intent);
                overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                finish();
                break;
            case R.id.textView2:
                intent = new Intent(this, myActivityManager.getVaamYabActivity().getClass());
                startActivity(intent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
                finish();
                break;
        }


    }

    @Override
    public void onBackPressed() {
        finish();
    }
}//
