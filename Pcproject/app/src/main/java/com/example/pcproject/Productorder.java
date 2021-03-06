package com.example.pcproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Productorder extends AppCompatActivity {

    Controller con =  Controller.getInstance();

    public String cate;
    public GridView grid;
    public Listsetting.ProductAdapterSet productAdapterSet;
    public ArrayList<Probean> selpro = new ArrayList<>();
    public TextView txtid;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productorder);
        grid = findViewById(R.id.grid);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtid = view.findViewById(R.id.orderTvName);
                con.sub(Productorder.this,"addpro");
            }
        });



    }//onCreate end



   public void onclickCate(View v){
      switch (v.getId()){
          case R.id.proRamen:
              cate = "1";
              break;
          case R.id.ProCoffee:
              cate = "2";
              break;
          case R.id.ProRice:
              cate = "3";
              break;
          case R.id.ProDrink:
              cate = "4";
              break;
          case R.id.ProOther:
              cate = "5";
              break;
      }
      con.sub(Productorder.this,"ordercate");
       grid.setAdapter(productAdapterSet);

   }

    public void onclickProOrder(View v){
        if(selpro.size() == 0){
            Toast.makeText(this, "주문등록한 상품이없습니다.", Toast.LENGTH_SHORT).show();
        }
        else {
            con.sub(Productorder.this, "orderhistory");
        }
    }


}
