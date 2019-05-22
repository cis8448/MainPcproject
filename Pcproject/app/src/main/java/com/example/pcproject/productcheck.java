package com.example.pcproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class productcheck extends AppCompatActivity {

    Controller con =  Controller.getInstance();
    HashMap<String,String> item;
    ListView list1;
    ArrayList<HashMap<String,String>> list = new ArrayList<>();
    ArrayList<Probean> pros;
    int sum;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productcheck);
        list1 = findViewById(R.id.list1);

        pros = con.selpros;
        for(int i = 0; i < pros.size(); i++){
            item = new HashMap<>();
            item.put("item1","상품명 : "+pros.get(i).getProName());
            item.put("item2","가격 : "+pros.get(i).getProPrice() + "    수량 : " + 1);
            list.add(item);
        }
        SimpleAdapter simple= new SimpleAdapter(this,list,android.R.layout.simple_expandable_list_item_2,
                new String[]{"item1","item2"},new int[]{android.R.id.text1,android.R.id.text2});
        list1.setAdapter(simple);

    }

    public void onclickhistory(View v){
        con.sub(productcheck.this,"orderpay");
    }

}
