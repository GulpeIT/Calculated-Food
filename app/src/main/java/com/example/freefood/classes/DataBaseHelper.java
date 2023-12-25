package com.example.freefood.classes;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "stash.db";     // название бд
    public static int SCHEMA = 1;                               // версия базы данных
    public static final String TABLE = "stash";                 // название таблицы в бд

    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PROTEINS = "proteins";
    public static final String COLUMN_FATS = "fats";
    public static final String COLUMN_CARBOHYDRATES = "carbohydrates";
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_GRAM = "gram";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Создание таблицы
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE +" ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PROTEINS + " REAL, "
                + COLUMN_FATS + " REAL, "
                + COLUMN_CARBOHYDRATES + " REAL, "
                + COLUMN_CALORIES + " REAL, "
                + COLUMN_GRAM + " REAL);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE);
        onCreate(db);
    }
}