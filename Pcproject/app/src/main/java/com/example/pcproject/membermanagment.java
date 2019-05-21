package com.example.pcproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class membermanagment  extends AppCompatActivity {

    LinearLayout memberV;
    Activity act;
    View memberView;
    Memberbeen MyMember = new Memberbeen();
    Button btnadMenu;
    ListView list1;
    ArrayList<Memberbeen> memberlist;
    Adapter memberAdapter;
    Controller con = Controller.getInstance();
    final String LISTSET = "listset";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membermanagment);


        list1 = findViewById(R.id.mList);
        if(memberAdapter == null ){
            con.sub(membermanagment.this,LISTSET);
        }
        memberV = findViewById(R.id.memberV);
        //컨텍스트 메뉴 추가
        btnadMenu = findViewById(R.id.btnadMenu);
        registerForContextMenu(btnadMenu);
        btnadMenu.setLongClickable(false);


    }//onCreate

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        memberView = View.inflate(act,R.layout.membermanagment,null);

        switch (v.getId()) {
            case R.id.memberV:
                menu.add(0,1,100,"좌석 관리");
                menu.add(0,2,100,"상품 관리");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }
}
