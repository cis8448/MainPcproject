package com.example.pcproject;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ProductDAO extends SQLiteOpenHelper {
    Cursor cur;

    public ProductDAO(Context context){
        super(context, "Product", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS PRODUCTDB(" +
                        "PROID NVARCHAR(20) PRIMARY KEY," +
                        "PRONAME NVARCHAR(20)," +
                        "PROPRICE NVARCHAR(20)," +
                        "PROAMOUNT NVARCHAR(20)," +
                        "PROCATE NVARCHAR(20)," +
                        "PROIMAGE NVARCHAR(20))"
                );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTDB");
    }

    public ArrayList selectAll(SQLiteDatabase db){
        ArrayList<Probean> allpro = new ArrayList<>();
        cur = db.rawQuery("SELECT * FROM PRODUCTDB ",null);
        while (cur.moveToNext()){
            Probean pro = new Probean();
            pro.setProID(cur.getString(0));
            pro.setProName(cur.getString(1));
            pro.setProPrice(cur.getString(2));
            pro.setProAmount(cur.getString(3));
            pro.setProCate(cur.getString(4));
            pro.setProImage(cur.getString(5));
            allpro.add(pro);
        }
        return allpro;
    }

    public ArrayList selectCate(SQLiteDatabase db,String cate){
        ArrayList<Probean> allorder = new ArrayList<>();

        cur = db.rawQuery("SELECT * FROM PRODUCTDB WHERE PROCATE = '" + cate + "'",null);

        while (cur.moveToNext()){
            Probean pro = new Probean();
            pro.setProID(cur.getString(0));
            pro.setProName(cur.getString(1));
            pro.setProPrice(cur.getString(2));
            pro.setProAmount(cur.getString(3));
            pro.setProCate(cur.getString(4));
            pro.setProImage(cur.getString(5));

            allorder.add(pro);
        }
        return allorder;
    }
}
