package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.westcoast.utilidades.utilidades;

public class raitingbar_empresa extends AppCompatActivity {

    EditText nombre, celular, email;

    RatingBar bar_alu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raitingbar_empresa);

        nombre = (EditText) findViewById(R.id.bar_nombre);
        email = (EditText) findViewById(R.id.bar_email);
        celular= (EditText) findViewById(R.id.bar_celular);

        bar_alu = (RatingBar) findViewById(R.id.ratingBar_empresa);

        bar_alu.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Toast.makeText(raitingbar_empresa.this, "Ha calificado a la empresa con: "+rating,Toast.LENGTH_LONG).show();
            }
        });

    }

    public void OnClick (View view){

        barempresa();

    }

    private void barempresa() {

        //Conexion a la base de datos
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        ////Abrimos la base de Datos
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] parametros = {nombre.getText().toString()};


        try{


            Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_EMPRESA+" WHERE "+utilidades.CAMPO_NOMBREEMPRESA+"=?",parametros);

            cursor.moveToFirst();

            email.setText(cursor.getString(5));
            celular.setText(cursor.getString(4));


            cursor.close();


        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"La empresa no existe",Toast.LENGTH_SHORT).show();

        }

    }



}


