package com.example.pcproject;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;

public class Controller {
    public void sub(Activity activity ,String str){
     if(str.equals("Login")){
         Intent loginOpen  = new Intent("com.example.pcproject.login");
         activity.startActivity(loginOpen);
     }
    }
}
