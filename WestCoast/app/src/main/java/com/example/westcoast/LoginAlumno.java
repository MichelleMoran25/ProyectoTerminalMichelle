package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.westcoast.utilidades.utilidades;

public class LoginAlumno extends AppCompatActivity {

    EditText matricula1, contrasena1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_alumno);


        //Se validan cada uno de los campos ingresados por el usuario
        matricula1 = (EditText) findViewById(R.id.matriculalog);
        contrasena1 = (EditText) findViewById(R.id.contrasenalog);


    }

    public void onClick(View view){
        loginAlumnos();

    }

    private void loginAlumnos() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //abrimos la base de datos para poder leerla
        SQLiteDatabase db = conexion.getReadableDatabase();

        String matricula = matricula1.getText().toString();
        String contrasena = contrasena1.getText().toString();

        Boolean matriculacontrasena1 = conexion.matriculacontrasena(matricula,contrasena);

        if(matriculacontrasena1 == true) {

            Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            Intent iniciar = new Intent(this, inicio_alumno.class);
            startActivity(iniciar);
        }

        else
            Toast.makeText(getApplicationContext(), "Verificar matricula o contraseña", Toast.LENGTH_SHORT).show();

            }


    //metodo del registro alumno
    public void btnregistroalu(View view){
        Intent registroalu = new Intent (this, RegistroAlumno.class);
        startActivity(registroalu);
    }

}