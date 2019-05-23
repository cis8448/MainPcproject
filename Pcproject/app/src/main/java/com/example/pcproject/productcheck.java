package com.example.pcproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class productcheck extends AppCompatActivity {

    Controller con =  Controller.getInstance();
    HashMap<String,String> item;
    ListView list1;
    ArrayList<HashMap<String,String>> list = new ArrayList<>();
    ArrayList<Probean> pros;
    int sum;
    int pos;
    TextView sumtxt;
    SimpleAdapter simple;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productcheck);
        list1 = findViewById(R.id.list1);
        sumtxt = findViewById(R.id.sum);
        con.setActivity2(this);

        pros = con.selpros;
        for(int i = 0; i < pros.size(); i++){
            item = new HashMap<>();
            item.put("item1","상품명 : "+pros.get(i).getProName());
            item.put("item2","가격 : "+pros.get(i).getProPrice() + "    수량 : " + 1);
            list.add(item);
            pros.get(i).setProAmount("1");
            sum = sum + Integer.parseInt(pros.get(i).getProPrice());
        }
        simple= new SimpleAdapter(this,list,android.R.layout.simple_expandable_list_item_2,
                new String[]{"item1","item2"},new int[]{android.R.id.text1,android.R.id.text2});
        list1.setAdapter(simple);
        sumtxt.setText(sum+"");
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos  = position;
            }
        });

    }

    public void onclickhistory(View v){
        con.sub(productcheck.this,"orderpay");
    }
    public void onclickQtyAdd(View v){
        switch (v.getId()){
            case R.id.qtyadd:
                list.get(pos).put("item2","가격 : "+pros.get(pos).getProPrice() + "    수량 : " + (Integer.parseInt(pros.get(pos).getProAmount())+1));
                sum = sum + Integer.parseInt(pros.get(pos).getProPrice());
                pros.get(pos).setProAmount((Integer.parseInt(pros.get(pos).getProAmount())+1)+"");
                sumtxt.setText(sum+"");
                simple.notifyDataSetChanged();
                break;
            case R.id.qtysub:
                if(pros.get(pos).getProAmount().equals("1")) {
                    sum = sum - Integer.parseInt(pros.get(pos).getProPrice());
                    list.remove(pos);
                    pros.remove(pos);
                    sumtxt.setText(sum + "");
                    simple.notifyDataSetChanged();
                }else{
                    list.get(pos).put("item2", "가격 : " + pros.get(pos).getProPrice() + "    수량 : " + (Integer.parseInt(pros.get(pos).getProAmount()) - 1));
                    sum = sum - Integer.parseInt(pros.get(pos).getProPrice());
                    pros.get(pos).setProAmount((Integer.parseInt(pros.get(pos).getProAmount()) - 1) + "");
                    sumtxt.setText(sum + "");
                    simple.notifyDataSetChanged();
                }

                break;
        }
    }
}
