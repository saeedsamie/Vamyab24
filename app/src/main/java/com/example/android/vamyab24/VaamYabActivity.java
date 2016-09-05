package com.example.android.vamyab24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VaamYabActivity extends AppCompatActivity implements View.OnClickListener {

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vam_yab);
        Button button = (Button)findViewById(R.id.VamYab_go);
        button.setOnClickListener(this);
        EditText editText = (EditText)findViewById(R.id.editText5);
        editText.setOnClickListener(this);
        editText = (EditText)findViewById(R.id.editText6);
        editText.setOnClickListener(this);
        editText = (EditText)findViewById(R.id.editText7);
        editText.setOnClickListener(this);
        editText = (EditText)findViewById(R.id.editText7);
        editText.setOnClickListener(this);
        editText = (EditText)findViewById(R.id.editText8);
        editText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent ;
        switch (v.getId()){
            case R.id.VamYab_go:
                if(i%2==0){
                    findViewById(R.id.vamYab_searchLayout).getLayoutParams().height = 0 ;
                    findViewById(R.id.vamYab_searchLayout).requestLayout();
                }else
                    findViewById(R.id.vamYab_searchLayout).getLayoutParams().height = 580 ;
                    findViewById(R.id.vamYab_searchLayout).requestLayout();
                    i++;
                break;
            case R.id.editText5:
//                EnteringNumber enteringNumber = new EnteringNumber(this);
                intent = new Intent( this , EnteringNumber.class);
                intent.putExtra("class","SoodYabActivity");
                startActivity(intent);
                break;
            case R.id.editText6:
                intent = new Intent( this , EnteringNumber.class);
                intent.putExtra("class","VaamYabActivity");
                startActivity(intent);
                break;
            case R.id.editText7:
                intent = new Intent( this , EnteringNumber.class);
                intent.putExtra("class","VaamYabActivity");
                startActivity(intent);
                break;
            case R.id.editText8:
                intent = new Intent( this , EnteringNumber.class);
                intent.putExtra("class","VaamYabActivity");
                startActivity(intent);
                break;
            case R.id.editText11:
                intent = new Intent( this , EnteringNumber.class);
                intent.putExtra("class","VaamYabActivity");
                startActivity(intent);
                break;
        }
    }

}
