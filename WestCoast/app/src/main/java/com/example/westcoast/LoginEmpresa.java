package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginEmpresa extends AppCompatActivity {

    EditText  email, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_empresa);

        //Se validan cada uno de los campos ingresados por el usuario
        email = (EditText) findViewById(R.id.emailog);
        contrasena = (EditText) findViewById(R.id.contralog);

    }

    public void onClick(View view){

        loginEmpresa();

    }

    private void loginEmpresa() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //abrimos la base de datos para poder leerla
        SQLiteDatabase db = conexion.getReadableDatabase();

        String email1 = email.getText().toString();
        String contrasena1 = contrasena.getText().toString();

        Boolean emailcontrasena1 = conexion.emailcontrasena(email1,contrasena1);

        if(emailcontrasena1 == true) {

            Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            Intent iniciar = new Intent(this, inicio_empresa.class);
            startActivity(iniciar);
        }

        else
            Toast.makeText(getApplicationContext(), "Verificar email o contraseña", Toast.LENGTH_SHORT).show();

    }


    // boton registro empresa
    public void btnregistroempresa(View view){
        Intent registroempresa = new Intent(this, RegistroEmpresa.class);
        startActivity(registroempresa);
    }


}