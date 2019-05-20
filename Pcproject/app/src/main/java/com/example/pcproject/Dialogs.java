package com.example.pcproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Dialogs {

    View UpdateView;
    EditText UpPass, UpPhone, UpBirth;
    Controller con;
    public String infopw;
    public String infohp;
    public String infobr;
    Memberbeen mybeen;

    public void myinfoDialog(final Activity act){
        con = Controller.getInstance();
        UpdateView = View.inflate(act, R.layout.myinfoupdate, null);
        mybeen = ((myinfo)act).memberbeen;
        AlertDialog.Builder UpdateDlg = new AlertDialog.Builder(act);
        UpdateDlg.setView(UpdateView);
        UpPass = UpdateView.findViewById(R.id.UpPass);
        UpPhone = UpdateView.findViewById(R.id.UpPhone);
        UpBirth = UpdateView.findViewById(R.id.UpBirth);

        UpdateDlg.setNegativeButton("취소", null);
        UpdateDlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                infopw = UpPass.getText().toString();
                infohp = UpPhone.getText().toString();
                infobr = UpBirth.getText().toString();
                if(infopw.equals("")) {
                    //EditText 가 공백일때
                    infopw = mybeen.getPass();
                }
                if(infohp.equals("")){
                    infohp = mybeen.getPhone();
                }
                if(infobr.equals("")){
                    infobr = mybeen.getBirth();
                }
                //다 끝나고 con.sub 실행
                con.sub(act, "myinfoupdating");

            }
        });
        UpdateDlg.show();

    }
}
