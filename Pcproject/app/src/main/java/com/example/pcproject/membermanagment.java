package com.example.pcproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class membermanagment  extends AppCompatActivity {
    ListView list1;
    public Listsetting.MemberAdapterSet adapterSet;
    Controller con = Controller.getInstance();
    final String LISTSET = "listset";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membermanagment);
        list1 = findViewById(R.id.mList);
        if(adapterSet == null ){
            con.sub(membermanagment.this,LISTSET);
        }
        list1.setAdapter(adapterSet);
    }
}