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

public class ratingbar_alumno extends AppCompatActivity {

    EditText nombre, email, celular;
    RatingBar rating_alumno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar_alumno);

        nombre = (EditText) findViewById(R.id.rating_nombre);
        email = (EditText) findViewById(R.id.rating_email);
        celular= (EditText) findViewById(R.id.rating_celular);


        rating_alumno = (RatingBar) findViewById(R.id.ratingBar_alumno);

        rating_alumno.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Toast.makeText(ratingbar_alumno.this, "Ha calificado al alumno con: "+rating,Toast.LENGTH_LONG).show();

                ///Toast.makeText(getApplicationContext(),"Ha calificaco al alumno",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void OnClick (View view){

        rating();

    }

    private void rating() {

        //Conexion a la base de datos
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        ////Abrimos la base de Datos
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] parametros = {nombre.getText().toString()};


        try{


            Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_ALUMNO+" WHERE "+utilidades.CAMPO_NOMBREALUMNO+"=?",parametros);

            cursor.moveToFirst();

            email.setText(cursor.getString(5));
            celular.setText(cursor.getString(4));

            cursor.close();


        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"El alumno no existe",Toast.LENGTH_SHORT).show();

        }

    }


}

