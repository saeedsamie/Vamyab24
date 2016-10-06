package com.example.android.vamyab24.Back;

/**
 * Created by HP on 10/2/2016.
 */
public class SoodYabRow {
    private int id;
    private int mablagh;
    private int moddat_sepordegozari;
    private int mablagh_ghest_varizi;
    private int pardakht_ghest_har;
    public SoodYabRow(int id, int mablagh, int moddat_sepordegozari, int mablagh_ghest_varizi, int pardakht_ghest_har){
        this.id = id;
        this.mablagh = mablagh;
        this.moddat_sepordegozari = moddat_sepordegozari;
        this.mablagh_ghest_varizi = mablagh_ghest_varizi;
        this.pardakht_ghest_har = pardakht_ghest_har;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMablagh() {
        return mablagh;
    }
    public void setMablagh(int mablagh) {
        this.mablagh = mablagh;
    }

    public int getModdat_sepordegozari() {
        return moddat_sepordegozari;
    }

    public void setModdat_sepordegozari(int moddat_sepordegozari) {
        this.moddat_sepordegozari = moddat_sepordegozari;
    }

    public int getMablagh_ghest_varizi() {
        return mablagh_ghest_varizi;
    }

    public void setMablagh_ghest_varizi(int mablagh_ghest_varizi) {
        this.mablagh_ghest_varizi = mablagh_ghest_varizi;
    }

    public int getPardakht_ghest_har() {
        return pardakht_ghest_har;
    }

    public void setPardakht_ghest_har(int pardakht_ghest_har) {
        this.pardakht_ghest_har = pardakht_ghest_har;
    }
}