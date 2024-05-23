package com.example.mosquelocalizationapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DatabaseHelper(Context context){
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
       db.execSQL("create table users(username TEXT primary key, password TEXT)");
       db.execSQL("create table mosques(mosqueName TEXT primary key, address TEXT, prayerTime TEXT, longitude double, latitude double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists mosques");
    }

    public boolean insertUser(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        long result = db.insert("users", null, values);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean insertMosque(String mosqueName, String address, String prayerTime, double lon, double lat){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mosquename", mosqueName);
        values.put("address", address);
        values.put("prayerTime", prayerTime);
        values.put("longitude", lon);
        values.put("latitude", lat);
        long ressult = db.insert("mosques", null, values);
        if(ressult == -1){
            return false;
        }else{
            return true;
        }
    }

    @SuppressLint("Range")
    public String[] getMosqueByName(String mosqueName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from mosques where mosqueName = ?", new String[] {mosqueName});
        if(cursor.getCount() > 0){
            if(cursor.moveToFirst()){
                do{
                   String address = cursor.getColumnName(cursor.getColumnIndex("address"));
                    String prayerTime = cursor.getColumnName(cursor.getColumnIndex("prayerTime"));
                    String longitude = cursor.getColumnName(cursor.getColumnIndex("longitute"));
                    String latitude = cursor.getColumnName(cursor.getColumnIndex("latitude"));

                }while(cursor.moveToNext());
            }
        }
        return new String[] {};
    }

    public boolean checkUserName(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?", new String[] {username, password});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

}
