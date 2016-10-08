package com.shubhamrana.recordingandreporting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler  extends SQLiteOpenHelper{

    private static final int VERSION = 1;
    private static final String DATABASE = "MyDB";

    private static final String TABLEA = "Info";
    private static final String COL0A = "Id";
    private static final String COL1A = "Name";
    private static final String COL2A = "Age";
    private static final String COLSA[] = {COL0A, COL1A, COL2A};

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =  "CREATE TABLE "+TABLEA+
                " ( "+
                COL0A+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COL1A+" TEXT NOT NULL, "+
                COL2A+" TEXT NOT NULL "+
                " );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLEA+" ; ";
        db.execSQL(query);
        onCreate(db);
    }

    public boolean addRowA() {

        return true;
    }

    public boolean delRowA() {

        return true;
    }
}
