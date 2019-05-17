package com.example.pcproject;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class myinfo extends AppCompatActivity {
    Controller con;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);

        con = Controller.getInstance();
    }

}