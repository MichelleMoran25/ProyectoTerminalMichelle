package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.westcoast.utilidades.utilidades;

import java.util.ArrayList;

public  class RegistroAlumno extends AppCompatActivity {

    public EditText nombre_alu, matricula_alu, edad_alu, carrera_alu, tel_alu, email_alu, contra_alu, hab_alu;

    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumno);

        //validacion de datos en cada uno de los campos

        nombre_alu = (EditText) findViewById(R.id.nombre_alumno);
        matricula_alu = (EditText) findViewById(R.id.matricula_alumno);
        edad_alu = (EditText) findViewById(R.id.edad_alumno);
        carrera_alu = (EditText) findViewById(R.id.carrera_alumno);
        tel_alu = (EditText) findViewById(R.id.telefono_alumno);
        email_alu = (EditText) findViewById(R.id.email_alumno);
        contra_alu = (EditText) findViewById(R.id.contraseña_alumno);
        hab_alu = (EditText) findViewById(R.id.habilidades_alumno);
        sp = (Spinner) findViewById(R.id.spinner);

        String [] opciones = {"Seleccionar", "Redes de computadoras", "Desarrollo de Software", "Inteligencia Artificial", "Machine Learning", "Big Data", "Sistemas de Información", "Seguridad Informática", "Electronica", "Bases de datos", "TIC's"};

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        sp.setAdapter(adapter);
    }

/*    //Metodo para mostrar los datos del alumno en su perfil

    public void Mostrar(View v){

        Intent i = new Intent(this, perfil_alumno.class);

        i.putExtra("nombre", nombre_alu.getText().toString());//
        i.putExtra("matricula",matricula_alu.getText().toString());
        i.putExtra("edad", edad_alu.getText().toString());
        i.putExtra("carrera", carrera_alu.getText().toString());//
        i.putExtra("telefono", tel_alu.getText().toString());//
        i.putExtra("email", email_alu.getText().toString());//
        i.putExtra("contrasena", contra_alu.getText().toString());
        i.putExtra("habilidades", hab_alu.getText().toString());//
        i.putExtra("intereses", int_alu.getText().toString());//

        startActivity(i);

    }*/



    //metodo de registro del alumno

    public void onClick(View view) {

        registrarAlumnos();
        //registrarAlumnosSql();

    }

    //Se registran los alumnos con el método SQL
/*
    private void registrarAlumnosSql() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //abrimos la base de datos para poder editarla
        SQLiteDatabase db = conexion.getWritableDatabase();

        //insert into alumno (nombre, matricula, edad, carrera, direccion, cp, telefono, email, contraseña, habilidades, intereses)
        // Values('Alejandro Valencia', 2152001907, 20, 'Ingenieria en Computacion','Azcapotzalco, Mexico', 272300, 5512358960, 'ale.lm@gmail.com', 'perrito56',
        // 'Autodidacta', 'Desarrollo Web')

        String insert = "INSERT INTO "+utilidades.TABLA_ALUMNO+" ("+utilidades.CAMPO_NOMBREALUMNO+", "+utilidades.CAMPO_MATRICULA+", "+utilidades.CAMPO_EDAD+", "
                +utilidades.CAMPO_CARRERA+","+utilidades.CAMPO_DIRECCIONALUMNO+", "+utilidades.CAMPO_CPALUMNO+", "+utilidades.CAMPO_TELEFONOALUMNO+", "
                +utilidades.CAMPO_EMAILALUMNO+", "+utilidades.CAMPO_CONTRASENAALUMNO+", "+utilidades.CAMPO_HABILIADESALUMNO+", "
                +utilidades.CAMPO_INTERESESALUMNO+") " +
                "values ('"+nombre_alu.getText().toString()+"', "+matricula_alu.getText().toString()+", "+edad_alu.getText().toString()+", '"
                +carrera_alu.getText().toString()+"', '"+direccion_alu.getText().toString()+"',"+cp_alu.getText().toString()+", "+tel_alu.getText().toString()+", '"
                +email_alu.getText().toString()+"', '"+contra_alu.getText().toString()+"', '"+hab_alu.getText().toString()+"', '"+int_alu.getText().toString()+"')";

        db.execSQL(insert);
        db.close();

    }*/


    //Se insertan los alumnos con el método content values

    private void registrarAlumnos() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //abrimos la base de datos para poder editarla
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(utilidades.CAMPO_NOMBREALUMNO, nombre_alu.getText().toString());
        values.put(utilidades.CAMPO_MATRICULA, matricula_alu.getText().toString());
        values.put(utilidades.CAMPO_EDAD, edad_alu.getText().toString());
        values.put(utilidades.CAMPO_CARRERA, carrera_alu.getText().toString());
        values.put(utilidades.CAMPO_TELEFONOALUMNO, tel_alu.getText().toString());
        values.put(utilidades.CAMPO_EMAILALUMNO, email_alu.getText().toString());
        values.put(utilidades.CAMPO_CONTRASENAALUMNO, contra_alu.getText().toString());
        values.put(utilidades.CAMPO_HABILIADESALUMNO, hab_alu.getText().toString());
        values.put(utilidades.CAMPO_INTERESESALUMNO, sp.getSelectedItem().toString());

        //Se hace la validacion de todos los campos

        if(nombre_alu.getText().toString().isEmpty() || matricula_alu.getText().toString().isEmpty() || edad_alu.getText().toString().isEmpty() ||
                carrera_alu.getText().toString().isEmpty() || tel_alu.getText().toString().isEmpty() || email_alu.getText().toString().isEmpty() ||
                contra_alu.getText().toString().isEmpty() || hab_alu.getText().toString().isEmpty() || sp.getSelectedItem().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "No se han llenado todos los campos", Toast.LENGTH_SHORT).show();

        }else {

            //inserción de datos

            Long matriculaResultante = db.insert(utilidades.TABLA_ALUMNO, utilidades.CAMPO_MATRICULA, values); //El dato que queremos que nos devuelva, en este caso sera  la matricula del alumno
            Toast.makeText(getApplicationContext(), "Alumno Registrado: " + matriculaResultante, Toast.LENGTH_SHORT).show();
            db.close();


            //Pasar a la otra activity

            Intent iniciar = new Intent(this, inicio_alumno.class);
            startActivity(iniciar);
            Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

        }

    }
}