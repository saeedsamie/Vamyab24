package com.example.android.vamyab24.Back;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.vamyab24.BuildConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * Created by Saeed on 9/30/2016.
 */
public class VaamyabDatabaseHandler extends SQLiteOpenHelper {

    private static final String TABLE_MELLI_BANK = "BankMelli";

    private static String DB_PATH = "/data/data/"+ BuildConfig.APPLICATION_ID+"/databases/";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DB_vaamyab";

    private static final String KEY_MABLAGH = "branch_mablagh";
    private static final String KEY_ID = "branch_code";
    private static final String KEY_BAZPARDAKHT = "branch_bazpardakht";
    private static final String KEY_MABLAGH_HAR_GHEST = "branch_mablagh_har_ghest";
    private static final String KEY_HADEAKSAR_KARMOZD = "branch_hadeaksar_karmozd";
    private static final String KEY_TEDAD_ZAMEN = "tedad_zamen";
    private static final String KEY_NIYAZ_BE_SEPORDE = "niyaz_be_seporde";
    private static final String KEY_NIYAZ_BE_SANAD = "niyaz_be_sanad";

    private final Context myContext;

    public VaamyabDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table " + TABLE_MELLI_BANK + "(" + KEY_MABLAGH + " integer," + KEY_ID + " integer primary key," + KEY_BAZPARDAKHT + " integer," + KEY_MABLAGH_HAR_GHEST + " integer," + KEY_HADEAKSAR_KARMOZD + " integer, " + KEY_TEDAD_ZAMEN + " integer," + KEY_NIYAZ_BE_SEPORDE + " boolean," + KEY_NIYAZ_BE_SANAD + " boolean" +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_MELLI_BANK);
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }

    }

    private boolean checkDataBase(){
        File dbFile = myContext.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }


    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);

        String outFileName = DB_PATH + DATABASE_NAME;

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[2048];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
    public void insertIntoBankBranchTable(String tableName, VaamyabRow vaamyabRow) {
        //tableName esmesh bayad mese esme table ha k bala tarif shode bashe.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //bayad havaset bashe id yeksan nadi k duplicate mikhore va insert nemishe
        int tempId = 0;
        try{
            if(getBranchRow(tableName, vaamyabRow.getId()) == null){
                tempId = 0;
            }
            else
                tempId = getBranchRow(tableName, vaamyabRow.getId()).getId();
        }catch(Exception e){}
        if (tempId == 0 || tempId != vaamyabRow.getId()) {
            values.put(KEY_MABLAGH, vaamyabRow.getMablagh());
            values.put(KEY_ID, vaamyabRow.getId());
            values.put(KEY_BAZPARDAKHT, vaamyabRow.getBazpardakht());
            values.put(KEY_MABLAGH_HAR_GHEST, vaamyabRow.getMablagh_har_ghest());
            values.put(KEY_HADEAKSAR_KARMOZD, vaamyabRow.getHadeaksar_karmozd());
            values.put(KEY_TEDAD_ZAMEN, vaamyabRow.getTedad_zamen());
            values.put(KEY_NIYAZ_BE_SEPORDE, vaamyabRow.getNiyaz_be_seporde());
            values.put(KEY_NIYAZ_BE_SANAD, vaamyabRow.getNiyaz_be_sanad());

            db.insert(tableName, null, values);
        }
        db.close();
    }

    public VaamyabRow getBranchRow(String tableName, int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(tableName, new String[]{KEY_ID ,KEY_MABLAGH, KEY_BAZPARDAKHT, KEY_MABLAGH_HAR_GHEST, KEY_HADEAKSAR_KARMOZD, KEY_TEDAD_ZAMEN, KEY_NIYAZ_BE_SEPORDE, KEY_NIYAZ_BE_SANAD}, KEY_ID + "= ?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        if(cursor != null) {
            VaamyabRow vaamyabRow = new VaamyabRow(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)),(cursor.getString(6)),(cursor.getString(7)));
            return vaamyabRow;
        }
        else{
            return null;
        }
    }

    public Vector<VaamyabRow> getAllBranchRows(String tableName) {
        Vector<VaamyabRow> BranchList = new Vector<VaamyabRow>();
        String selectQuery = "SELECT * FROM " + tableName;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                VaamyabRow tempBranchRow = new VaamyabRow(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)),(cursor.getString(6)),(cursor.getString(7)));
                BranchList.add(tempBranchRow);
            } while (cursor.moveToNext());
        }
        return BranchList;
    }

    public int updateBranchRow(String tableName, VaamyabRow vaamyabRow, int whichId) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MABLAGH, vaamyabRow.getMablagh());
        values.put(KEY_ID, vaamyabRow.getId());
        values.put(KEY_BAZPARDAKHT, vaamyabRow.getBazpardakht());
        values.put(KEY_MABLAGH_HAR_GHEST, vaamyabRow.getMablagh_har_ghest());
        values.put(KEY_HADEAKSAR_KARMOZD, vaamyabRow.getHadeaksar_karmozd());
        values.put(KEY_TEDAD_ZAMEN, vaamyabRow.getTedad_zamen());
        values.put(KEY_NIYAZ_BE_SEPORDE, vaamyabRow.getNiyaz_be_seporde());
        values.put(KEY_NIYAZ_BE_SANAD, vaamyabRow.getNiyaz_be_sanad());

        return db.update(tableName, values, KEY_ID + " = ?", new String[]{String.valueOf(whichId)});
    }

    public void deleteBranchRow(String tableName, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableName, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }
}
