package com.example.android.vamyab24;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.vamyab24.Back.VaamyabDatabaseHandler;
import com.example.android.vamyab24.Back.VaamyabRow;

import java.io.IOException;
import java.util.Vector;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class VaamYabActivity extends AppCompatActivity implements View.OnClickListener {


    int i = 0;
    boolean j [] = new boolean[12];
    int height;
    private static final String TABLE_MELLI_BANK = "BankMelli";
    VaamyabDatabaseHandler vaamyabDatabaseHandler;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vam_yab);
        TextView text2ndActivity = new TextView(this);
        text2ndActivity.setText("VaamYabActivity");

        for(int k = 0;k<12;k++)
            j[k] = false;

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


        ImageButton imageButton = (ImageButton)findViewById(R.id.logo_day);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_karafarin);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_maskan);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_mellat);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_melli);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_parsian);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_pasargad);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_saman);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_sarmaye);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_sina);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_tejarat);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_tourism);
        imageButton.setOnClickListener(this);


        vaamyabDatabaseHandler = new VaamyabDatabaseHandler(this);
        try {
            vaamyabDatabaseHandler.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

        Intent intent ;
        EditText editText;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.vamYab_searchLayout);

        switch (v.getId()){
            case R.id.VamYab_go: //search
                if(i%2==0){
                    height = relativeLayout.getHeight();
                    findViewById(R.id.vamYab_searchLayout).getLayoutParams().height = 0 ;
                    findViewById(R.id.vamYab_searchLayout).requestLayout();


                    Vector<VaamyabRow> tmp = vaamyabDatabaseHandler.getAllBranchRows(TABLE_MELLI_BANK);
                    EditText mablagh = (EditText) findViewById(R.id.editText5);
                    EditText bazpardakht = (EditText) findViewById(R.id.editText6);
                    EditText mablaghe_har_ghest = (EditText) findViewById(R.id.editText7);
                    EditText hadeaksare_karmozd = (EditText) findViewById(R.id.editText8);
                    EditText tedad_zamen = (EditText) findViewById(R.id.editText11);
                    CheckBox niyaz_be_seporde = (CheckBox) findViewById(R.id.checkBox2);
                    CheckBox niyaz_be_sanad = (CheckBox) findViewById(R.id.checkBox);
                    int j=0;
                    for (int i=0;j<5&&i<5;i++,j++) {
                        VaamyabRow r = tmp.elementAt(i);
                        if(!mablagh.getText().toString().equals(""))
                        try{
                            if (!(mablagh.getText().toString()).equals(String.valueOf(r.getMablagh()))) {
                                tmp.remove(tmp.indexOf(r));
                                i--;
                                continue;
                            }
                        }catch (Exception e){}
                        if(!bazpardakht.getText().toString().equals(""))
                        try {
                            if (!(bazpardakht.getText().toString()).equals(String.valueOf(r.getBazpardakht()))) {
                                tmp.remove(tmp.indexOf(r));
                                i--;
                                continue;
                            }
                        }catch (Exception e){}
                        if(!mablaghe_har_ghest.getText().toString().equals(""))
                        try{
                            if (!(mablaghe_har_ghest.getText().toString()).equals(String.valueOf(r.getMablagh_har_ghest()))) {
                                tmp.remove(tmp.indexOf(r));
                                i--;
                                continue;
                            }
                        }catch(Exception e){}
                        if(!hadeaksare_karmozd.getText().toString().equals(""))
                            try{
                                if (!(hadeaksare_karmozd.getText().toString()).equals(String.valueOf(r.getHadeaksar_karmozd()))) {
                                    tmp.remove(tmp.indexOf(r));
                                    i--;
                                    continue;
                                }
                            }catch(Exception e){}

                        if(!tedad_zamen.getText().toString().equals(""))
                        try{
                            if (!(tedad_zamen.getText().toString()).equals(String.valueOf(r.getTedad_zamen()))) {
                                tmp.remove(tmp.indexOf(r));
                                i--;
                                continue;
                            }
                        }catch(Exception e){}

//                        if(niyaz_be_seporde.getText()!=null)
//                        try {
//                        if (niyaz_be_seporde.isChecked()!=Boolean.parseBoolean(r.getNiyaz_be_seporde())){
//                            tmp.remove(tmp.indexOf(r));
//                            i--;
//                            continue;
//                        }
//                        }catch (Exception e){}
//                        if(niyaz_be_sanad.getText()!=null)
//                        try{
//                          if (niyaz_be_sanad.isChecked()!=Boolean.parseBoolean(r.getNiyaz_be_sanad())){
//                            tmp.remove(tmp.indexOf(r));
//                            i--;
//                            continue;
//                        }
//                        }catch (Exception e){}
                    }
                    show(tmp);
                }else {
                    findViewById(R.id.vamYab_searchLayout).getLayoutParams().height = height ;
                    findViewById(R.id.vamYab_searchLayout).requestLayout();
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

            case R.id.logo_day:
                if(j[0])
                    v.setBackgroundResource(R.drawable.logo_day2);
                else if(!j[0])
                    v.setBackgroundResource(R.drawable.logo_day3);
                j[0] = !j[0];
                break;
            case R.id.logo_karafarin:
                if(j[1])
                    v.setBackgroundResource(R.drawable.logo_karafarin2);
                else if(!j[1])
                    v.setBackgroundResource(R.drawable.logo_karafarin3);
                j[1] = !j[1];
                break;
            case R.id.logo_maskan:
                if(j[2])
                    v.setBackgroundResource(R.drawable.logo_maskan2);
                else if(!j[2])
                    v.setBackgroundResource(R.drawable.logo_maskan3);
                j[2] = !j[2];
                break;
            case R.id.logo_mellat:
                if(j[3])
                    v.setBackgroundResource(R.drawable.logo_mellat2);
                else if(!j[3])
                    v.setBackgroundResource(R.drawable.logo_mellat3);
                j[3] = !j[3];
                break;
            case R.id.logo_melli:
                if(j[4])
                    v.setBackgroundResource(R.drawable.logo_melli2);
                else if(!j[4])
                    v.setBackgroundResource(R.drawable.logo_melli3);
                j[4] = !j[4];
                break;
            case R.id.logo_parsian:
                if(j[5])
                    v.setBackgroundResource(R.drawable.logo_parsian2);
                else if(!j[5])
                    v.setBackgroundResource(R.drawable.logo_parsian3);
                j[5] = !j[5];
                break;
            case R.id.logo_pasargad:
                if(j[6])
                    v.setBackgroundResource(R.drawable.logo_pasargad2);
                else if(!j[6])
                    v.setBackgroundResource(R.drawable.logo_pasargad3);
                j[6] = !j[6];
                break;
            case R.id.logo_saman:
                if(j[7])
                    v.setBackgroundResource(R.drawable.logo_saman2);
                else if(!j[7])
                    v.setBackgroundResource(R.drawable.logo_saman3);
                j[7] = !j[7];
                break;
            case R.id.logo_sarmaye:
                if(j[8])
                    v.setBackgroundResource(R.drawable.logo_sarmaye2);
                else if(!j[8])
                    v.setBackgroundResource(R.drawable.logo_sarmaye3);
                j[8] = !j[8];
                break;
            case R.id.logo_sina:
                if(j[9])
                    v.setBackgroundResource(R.drawable.logo_sina2);
                else if(!j[9])
                    v.setBackgroundResource(R.drawable.logo_sina3);
                j[9] = !j[9];
                break;
            case R.id.logo_tejarat:
                if(j[10])
                    v.setBackgroundResource(R.drawable.logo_tejarat2);
                else if(!j[10])
                    v.setBackgroundResource(R.drawable.logo_tejarat3);
                j[10] = !j[10];
                break;
            case R.id.logo_tourism:
                if(j[11])
                    v.setBackgroundResource(R.drawable.logo_tourism2);
                else if(!j[11])
                    v.setBackgroundResource(R.drawable.logo_tourism3);
                j[11] = !j[11];
                break;
        }
    }

    private void show(Vector<VaamyabRow> tmp) {
        //// TODO: 9/30/2016

        for (VaamyabRow r : tmp) {
            String log = "Mablagh: " + r.getMablagh() + " ,ID: " + r.getId() + ",hadeaksar karmozd: "+r.getHadeaksar_karmozd()+" ,bazpardakht: " + r.getBazpardakht() + " mablaghe_har_ghest: " + r.getMablagh_har_ghest() + " tedad_zamen: " + r.getTedad_zamen() + " niyaz_be_seporde: " + r.getNiyaz_be_seporde()+ " niyaz_be_sanad: " + r.getNiyaz_be_sanad();
            Log.d("DDDD: ", log);
        }


        LinearLayout resultLayout = (LinearLayout)findViewById(R.id.vaamyabResultLinearLayout);
        resultLayout.removeAllViews();
        for (VaamyabRow rs : tmp) {

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
            rowTextView2.setText("حداکثر کارمزد: "+rs.getHadeaksar_karmozd()+"%");
            rowTextView2.setTextSize(20);
            linearLayout1.addView(rowTextView2,param);

            final TextView rowTextView3 = new TextView(this);
            rowTextView3.setText("مهلت بازپرداخت: "+rs.getBazpardakht()+"ماهه");
            rowTextView3.setTextSize(20);
            linearLayout1.addView(rowTextView3,param);

            final TextView rowTextView4 = new TextView(this);
            rowTextView4.setText("مبلغ هر قسط: "+rs.getMablagh_har_ghest()+"000"+"تومان");
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


