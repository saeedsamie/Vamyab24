package com.example.android.vamyab24;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class VaamYab extends AppCompatActivity implements View.OnClickListener {

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vam_yab);
        Button button = (Button)findViewById(R.id.VamYab_go);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        findViewById(R.id.searchLayout).getLayoutParams().height = 10 ;
        findViewById(R.id.searchLayout).requestLayout();
//        findViewById(R.id.searchLayout).setBackgroundColor(R.);
        Button button = (Button)findViewById(R.id.VamYab_go);
//        button.setBackgroundColor(R.color.colorPrimary);

        switch (v.getId()){


            case R.id.VamYab_go:
                if(i%2==0){
//                    v.requestLayout();
//                    v.getLayoutParams().height = 10 ;
//                    fadeOutEverythings();
                }
                else
//                    fadeInEverythings();
                i++;
                break;
        }
    }

}
