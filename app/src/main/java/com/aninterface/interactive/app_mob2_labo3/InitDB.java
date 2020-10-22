package com.aninterface.interactive.app_mob2_labo3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class InitDB extends SQLiteOpenHelper {
    public InitDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE IF NOT EXISTS AstreCeleste(id integer primary key autoincrement,NomAstre text ,TailleAstre integer," +
                "CouleurAstre text,StatusAstre Boolean,NomImageAstre text );";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
