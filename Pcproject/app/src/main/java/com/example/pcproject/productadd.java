package com.example.pcproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class productadd extends AppCompatActivity {

    public EditText proEdname, proEdprice, proEdamount;
    RadioGroup RadioGr;
    RadioButton rgbtn1, rgbtn2, rgbtn3, rgbtn4, rgbtn5;
    public ImageView proaddImV;
    Controller con = Controller.getInstance();
    public Probean probean = new Probean();
    final String PROPHOTOADD = "prophotoadd";
    final String PROADDLISTADD = "proaddlistadd";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productadd);

        proEdname = findViewById(R.id.proEdname);
        proEdprice = findViewById(R.id.proEdprice);
        proEdamount = findViewById(R.id.proEdamount);
        RadioGr = findViewById(R.id.RadioGr);
        rgbtn1 = findViewById(R.id.rgbtn1);
        rgbtn2 = findViewById(R.id.rgbtn2);
        rgbtn3 = findViewById(R.id.rgbtn3);
        rgbtn4 = findViewById(R.id.rgbtn4);
        rgbtn5 = findViewById(R.id.rgbtn5);
        proaddImV = findViewById(R.id.proaddImV);
        RadioGr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rgbtn1:
                        probean.setProCate("1");
                        break;
                    case R.id.rgbtn2:
                        probean.setProCate("2");
                        break;
                    case R.id.rgbtn3:
                        probean.setProCate("3");
                        break;
                    case R.id.rgbtn4:
                        probean.setProCate("4");
                        break;
                    case R.id.rgbtn5:
                        probean.setProCate("5");
                        break;
                }

            }
        });


    }

    public void onClickProPhotoAdd(View v){

        con.sub(productadd.this,PROPHOTOADD);

//        int ImageP = Integer.parseInt(probean.getProImage());
//
//        proaddImV.setImageResource(ImageP);

    }

    public void onClickProaddbtn(View v){
        probean.setProName(proEdname.getText().toString());
        probean.setProPrice(proEdprice.getText().toString());
        probean.setProAmount(proEdamount.getText().toString());

        con.sub(productadd.this,PROADDLISTADD);
    }

    @Override
    protected void onResume() {

        Intent intent = getIntent();
        int i = intent.getIntExtra("photo",-1);
        if(i != -1){
            proaddImV.setImageResource(i);
        }
        super.onResume();
    }


}
