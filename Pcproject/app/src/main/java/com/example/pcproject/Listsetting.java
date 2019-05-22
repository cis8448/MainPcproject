package com.example.pcproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Listsetting {

    ArrayList<Memberbeen> allmember;
    ArrayList<Probean> allproduct;
    ArrayList<Seatbean> allSeat;

    public Listsetting(Object amem, int category){
        if(category == 1){
            allmember = (ArrayList<Memberbeen>)amem;
        }
        else if(category == 2){
            allproduct = (ArrayList<Probean>)amem;
        }else if(category == 3){
            allSeat = (ArrayList<Seatbean>)amem;
        }

    }
    public Listsetting(ArrayList<Probean> allpro){
        this.allproduct = allpro;
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
    public ProductAdapterSet productListSetting(){
        ProductAdapterSet productAdapter = new ProductAdapterSet(allproduct);
        return productAdapter;
    }
    public class ProductAdapterSet extends BaseAdapter{
        ArrayList<Probean> allproduct;
        public ProductAdapterSet(ArrayList allpro){
            this.allproduct = allpro;
        }

        @Override
        public int getCount() {
            return allproduct.size();
        }

        @Override
        public Object getItem(int position) {
            return allproduct.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Probean probean;
            int proPos = position;
            Context context = parent.getContext();
            if(convertView == null){
                if(context instanceof productmanagment) {
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.productlistview, parent, false);
                }else{
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.productgridview, parent, false);
                }
            }
            TextView proTvName, proTvPrice;
            ImageView proImage;

            TextView orderTvName,orderTvPrice;


            if(context instanceof productmanagment) {


                proTvName = convertView.findViewById(R.id.proTvName);
                proTvPrice = convertView.findViewById(R.id.proTvPrice);
                proImage = convertView.findViewById(R.id.proImage);

                Probean pro = allproduct.get(position);

                int ImageSource = Integer.parseInt(pro.getProImage());

                proTvName.setText(pro.getProName());
                proTvPrice.setText(pro.getProPrice());
                proImage.setImageResource(ImageSource);


            }
            else {
                //병호가 쓸것

                orderTvName = convertView.findViewById(R.id.orderTvName);
                orderTvPrice = convertView.findViewById(R.id.orderTvPrice);
                proImage = convertView.findViewById(R.id.proImage);


                Probean pro = allproduct.get(position);

                int ImageSource = Integer.parseInt(pro.getProImage());

                orderTvName.setText(pro.getProName());
                orderTvPrice.setText(pro.getProPrice());
                proImage.setImageResource(ImageSource);

            }
            return convertView;
            //instanceof 될지 모름
        }

    }

}
