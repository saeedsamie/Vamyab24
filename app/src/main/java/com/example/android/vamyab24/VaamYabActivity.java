package com.example.android.vamyab24;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android.vamyab24.Back.VaamyabDatabaseHandler;
import com.example.android.vamyab24.Back.VaamyabRow;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Vector;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class VaamYabActivity extends AppCompatActivity implements View.OnClickListener {

    int i=0;
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

        ImageButton imageButton = (ImageButton)findViewById(R.id.logo_tourism);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_day);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_melli);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_mellat);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_tejarat);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_pasargad);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_karafarin);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_maskan);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_parsian);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_saman);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_sarmaye);
        imageButton.setOnClickListener(this);
        imageButton = (ImageButton)findViewById(R.id.logo_sina);
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
        int height = 900;
        switch (v.getId()){
            case R.id.VamYab_go: //search
                if(i%2==0){

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

    private void show(Vector<VaamyabRow> tmp) {
        //// TODO: 9/30/2016
        int i = 1;
        for (VaamyabRow r : tmp) {
            String log = "Mablagh: " + r.getMablagh() + " ,ID: " + r.getId() + ",hadeaksar karmozd: "+r.getHadeaksar_karmozd()+" ,bazpardakht: " + r.getBazpardakht() + " mablaghe_har_ghest: " + r.getMablagh_har_ghest() + " tedad_zamen: " + r.getTedad_zamen() + " niyaz_be_seporde: " + r.getNiyaz_be_seporde()+ " niyaz_be_sanad: " + r.getNiyaz_be_sanad();
            Log.d("BBBB: ", log);
            if(i == 1) {
                TextView textView = (TextView) findViewById(R.id.BankName);
                textView.setText("ملٌی");
                textView = (TextView) findViewById(R.id.VMblagh);
                textView.setText(Integer.toString(r.getMablagh()));
                textView = (TextView) findViewById(R.id.NDarsad);
                textView.setText(Integer.toString(r.getHadeaksar_karmozd()));
                textView = (TextView) findViewById(R.id.Mohlat);
                textView.setText(Integer.toString(r.getBazpardakht()));
                textView = (TextView) findViewById(R.id.VMblagh_har_ghest);
                textView.setText(Integer.toString(r.getMablagh_har_ghest()));
            }else if(i == 2) {
                TextView textView = (TextView) findViewById(R.id.BankName2);
                textView.setText("ملٌی");
                textView = (TextView) findViewById(R.id.VMblagh2);
                textView.setText(Integer.toString(r.getMablagh()));
                textView = (TextView) findViewById(R.id.NDarsad2);
                textView.setText(Integer.toString(r.getHadeaksar_karmozd()));
                textView = (TextView) findViewById(R.id.Mohlat2);
                textView.setText(Integer.toString(r.getBazpardakht()));
                textView = (TextView) findViewById(R.id.VMblagh_har_ghest2);
                textView.setText(Integer.toString(r.getMablagh_har_ghest()));
            }else if(i == 3) {
                TextView textView = (TextView) findViewById(R.id.BankName3);
                textView.setText("ملٌی");
                textView = (TextView) findViewById(R.id.VMblagh3);
                textView.setText(Integer.toString(r.getMablagh()));
                textView = (TextView) findViewById(R.id.NDarsad3);
                textView.setText(Integer.toString(r.getHadeaksar_karmozd()));
                textView = (TextView) findViewById(R.id.Mohlat3);
                textView.setText(Integer.toString(r.getBazpardakht()));
                textView = (TextView) findViewById(R.id.VMblagh_har_ghest3);
                textView.setText(Integer.toString(r.getMablagh_har_ghest()));
            } else if(i == 4) {
                TextView textView = (TextView) findViewById(R.id.BankName4);
                textView.setText("ملٌی");
                textView = (TextView) findViewById(R.id.VMblagh4);
                textView.setText(Integer.toString(r.getMablagh()));
                textView = (TextView) findViewById(R.id.NDarsad4);
                textView.setText(Integer.toString(r.getHadeaksar_karmozd()));
                textView = (TextView) findViewById(R.id.Mohlat4);
                textView.setText(Integer.toString(r.getBazpardakht()));
                textView = (TextView) findViewById(R.id.VMblagh_har_ghest4);
                textView.setText(Integer.toString(r.getMablagh_har_ghest()));
            } else if(i == 5) {
                TextView textView = (TextView) findViewById(R.id.BankName5);
                textView.setText("ملٌی");
                textView = (TextView) findViewById(R.id.VMblagh5);
                textView.setText(Integer.toString(r.getMablagh()));
                textView = (TextView) findViewById(R.id.NDarsad5);
                textView.setText(Integer.toString(r.getHadeaksar_karmozd()));
                textView = (TextView) findViewById(R.id.Mohlat5);
                textView.setText(Integer.toString(r.getBazpardakht()));
                textView = (TextView) findViewById(R.id.VMblagh_har_ghest5);
                textView.setText(Integer.toString(r.getMablagh_har_ghest()));
            }

            i++;
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


