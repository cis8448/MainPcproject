package com.example.pcproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class seatdata extends AppCompatActivity {
    Controller con;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seatdata);
        con = Controller.getInstance();

        Intent intent = getIntent();
        int [] seat = intent.getIntArrayExtra("좌석");
    }

    public void Onclickseat(View v){
        con.sub(seatdata.this,"seatreseve");


    }
}
