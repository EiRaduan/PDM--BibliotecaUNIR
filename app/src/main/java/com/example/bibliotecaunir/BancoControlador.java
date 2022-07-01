package com.example.bibliotecaunir;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BancoControlador extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "biblioteca";
    private static final int DATABASE_VERSION = 1;
    private final String CREATE_TABLE_CATALOGO =
            "CREATE TABLE catalogo ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "titulo TEXT, autor TEXT,"
                    + "ano INTEGER);";

    public BancoControlador(@Nullable Context contex) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CATALOGO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS catalogo");
        onCreate(sqLiteDatabase);
    }
}