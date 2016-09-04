package com.example.android.vamyab24;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entering_number);

        editText = (EditText)findViewById(R.id.editText9);
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
                Intent intent;
                switch (getIntent().getExtras().getString("class")){
                    case "VaamYab":
                        intent= new Intent(getBaseContext() , VaamYab.class);
                        startActivity(intent);
                    break;

                    case "SoodYab":
                        intent= new Intent(getBaseContext() , SoodYab.class);
                        startActivity(intent);
                    break;
                }

            }
        });

    }
}
