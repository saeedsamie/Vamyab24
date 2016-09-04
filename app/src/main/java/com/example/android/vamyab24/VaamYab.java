package com.example.android.vamyab24;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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



//        Button button = (Button)findViewById(R.id.VamYab_go);
//        button.setBackgroundColor(R.color.colorPrimary);

        switch (v.getId()){


            case R.id.VamYab_go:
                if(i%2==0){
                    findViewById(R.id.vamYab_searchLayout).getLayoutParams().height = 0 ;
                    findViewById(R.id.vamYab_searchLayout).requestLayout();
                }
                else
                    findViewById(R.id.vamYab_searchLayout).getLayoutParams().height = 580 ;
                    findViewById(R.id.vamYab_searchLayout).requestLayout();
                    i++;
                break;
        }
    }

}
