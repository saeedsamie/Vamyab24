package com.example.android.vamyab24;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

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

    public void setVaamYabActivity(VaamYabActivity vaamYabActivity) {
        this.vaamYabActivity = vaamYabActivity;
    }

    public void setSoodYabActivity(SoodYabActivity soodYabActivity) {
        this.soodYabActivity = soodYabActivity;
    }

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

                switch (getIntent().getExtras().get("field").toString()){
                    case "mablagh":
                        try{vaamYabActivity.setMablagh(Integer.parseInt(editText.getText().toString()));}catch (Exception e){}
                        break;
                    case "bazpardakht":
                        try{vaamYabActivity.setBazpardakht(Integer.parseInt(editText.getText().toString()));}catch (Exception e){}
                        break;
                    case "mablagheharghest":
                        try{vaamYabActivity.setMablagheharghest(Integer.parseInt(editText.getText().toString()));}catch (Exception e){}
                        break;
                    case "hadeaksarkarmozd":
                        try{vaamYabActivity.setHadeaksarkarmozd(Integer.parseInt(editText.getText().toString()));}catch (Exception e){}
                        break;
                    case "tedadezamen":
                        try{vaamYabActivity.setTedadezamen(Integer.parseInt(editText.getText().toString()));}catch (Exception e){}
                        break;
                }
                finish();






//                Intent intent;
////                intent = new Intent(getBaseContext(),);
////                switch (getIntent().getExtras().getString("class")){
////                    case "VaamYabActivity":
//                        intent= new Intent(getBaseContext() ,VaamYabActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                Bundle bundle = new Bundle();
//                bundle.putString("feild",getIntent().getExtras().getString("field").toString());
//                bundle.putString("input",editText.getText().toString());
//                        intent.putExtra("box",bundle);
//                        startActivity(intent);
//                    break;

//                    case "SoodYabActivity":
//                        intent= new Intent(getBaseContext() , SoodYabActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//                        startActivity(intent);
//                    break;
//                }

            }
        });

    }
}
