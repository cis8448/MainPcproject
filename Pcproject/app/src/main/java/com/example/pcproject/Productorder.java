package com.example.pcproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Productorder extends AppCompatActivity {

    Controller con =  Controller.getInstance();

    Intent intent = getIntent();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productorder);
    }//onCreate end


    public void onclickProOrder(View v) {

}



}
