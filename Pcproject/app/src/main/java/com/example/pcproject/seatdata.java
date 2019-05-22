package com.example.pcproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class seatdata extends AppCompatActivity {
    Controller con;
    int state[] = {R.id.blankseat, R.id.reseseat, R.id.usedseat};
    public Button[] btn = new Button[20];
    int[] btnid = {
      R.id.bt1,R.id.bt2,R.id.bt3,R.id.bt4,R.id.bt5,R.id.bt6,R.id.bt7,R.id.bt8,R.id.bt9,R.id.bt10,
      R.id.bt11,R.id.bt12,R.id.bt13,R.id.bt14,R.id.bt15,R.id.bt16,R.id.bt17,R.id.bt18,R.id.bt19,R.id.bt20
    };
    public Button btn1,btn2,btn3;
    public int [] seat;
    public int item;


    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.seatdata);
        con = Controller.getInstance();
        btn1 = findViewById(state[0]);
        btn2 = findViewById(state[1]);
        btn3 = findViewById(state[2]);

        Intent intent = getIntent();
        seat = intent.getIntArrayExtra("좌석");

        for(int i = 0; i < seat.length; i++){
            if(seat[i] == 0){
                btn[i] = findViewById(btnid[i]);
                btn[i].setBackground(btn1.getBackground());

            }else if(seat[i]==1){
                btn[i] = findViewById(btnid[i]);
                btn[i].setBackground(btn2.getBackground());

            }else if(seat[i]==2){
                btn[i] = findViewById(btnid[i]);
                btn[i].setBackground(btn3.getBackground());
            }
        }
    }

    public void Onclickseat(View v){
        for(int i = 0; i<btnid.length; i++){
            if(btnid[i] == v.getId()){
                if(seat[i] == 0){
                    item = i;
                    con.sub(seatdata.this, "seatreve");
                    break;
                }else if(seat[i] == 1){
                    item = i;
                    con.sub(seatdata.this,"seatreserve");
                    break;
                    }
                }else  if(seat[i]==2) {
                    item = i;
                    Toast.makeText(this, "이미 사용중인 좌석입니다. 다른 좌석을 선택해주세요.", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

