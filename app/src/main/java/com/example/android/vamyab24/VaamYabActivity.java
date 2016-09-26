package com.example.android.vamyab24;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class VaamYabActivity extends AppCompatActivity implements View.OnClickListener {

    int i=0;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vam_yab);

        getSupportActionBar().hide();

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
        EditText editText;
        switch (v.getId()){
            case R.id.VamYab_go:
                if(i%2==0){
                    findViewById(R.id.vamYab_searchLayout).getLayoutParams().height = 0 ;
                    findViewById(R.id.vamYab_searchLayout).requestLayout();

                }else {
                    findViewById(R.id.vamYab_searchLayout).getLayoutParams().height = 600 ;
                }
                findViewById(R.id.vamYab_searchLayout).requestLayout();
                i++;
                break;
            case R.id.editText5:
                intent = new Intent( this , EnteringNumber.class);
                editText = (EditText)findViewById(R.id.editText5);
                intent.putExtra("value",editText.getText().toString());
                startActivityForResult(intent,2001);
                break;
            case R.id.editText6:
                intent = new Intent( this , EnteringNumber.class);
                editText = (EditText)findViewById(R.id.editText6);
                intent.putExtra("value",editText.getText().toString());
                startActivityForResult(intent,2002);
                break;
            case R.id.editText7:
                intent = new Intent( this , EnteringNumber.class);
                editText = (EditText)findViewById(R.id.editText7);
                intent.putExtra("value",editText.getText().toString());
                startActivityForResult(intent,2003);
                break;
            case R.id.editText8:
                intent = new Intent( this , EnteringNumber.class);
                editText = (EditText)findViewById(R.id.editText8);
                intent.putExtra("value",editText.getText().toString());
                startActivityForResult(intent,2004);
                break;
            case R.id.editText11:
                intent = new Intent( this , EnteringNumber.class);
                editText = (EditText)findViewById(R.id.editText11);
                intent.putExtra("value",editText.getText().toString());
                startActivityForResult(intent,2005);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent( this , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        overridePendingTransition(R.anim.push_down_in ,R.anim.push_down_out);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 2001){
                EditText editText = (EditText) findViewById(R.id.editText5);
                editText.setText( data.getStringExtra("code").toString());
            }
            else if(requestCode == 2002){
                EditText editText = (EditText) findViewById(R.id.editText6);
                editText.setText( data.getStringExtra("code").toString());
            }
            else if(requestCode == 2003){
                EditText editText = (EditText) findViewById(R.id.editText7);
                editText.setText( data.getStringExtra("code").toString());
            }
            else if(requestCode == 2004){
                EditText editText = (EditText) findViewById(R.id.editText8);
                editText.setText( data.getStringExtra("code").toString());
            }
            else if(requestCode == 2005){
                EditText editText = (EditText) findViewById(R.id.editText11);
                editText.setText( data.getStringExtra("code").toString());
            }
        }
    }
}


