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
//        db.execSQL("DELETE FROM SEATDB");
//        db.execSQL("INSERT INTO SEATDB VALUES(0,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(1,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(2,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(3,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(4,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(5,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(6,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(7,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(8,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(9,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(10,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(11,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(12,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(13,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(14,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(15,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(16,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(17,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(18,'0',NULL,0,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(19,'0',NULL,0,NULL,NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SEATDB");


    }

    public int[] selectstate(SQLiteDatabase db) {
        int[] seat = new int[20];
        int i = 0;
        cur = db.rawQuery("SELECT PCSTATE FROM SEATDB", null);
        while (cur.moveToNext()){
            seat[i] = cur.getInt(0);
            i++;
        }
        db.close();
        return seat;

    }
    public void updatestate(SQLiteDatabase db, int Pcname, String Pcstate){
        db.execSQL("UPDATE SEATDB " + "SET PCSTATE = '"+ Pcstate +"' WHERE PCNAME = '"+Pcname+"'");
        db.close();
    }


}
