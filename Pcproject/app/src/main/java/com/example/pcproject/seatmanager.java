package com.example.pcproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class seatmanager extends AppCompatActivity {

    Controller con;
    Button btnadMenu;
    ListView list1;
    Listsetting.SeatAdapterSet seatAdapterSet;


    final String MEMBERMANA = "adminLogin";
    final String PRODUCTMANA = "productlist";
    final String SEATLISTSET = "seatListset";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seatmenagement);
        con = Controller.getInstance();
        list1 = findViewById(R.id.sList);
        if(seatAdapterSet == null){
            con.sub(seatmanager.this,SEATLISTSET);
        }
        list1.setAdapter(seatAdapterSet);





        //컨텍스트 메뉴 추가
        btnadMenu = findViewById(R.id.btnadMenu);
        registerForContextMenu(btnadMenu);
        btnadMenu.setLongClickable(true);


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 100, "상품 관리");
        menu.add(0, 1, 100, "회원 관리");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                con.sub(seatmanager.this, PRODUCTMANA);
                break;
            case 1:
                con.sub(seatmanager.this, MEMBERMANA);
                break;
        }
        return super.onContextItemSelected(item);
    }
    public void Onclickadmin(View v) {
        this.openContextMenu(btnadMenu);
    }
}
