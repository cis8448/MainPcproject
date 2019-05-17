package com.example.pcproject;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class myinfo extends AppCompatActivity {
    Controller con;
    Button midbtn, mclose;
    TextView tvId, tvPw, tvName, tvHp, tvTime;

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
        midbtn = findViewById(R.id.midbtn);
        mclose = findViewById(R.id.mclose);

        con = Controller.getInstance();
    }

}