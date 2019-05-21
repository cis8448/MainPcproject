package com.example.pcproject;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class membermanagment  extends AppCompatActivity {
    public ListView list1;
    public Listsetting.MemberAdapterSet adapterSet;
    Controller con = Controller.getInstance();
    final String LISTSET = "listset";
    Button btnadMenu,bgtnadd,btndel;
    public int itemnum = -1;

    final String PRODUCTMANA = "productlist";
    final String SEATMANA = "seatmanager";
    final String MEMADD = "signup";
    final String MEMDEL = "userdel";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membermanagment);
        list1 = findViewById(R.id.mList);
        if(adapterSet == null ){
            con.sub(membermanagment.this,LISTSET);
        }
        con.setActivity(this);
        list1.setAdapter(adapterSet);
        //컨텍스트 메뉴 추가
        btnadMenu = findViewById(R.id.btnadMenu);
        registerForContextMenu(btnadMenu);
        btnadMenu.setLongClickable(true);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                LinearLayout ll = view.findViewById(R.id.hh);
                switch (itemnum) {
                    case -1:
                        ll.setBackgroundColor(Color.GRAY);
                        itemnum = position;
                        break;
                    default:
                        ll.setBackgroundColor(Color.WHITE);
                        itemnum = -1;
                }
            }
        });
        list1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                itemnum = position;
                con.sub(membermanagment.this,"memberinfoupdate");
                return true;
            }
        });

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
    public void onclickaddmem(View v){
        switch (v.getId()){
            case R.id.add:
                con.sub(this,MEMADD);
                this.onStop();
                break;
            case R.id.del:
                if(itemnum != -1 ) {
                    con.sub(this, MEMDEL);
                }
                break;
        }
    }
    protected void onResume() {
        super.onResume();
        if(list1 != null) {
            adapterSet.notifyDataSetChanged();

        }
    }

}
