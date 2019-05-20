package com.example.pcproject;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        if(state.equals("myinfo")){
            Intent myinfoOpen  = new Intent("com.example.pcproject.myinfo");
            activity.startActivity(myinfoOpen);
        }
     if(state.equals("selLogin")){
         int count = memberDAO.selectLogin(db,intentid,intentpw);
         switch (count){
             case 0:
                 Toast.makeText(activity, "아이디및 비밀번호 오류입니다.", Toast.LENGTH_SHORT).show();
                 break;
             case 1:
                mybean = memberDAO.selectID(db,intentid);
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
     if(state.equals("signup")){
         Intent signupOpen  = new Intent("com.example.pcproject.memberadd");
         activity.startActivity(signupOpen);
     }

     if(state.equals("signing")){
         String id = ((memberadd)activity).joinid.getText().toString();
         int se = memberDAO.seletoverlap(db,id);
         if(se != 0){
             Toast.makeText(activity, "아이디가 중복되었습니다.", Toast.LENGTH_SHORT).show();
         }
         else {
             Memberbeen nemem = ((memberadd)activity).memberbeen;
             memberDAO.insertMember(db,nemem);
             activity.finish();
             Toast.makeText(activity, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
             }
         }

     }
    }
