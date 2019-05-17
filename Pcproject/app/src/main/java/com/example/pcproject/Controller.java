package com.example.pcproject;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

public class Controller extends AppCompatActivity {
    MemberDAO memberDAO;
    SQLiteDatabase db;
    public String intentid;
    public String intentpw;
    Memberbeen mybean;
    Activity mainAct;
    static Controller controller;

    private Controller(){

    }

    public static Controller getInstance(){
        if(controller == null){
            controller = new Controller();
        }
        return controller;
    }

    public void setActivity(Activity act){
        mainAct = act;
    }

    public void sub(Activity activity ,String state){
        memberDAO = new MemberDAO(activity);
        db = memberDAO.getWritableDatabase();
     if(state.equals("login")){
         Intent loginOpen  = new Intent("com.example.pcproject.login");
         activity.startActivity(loginOpen);
     }
     if(state.equals("selLogin")){
         int count = memberDAO.selectLogin(db,intentid,intentpw);
         switch (count){
             case 0:

                 break;
             case 1:
                mybean=memberDAO.selectID(db,intentid);
                if(mybean.getId().equals("admin")){
                   sub(activity,"adminLogin");
                }else{
                    sub(activity,"ClearLogin");
                }
                 break;
         }
     }
     if(state.equals("ClearLogin")){
         ((MainActivity)mainAct).MyMember = mybean;
         activity.finish();

     }
    }
}
