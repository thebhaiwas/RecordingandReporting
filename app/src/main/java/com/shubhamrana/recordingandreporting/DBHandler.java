package com.shubhamrana.recordingandreporting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHandler  extends SQLiteOpenHelper{

    private Context context;

    private static final int VERSION = 5;
    private static final String DATABASE = "MyDB";

    private static final String TABLEA = "Annex3A";
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
                COL1A+" TEXT, "+
                COL2A+" TEXT, "+
                COL3A+" TEXT, "+
                COL4A+" TEXT, "+
                COL5A+" TEXT, "+
                COL6A+" TEXT, "+
                COL7A+" TEXT, "+
                COL8A+" TEXT, "+
                COL9A+" TEXT, "+
                COL10A+" TEXT, "+
                COL11A+" TEXT, "+
                COL12A+" TEXT, "+
                COL13A+" TEXT, "+
                COL14A+" TEXT "+
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

        long status = -1;

        try {
            SQLiteDatabase db = getWritableDatabase();
            status = db.insert(TABLEA, null, cv);
            db.close();
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        if(status != -1)
            return true;
        else
            return false;
    }

    public Cursor getCursor(String tableName) {

        if(tableName.equals(TABLEA)) {

            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cr = sqLiteDatabase.query(tableName, COLSA, null, null, null, null,
                    null);
            return cr;
        }

        return null;
    }

    public void mark(String tableName, String id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(tableName, "Id = "+id, null);
        sqLiteDatabase.close();
    }

    public ArrayList<String> showTable(String tableName) {

        ArrayList<String> rows = new ArrayList<>();

        if(tableName.equals(TABLEA)) {
            Toast.makeText(context, tableName, Toast.LENGTH_SHORT).show();
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            Cursor cr = sqLiteDatabase.query(tableName, COLSA, null, null, null , null,
                    null);
            for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()) {
                StringBuilder sb = new StringBuilder("");
                sb.append(cr.getString(cr.getColumnIndex(COL0A)));
                sb.append(" ");
                sb.append(cr.getString(cr.getColumnIndex(COL3A)));
                rows.add(sb.toString());
            }
            sqLiteDatabase.close();
        } else {
            Toast.makeText(context, "Table not found", Toast.LENGTH_SHORT).show();
        }

        return rows;
    }
}
