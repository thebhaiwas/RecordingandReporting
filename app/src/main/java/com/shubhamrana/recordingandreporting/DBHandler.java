package com.shubhamrana.recordingandreporting;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHandler  extends SQLiteOpenHelper{

    private Context context;

    private static final int VERSION = 1;
    private static final String DATABASE = "MyDB";

    private static final String TABLEA = "ANNEXA";
    private static final String COL0A = "Id";
    private static final String COL1A = "NameRHF";
    private static final String COL2A = "Date";
    private static final String COL3A = "NamePatient";
    private static final String COL4A = "Age";
    private static final String COL5A = "Sex";
    private static final String COL6A = "Address";
    private static final String COL7A = "Disease";
    private static final String COL8A = "Site";
    private static final String COL9A = "Reason";
    private static final String COL10A = "PTN";
    private static final String COL11A = "NameOfficial";
    private static final String COL12A = "SIN";
    private static final String COL13A = "DateSputum";
    private static final String COL14A = "NameCollector";
    public static final String COLSA[] = {COL0A, COL1A, COL2A, COL3A, COL4A, COL5A, COL6A,
        COL7A, COL8A, COL9A, COL10A, COL11A, COL12A, COL13A, COL14A};

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE, null, VERSION);
        this.context = context;
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

    public boolean addRowA(ContentValues cv) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLEA, null, cv);
        db.close();

        Toast.makeText(context, "Record submitted successfully", Toast.LENGTH_SHORT).show();

        return true;
    }
}
