package com.example.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FunFact extends AppCompatActivity {
    ImageView factimage ;
    TextView factcityname;
    TextView factinfo;
    ArrayList<FunFactItem> funFactItems;
    int index = 0;
    public void showfact(int index){
        FunFactItem funFactItem = funFactItems.get(index);
        factimage.setImageResource(funFactItem.FunFactImage);
        factinfo.setText(funFactItem.funfactinfo);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_fact);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(funFactItems.size() == index+1){
                    index = 0;
                    showfact(index);
                }else{
                    index++;
                    showfact(index);
                }
            }
        });

        factimage = findViewById(R.id.factimage);
        factcityname = findViewById(R.id.citynameView);
        factinfo = findViewById(R.id.cityfactinfo);
        Intent intent = getIntent();
        int cityid = intent.getIntExtra("cityid",0);
        Log.i("FUN FACT",String.valueOf(cityid));
        CitiesData citiesData = new CitiesData();
        CityItem cityItem =  citiesData.getCity(cityid);
        funFactItems = cityItem.funfacts;
        Log.i("FUN FACT",String.valueOf(cityItem.cityname));
        factcityname.setText(cityItem.cityname);
        showfact(index);
    }
}