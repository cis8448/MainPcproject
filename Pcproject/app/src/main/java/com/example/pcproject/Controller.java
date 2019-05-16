package com.example.pcproject;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;

public class Controller {
    public void sub(Activity activity ,String state){
     if(state.equals("login")){
         Intent loginOpen  = new Intent("com.example.pcproject.login");
         activity.startActivity(loginOpen);
     }
    }
}
