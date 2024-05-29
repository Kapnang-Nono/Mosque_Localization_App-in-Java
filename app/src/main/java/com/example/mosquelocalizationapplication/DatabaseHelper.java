package com.example.mosquelocalizationapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DatabaseHelper(Context context){
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
       db.execSQL("create table users(username TEXT primary key, password TEXT)");
       db.execSQL("create table mosques(mosqueName TEXT primary key, address TEXT, prayerTime TEXT, longitude double, latitude double)");
       db.execSQL("insert into mosques values('El-adj', 'Ekounou', '15:00 pm', 234.890, 123.90), ('Mosque2', 'Awea-Eskalier', '18:00 pm', 23.78, 89.45)");
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

    @SuppressLint("Range")
    public List<Mosque> getMosqueByName(String mosqueName){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from mosques where mosqueName = ?", new String[] {mosqueName});
        DatabaseUtils.dumpCursorToString(cursor);
        List<Mosque> dataList = new ArrayList<>();
        while(cursor.moveToNext()){
            String mosque_name = cursor.getString(cursor.getColumnIndex("mosqueName"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String timePrayer = cursor.getString(cursor.getColumnIndex("prayerTime"));
            double longitude = cursor.getDouble(cursor.getColumnIndex("longitude"));
            double latitude = cursor.getDouble(cursor.getColumnIndex("latitude"));

            dataList.add(new Mosque(mosque_name, address, timePrayer, longitude, latitude));
        }
//        cursor.close();
//        db.close();
        return dataList;
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
