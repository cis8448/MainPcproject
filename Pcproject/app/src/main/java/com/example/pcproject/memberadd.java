package com.example.pcproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class memberadd extends AppCompatActivity {

    public EditText joinid,joinpw,joinphone,joinname,joinbirth;
    Controller con = Controller.getInstance();
    public Memberbeen memberbeen = new Memberbeen();
    final String memberjoin = "signing";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memberadd);

        joinid = findViewById(R.id.joinid);
        joinpw = findViewById(R.id.joinpw);
        joinphone = findViewById(R.id.joinphone);
        joinname = findViewById(R.id.joinname);
        joinbirth = findViewById(R.id.joinbirth);
    }
    public void onclickmemberjoin(View v){

        memberbeen.setId(joinid.getText().toString());
        memberbeen.setPass(joinpw.getText().toString());
        memberbeen.setPhone(joinphone.getText().toString());
        memberbeen.setName(joinname.getText().toString());
        memberbeen.setBirth(joinbirth.getText().toString());

        con.sub(memberadd.this,memberjoin);
    }

}
