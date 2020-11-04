package com.aninterface.interactive.app_mob2_labo3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Move extends View implements SensorEventListener {

    private int screenW;
    private int screenH;
    private Random alea;
    private Paint ballPaint;
    private int ballX;
    private int bally;
    private float ballRadius;
    private int cnt;
    private Context mcontext;
    private boolean fin;
    private ArrayList<AstreCeleste> ls;
    //construction du dialogue
    //attribut
    AlertDialog.Builder bulder;

    //element du sensor
    private SensorManager sm;
    private List<Sensor> sensorList;
    private Sensor accelerometer;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w,h,oldw,oldh);
        screenW = w;
        screenH = h;
    }


    public Move(Context context)
    {
        super(context);
        mcontext = context;

        fin = false;
        cnt =0;
        alea = new Random();
        ballX = alea.nextInt(400);
        bally = alea.nextInt(400);

        //on construit la boule noir
        ballPaint = new Paint();
        ballPaint.setAntiAlias(true);
        ballPaint.setColor(Color.BLACK);
        ballRadius = 30;

        Manager_ModelDB myDbAdapter = new Manager_ModelDB(context.getApplicationContext());
        myDbAdapter.Open();
        myDbAdapter.effacerAstreCeleste();
        myDbAdapter.InsertAstreCeleste();
        ls = new ArrayList<AstreCeleste>();
        ls = myDbAdapter.SelectAllAstreCeleste();

        //implementation des elements du sensor

        SensorManager sm = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener((SensorEventListener) this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);

    }
   /* public float getBallX()
    {
        return this.ballX;
    }
    public void setBallX(float ballX)
    {
        this.ballX=ballX;
    }

    public float getBally()
    {
        return this.bally;
    }
    public void setBally(float bally)
    {
        this.bally=bally;
    }*/



    @Override
    protected void onDraw(Canvas canvas)
    {
        // super.onDraw(canvas);

        canvas.drawCircle(ballX, bally, ballRadius, ballPaint);

        for (int i=0;i<8;i++)
        {

            ls.get(i).onDraw(canvas);
        }

        if(cnt>=8 && !fin)
        {
            Toast.makeText(mcontext,"Vous avez visité toutes les planêtes",Toast.LENGTH_LONG).show();
            fin = true;
        }

    }

    private void moveImage( float x, float y ) {
        this.bally += (int) x;
        this.bally += (int) y;
    }


        @Override
    public void onSensorChanged(SensorEvent event) {
       Sensor sensor = event.sensor;
        float vectorLength;


        //gX.setText("X: " + String.valueOf(event.values[0]));
        //gY.setText("Y: " + String.valueOf(event.values[1]));
       // gZ.setText("Z: " + String.valueOf(event.values[2]));

       vectorLength = (float)Math.sqrt(Math.pow((double)(event.values[0]),2)+Math.pow((double)(event.values[1]),2)
                + Math.pow((double)(event.values[2]),2));

        //ballX=ballX + event.values[0];//* (-1*vectorLength);
        //bally=bally + event.values[1];//* vectorLength;

            float x = event.values[0]* (-1*vectorLength);
            float y = event.values[1]* vectorLength;

            this.moveImage( -x*5, y*5 );

        }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }



}
