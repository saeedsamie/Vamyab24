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
import android.widget.ImageButton;
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
    boolean j [] = new boolean[12];
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


        for(int k = 0;k<12;k++)
            j[k] = false;


        EditText editText;
        editText = (EditText) findViewById(R.id.enter_mablagh);
        editText.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.enter_bahreh);
        editText.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.enter_modate_sepordegozari);
        editText.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.enter_pardakhte_ghest_har);
        editText.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.enter_mablaghe_ghest_varizi);
        editText.setOnClickListener(this);


        ImageButton imageButton = (ImageButton)findViewById(R.id.logo_days);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_karafarins);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_maskans);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_mellats);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_mellis);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_parsians);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_pasargads);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_samans);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_sarmayes);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_sinas);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_tejarats);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_tourisms);
        imageButton.setOnClickListener(this);

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
                    EditText bahre = (EditText) findViewById(R.id.enter_bahreh);
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
            case R.id.enter_bahreh:
                intent = new Intent(this, EnteringNumber.class);
                editText = (EditText) findViewById(R.id.enter_bahreh);
                intent.putExtra("value", editText.getText().toString());
                startActivityForResult(intent, 1005);
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
            case R.id.logo_days:
                if(j[0])
                    v.setBackgroundResource(R.drawable.logo_day2);
                else if(!j[0])
                    v.setBackgroundResource(R.drawable.logo_day3);
                j[0] = !j[0];
                break;
            case R.id.logo_karafarins:
                if(j[1])
                    v.setBackgroundResource(R.drawable.logo_karafarin2);
                else if(!j[1])
                    v.setBackgroundResource(R.drawable.logo_karafarin3);
                j[1] = !j[1];
                break;
            case R.id.logo_maskans:
                if(j[2])
                    v.setBackgroundResource(R.drawable.logo_maskan2);
                else if(!j[2])
                    v.setBackgroundResource(R.drawable.logo_maskan3);
                j[2] = !j[2];
                break;
            case R.id.logo_mellats:
                if(j[3])
                    v.setBackgroundResource(R.drawable.logo_mellat2);
                else if(!j[3])
                    v.setBackgroundResource(R.drawable.logo_mellat3);
                j[3] = !j[3];
                break;
            case R.id.logo_mellis:
                if(j[4])
                    v.setBackgroundResource(R.drawable.logo_melli2);
                else if(!j[4])
                    v.setBackgroundResource(R.drawable.logo_melli3);
                j[4] = !j[4];
                break;
            case R.id.logo_parsians:
                if(j[5])
                    v.setBackgroundResource(R.drawable.logo_parsian2);
                else if(!j[5])
                    v.setBackgroundResource(R.drawable.logo_parsian3);
                j[5] = !j[5];
                break;
            case R.id.logo_pasargads:
                if(j[6])
                    v.setBackgroundResource(R.drawable.logo_pasargad2);
                else if(!j[6])
                    v.setBackgroundResource(R.drawable.logo_pasargad3);
                j[6] = !j[6];
                break;
            case R.id.logo_samans:
                if(j[7])
                    v.setBackgroundResource(R.drawable.logo_saman2);
                else if(!j[7])
                    v.setBackgroundResource(R.drawable.logo_saman3);
                j[7] = !j[7];
                break;
            case R.id.logo_sarmayes:
                if(j[8])
                    v.setBackgroundResource(R.drawable.logo_sarmaye2);
                else if(!j[8])
                    v.setBackgroundResource(R.drawable.logo_sarmaye3);
                j[8] = !j[8];
                break;
            case R.id.logo_sinas:
                if(j[9])
                    v.setBackgroundResource(R.drawable.logo_sina2);
                else if(!j[9])
                    v.setBackgroundResource(R.drawable.logo_sina3);
                j[9] = !j[9];
                break;
            case R.id.logo_tejarats:
                if(j[10])
                    v.setBackgroundResource(R.drawable.logo_tejarat2);
                else if(!j[10])
                    v.setBackgroundResource(R.drawable.logo_tejarat3);
                j[10] = !j[10];
                break;
            case R.id.logo_tourisms:
                if(j[11])
                    v.setBackgroundResource(R.drawable.logo_tourism2);
                else if(!j[11])
                    v.setBackgroundResource(R.drawable.logo_tourism3);
                j[11] = !j[11];
                break;
        }
    }



    private void show(Vector<SoodYabRow> tmp) {
        //// TODO: 9/30/2016
        for (SoodYabRow r : tmp) {
            String log = "Mablagh: " + r.getMablagh() + " ,ID: " + r.getId() + ",modate_sepordegozari: " + r.getModdat_sepordegozari() + " ,mablagh_ghest_varizi: " + r.getMablagh_ghest_varizi() + "pardakht_ghest_har: " + r.getPardakht_ghest_har() + " tedad_zamen: ";
            Log.d("BBBB: ", log);

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
            rowTextView1.setTextSize(15);
            linearLayout1.addView(rowTextView1,param);

            final TextView rowTextView2 = new TextView(this);
            rowTextView2.setText("مدت سپرده گذاری: "+rs.getModdat_sepordegozari()+"ماه");
            rowTextView2.setTextSize(15);
            linearLayout1.addView(rowTextView2,param);

            final TextView rowTextView3 = new TextView(this);
            rowTextView3.setText("مهلت بازپرداخت: "+rs.getPardakht_ghest_har()+"ماهه");
            rowTextView3.setTextSize(15);
            linearLayout1.addView(rowTextView3,param);

            final TextView rowTextView4 = new TextView(this);
            rowTextView4.setText("مبلغ هر قسط: "+rs.getMablagh_ghest_varizi()+"000"+"تومان");
            rowTextView4.setTextSize(15);
            linearLayout1.addView(rowTextView4,param);

            final ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(R.drawable.logo_melli);

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
            else if(requestCode == 1005){
            EditText editText = (EditText) findViewById(R.id.enter_bahreh);
            editText.setText( data.getStringExtra("code").toString());
        }
    }
    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent( this , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        overridePendingTransition(R.anim.push_up_in ,R.anim.push_up_out);
    }
}
