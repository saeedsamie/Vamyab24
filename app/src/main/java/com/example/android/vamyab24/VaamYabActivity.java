package com.example.android.vamyab24;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VaamYabActivity extends AppCompatActivity implements View.OnClickListener {
    int mablagh;
    int bazpardakht;
    int mablagheharghest;
    int hadeaksarkarmozd;
    int tedadezamen;
    EnteringNumber enteringNumber;
    public void setBazpardakht(int bazpardakht) {
        this.bazpardakht = bazpardakht;
    }

    public void setHadeaksarkarmozd(int hadeaksarkarmozd) {
        this.hadeaksarkarmozd = hadeaksarkarmozd;
    }

    public void setMablagh(int mablagh) {
        this.mablagh = mablagh;
    }

    public void setMablagheharghest(int mablagheharghest) {
        this.mablagheharghest = mablagheharghest;
    }

    public void setTedadezamen(int tedadezamen) {
        this.tedadezamen = tedadezamen;
    }

    int i=0;
    public int geti(){
        return i;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vam_yab);
        getSupportActionBar().hide();
        enteringNumber = new EnteringNumber();
        enteringNumber.setVaamYabActivity(this);
        TextView textView;
     //   textView = (TextView)findViewById(R.id.textView33);
        ;

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

                }else {
                    findViewById(R.id.vamYab_searchLayout).getLayoutParams().height = 580 ;
                }
                findViewById(R.id.vamYab_searchLayout).requestLayout();
                i++;
                break;
            case R.id.editText5:

                intent = new Intent( this , enteringNumber.getClass());
                intent.putExtra("field","mablagh");
                startActivityForResult(intent,1);
                break;
            case R.id.editText6:
                intent = new Intent( this , EnteringNumber.class);
                intent.putExtra("field","bazpardakht");
                startActivityForResult(intent,2);
                break;
            case R.id.editText7:
                intent = new Intent( this , EnteringNumber.class);
                intent.putExtra("field","mablagheharghest");
                startActivityForResult(intent,3);
                break;
            case R.id.editText8:
                intent = new Intent( this , EnteringNumber.class);
                intent.putExtra("field","hadeaksarkarmozd");
                startActivityForResult(intent,4);
                break;
            case R.id.editText11:
                intent = new Intent( this , EnteringNumber.class);
                intent.putExtra("field","tedadezamen");
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivityForResult(intent,5);
                break;
        }
        EditText et = new EditText(this);
        et = (EditText) findViewById(R.id.editText5);
        et.setText(String.valueOf(mablagh));
        et = (EditText) findViewById(R.id.editText6);
        et.setText(String.valueOf(bazpardakht));
        et = (EditText) findViewById(R.id.editText7);
        et.setText(String.valueOf(mablagheharghest));
        et = (EditText) findViewById(R.id.editText8);
        et.setText(String.valueOf(hadeaksarkarmozd));
        et = (EditText) findViewById(R.id.editText11);
        et.setText(String.valueOf(tedadezamen));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( this , MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_down_in ,R.anim.push_down_out);
    }
}

