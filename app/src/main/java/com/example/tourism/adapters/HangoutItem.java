package com.example.tourism.adapters;

public class HangoutItem {
    int placeimage;
    String placeName;
    String placeCategory;
    String placeDescription;
    double placeLatitude;
    double placeLongitude;

    public  HangoutItem( int placeimage,
            String placeName,
            String placeCategory,
            String placeDescription,
            double placeLatitude,
            double placeLongitude){
        this.placeimage = placeimage;
        this.placeName = placeName;
        this.placeCategory = placeCategory;
        this.placeDescription = placeDescription;
        this.placeLatitude = placeLatitude;
        this.placeLongitude = placeLongitude;
    }
}
