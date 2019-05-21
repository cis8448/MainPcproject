package com.example.pcproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SeatDAO extends SQLiteOpenHelper {

    public SeatDAO(Context context) {
        super(context, "Seat", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS SEATDB(" +
                "PCNAME INTERGER(2) PRIMARY KEY," +
                "PCSTATE NVARCHAR(10)," +
                "USESTATE NVARCHAR(30)," +
                "MEMSTATE INTERGER(1),"+
                "USERID NVARCHAR(20),"+
                "UNMEM INTERGER(2))"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SEATDB");

    }
}
