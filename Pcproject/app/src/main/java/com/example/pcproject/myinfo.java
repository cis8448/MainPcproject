package com.example.pcproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class myinfo extends AppCompatActivity {
    Controller con;
    Button midUpdate, mTimeAdd, mSeatrese, midRemove;
    public TextView tvId, tvPw, tvName, tvHp, tvTime;
    String myinfoupdate = "myinfoupdate";
    String addtime = "addtime";
    String myremove = "myremove";
    public Memberbeen memberbeen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);
        //텍스트뷰
        tvId = findViewById(R.id.tvId);
        tvPw = findViewById(R.id.tvPw);
        tvName = findViewById(R.id.tvName);
        tvHp = findViewById(R.id.tvHp);
        tvTime = findViewById(R.id.tvTime);

        //버튼
        midUpdate = findViewById(R.id.midUpdate);
        mTimeAdd = findViewById(R.id.mTimeAdd);
        mSeatrese = findViewById(R.id.mSeatrese);
        midRemove = findViewById(R.id.midRemove);

        con = Controller.getInstance();

        Intent intent = getIntent();
        memberbeen = (Memberbeen)intent.getSerializableExtra("OBJECT");

        tvId.setText(memberbeen.getId());
        tvPw.setText(memberbeen.getPass());
        tvName.setText(memberbeen.getName());
        tvHp.setText(memberbeen.getPhone());
        tvTime.setText(memberbeen.getRetime());

    }

    public void OnclickUpdate(View v) {
        con.sub(myinfo.this, myinfoupdate);
    }

    public void Onclickremove(View v) {
        con.sub(myinfo.this, myremove);

    }
    public void OnclickTimeadd(View v){
        con.sub(myinfo.this,addtime);
    }
    public void Onclickrevecheck(View v){
        con.sub(myinfo.this,"revecheck");
    }

}

