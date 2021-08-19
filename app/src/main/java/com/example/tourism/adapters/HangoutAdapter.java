package com.example.tourism.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourism.MapsActivity;
import com.example.tourism.R;

import java.util.ArrayList;

public class HangoutAdapter extends BaseAdapter {
    Context context;
    ArrayList<HangoutItem> hangoutItemArrayList;
    LayoutInflater inflater;

    public  HangoutAdapter(Context applicationContext,ArrayList<HangoutItem> hangoutItemArrayList){
        this.context = applicationContext;
        this.hangoutItemArrayList  = hangoutItemArrayList;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return hangoutItemArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.listlayout,null);
        HangoutItem item  = hangoutItemArrayList.get(i);
        ImageView placeimage = (ImageView) view.findViewById(R.id.placeimage);
        TextView placename = (TextView) view.findViewById(R.id.placename);
        TextView placeDescription = (TextView) view.findViewById(R.id.placedescription);
        placeimage.setImageResource(item.placeimage);
        placename.setText(item.placeName);
        placeDescription.setText(item.placeCategory);
        Context Context = this.context;

        Button Button = (Button) view.findViewById(R.id.locateonmap) ;
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(Context, MapsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("latitude",item.placeLatitude);
                    intent.putExtra("longitude",item.placeLongitude);
                    intent.putExtra("name",item.placeName);
                    Context.startActivity(intent);
            }
        });
        return view;
    }
}
