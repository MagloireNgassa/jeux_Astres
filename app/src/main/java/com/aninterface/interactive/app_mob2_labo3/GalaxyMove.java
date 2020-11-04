package com.aninterface.interactive.app_mob2_labo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GalaxyMove extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_galaxy_move);

        Move move= new Move(this);
        //startScreen.setKeepScreenOn(true);

        setContentView(move);
    }
}
