package com.example.android.vamyab24;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by HP on 9/13/2016.
 */
public class Font extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/irsans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}