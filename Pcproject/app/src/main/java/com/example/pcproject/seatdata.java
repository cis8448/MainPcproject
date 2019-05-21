package com.example.pcproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class seatdata extends AppCompatActivity {

    Controller con;
    Memberbeen mybeen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seatdata);
        con = Controller.getInstance();

    }
    public void Onclickseat(View v){
        con.sub(seatdata.this,"seatreve");

        if(mybeen.getRetime().equals()){

        }

    }

}
