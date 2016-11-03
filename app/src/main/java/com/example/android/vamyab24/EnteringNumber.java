package com.example.android.vamyab24;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class EnteringNumber extends Activity {
    EditText editText;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button dele;
    Button done;
    VaamYabActivity vaamYabActivity;
    SoodYabActivity soodYabActivity;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entering_number);



        editText = (EditText)findViewById(R.id.editText9);
        editText.setText(getIntent().getStringExtra("value").toString());
        b1 = (Button)findViewById(R.id.n1);
        b2 = (Button)findViewById(R.id.n2);
        b3 = (Button)findViewById(R.id.n3);
        b4 = (Button)findViewById(R.id.n4);
        b5 = (Button)findViewById(R.id.n5);
        b6 = (Button)findViewById(R.id.n6);
        b7 = (Button)findViewById(R.id.n7);
        b8 = (Button)findViewById(R.id.n8);
        b9 = (Button)findViewById(R.id.n9);
        b0 = (Button)findViewById(R.id.n0);
        dele = (Button)findViewById(R.id.del);
        done = (Button)findViewById(R.id.done);

        b0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"0"));
            }
        });
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"1"));
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"2"));
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"3"));
            }
        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"4"));
            }
        });
        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"5"));
            }
        });
        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"6"));
            }
        });
        b7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"7"));
            }
        });
        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"8"));
            }
        });
        b9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().insert(editText.getText().length(),"9"));
            }
        });
        dele.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(editText.getText().length()>0){
                    editText.setText(editText.getText().delete(editText.getText().length() - 1, editText.getText().length()));
                }
            }
        });
        done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                Intent returnIntent =new Intent();
                returnIntent.putExtra("code", editText.getText().toString());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();


            }
        });

    }
}
