package com.example.android.vamyab24;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SoodYabActivity extends AppCompatActivity implements View.OnClickListener {

    int i=0;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sood_yab);
        getSupportActionBar().hide();
        Button button ;
        button = (Button) findViewById(R.id.SoodYab_go);
        button.setOnClickListener(this);
        EditText editText;
        editText = (EditText) findViewById(R.id.enter_mablagh);
        editText.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.enter_modate_sepordegozari);
        editText.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.enter_pardakhte_ghest_har);
        editText.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.enter_mablaghe_ghest_varizi);
        editText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        EnteringNumber enteringNumber = new EnteringNumber();
        EditText editText;
        switch (v.getId()){

            case R.id.SoodYab_go:
                if(i%2==0)
                fadeOutEverythings();
                else
                fadeInEverythings();
                i++;
                break;
            case R.id.editText5:
                intent = new Intent( this , EnteringNumber.class);
//                intent.putExtra("field","mablagh");
                startActivityForResult(intent,1000);
                break;
            case R.id.enter_mablagh:
                intent = new Intent( this , EnteringNumber.class);
//                intent.putExtra("field","enter_mablagh");
                editText = (EditText)findViewById(R.id.enter_mablagh);
                intent.putExtra("value",editText.getText().toString());
                startActivityForResult(intent,1001);
            break;
            case R.id.enter_modate_sepordegozari:
                intent = new Intent( this , EnteringNumber.class);
                editText = (EditText)findViewById(R.id.enter_modate_sepordegozari);
                intent.putExtra("value",editText.getText().toString());
                startActivityForResult(intent,1002);
                break;
            case R.id.enter_mablaghe_ghest_varizi:
                intent = new Intent( this , EnteringNumber.class);
                editText = (EditText)findViewById(R.id.enter_mablaghe_ghest_varizi);
                intent.putExtra("value",editText.getText().toString());
                startActivityForResult(intent,1003);
                break;
            case R.id.enter_pardakhte_ghest_har:
                intent = new Intent( this , EnteringNumber.class);
                editText = (EditText)findViewById(R.id.enter_pardakhte_ghest_har);
                intent.putExtra("value",editText.getText().toString());
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivityForResult(intent,1004);
                break;
        }
    }
    void fadeOutEverythings(){


        final EditText editText = (EditText)findViewById(R.id.enter_pardakhte_ghest_har);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            editText.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            editText.setVisibility(View.GONE);
                        }
                    });
        }else {editText.setVisibility(View.GONE);}

        final TextView textView = (TextView)findViewById(R.id.pardakhte_ghest_har);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            textView.setVisibility(View.GONE);
                        }
                    });
        }else {textView.setVisibility(View.GONE);}

        final TextView textView1 = (TextView)findViewById(R.id.mah);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView1.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            textView1.setVisibility(View.GONE);
                        }
                    });
        }else {textView1.setVisibility(View.GONE);}

        final EditText editText1 = (EditText)findViewById(R.id.enter_mablaghe_ghest_varizi);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            editText1.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            editText1.setVisibility(View.GONE);
                        }
                    });
        }else {editText1.setVisibility(View.GONE);}

        final TextView textView2 = (TextView)findViewById(R.id.mablaghe_ghest_varizi);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView2.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            textView2.setVisibility(View.GONE);
                        }
                    });
        }else {textView2.setVisibility(View.GONE);}

        final EditText editText2 = (EditText)findViewById(R.id.enter_modate_sepordegozari);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            editText2.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            editText2.setVisibility(View.GONE);
                        }
                    });
        }else {editText2.setVisibility(View.GONE);}

        final TextView textView3 = (TextView)findViewById(R.id.modate_sepordegozari);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView3.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            textView3.setVisibility(View.GONE);
                        }
                    });
        }else {textView3.setVisibility(View.GONE);}

        final EditText editText3 = (EditText)findViewById(R.id.enter_mablagh);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            editText3.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            editText3.setVisibility(View.GONE);
                        }
                    });
        }else {editText3.setVisibility(View.GONE);}

        final TextView textView4 = (TextView)findViewById(R.id.mablagh);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView4.animate()
                    .alpha(0f)
                    .setDuration(100)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            textView4.setVisibility(View.GONE);
                        }
                    });
        }else {textView4.setVisibility(View.GONE);}
    }

    void fadeInEverythings(){

        final TextView textView4 = (TextView)findViewById(R.id.mablagh);
        textView4.setAlpha(0f);
        textView4.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView4.animate()
                    .alpha(1f)
                    .setDuration(100)
                    .setListener(null);
        }else {textView4.setAlpha(1f);}

        final EditText editText3 = (EditText)findViewById(R.id.enter_mablagh);
        editText3.setAlpha(0f);
        editText3.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            editText3.animate()
                    .alpha(1f)
                    .setDuration(100)
                    .setListener(null);
        }else {editText3.setAlpha(1f);}

        final TextView textView3 = (TextView)findViewById(R.id.modate_sepordegozari);
        textView3.setAlpha(0f);
        textView3.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView3.animate()
                    .alpha(1f)
                    .setDuration(100)
                    .setListener(null);
        }else {textView3.setAlpha(1f);}

        final EditText editText2 = (EditText)findViewById(R.id.enter_modate_sepordegozari);
        editText2.setAlpha(0f);
        editText2.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            editText2.animate()
                    .alpha(1f)
                    .setDuration(100)
                    .setListener(null);
        }else {editText2.setAlpha(1f);}

        final TextView textView2 =  (TextView)findViewById(R.id.mablaghe_ghest_varizi);
        textView2.setAlpha(0f);
        textView2.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView2.animate()
                    .alpha(1f)
                    .setDuration(100)
                    .setListener(null);
        }else {textView2.setAlpha(1f);}

        final EditText editText1 = (EditText)findViewById(R.id.enter_mablaghe_ghest_varizi);
        editText1.setAlpha(0f);
        editText1.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            editText1.animate()
                    .alpha(1f)
                    .setDuration(100)
                    .setListener(null);
        }else {editText1.setAlpha(1f);}
        final TextView textView1 = (TextView)findViewById(R.id.mah);
        textView1.setAlpha(0f);
        textView1.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView1.animate()
                    .alpha(1f)
                    .setDuration(100)
                    .setListener(null);
        }else {textView1.setAlpha(1f);}

        final EditText editText = (EditText)findViewById(R.id.enter_pardakhte_ghest_har);
        editText.setAlpha(0f);
        editText.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            editText.animate()
                    .alpha(1f)
                    .setDuration(100)
                    .setListener(null);
        }else {editText.setAlpha(1f);}

        final TextView textView =  (TextView)findViewById(R.id.pardakhte_ghest_har);
                textView.setAlpha(0f);
        textView.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            textView.animate()
                    .alpha(1f)
                    .setDuration(100)
                    .setListener(null);
        }else {textView.setAlpha(1f);}
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent( this , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1001){
                EditText editText = (EditText) findViewById(R.id.enter_mablagh);
                editText.setText( data.getStringExtra("code").toString());
            }
            else if(requestCode == 1002){
                EditText editText = (EditText) findViewById(R.id.enter_modate_sepordegozari);
                editText.setText( data.getStringExtra("code").toString());
            }
            else if(requestCode == 1003){
                EditText editText = (EditText) findViewById(R.id.enter_mablaghe_ghest_varizi);
                editText.setText( data.getStringExtra("code").toString());
            }
            else if(requestCode == 1004){
                EditText editText = (EditText) findViewById(R.id.enter_pardakhte_ghest_har);
                editText.setText( data.getStringExtra("code").toString());
            }
        }
    }
}
