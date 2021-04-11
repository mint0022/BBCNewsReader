package com.example.finalproject;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class OpenerDB extends SQLiteOpenHelper {

    protected final static String DATABASE_NAME = "BBCNewsDB";
    protected final static int VERSION_NUM = 1;
    public final static String TABLE_NAME = "ARTICLES";
    public final static String COL_TITLE = "TITLE";
    public final static String COL_DESCRIPTION = "DESCRIPTION";
    public final static String COL_ID = "_id";

    public OpenerDB(Context ctx)
    {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }


   //Called if no DB exists.
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_TITLE + " text,"
                + COL_DESCRIPTION  + " text);");  // add or remove columns
    }


    //this function gets called if the database version on your device is lower than VERSION_NUM
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {   //Drop the old table:
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME);

        //Create the new table:
        onCreate(db);
    }

    //this function gets called if the database version on your device is higher than VERSION_NUM
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {   //Drop the old table:
        db.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME);

        //Create the new table:
        onCreate(db);
    }
}
