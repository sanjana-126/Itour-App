package com.example.tourism;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class CitySelected extends AppCompatActivity {
    RelativeLayout selectedImage;
    TextView citynameTextView;
    TextView citydescriptionTextView;
    TextView weatherTextView;
    CityItem city;


    public  void onFunFact(View view){
        Intent intent = new Intent(getApplicationContext(),FunFact.class);
        intent.putExtra("cityid",city.cityid);
        startActivity(intent);
    }
    public  void onHangoutbttn(View view){
        Intent intent = new Intent(getApplicationContext(),HangoutPlaces.class);
        intent.putExtra("cityid",city.cityid);
        intent.putExtra("name","Hangouts" );
        startActivity(intent);
    }
    public  void onMonumentsbttn(View view){
        Intent intent = new Intent(getApplicationContext(),HangoutPlaces.class);
        intent.putExtra("cityid",city.cityid);
        intent.putExtra("name","Monuments");
        startActivity(intent);
    }
    public  void onShoppingbttn(View view){
        Intent intent = new Intent(getApplicationContext(),HangoutPlaces.class);
        intent.putExtra("cityid",city.cityid);
        intent.putExtra("name","Shopping");
        startActivity(intent);
    }
    public  void onRestaurentsbttn(View view){
        Intent intent = new Intent(getApplicationContext(),HangoutPlaces.class);
        intent.putExtra("cityid",city.cityid);
        intent.putExtra("name","Restaurents");
        startActivity(intent);
    }

    public  void viewOnMap(View view){
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        intent.putExtra("latitude",city.cityLatitude);
        intent.putExtra("longitude",city.cityLongitude);
        intent.putExtra("name",city.cityname);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_city_selected);

        selectedImage = (RelativeLayout) findViewById(R.id.imagelayout);
        citynameTextView = (TextView) findViewById(R.id.cityname);
        weatherTextView = (TextView) findViewById(R.id.weatherM);
        citydescriptionTextView = (TextView) findViewById(R.id.cityinfo);
        Intent intent = getIntent();
//        selectedImage.setBackgroundResource(intent.getIntExtra("image", 0));
        CitiesData citydata = new CitiesData();
        city = citydata.getCity(intent.getIntExtra("image",0));
        citynameTextView.setText(city.cityname);
        selectedImage.setBackgroundResource(city.cityimage);
//        getSupportActionBar().setTitle(city.cityname);
        citydescriptionTextView.setText(city.description);
        setweather(city.cityname);
        Log.i("CIty",city.cityname) ;
    }

    public void setweather(String cityname){
        String result = null;
        weatherDownload taskdownload = new weatherDownload();
        try{
            String location = URLEncoder.encode(cityname,"UTF-8");
            String weatherapi = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=5f38e129a11312b6c55be4adcf869fd0",location);
            result =  taskdownload.execute(weatherapi).get();
            Log.i("JSON DATA",result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    class  weatherDownload extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1){
                    char current  = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return "NUll";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(s);
                String weatherInfo  = jsonObject.getString("weather");
                String temp = jsonObject.getString("main");
                JSONArray arr = new JSONArray(weatherInfo);
                JSONObject tempjson = new JSONObject(temp);
                String main = "";
                String description = "";
                double temperature = Double.parseDouble(tempjson.getString("temp"));

                main += String.format("%.2f",temperature-273.15) +"\u2103";
                for(int i=0;i <arr.length();i++){
                    JSONObject jsonPart = arr.getJSONObject(i);

                    description += jsonPart.getString("description");

                }
                String resultText = String.format(" %s \n %s",main,description);
                weatherTextView.setText(resultText);
            } catch (Exception e) {
                e.printStackTrace();
                weatherTextView.setText("Failed : Wrong Location");

            }

        }
    }
}