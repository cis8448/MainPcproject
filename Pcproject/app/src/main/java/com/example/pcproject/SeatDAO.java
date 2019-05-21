package com.example.pcproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SeatDAO extends SQLiteOpenHelper {
    Cursor cur;

    public SeatDAO(Context context) {
        super(context, "Seat", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS SEATDB(" +
                "PCNAME INTERGER(2) PRIMARY KEY," +
                "PCSTATE NVARCHAR(10)," +
                "USESTATE NVARCHAR(30)," +
                "MEMSTATE INTERGER(1)," +
                "USERID NVARCHAR(20)," +
                "UNMEM INTERGER(2))"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SEATDB");

    }

    public int[] selectstate(SQLiteDatabase db) {
        int[] seat = new int[20];
        cur = db.rawQuery("SELECT PCSTATE FROM SEATDB", null);
        for (int i = 0; cur.moveToNext(); i++) {
            seat[i] = cur.getInt(0);
        }
        db.close();
        return seat;

    }
    public void updatestate(SQLiteDatabase db, String Pcname, String Pcstate){
        db.execSQL("UPDATE SEATDB " + "SET PCSTATE = '"+ Pcstate +"' WHERE PCNAME = '"+Pcname+"'");
        db.close();
    }

}
