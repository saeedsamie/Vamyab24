package com.example.android.vamyab24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.android.vamyab24.Back.MyActivityManager;

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

        ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setOnClickListener(this);
        ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
        ib2.setOnClickListener(this);
//        Button button = (Button) findViewById(R.id.button4);
//        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent ;
        myActivityManager = new MyActivityManager();
        switch (v.getId()){

            case R.id.imageButton:
                intent= new Intent( this , myActivityManager.getSoodYabActivity().getClass());
                startActivity(intent);
                overridePendingTransition(R.anim.push_down_in ,R.anim.push_down_out);
                break;
            case R.id.imageButton2:
                intent = new Intent( this , myActivityManager.getVaamYabActivity().getClass());
                startActivity(intent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
                break;
//            case R.id.button4:
//                intent = new Intent( this , EnteringNumber.class);
//                intent.putExtra("class","VaamYabActivity");
//                startActivity(intent);
//                break;
        }

    }
}
