package com.example.tourism;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 3000;

    Animation bounce, fadein, zoomout;
    ImageView logoextract, cloud1, cloud2;
    TextView geoTraveller, slogan1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up animations
        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);

        //setting up hooks
        logoextract = findViewById(R.id.logo_extract);
        cloud1 = findViewById(R.id.cloud1);
        cloud2 = findViewById(R.id.cloud2);
        geoTraveller = findViewById(R.id.geo_traveller);
        slogan1 = findViewById(R.id.slogan1);

        //setting up animations
        logoextract.setAnimation(bounce);
        cloud1.setAnimation(fadein);
        cloud2.setAnimation(fadein);
        geoTraveller.setAnimation(zoomout);
        slogan1.setAnimation(zoomout);
        CitiesData citydata = new CitiesData();
        citydata.addcity();
        //setting animation to next Login screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);
                Pair[] pairs = new Pair[4];
                pairs[0] = new Pair<View, String>(logoextract, "logo_extract");
                pairs[1] = new Pair<View, String>(cloud1, "cloud1");
                pairs[2] = new Pair<View, String>(cloud2, "cloud2");
                pairs[3] = new Pair<View, String>(geoTraveller, "geo_traveller");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                    finish();
                }
            }
        }, SPLASH_SCREEN);
    }
}