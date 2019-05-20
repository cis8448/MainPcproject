package com.example.pcproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MemberDAO extends SQLiteOpenHelper {
    Cursor cur;

    public MemberDAO(Context context) {
        super(context, "Member", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS MEMBERDB(" +
                "ID NVARCHAR(15) PRIMARY KEY," +
                "PASS NVARCHAR(20)," +
                "NAME NVARCHAR(5)," +
                "PHONE NVARCHAR(12)," +
                "RETIME NVARCHAR(6)," +
                "BIRTH NVARCHAR(6))"
        );
//        db.execSQL("INSERT INTO MEMBERDB VALUES(" +
//                "'cis8448'," +
//                "'1234'," +

//                "'최인수'," +
//                "'01000000000'," +
//                "null," +
//                "'950103')"
//        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MEMBERDB");

    }

    public int selectLogin(SQLiteDatabase db, String id, String pw) {
        onCreate(db);
        int selectset = -1;
        cur = db.rawQuery("SELECT COUNT(*)   FROM MEMBERDB WHERE ID ='" + id + "' AND PASS ='" + pw + "'", null);
        if (cur.moveToNext()) {
            selectset = cur.getInt(0); //0은 첫번째
        }
        return selectset;
    }

    public Memberbeen selectID(SQLiteDatabase db, String id) {
        Memberbeen myMem = new Memberbeen();
        cur = db.rawQuery("SELECT * FROM MEMBERDB WHERE ID ='" + id + "'", null);
        if (cur.moveToNext()) {
            if (cur.getString(0).equals("admin")) {
                myMem.setId(cur.getString(0));
                return myMem;
            } else {
                myMem.setId(cur.getString(0));
                myMem.setPass(cur.getString(1));
                myMem.setName(cur.getString(2));
                myMem.setPhone(cur.getString(3));
                myMem.setRetime(cur.getString(4));
                myMem.setBirth(cur.getString(5));
            }
        }
        return myMem;
    }

    public int seletoverlap(SQLiteDatabase db, String id) {
        onCreate(db);
        int overlap = -1;
        cur = db.rawQuery("SELECT COUNT(*) FROM MEMBERDB WHERE ID ='" + id + "'", null);
        if (cur.moveToNext()) {
            overlap = cur.getInt(0);
        }
        return overlap;
    }

    public void insertMember(SQLiteDatabase db, Memberbeen mem) {
        db.execSQL("INSERT INTO MEMBERDB VALUES('" + mem.getId() + "','" + mem.getPass() + "','" + mem.getName() + "'," +
                "'" + mem.getPhone() + "','" + mem.getRetime() + "','" + mem.getBirth() + "')");
        db.close();

    }

    public void updateUser(SQLiteDatabase db, String Id, String Pass, String Phone, String birth) {
        db.execSQL("UPDATE MEMBERDB " +
                "SET PASS='" + Pass + "', PHONE='" + Phone + "', BIRTH='" + birth + "' WHERE ID='" + Id + "'");
        db.close();

    }

    public void updateTime(SQLiteDatabase db, String Id, String Retime){
        db.execSQL("UPDATE MEMBERDB " + "SET RETIME = '" + Retime + "' WHERE ID = '" + Id + "'");
        db.close(); 
    }
}
