package com.example.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tourism.adapters.CustomAdapter;
import com.example.tourism.adapters.HangoutAdapter;
import com.example.tourism.adapters.HangoutItem;

import java.util.ArrayList;

public class HangoutPlaces extends AppCompatActivity {
    ArrayList<HangoutItem> hangoutitems;
    TextView placecategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int cityid = intent.getIntExtra("cityid",0);
        setContentView(R.layout.activity_hangout_places);
        String title = intent.getStringExtra("name");
        placecategory = (TextView) findViewById(R.id.placecategory);
        placecategory.setText(title);
//        getSupportActionBar().setTitle(title);
        Log.i("Monuments",String.valueOf(cityid));
        CitiesData citiesData = new CitiesData();
        CityItem cityItem =  citiesData.getCity(cityid);
        if(title.equals("Restaurents")){
            hangoutitems = cityItem.restuarentsItemArrayList;
        }else {
        hangoutitems = cityItem.hangoutItemArrayList;
        }


        ListView listView = (ListView) findViewById(R.id.listview);

        HangoutAdapter hangoutAdapter = new HangoutAdapter(getApplicationContext(),hangoutitems);
        listView.setAdapter(hangoutAdapter);
    }
}