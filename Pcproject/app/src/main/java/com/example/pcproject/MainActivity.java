package com.example.pcproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Memberbeen MyMember = new Memberbeen();
    Controller con;
    Button btn1;

    final String LOGIN = "login";
    final String MYINFO = "myinfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con = Controller.getInstance();
        con.setActivity(this);
        btn1 = findViewById(R.id.btn1);
        registerForContextMenu(btn1);
        btn1.setLongClickable(false);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(MyMember.getId() == null){
            menu.add(0,1,100,"로그인");
        }else{
            menu.add(0,1,100,"상품등록");
            menu.add(0,2,100,"좌석정보");
            menu.add(0,3,100,"내정보");
            menu.add(0,4,100,"로그아웃");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if(item.getTitle().equals("로그인")) {
                    con.sub(MainActivity.this, LOGIN);
                }else{

                }
                break;
            case 2:
                break;
            case 3:
                if(item.getTitle().equals("내정보")) {
                    con.sub(MainActivity.this, MYINFO);
                }
                break;
            case 4:
                break;
        }
        return super.onContextItemSelected(item);
    }
    public void Onclick(View v){
        this.openContextMenu(btn1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), MyMember.getName(), Toast.LENGTH_SHORT).show();
    }
}
