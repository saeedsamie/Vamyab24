package com.example.android.vamyab24;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.vamyab24.Back.SoodYabRow;
//import com.example.android.vamyab24.Back.SoodyabDatabaseHandler;
import com.example.android.vamyab24.Back.SoodyabDatabaseHandler;

import java.io.IOException;
import java.util.Vector;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SoodYabActivity extends AppCompatActivity implements View.OnClickListener {

    int i=0;
    int height;
    SoodyabDatabaseHandler soodyabDatabaseHandler;
    private static final String TABLE_MELLI_BANK = "BankMelli";

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

        soodyabDatabaseHandler = new SoodyabDatabaseHandler(this);
        try {
            soodyabDatabaseHandler.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.soodYab_SearchLayout);

        EditText editText;
        switch (v.getId()) {

            case R.id.SoodYab_go:
                if (i % 2 == 0) {
                    height = relativeLayout.getHeight();
                    findViewById(R.id.soodYab_SearchLayout).getLayoutParams().height = 0;
                    findViewById(R.id.soodYab_SearchLayout).requestLayout();

                    Vector<SoodYabRow> tmp = soodyabDatabaseHandler.getAllBranchRows(TABLE_MELLI_BANK);
                    EditText mablagh = (EditText) findViewById(R.id.enter_mablagh);
                    EditText modate_sepordegozari = (EditText) findViewById(R.id.enter_modate_sepordegozari);
                    EditText mablaghe_ghest_varizi = (EditText) findViewById(R.id.enter_mablaghe_ghest_varizi);
                    EditText pardakhte_ghest_har = (EditText) findViewById(R.id.enter_pardakhte_ghest_har);
                    int j = 0;
                    for (int i = 0; j < 5 && i < 5; i++, j++) {
                        SoodYabRow r = tmp.elementAt(i);
                        if (!mablagh.getText().toString().equals(""))
                            try {
                                if (!(mablagh.getText().toString()).equals(String.valueOf(r.getMablagh()))) {
                                    tmp.remove(tmp.indexOf(r));
                                    i--;
                                    continue;
                                }
                            } catch (Exception e) {
                            }
                        if (!modate_sepordegozari.getText().toString().equals(""))
                            try {
                                if (!(modate_sepordegozari.getText().toString()).equals(String.valueOf(r.getModdat_sepordegozari()))) {
                                    tmp.remove(tmp.indexOf(r));
                                    i--;
                                    continue;
                                }
                            } catch (Exception e) {
                            }
                        if (!mablaghe_ghest_varizi.getText().toString().equals(""))
                            try {
                                if (!(mablaghe_ghest_varizi.getText().toString()).equals(String.valueOf(r.getMablagh_ghest_varizi()))) {
                                    tmp.remove(tmp.indexOf(r));
                                    i--;
                                    continue;
                                }
                            } catch (Exception e) {
                            }
                        if (!pardakhte_ghest_har.getText().toString().equals(""))
                            try {
                                if (!(pardakhte_ghest_har.getText().toString()).equals(String.valueOf(r.getPardakht_ghest_har()))) {
                                    tmp.remove(tmp.indexOf(r));
                                    i--;
                                    continue;
                                }
                            } catch (Exception e) {
                            }
                    }
                    show(tmp);
                } else {
                    findViewById(R.id.soodYab_SearchLayout).getLayoutParams().height = height;
                    findViewById(R.id.soodYab_SearchLayout).requestLayout();
                }
                findViewById(R.id.soodYab_SearchLayout).requestLayout();
                i++;
                break;
            case R.id.enter_mablagh:
                intent = new Intent(this, EnteringNumber.class);
                editText = (EditText) findViewById(R.id.enter_mablagh);
                intent.putExtra("value", editText.getText().toString());
                startActivityForResult(intent, 1001);
                break;
            case R.id.enter_modate_sepordegozari:
                intent = new Intent(this, EnteringNumber.class);
                editText = (EditText) findViewById(R.id.enter_modate_sepordegozari);
                intent.putExtra("value", editText.getText().toString());
                startActivityForResult(intent, 1002);
                break;
            case R.id.enter_mablaghe_ghest_varizi:
                intent = new Intent(this, EnteringNumber.class);
                editText = (EditText) findViewById(R.id.enter_mablaghe_ghest_varizi);
                intent.putExtra("value", editText.getText().toString());
                startActivityForResult(intent, 1003);
                break;
            case R.id.enter_pardakhte_ghest_har:
                intent = new Intent(this, EnteringNumber.class);
                editText = (EditText) findViewById(R.id.enter_pardakhte_ghest_har);
                intent.putExtra("value", editText.getText().toString());
                startActivityForResult(intent, 1004);
                break;
        }
    }



    private void show(Vector<SoodYabRow> tmp) {
        //// TODO: 9/30/2016
//        int i = 1;
        for (SoodYabRow r : tmp) {
            String log = "Mablagh: " + r.getMablagh() + " ,ID: " + r.getId() + ",modate_sepordegozari: " + r.getModdat_sepordegozari() + " ,mablagh_ghest_varizi: " + r.getMablagh_ghest_varizi() + "pardakht_ghest_har: " + r.getPardakht_ghest_har() + " tedad_zamen: ";
            Log.d("BBBB: ", log);
//            if (i == 1) {
//                TextView textView = (TextView) findViewById(R.id.BankName10);
//                textView.setText("ملٌی");
//                textView = (TextView) findViewById(R.id.VMblagh);
//                textView.setText(Integer.toString(r.getMablagh()));
//                textView = (TextView) findViewById(R.id.NDarsad);
//                textView.setText(Integer.toString(r.getModdat_sepordegozari()));
//                textView = (TextView) findViewById(R.id.Mohlat);
//                textView.setText(Integer.toString(r.getMablagh_ghest_varizi()));
//                textView = (TextView) findViewById(R.id.VMblagh_har_ghest);
//                textView.setText(Integer.toString(r.getPardakht_ghest_har()));
//            } else if (i == 2) {
//                TextView textView = (TextView) findViewById(R.id.BankName2);
//                textView.setText("ملٌی");
//                textView = (TextView) findViewById(R.id.VMblagh2);
//                textView.setText(Integer.toString(r.getMablagh()));
//                textView = (TextView) findViewById(R.id.NDarsad2);
//                textView.setText(Integer.toString(r.getModdat_sepordegozari()));
//                textView = (TextView) findViewById(R.id.Mohlat);
//                textView.setText(Integer.toString(r.getMablagh_ghest_varizi()));
//                textView = (TextView) findViewById(R.id.VMblagh_har_ghest);
//                textView.setText(Integer.toString(r.getPardakht_ghest_har()));
//            } else if (i == 3) {
//                TextView textView = (TextView) findViewById(R.id.BankName3);
//                textView.setText("ملٌی");
//                textView = (TextView) findViewById(R.id.VMblagh3);
//                textView.setText(Integer.toString(r.getMablagh()));
//                textView = (TextView) findViewById(R.id.NDarsad3);
//                textView.setText(Integer.toString(r.getModdat_sepordegozari()));
//                textView = (TextView) findViewById(R.id.Mohlat);
//                textView.setText(Integer.toString(r.getMablagh_ghest_varizi()));
//                textView = (TextView) findViewById(R.id.VMblagh_har_ghest);
//                textView.setText(Integer.toString(r.getPardakht_ghest_har()));
//            } else if (i == 4) {
//                TextView textView = (TextView) findViewById(R.id.BankName4);
//                textView.setText("ملٌی");
//                textView = (TextView) findViewById(R.id.VMblagh4);
//                textView.setText(Integer.toString(r.getMablagh()));
//                textView = (TextView) findViewById(R.id.NDarsad4);
//                textView.setText(Integer.toString(r.getModdat_sepordegozari()));
//                textView = (TextView) findViewById(R.id.Mohlat);
//                textView.setText(Integer.toString(r.getMablagh_ghest_varizi()));
//                textView = (TextView) findViewById(R.id.VMblagh_har_ghest);
//                textView.setText(Integer.toString(r.getPardakht_ghest_har()));
//            } else if (i == 5) {
//                TextView textView = (TextView) findViewById(R.id.BankName5);
//                textView.setText("ملٌی");
//                textView = (TextView) findViewById(R.id.VMblagh5);
//                textView.setText(Integer.toString(r.getMablagh()));
//                textView = (TextView) findViewById(R.id.NDarsad5);
//                textView.setText(Integer.toString(r.getModdat_sepordegozari()));
//                textView = (TextView) findViewById(R.id.Mohlat);
//                textView.setText(Integer.toString(r.getMablagh_ghest_varizi()));
//                textView = (TextView) findViewById(R.id.VMblagh_har_ghest);
//                textView.setText(Integer.toString(r.getPardakht_ghest_har()));
//            }
        }

        LinearLayout resultLayout = (LinearLayout)findViewById(R.id.soodyabResultLinearLayout);
        resultLayout.removeAllViews();
        for (SoodYabRow rs : tmp) {

            LinearLayout linearLayout1 = new LinearLayout(this);
            linearLayout1.setOrientation(LinearLayout.VERTICAL);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(LinearLayout.VERTICAL);
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setOrientation(LinearLayout.VERTICAL);

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
            param.weight = 1.0f;
            param.gravity = Gravity.START;

            final TextView rowTextView = new TextView(this);
            rowTextView.setText("بانک: "+"ملی");
            rowTextView.setTextSize(20);
            linearLayout1.addView(rowTextView,param);

            final TextView rowTextView1 = new TextView(this);
            rowTextView1.setText("مبلغ: "+rs.getMablagh()+"ملیون تومان");
            rowTextView1.setTextSize(20);
            linearLayout1.addView(rowTextView1,param);

            final TextView rowTextView2 = new TextView(this);
            rowTextView2.setText("مدت سپرده گذاری: "+rs.getModdat_sepordegozari()+"ماه");
            rowTextView2.setTextSize(20);
            linearLayout1.addView(rowTextView2,param);

            final TextView rowTextView3 = new TextView(this);
            rowTextView3.setText("مهلت بازپرداخت: "+rs.getPardakht_ghest_har()+"ماهه");
            rowTextView3.setTextSize(20);
            linearLayout1.addView(rowTextView3,param);

            final TextView rowTextView4 = new TextView(this);
            rowTextView4.setText("مبلغ هر قسط: "+rs.getMablagh_ghest_varizi()+"000"+"تومان");
            rowTextView4.setTextSize(20);
            linearLayout1.addView(rowTextView4,param);

//            final TextView rowTextView5 = new TextView(this);
//            rowTextView5.setText("نوع حساب: "+"-");
//            rowTextView5.setTextSize(20);
//            linearLayout1.addView(rowTextView5,param);

            final ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(R.drawable.logo_melli2);

            LinearLayout.LayoutParams pm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
            pm.weight = 1.0f;
            pm.gravity = Gravity.START;

            linearLayout4.addView(imageView,pm);
            TextView textView = new TextView(this);
            textView.setMinHeight(linearLayout1.getHeight()-imageView.getHeight());
            linearLayout4.addView(textView,pm);
            linearLayout2.addView(linearLayout4,param);
            linearLayout2.addView(linearLayout1,param);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout3.addView(linearLayout2,params);

            linearLayout3.setBackgroundResource(R.drawable.result_box_border);
            resultLayout.addView(linearLayout3);
            TextView tx = new TextView(this);
            tx.setMinHeight(10);
            resultLayout.addView(tx);
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
