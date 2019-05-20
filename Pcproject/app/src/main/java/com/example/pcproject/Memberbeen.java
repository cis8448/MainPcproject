package com.example.pcproject;

import java.io.Serializable;

public class Memberbeen implements Serializable {
    String Id;     //아이디
    String Pass;   //패스워드
    String Name;   //이름
    String Phone;  //휴대폰번호
    String Retime = "00:00"; //적립시간
    String birth;  //생년월일

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getRetime() {
        return Retime;
    }

    public void setRetime(String retime) {
        Retime = retime;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
