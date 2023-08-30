package com.example.contac_activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class My_Database extends SQLiteOpenHelper {
    public My_Database(Context context) {
        super(context, "ContactBook", null, 1);
        Log.d("TTT", "My_Database: Create Contact");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="Create Table Contact(ID integer primary key autoincrement,NAME text,NUMBER text)";
        db.execSQL(query);
        Log.d("TTT", "onCreate: Create Table");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AddContact(String name, String number) {

        String query="insert into Contact(NAME,NUMBER)values('"+name+"','"+number+"')";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }

    public Cursor ShowData() {
        String query="Select *from Contact";
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        return  cursor;
    }
}
