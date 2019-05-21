package com.example.pcproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class productmanagment extends AppCompatActivity {
    Controller con;
    Button btnadMenu;

    final String MEMBERMANA = "adminLogin";
    final String SEATMANA = "seatmanager";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productlist);
        con = Controller.getInstance();
        btnadMenu = findViewById(R.id.btnadMenu);
        registerForContextMenu(btnadMenu);
        btnadMenu.setLongClickable(true);
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
}
