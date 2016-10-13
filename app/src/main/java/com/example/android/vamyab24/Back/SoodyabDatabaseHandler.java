package com.example.android.vamyab24.Back;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.vamyab24.BuildConfig;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * Created by HP on 10/2/2016.
 */
public class SoodyabDatabaseHandler extends SQLiteOpenHelper {
    //your pachakge in middle
    private static String DB_PATH = "/data/data/"+ BuildConfig.APPLICATION_ID+"/databases/";

    private static final int BRANCH_DATABASE_VERSION = 1;

    private static final String BRANCHS_DATABASE_NAME = "DB_SoodYab";

    private static final String TABLE_MELLI_BANK = "BankMelli";

    //for each bank table!
    private static final String KEY_MABLAGH = "branch_mablagh";
    private static final String KEY_ID = "branch_code";
    private static final String KEY_MODDAT_SEPORDEGOZARI = "branch_moddat_sepordegozari";
    private static final String KEY_MABLAGH_GHEST_VARIZI = "branch_mablagh_ghest_varizi";
    private static final String KEY_PARDAKHT_GHEST_HAR = "branch_pardakht_ghest_har";


    private final Context myContext;

    public SoodyabDatabaseHandler(Context context) {
        super(context, BRANCHS_DATABASE_NAME, null, BRANCH_DATABASE_VERSION);
        myContext = context;
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

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_MELLI_BANK + "(" +  KEY_ID + " integer primary key," + KEY_MABLAGH + " integer," + KEY_MODDAT_SEPORDEGOZARI + " integer," + KEY_MABLAGH_GHEST_VARIZI + " integer," + KEY_PARDAKHT_GHEST_HAR + " integer" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_MELLI_BANK);
        onCreate(db);
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = DB_PATH + BRANCHS_DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){
            //database does't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }


    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(BRANCHS_DATABASE_NAME);

        String outFileName = DB_PATH + BRANCHS_DATABASE_NAME;

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


    public void insertIntoBankBranchTable(String tableName, SoodYabRow row) {
        //tableName esmesh bayad mese esme table ha k bala tarif shode bashe.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //bayad havaset bashe id yeksan nadi k duplicate mikhore va insert nemishe
        int tempId = 0;
        try{
            if(getBranchRow(tableName, row.getId()) == null){
                tempId = 0;
            }
            else
                tempId = getBranchRow(tableName, row.getId()).getId();
        }catch(Exception e){}
        if (tempId == 0 || tempId != row.getId()) {
            values.put(KEY_MABLAGH, row.getMablagh());
            values.put(KEY_ID, row.getId());
            values.put(KEY_MODDAT_SEPORDEGOZARI, row.getModdat_sepordegozari());
            values.put(KEY_MABLAGH_GHEST_VARIZI, row.getMablagh_ghest_varizi());
            values.put(KEY_PARDAKHT_GHEST_HAR, row.getPardakht_ghest_har());

            db.insert(tableName, null, values);
        }
        db.close();
    }

    public SoodYabRow getBranchRow(String tableName, int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(tableName, new String[]{KEY_ID, KEY_MABLAGH, KEY_MODDAT_SEPORDEGOZARI, KEY_MABLAGH_GHEST_VARIZI, KEY_PARDAKHT_GHEST_HAR}, KEY_ID + "= ?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        if(cursor != null) {
            SoodYabRow row = new SoodYabRow(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)));
            return row;
        }
        else{
            return null;
        }
    }

    public Vector<SoodYabRow> getAllBranchRows(String tableName) {
        Vector<SoodYabRow> BranchList = new Vector<SoodYabRow>();
        String selectQuery = "SELECT * FROM " + tableName;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                SoodYabRow tempBranchRow = new SoodYabRow(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)));
                BranchList.add(tempBranchRow);
            } while (cursor.moveToNext());
        }
        return BranchList;
    }

    public int updateBranchRow(String tableName, SoodYabRow row, int whichId) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MABLAGH, row.getMablagh());
        values.put(KEY_ID, row.getId());
        values.put(KEY_MODDAT_SEPORDEGOZARI, row.getModdat_sepordegozari());
        values.put(KEY_MABLAGH_GHEST_VARIZI, row.getMablagh_ghest_varizi());
        values.put(KEY_PARDAKHT_GHEST_HAR, row.getPardakht_ghest_har());

        return db.update(tableName, values, KEY_ID + " = ?", new String[]{String.valueOf(whichId)});
    }

    public void deleteBranchRow(String tableName, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableName, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

}

