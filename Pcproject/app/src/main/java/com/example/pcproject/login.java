package com.example.pcproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText idtext, pwtext;
    Controller con;
    final String LOGIN = "selLogin";
    final String ID = "txtid";
    final String PW = "txtpw";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        con = Controller.getInstance();

        idtext = findViewById(R.id.logid);
        pwtext = findViewById(R.id.logpw);
}
    public void Onclicklog(View v){
        String idtxt = idtext.getText().toString();
        String pwtxt = pwtext.getText().toString();
        if(idtxt.equals("") || pwtxt.equals("")){
            Toast.makeText(getApplicationContext(), "텍스트를 입력해주세요", Toast.LENGTH_SHORT).show();
        }else{
            con.intentid = idtxt;
            con.intentpw = pwtxt;
            con.sub(login.this,LOGIN);
        }
    }
}
