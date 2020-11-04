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

        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('Terre','20','BLUE','true','collection');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('Saturne','33','BLUE','true','formule1');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('Jupiter','42','GREEN','true','moteur');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('Lune','27','RED','true','porche');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('Mars','36','RED','true','rally');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('Uranus','30','GREEN','true','suv');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('Mercure','39','YELLOW','true','tesla');");
        this.db.execSQL("INSERT INTO AstreCeleste(NomAstre,TailleAstre,CouleurAstre,StatusAstre,NomImageAstre) values('Venus','23','YELLOW','true','voiture_bb');");
    }

    public ArrayList<AstreCeleste> SelectAllAstreCeleste()
    {

        ArrayList<AstreCeleste> listOfAstres = new ArrayList<AstreCeleste>();

        Cursor cursor = this.db.rawQuery("select * from AstreCeleste",null);



        if((cursor != null) && cursor.moveToFirst())
        {
            String a,c,d,e;
            int b; Boolean f = false;

            do{

                a = cursor.getString(1);
                b = cursor.getInt(2);
                c = cursor.getString(3);
                d = cursor.getString(4); if(d.equals("true")){f=true;}
                e = cursor.getString(5);

                AstreCeleste astre = new AstreCeleste();

                astre.setNomAstre(a);
                astre.setTailleAstre(b);//parametrer l'attirbut coulleur astre a recevoir des int

                if (c.equals("BLUE")){astre.setCouleurAstre(0);}//(0xff0000ff)
                else if (c.equals("YELLOW")){astre.setCouleurAstre(3);}//(0xffffff00)
                else if (c.equals("RED")){astre.setCouleurAstre(2);} //(0xffff0000)
                else {astre.setCouleurAstre(1);} //(0xff00ff00)

                astre.setStatusAstre(f);
                astre.setNomImageAstre(e);

                listOfAstres.add(astre);

            }while(cursor.moveToNext());
        }

        return listOfAstres;
    }
    public void effacerAstreCeleste()
    {
        this.db.execSQL("delete from AstreCeleste;");
    }

}
