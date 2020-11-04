package com.aninterface.interactive.app_mob2_labo3;


import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.Random;

public class Galaxy_Touch extends View {

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

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w,h,oldw,oldh);
        screenW = w;
        screenH = h;
    }

    public Galaxy_Touch(Context context)
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

        //implementation attribut dialogue dans le constructeyur

    }



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

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        int touchX = (int)event.getX();
        int touchY = (int)event.getY();

        boolean limitL,limitR,LimitU,LimitD = false;

        switch (action)
        {

            case MotionEvent.ACTION_MOVE:
                ballX = touchX;
                bally = touchY;

                for(int i =0;i<8;i++)
                {
                    limitL = ballX > (ls.get(i).getPosX()-30);
                    limitR =  ballX < (ls.get(i).getPosX()+30);
                    LimitU =  bally > (ls.get(i).getPosY()-30);
                    LimitD =  bally < (ls.get(i).getPosY()+30);

                    if(limitL && limitR && LimitD && LimitU )
                    {

                        if(ls.get(i).getStatusAstre())
                        {
                            int col = ls.get(i).getCouleurAstre();
                            String couleur;
                            if (col==0)
                            {
                                couleur = "BLEU";
                            }
                            else if(col==2)
                            {
                                couleur = "ROUGE";
                            }
                            else if (col==3)
                            {
                                couleur = "JAUNE";
                            }
                            else
                            {
                                couleur = "VERTE";
                            }
                            ImageView image = new ImageView(mcontext);
                            if(ls.get(i).getNomImageAstre().equals("Terre")){image.setImageResource(R.drawable.terre);}
                            else if(ls.get(i).getNomImageAstre().equals("Jupiter")){image.setImageResource(R.drawable.jupiter);}
                            else if(ls.get(i).getNomImageAstre().equals("Mercure")){image.setImageResource(R.drawable.mercure);}
                            else if(ls.get(i).getNomImageAstre().equals("Venus")){image.setImageResource(R.drawable.venus);}
                            else if(ls.get(i).getNomImageAstre().equals("Uranus")){image.setImageResource(R.drawable.uranus);}
                            else if(ls.get(i).getNomImageAstre().equals("Lune")){image.setImageResource(R.drawable.lune);}
                            else if(ls.get(i).getNomImageAstre().equals("Saturne")){image.setImageResource(R.drawable.saturne);}
                            else {image.setImageResource(R.drawable.mars);}


                            AlertDialog alertD = new AlertDialog.Builder(mcontext).create();
                            alertD.setTitle("Information sur la Planête");
                            alertD.setMessage("Nom: "+ls.get(i).getNomAstre()+"\n"+"Couleur: "+couleur+"\n"+"Diamètre: "+ls.get(i).getTailleAstre());
                            alertD.setButton(AlertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            alertD.setView(image);
                            alertD.show();




                            ls.get(i).setStatusAstre(false);
                            cnt++;
                        }


                        System.out.println(cnt);

                    }

                }

                break;


        }
        invalidate();
        return true;
    }


}
