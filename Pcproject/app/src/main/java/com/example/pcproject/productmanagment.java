package com.example.pcproject;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class productmanagment extends AppCompatActivity {

    public ListView proListView;
    public Listsetting.ProductAdapterSet proAdapterset;
    Controller con = Controller.getInstance();
    final String PROLISTSET = "productlistset";
    public int proitemsel = -1;
    Button btnadMenu, productAdd, productDel;
    Listsetting listset ;
    Context context;

    final String MEMBERMANA = "adminLogin";
    final String SEATMANA = "seatmanager";

    String PROADD = "adminproadd";
    String PRODEL = "adminprodeldi";


    //final String 으로 Controller 보내줘야할 때

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productlist);
        btnadMenu = findViewById(R.id.btnadMenu);
        productAdd = findViewById(R.id.productAdd);
        productDel = findViewById(R.id.productDel);
        proListView = findViewById(R.id.proListView);

        if (proAdapterset == null) {
            con.sub(productmanagment.this, PROLISTSET);
        }
        con.setActivity(this);
        proListView.setAdapter(proAdapterset);

        registerForContextMenu(btnadMenu);
        btnadMenu.setLongClickable(true);

        proListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LinearLayout proll = view.findViewById(R.id.proll);
                switch (proitemsel) {
                        case -1:
                            proll.setBackgroundColor(Color.GRAY);
                            proitemsel = position;
                            break;
                        default:
                            proll.setBackgroundColor(Color.WHITE);
                            proitemsel = -1;
                }
            }
        });

    }//onCreate

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 100, "좌석 관리");
        menu.add(0, 1, 100, "회원 관리");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                con.sub(productmanagment.this, SEATMANA);
                break;
            case 1:
                con.sub(productmanagment.this, MEMBERMANA);
                break;
        }
        return super.onContextItemSelected(item);

    }

    public void Onclickadmin(View v) {
        this.openContextMenu(btnadMenu);
    }

    public void onClickProbtn(View v) {
        switch (v.getId()) {
            case R.id.productAdd:
                con.sub(productmanagment.this, PROADD);
                break;
            case R.id.productDel:
                con.sub(this, PRODEL);
                break;
        }
    }
}
