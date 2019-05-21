package com.example.pcproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Listsetting {

    ArrayList<Memberbeen> allmember;

    public Listsetting(ArrayList<Memberbeen> allmember){
        this.allmember = allmember;
    }

    public MemberAdapterSet memberListSetting(){
        MemberAdapterSet memberAdapter = new MemberAdapterSet(allmember);
        return memberAdapter;
    }


 public class MemberAdapterSet extends BaseAdapter{
        ArrayList<Memberbeen> allmember;
        public MemberAdapterSet(ArrayList allmem){
            this.allmember = allmem;
        }
     @Override
     public int getCount() {
         return allmember.size();
     }

     @Override
     public Object getItem(int position) {
         return allmember.get(position) ;
     }

     @Override
     public long getItemId(int position) {
         return position;
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
         final int pos = position;
         final Context context = parent.getContext();
         if(convertView == null){
             LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
             convertView = inflater.inflate(R.layout.membermanagment2,parent,false);
         }
         TextView nametxt, birthtxt, idtxt, timetxt;

         nametxt = convertView.findViewById(R.id.mName);
         birthtxt = convertView.findViewById(R.id.mDb);
         idtxt = convertView.findViewById(R.id.mId);
         timetxt = convertView.findViewById(R.id.mTime);
             Memberbeen mem = allmember.get(position);
             nametxt.setText(mem.getName());
             birthtxt.setText(mem.getBirth());
             idtxt.setText(mem.getId());
             timetxt.setText(mem.getRetime());
         return convertView;
     }
 }
}
