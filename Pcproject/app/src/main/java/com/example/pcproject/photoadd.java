package com.example.pcproject;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class photoadd extends AppCompatActivity {

    public int Photo[] = {
            R.drawable.ramen1, R.drawable.ramen2, R.drawable.ramen3, R.drawable.ramen4, R.drawable.ramen5,
            R.drawable.ramen6, R.drawable.ramen7,

            R.drawable.rice1, R.drawable.rice2, R.drawable.rice3, R.drawable.rice4, R.drawable.rice5,

            R.drawable.coffee, R.drawable.coffee2, R.drawable.coffee3, R.drawable.coffee4, R.drawable.coffee5,

            R.drawable.drink1, R.drawable.drink2, R.drawable.drink3, R.drawable.drink4, R.drawable.drink5,
            R.drawable.drink6, R.drawable.drink7, R.drawable.drink8, R.drawable.drink9, R.drawable.drink10,
            R.drawable.drink11, R.drawable.drink12,

            R.drawable.etc1, R.drawable.etc2, R.drawable.etc3, R.drawable.etc4, R.drawable.etc5,
            R.drawable.etc6, R.drawable.etc7, R.drawable.etc8, R.drawable.etc9, R.drawable.etc10,
    };
    int photoitemset = -1;
    public int pos = -1;
    Controller con = Controller.getInstance();
    Listsetting.MyPhotoAdapter myPhotoAdapter;
    GridView gv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoadd);
        if(myPhotoAdapter == null){
         con.sub(photoadd.this,"photoopen");
        }
        gv = findViewById(R.id.grid);
        gv.setAdapter(myPhotoAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LinearLayout ll = view.findViewById(R.id.ii);
                if(pos != -1){
                    if(pos != position){
                        Toast.makeText(getApplicationContext(), "전에 선택한 사진이있습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                switch (photoitemset) {
                    case -1:
                        ll.setBackgroundColor(Color.GRAY);
                        photoitemset = position;
                        pos = position;
                        break;
                    default:
                        ll.setBackgroundColor(Color.WHITE);
                        photoitemset = -1;
                        pos = -1;

                }

            }
        });
    }
    public void onClickPtadd(View v) {
        con.sub(photoadd.this,"photoadd");
    }

}
