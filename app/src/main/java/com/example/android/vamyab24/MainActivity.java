package com.example.android.vamyab24;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.vamyab24.Back.VaamyabDatabaseHandler;
import com.example.android.vamyab24.Back.MyActivityManager;
import com.example.android.vamyab24.Back.VaamyabRow;

import java.io.IOException;
import java.util.Vector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public MyActivityManager myActivityManager;
    private static final String TABLE_MELLI_BANK = "BankMelli";
    public Vector<VaamyabRow> vaamha;

    public Vector<VaamyabRow> getVaamha() {
        return vaamha;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();

        VaamyabDatabaseHandler vaamyabDatabaseHandler = new VaamyabDatabaseHandler(this);
        try {
            vaamyabDatabaseHandler.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        vaamha = vaamyabDatabaseHandler.getAllBranchRows(TABLE_MELLI_BANK);
        for (VaamyabRow r : vaamha) {
            String log = "Mablagh: " + r.getMablagh() + " ,ID: " + r.getId() + ",hadeaksar karmozd: "+r.getHadeaksar_karmozd()+" ,bazpardakht: " + r.getBazpardakht() + " mablaghe_har_ghest: " + r.getMablagh_har_ghest() + " tedad_zamen: " + r.getTedad_zamen() + " niyaz_be_seporde: " + r.getNiyaz_be_seporde()+ " niyaz_be_sanad: " + r.getNiyaz_be_sanad();
            Log.d("AAAAA: ", log);
        }


        TextView textView;
        textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.textView2);
        textView.setOnClickListener(this);

        TextView tv;
        textView = (TextView)findViewById(R.id.textView);
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/BNazanin+Bold.ttf");
        textView.setTypeface(tf);
        textView = (TextView)findViewById(R.id.textView2);
        textView.setTypeface(tf);

    }

    @Override
    public void onClick(View v) {

        Intent intent;
        myActivityManager = new MyActivityManager();
        switch (v.getId()) {

            case R.id.textView:
                intent = new Intent(this, myActivityManager.getSoodYabActivity().getClass());
                startActivity(intent);
                overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
                finish();
                break;
            case R.id.textView2:
                intent = new Intent(this, myActivityManager.getVaamYabActivity().getClass());
                startActivity(intent);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
                finish();
                break;
        }


    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
