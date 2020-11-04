package com.aninterface.interactive.app_mob2_labo3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class AstreCeleste {

    private Paint crayon;
    private Random alea;
    private int posX;
    private int posY;
    private String NomAstre;
    private int TailleAstre;
    private int CouleurAstre;
    private Boolean StatusAstre;
    private String NomImageAstre;

    private static final int[] palette = {Color.BLUE,Color.GREEN,Color.RED,Color.YELLOW};


    public AstreCeleste() {

        alea = new Random();
        posX = alea.nextInt(400);
        posY = alea.nextInt(400);

         crayon = new Paint();
        crayon.setAntiAlias(true);
        crayon.setColor(palette[CouleurAstre]);

    }

    public String getNomAstre() {
        return NomAstre;
    }

    public void setNomAstre(String nomAstre) {
        NomAstre = nomAstre;
    }

    public int getTailleAstre() {
        return TailleAstre;
    }

    public void setTailleAstre(int tailleAstre) {
        TailleAstre = tailleAstre;
    }

    public int getCouleurAstre() {
        return CouleurAstre;

    }

    public void setCouleurAstre(int couleurAstre) {
        CouleurAstre = couleurAstre;
        crayon.setColor(palette[CouleurAstre]);
    }

    public Boolean getStatusAstre() {
        return StatusAstre;
    }

    public void setStatusAstre(Boolean statusAstre) {

        this.StatusAstre = statusAstre;

        if (!this.StatusAstre)
        {
            crayon.setColor(Color.TRANSPARENT);
        }
    }

    public String getNomImageAstre() {
        return NomImageAstre;
    }

    public void setNomImageAstre(String nomImageAstre) {
        NomImageAstre = nomImageAstre;
    }

    //getter des position pourm recuperer la position des objet
    public int getPosX()
    {

        return this.posX;
    }

    public int getPosY()
    {
        return
                this.posY;
    }

    //methode pour desiner les objets
   protected void onDrawBitmap(Canvas canvas, Bitmap bitmap) {


       canvas.drawBitmap( bitmap, posX, posY, null);
   }

    protected void onDraw(Canvas canvas) {


        canvas.drawCircle(posX, posY, TailleAstre, crayon);
    }
}
