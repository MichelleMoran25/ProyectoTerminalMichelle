package com.example.westcoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.westcoast.utilidades.utilidades;


public class config_alumno extends AppCompatActivity {

    EditText matricula, nombre, carrera, edad, telefono, email, contrasena, habilidades, intereses;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_alumno);


        //matricula = (EditText) findViewById(R.id.uam_matricula);

        nombre = (EditText) findViewById(R.id.uam_nombre);
        carrera = (EditText) findViewById(R.id.uam_carrera);
        edad = (EditText) findViewById(R.id.uam_edad);
        telefono = (EditText) findViewById(R.id.uam_telefono);
        email = (EditText) findViewById(R.id.uam_email);
        contrasena = (EditText) findViewById(R.id.uam_contrasena);
        habilidades = (EditText) findViewById(R.id.uam_habilidades);
        intereses = (EditText) findViewById(R.id.uam_intereses);


    }


    //metodo para consultar los datos
    public void OnClick(View view){

        switch (view.getId()){

            case R.id.buscar_matricula:
                consultar();
                break;

            case R.id.act_alumno:
                alert_dialog1();
                break;

            case R.id.elim_alumno:
                alert_dialog();
                break;
        }

    }



    //Consulta con metodo SQL

     private void consultar() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

       //Abrimos la base de Datos
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] parametros = {contrasena.getText().toString()};

        //String[] campos = {utilidades.CAMPO_NOMBREALUMNO, utilidades.CAMPO_CARRERA, utilidades.CAMPO_EDAD, utilidades.CAMPO_TELEFONOALUMNO, utilidades.CAMPO_EMAILALUMNO, utilidades.CAMPO_HABILIADESALUMNO, utilidades.CAMPO_INTERESESALUMNO};

        try {

            Cursor cursor = db.rawQuery("SELECT * FROM "+utilidades.TABLA_ALUMNO+" WHERE "+utilidades.CAMPO_CONTRASENAALUMNO+"=?",parametros);

            cursor.moveToFirst();

            nombre.setText(cursor.getString(0));
            carrera.setText(cursor.getString(3));
            edad.setText(cursor.getString(2));
            telefono.setText(cursor.getString(4));
            email.setText(cursor.getString(5));
            habilidades.setText(cursor.getString(7));
            intereses.setText(cursor.getString(8));

            cursor.close();

        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "La contraseña no existe", Toast.LENGTH_SHORT).show();

            limpiar();
        }
    }

    //actualizar datos del alumno con método content values

    private void actualizar() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //Abrimos la base de Datos
        SQLiteDatabase db = conexion.getWritableDatabase();

        String[] parametros = {contrasena.getText().toString()};

        ContentValues values=new ContentValues();

        values.put(utilidades.CAMPO_NOMBREALUMNO, nombre.getText().toString());
        values.put(utilidades.CAMPO_CARRERA, carrera.getText().toString());
        values.put(utilidades.CAMPO_EDAD, edad.getText().toString());
        values.put(utilidades.CAMPO_TELEFONOALUMNO, telefono.getText().toString());
        values.put(utilidades.CAMPO_EMAILALUMNO, email.getText().toString());
        values.put(utilidades.CAMPO_HABILIADESALUMNO, habilidades.getText().toString());
        values.put(utilidades.CAMPO_INTERESESALUMNO, intereses.getText().toString());

        db.update(utilidades.TABLA_ALUMNO,values,utilidades.CAMPO_CONTRASENAALUMNO+"=?", parametros);

        Toast.makeText(getApplicationContext(),"El usuario fue actualizado",Toast.LENGTH_LONG).show();

        db.close();

        limpiar();

    }

    //Elminar alumno

    private void eliminar() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //Abrimos la base de Datos
        SQLiteDatabase db = conexion.getWritableDatabase();

        String[] parametros = {contrasena.getText().toString()};

        db.delete(utilidades.TABLA_ALUMNO,utilidades.CAMPO_CONTRASENAALUMNO+"=?", parametros);

        Toast.makeText(getApplicationContext(),"El alumno fue eliminado",Toast.LENGTH_LONG).show();

        contrasena.setText("");

        limpiar();
        db.close();
    }


    private void limpiar() {

        contrasena.setText("");
        nombre.setText("");
        carrera.setText("");
        edad.setText("");
        telefono.setText("");
        email.setText("");
        habilidades.setText("");
        intereses.setText("");
    }



    public void alert_dialog(){
        new AlertDialog.Builder(this)
                .setTitle("Eliminar")
                .setMessage("¿Estás seguro de eliminar los datos?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        eliminar();

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Mensaje", "Se cancelo la acción");
                    }
                })
                .show();

    }


    public void alert_dialog1(){
        new AlertDialog.Builder(this)
                .setTitle("Actualizar")
                .setMessage("¿Estás seguro de actualizar los datos?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        actualizar();

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Mensaje", "Se cancelo la acción");
                    }
                })
                .show();

    }


}