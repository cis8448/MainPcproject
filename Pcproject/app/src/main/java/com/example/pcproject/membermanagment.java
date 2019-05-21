package com.example.pcproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class membermanagment  extends AppCompatActivity {
    ListView list1;
    public Listsetting.MemberAdapterSet adapterSet;
    Controller con = Controller.getInstance();
    final String LISTSET = "listset";
    Button btnadMenu;

    final String PRODUCTMANA = "productlist";
    final String SEATMANA = "seatmanager";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membermanagment);
        list1 = findViewById(R.id.mList);
        if(adapterSet == null ){
            con.sub(membermanagment.this,LISTSET);
        }
        list1.setAdapter(adapterSet);
        //컨텍스트 메뉴 추가
        btnadMenu = findViewById(R.id.btnadMenu);
        registerForContextMenu(btnadMenu);
        btnadMenu.setLongClickable(true);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
                menu.add(0,0,100,"상품 관리");
                menu.add(0,1,100,"좌석 관리");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                con.sub(membermanagment.this,PRODUCTMANA);
                break;
            case 1:
                con.sub(membermanagment.this,SEATMANA);
                break;
        }


        return super.onContextItemSelected(item);
    }

    public void Onclickadmin(View v){
        this.openContextMenu(btnadMenu);
    }


}
