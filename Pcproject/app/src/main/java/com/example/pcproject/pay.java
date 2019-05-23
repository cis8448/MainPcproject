package com.example.pcproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class pay extends AppCompatActivity {
    Controller con = Controller.getInstance();

    Spinner sp1;

    ArrayList<String> movies = new ArrayList<>();



    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay);

        movies.add("금액 선택");
        movies.add("금액에 맞게");
        movies.add("1000원");
        movies.add("2000원");
        movies.add("3000원");
        movies.add("5000원");
        movies.add("10000원");


        sp1 = findViewById(R.id.sp1);


        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                movies);

        sp1.setAdapter(adapter);

        sp1.setSelection(0);
    }
    public void onclickfinish(View v){
        con.sub(this,"payend");
    }
}
