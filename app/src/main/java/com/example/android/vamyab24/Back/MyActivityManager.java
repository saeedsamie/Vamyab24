package com.example.android.vamyab24.Back;

import android.app.Activity;

import com.example.android.vamyab24.SoodYabActivity;
import com.example.android.vamyab24.VaamYabActivity;

/**
 * Created by Saeed on 9/5/2016.
 */
public class MyActivityManager {

    VaamYabActivity vaamYabActivity;
    SoodYabActivity soodYabActivity;

    public Activity getVaamYabActivity(){
        if(vaamYabActivity==null)
            vaamYabActivity = new VaamYabActivity();
        return vaamYabActivity;
    }
    public Activity getSoodYabActivity(){
        if(soodYabActivity==null)
            soodYabActivity = new SoodYabActivity();
        return soodYabActivity;
    }

}
