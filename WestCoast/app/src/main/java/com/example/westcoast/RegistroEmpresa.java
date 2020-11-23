package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.westcoast.utilidades.utilidades;


public class RegistroEmpresa extends AppCompatActivity {

    public EditText rfc, nombre_emp, direccion_emp, cp_emp, telefono_emp, email_emp, contra_emp, desc_emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empresa);

        //validacion de los datos en cada uno de los campos

        rfc = (EditText) findViewById(R.id.rfc_empresa);
        nombre_emp = (EditText) findViewById(R.id.nombre_empresa);
        direccion_emp = (EditText) findViewById(R.id.direccion_empresa);
        cp_emp = (EditText) findViewById(R.id.cp_empresa);
        telefono_emp = (EditText) findViewById(R.id.telefono_empresa);
        email_emp = (EditText) findViewById(R.id.email_empresa);
        contra_emp = (EditText) findViewById(R.id.contrasena_empresa);
        desc_emp = (EditText) findViewById(R.id.descripcion_empresa);


    }


   /* //Metodo para mostrar los datos de la empresa en su perfil

    public void MostrarEmp(View v){

        Intent o = new Intent(this, perfil_empresa.class);

        o.putExtra("nombre1", nombre_emp.getText().toString());
        o.putExtra("direccion1", direccion_emp.getText().toString());
        o.putExtra("cp1", cp_emp.getText().toString());
        o.putExtra("telefono1", telefono_emp.getText().toString());
        o.putExtra("email1", email_emp.getText().toString());
        o.putExtra("descripcion1", desc_emp.getText().toString());

        startActivity(o);

    }*/

    public void inicio(View view) {
        Intent iniciar = new Intent(this, inicio_empresa.class);
        startActivity(iniciar);
    }


    //metodo de registro de la empresa

    public void onClick(View view) {

        registroEmpresa();

    }


    //Se insertan las empresas con el método content values

    private void registroEmpresa() {

        //Se inserta la conexion
        ConexionSQLiteHelper conexion2 = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //abrimos la base de datos para poder editarla
        SQLiteDatabase db = conexion2.getWritableDatabase();


        ContentValues values1 = new ContentValues();

        values1.put(utilidades.CAMPO_RFC, rfc.getText().toString());
        values1.put(utilidades.CAMPO_NOMBREEMPRESA, nombre_emp.getText().toString());
        values1.put(utilidades.CAMPO_DIRECCIONEMPRESA, direccion_emp.getText().toString());
        values1.put(utilidades.CAMPO_CPEMPRESA, cp_emp.getText().toString());
        values1.put(utilidades.CAMPO_TELEFONOEMPRESA, telefono_emp.getText().toString());
        values1.put(utilidades.CAMPO_EMAILEMPRESA, email_emp.getText().toString());
        values1.put(utilidades.CAMPO_CONTRAEMPRESA, contra_emp.getText().toString());
        values1.put(utilidades.CAMPO_DESCRIPCIONEMPRESA, desc_emp.getText().toString());


        //Se hace la validacion de todos los campos

        if (rfc.getText().toString().isEmpty() || nombre_emp.getText().toString().isEmpty() || direccion_emp.getText().toString().isEmpty() || cp_emp.getText().toString().isEmpty() ||
             telefono_emp.getText().toString().isEmpty() || email_emp.getText().toString().isEmpty() || contra_emp.getText().toString().isEmpty() ||
                desc_emp.getText().toString().isEmpty() ) {

            Toast.makeText(getApplicationContext(), "No se han llenado todos los campos", Toast.LENGTH_SHORT).show();

        } else {

            //inserción de datos de la empresa

            Long nombreempresa = db.insert(utilidades.TABLA_EMPRESA, utilidades.CAMPO_NOMBREEMPRESA, values1); //El dato que queremos que nos devuelva, en este caso sera el nombre de la empresa
            Toast.makeText(getApplicationContext(), "Empresa Registrada: " + nombreempresa, Toast.LENGTH_SHORT).show();
            db.close();


            //Pasar a la otra activity

            Intent iniciar = new Intent(this, inicio_empresa.class);
            startActivity(iniciar);
            Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

        }

    }


}