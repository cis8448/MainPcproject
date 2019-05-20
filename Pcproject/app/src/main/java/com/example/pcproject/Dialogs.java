package com.example.pcproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Dialogs {

    View UpdateView, ReserveView, AddTimeView;
    EditText UpPass, UpPhone, UpBirth;
    Controller con;
    public String infopw;
    public String infohp;
    public String infobr;
    Memberbeen mybeen;
    Spinner spTime;
    TextView addTimeTv;
    Object abj;
    int infotimeIt;
    String infotimeSt2;



    String Time[] = {
            "1시간", "2시간", "3시간", "4시간", "5시간",
            "6시간", "7시간", "8시간", "9시간", "10시간"
    };
    ArrayList<String> TimeList = new ArrayList<>();
    ArrayAdapter<String> timeAdapter;

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

    public void removeDialog(final Activity act){
        con = Controller.getInstance();
        AlertDialog.Builder removeDlg = new AlertDialog.Builder(act);
        removeDlg.setTitle("정말 탈퇴하실겁니까? 예?");
        removeDlg.setNegativeButton("취소", null);
        removeDlg.setPositiveButton("탈퇴", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                con.sub(act, "myremoving");
            }
        });
        removeDlg.show();
    }
    public void reserveDialog(final Activity act) {
        con = Controller.getInstance();
        ReserveView = View.inflate(act, R.layout.seatreserve, null);
        mybeen = ((myinfo) act).memberbeen;
        AlertDialog.Builder reserveDlg = new AlertDialog.Builder(act);
        reserveDlg.setView(ReserveView);

        reserveDlg.setNegativeButton("취소", null);
        reserveDlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (infopw.equals("")) {
                    //EditText 가 공백일때
                    infopw = mybeen.getPass();
                }
                if (infohp.equals("")) {
                    infohp = mybeen.getPhone();
                }
                if (infobr.equals("")) {
                    infobr = mybeen.getBirth();
                }
                //다 끝나고 con.sub 실행

                con.sub(act, "myinfoupdating");

            }
        });
        reserveDlg.show();
    }

    public void addTimeDialog(final Activity act){
        con = Controller.getInstance();
        mybeen = ((myinfo)act).memberbeen;
        String infotimeSt = mybeen.getRetime();
        if(infotimeSt.length() == 5){
            String str = infotimeSt.substring(0, 2);
            infotimeIt = Integer.parseInt(str);
            infotimeSt2 = mybeen.getRetime().substring(3, 5);
        }else{
            String str = infotimeSt.substring(0, 1);
            infotimeIt = Integer.parseInt(str);
            infotimeSt2 = mybeen.getRetime().substring(2, 4);
        }
        //스트링 -> 숫자 변환


        AddTimeView = View.inflate(act, R.layout.timeadd, null);
        mybeen = ((myinfo) act).memberbeen;
        AlertDialog.Builder AddTimeDlg = new AlertDialog.Builder(act);
        AddTimeDlg.setView(AddTimeView);
        spTime = AddTimeView.findViewById(R.id.spTime);

        for (int i = 0; i < Time.length; i++) {
            TimeList.add(String.valueOf(Time[i]));
        }

        timeAdapter = new ArrayAdapter<>(
                act, android.R.layout.simple_spinner_dropdown_item, TimeList);

        spTime.setAdapter(timeAdapter);
        spTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                addTimeTv = AddTimeView.findViewById(R.id.addTimeTv);
                addTimeTv.setText("선택하신 시간은 : " + parent.getItemAtPosition(position));
                timeAdapter.notifyDataSetChanged();
                abj = parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        AddTimeDlg.setNegativeButton("취소", null);
        AddTimeDlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String subtime = abj.toString().substring(0,1);
                int timeResult = Integer.parseInt(subtime);

                int result = timeResult + infotimeIt;


                String stresult = result + ":" + infotimeSt2;
                mybeen.setRetime(stresult);
                con.sub(act,"addtimefinal");
            }
        });

        AddTimeDlg.show();
    }
}
