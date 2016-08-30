package com.example.android.vamyab24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setOnClickListener(this);
        ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
        ib2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent ;
        switch (v.getId()){

            case R.id.imageButton:
                intent= new Intent( this , SoodYab.class);
                startActivity(intent);
                break;
            case R.id.imageButton2:
                intent = new Intent( this , VaamYab.class);
                startActivity(intent);
                break;

        }

    }
}
