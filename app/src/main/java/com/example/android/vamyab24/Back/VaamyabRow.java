package com.example.android.vamyab24.Back;

/**
 * Created by Saeed on 9/29/2016.
 */
public class VaamyabRow {
    private int id;
    private int mablagh;
    private int bazpardakht;
    private int mablagh_har_ghest;
    private int hadeaksar_karmozd;
    private int tedad_zamen;
    private String niyaz_be_seporde= "false";
    private String niyaz_be_sanad;
    public VaamyabRow(int id, int mablagh, int bazpardakht, int mablagh_har_ghest, int hadeaksar_karmozd, int tedad_zamen,
                      String niyaz_be_seporde, String niyaz_be_sanad){
        this.id = id;
        this.mablagh = mablagh;
        this.bazpardakht = bazpardakht;
        this.mablagh_har_ghest = mablagh_har_ghest;
        this.hadeaksar_karmozd = hadeaksar_karmozd;
        this.tedad_zamen = tedad_zamen;
        this.niyaz_be_seporde = niyaz_be_seporde;
        this.niyaz_be_sanad = niyaz_be_sanad;
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

    public int getBazpardakht() {
        return bazpardakht;
    }

    public void setBazpardakht(int bazpardakht) {
        this.bazpardakht = bazpardakht;
    }

    public int getMablagh_har_ghest() {
        return mablagh_har_ghest;
    }

    public void setMablagh_har_ghest(int mablagh_har_ghest) {
        this.mablagh_har_ghest = mablagh_har_ghest;
    }

    public int getHadeaksar_karmozd() {
        return hadeaksar_karmozd;
    }

    public void setHadeaksar_karmozd(int hadeaksar_karmozd) {
        this.hadeaksar_karmozd = hadeaksar_karmozd;
    }

    public int getTedad_zamen() {
        return tedad_zamen;
    }

    public void setTedad_zamen(int tedad_zamen) {
        this.tedad_zamen = tedad_zamen;
    }

    public String getNiyaz_be_sanad() {
        return niyaz_be_sanad;
    }

    public void setNiyaz_be_sanad(String niyaz_be_sanad) {
        this.niyaz_be_sanad = niyaz_be_sanad;
    }

    public String getNiyaz_be_seporde() {
        return niyaz_be_seporde;
    }

    public void setNiyaz_be_seporde(String niyaz_be_seporde) {
        this.niyaz_be_seporde = niyaz_be_seporde;
    }
}
