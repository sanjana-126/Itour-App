package com.example.tourism;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserDataDatabase";
    private static final String TABLE_NAME = "UserData";
    private static final String COLUMN1 = "Name";
    private static final String COLUMN2 = "Contact";
    private static final String COLUMN3 = "EmailId";
    private static final String COLUMN4 = "Password";

    private SignUpFragment signUpFragment;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(Name TEXT, Contact INTEGER, EmailId TEXT PRIMARY KEY, Password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean RegisterUser(String Name, String Contact, String EmailId, String Password) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN1, Name);
        values.put(COLUMN2, Contact);
        values.put(COLUMN3, EmailId);
        values.put(COLUMN4, Password);

        long result = database.insert(TABLE_NAME, null, values);
        if (result == -1) {
            return false;
        }
        else{
            return true;
        }
    }

    public boolean checkUser(String EmailId, String Password) {
        SQLiteDatabase database = this.getWritableDatabase();
        String[] EmailList = {COLUMN3};
        String selection = COLUMN3 + "=?" + " and " + COLUMN4 + "=?";
        String[] selectionargs = {EmailId, Password};
        Cursor cursor = database.query(TABLE_NAME, EmailList, selection, selectionargs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        database.close();
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ForgotcheckUser(String EmailId) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM UserData WHERE EmailId =?", new String[] {EmailId});
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean updatePassword (String EmailId, String Password) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN4, Password);
        long result = database.update(TABLE_NAME, values, "EmailId = ?", new String[] {EmailId});
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
