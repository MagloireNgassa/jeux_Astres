package com.aninterface.interactive.app_mob2_labo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        StartView startView = new StartView(this);
        //startScreen.setKeepScreenOn(true);
        setContentView(startView);

        /*this.btn = (Button)findViewById(R.id.btn1);

        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Manager_ModelDB myDbAdapter = new Manager_ModelDB(getApplicationContext());
                    myDbAdapter.Open();
                    myDbAdapter.InsertAstreCeleste();
                    ArrayList<AstreCeleste> ls = new ArrayList<AstreCeleste>();
                    ls = myDbAdapter.SelectAllAstreCeleste();
                    Log.i("dbTest",String.valueOf(ls.size()));//Affiche la taille de l'arraylist
                    myDbAdapter.effacerAstreCeleste();
                    ls = myDbAdapter.SelectAllAstreCeleste();
                    Log.i("dbTest",String.valueOf(ls.size()));

                }catch (Exception ex)
                {
                    Log.i("dbTest",ex.getMessage());

                }

            }
        });*/

    }
}
