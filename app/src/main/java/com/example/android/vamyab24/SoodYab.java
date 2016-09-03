package com.example.android.vamyab24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SoodYab extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sood_yab);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.SoodYab_go:
                fadeOutEvrythings();

                break;
        }
    }
    void fadeOutEvrythings(){

    }
}
