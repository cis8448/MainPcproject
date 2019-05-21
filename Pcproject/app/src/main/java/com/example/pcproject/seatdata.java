package com.example.pcproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class seatdata extends AppCompatActivity {
    Controller con;
    int state[] = {R.id.blankseat, R.id.reseseat, R.id.usedseat};
    Button[] btn = new Button[20];
    int[] btnid = {
      R.id.bt1,R.id.bt2,R.id.bt3,R.id.bt4,R.id.bt5,R.id.bt6,R.id.bt7,R.id.bt8,R.id.bt9,R.id.bt10,
      R.id.bt11,R.id.bt12,R.id.bt13,R.id.bt14,R.id.bt15,R.id.bt16,R.id.bt17,R.id.bt18,R.id.bt19,R.id.bt20
    };
    Button btn1,btn2,btn3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seatdata);
        con = Controller.getInstance();
        btn1 = findViewById(state[0]);
        btn2 = findViewById(state[1]);
        btn3 = findViewById(state[2]);



        Intent intent = getIntent();
        int [] seat = intent.getIntArrayExtra("좌석");

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
        con.sub(seatdata.this,"seatreseve");

    }
}
