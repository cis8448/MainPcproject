package com.example.pcproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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
                "UNMEM INTERGER(2),"+
                "PCREVETIME NVARCHAR(5))"
        );
//        db.execSQL("DELETE FROM SEATDB");
//        db.execSQL("INSERT INTO SEATDB VALUES(0,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(1,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(2,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(3,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(4,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(5,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(6,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(7,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(8,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(9,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(10,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(11,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(12,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(13,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(14,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(15,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(16,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(17,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(18,'0',NULL,0,NULL,NULL,NULL)");
//        db.execSQL("INSERT INTO SEATDB VALUES(19,'0',NULL,0,NULL,NULL,NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SEATDB");
        onCreate(db);


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
    public void updatestate(SQLiteDatabase db, int Pcname, String Pcstate, String revetime,String id){
        db.execSQL("UPDATE SEATDB " + "SET PCSTATE = '"+ Pcstate +"'," +
                                        "  PCREVETIME = '"+ revetime +"'," +
                                        "  USERID = '" + id + "' WHERE PCNAME = '"+Pcname+"'");
        db.close();
    }
    public int selectreserve(SQLiteDatabase db,String id){
        int reserve = 0;
        cur = db.rawQuery("SELECT COUNT(*) FROM SEATDB WHERE USERID = '" +id+"'", null);
        if (cur.moveToNext()) {
            reserve = cur.getInt(0);
        }
        db.close();
        return reserve;
    }

    public void updatedelete(SQLiteDatabase db, int Pcname, String Pcstate,String id){
        db.execSQL("UPDATE SEATDB " + "SET PCSTATE = '"+ Pcstate +"'," +
                "  USERID = NULL ,PCREVETIME = NULL  WHERE USERID = '"+id+"'");
        db.close();

    }
    public int selectprev(SQLiteDatabase db,String id){
        int prev = -1;
        cur = db.rawQuery("SELECT PCNAME FROM SEATDB WHERE USERID = '"+id+"'",null);
        if(cur.moveToNext()){
            prev = cur.getInt(0);
        }
        return prev;
    }
    public ArrayList<Seatbean> selectall(SQLiteDatabase db) {
        ArrayList<Seatbean> seatbeans = new ArrayList<>();
        cur = db.rawQuery("SELECT * FROM SEATDB", null);
        while (cur.moveToNext()) {
            Seatbean allseat = new Seatbean();
            allseat.setsPcname(cur.getString(0));
            allseat.setsUsestate(cur.getString(1));
            allseat.setsMemstate(cur.getString(2));
            allseat.setsUserid(cur.getString(3));
            allseat.setsUnmem(cur.getString(4));
            seatbeans.add(allseat);
        }
        return seatbeans;
    }

}
