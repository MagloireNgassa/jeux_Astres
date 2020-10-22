package com.aninterface.interactive.app_mob2_labo3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;

import java.util.ArrayList;

public class Manager_ModelDB {

    private Context context;
    private final String DATABASE_NAME ="SolarSystemDB";
    private InitDB dbHelper;
    private final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public Manager_ModelDB(Context context)
    {
        this.context = context;
        this.dbHelper = new InitDB(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void Open()
    {
        this.db = this.dbHelper.getWritableDatabase();
    }

    public void InsertAstreCeleste()
    {

        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('pierre','400','BLUE','true','collection.jpg');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('jean','800','BLUE','true','formule.jpg');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('paul','1100','RED','true','moteur.jpg');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('yoan','600','RED','true','porche.jpg');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('arsene','900','GREEN','true','rally');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('baruch','700','GREEN','true','suv.jpg');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('claud','1000','YELLOW','true','tesla.jpg');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('franck','500','YELLOW','true','voiture_bb.jpg');");
    }

    public ArrayList<AstreCeleste> SelectAllAstreCeleste()
    {

        ArrayList<AstreCeleste> listOfStudents = new ArrayList<AstreCeleste>();

        Cursor cursor = this.db.rawQuery("select * from AstreCeleste",null);



        if((cursor != null) && cursor.moveToFirst())
        {
            String a,c,d,e;
            int b; Boolean f = true;

            do{

                a = cursor.getString(1);
                b = cursor.getInt(2);
                c = cursor.getString(3);
                d = cursor.getString(4); if(d!="true"){f=false;}
                e = cursor.getString(5);
                AstreCeleste astre = new AstreCeleste();
                astre.setNomAstre(a);
                astre.setTailleAstre(b);
                if (c=="BLUE"){astre.setCouleurAstre(Color.valueOf(0xff0000ff));}
                else if (c=="YELLOW"){astre.setCouleurAstre(Color.valueOf(0xffffff00));}
                else if (c=="RED"){astre.setCouleurAstre(Color.valueOf(0xffff0000));}
                else {astre.setCouleurAstre(Color.valueOf(0xff00ff00));}

                astre.setStatusAstre(f);
                astre.setNomImageAstre(e);
                listOfStudents.add(astre);
            }while(cursor.moveToNext());
        }

        return listOfStudents;
    }
    public void effacerAstreCeleste()
    {
        this.db.execSQL("delete from AstreCeleste;");
    }

}
