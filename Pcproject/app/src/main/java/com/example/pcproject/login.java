package com.example.pcproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText idtext, pwtext;
    Controller con = new Controller();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        idtext = findViewById(R.id.logid);
        pwtext = findViewById(R.id.logpw);
    }
    public void Onclicklog(View v){
        if(idtext.toString().equals("") || pwtext.toString().equals("")){
            Toast.makeText(this, "텍스트를 입력해주세요", Toast.LENGTH_SHORT).show();
        }else{
            con.sub(login.this,"selLogin");
        }
    }
}
