package com.example.westcoast;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.westcoast.entidades.oferta;
import com.example.westcoast.utilidades.utilidades;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.O;
import static com.example.westcoast.utilidades.utilidades.*;

//Metodo para la construccion de la base de datos

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Genera las tablas de nuestros scripts correspondientes
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREAR_TABLA_ALUMNO);
        db.execSQL(CREAR_TABLA_EMPRESA);
        db.execSQL(CREAR_TABLA_OFERTA);
    }


    //verifica si hay una version antigua de la bd
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //elimina la tabla alumnos si esta y con el metodo onCreate crea la db
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_ALUMNO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_EMPRESA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_OFERTA);
        onCreate(db);

    }

    //verifica el Login del usuario alumno: matricula y contraseña

    public Boolean matriculacontrasena(String matricula, String contrasena) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLA_ALUMNO + " WHERE " + CAMPO_MATRICULA + " =? AND " + CAMPO_CONTRASENAALUMNO + " =? ", new String[]{matricula, contrasena});
        if (cursor.getCount() > 0) return true;
        else return false;
    }


    //verifica el Login de la empresa: email y contraseña
    public Boolean emailcontrasena(String email, String contrasena) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLA_EMPRESA + " WHERE " + CAMPO_EMAILEMPRESA + " =? AND " + CAMPO_CONTRAEMPRESA + " =? ", new String[]{email, contrasena});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

}

