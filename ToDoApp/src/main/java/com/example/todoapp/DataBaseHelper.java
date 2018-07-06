package com.example.todoapp;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "todo.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "todo";
    public static final String ID_FIELD_NAME = "_id";
    public static final String ID_FIELD_TYPE = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String DATE_FIELD_NAME = "date";
    public static final String DATE_FIELD_TYPE = "INTEGER";
    public static final String TITLE_FIELD_NAME = "title";
    public static final String TITLE_FIELD_TYPE = "TEXT";
    public static final String DESCR_FIELD_NAME = "description";
    public static final String DESCR_FIELD_TYPE = "TEXT";

    private static  final String TABLE_CREATE =     "CREATE TABLE " + TABLE_NAME + "("
                                    +    ID_FIELD_NAME + " " +    ID_FIELD_TYPE + ", "
                                    +  DATE_FIELD_NAME + " " +  DATE_FIELD_TYPE + ", "
                                    + TITLE_FIELD_NAME + " " + TITLE_FIELD_TYPE + ", "
                                    + DESCR_FIELD_NAME + " " + DESCR_FIELD_TYPE + ")";

    public DataBaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(TABLE_CREATE);
        } catch (SQLException e) {
            Log.e("DatabaseHelper", "error creating tables ", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("DatabaseHelper", "onUpgrade: ");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        Log.i("DatabaseHelper", "onDowngrade: ");
    }

}
