package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    //metodo para el boton Alumno
    public void btnalumno(View view){
        Intent alumno = new Intent(this, LoginAlumno.class);
        startActivity(alumno);
    }

    //metodo para el boton Empresa
    public void btnempresa(View view){
        Intent empresa = new Intent(this, LoginEmpresa.class);
        startActivity(empresa);
    }
}