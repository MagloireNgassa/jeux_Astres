package com.aninterface.interactive.app_mob2_labo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Galaxy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_galaxy);

        Galaxy_Touch galaxy_touch= new Galaxy_Touch(this);
        //startScreen.setKeepScreenOn(true);

        setContentView(galaxy_touch);
    }
}
