package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.westcoast.utilidades.utilidades;

public class OfertaTrabajo extends AppCompatActivity {

    public EditText nameOferta, nameEmpresa, ubicacion, descripcionOferta, contacto, codi_ofer;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oferta_trabajo);

        //validacion de datos en cada uno de los campos
        nameOferta =(EditText) findViewById(R.id.nombreOferta);
        nameEmpresa = (EditText) findViewById(R.id.nombreEmpresaOfer);
        codi_ofer = (EditText) findViewById(R.id.codi);
        ubicacion = (EditText) findViewById(R.id.ubicacionEmpresa);
        descripcionOferta = (EditText) findViewById(R.id.descripcion_oferta);
        spinner = (Spinner) findViewById(R.id.spinner2);
        contacto = (EditText) findViewById(R.id.ContactoOferta);

        String [] opciones = {"Seleccionar", "Redes de computadoras", "Desarrollo de Software", "Inteligencia Artificial", "Machine Learning", "Big Data", "Sistemas de Información", "Seguridad Informática","Electronica", "Bases de datos", "TIC's"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

    }


    //Metodo para el registro de la oferta de trabajo
    public void onClick (View view){
        registroOferta();

    }


    private void registroOferta() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion3 = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //abrimos la base de datos para poder editarla
        SQLiteDatabase db = conexion3.getWritableDatabase();

        ContentValues ofertas = new ContentValues();

        ofertas.put(utilidades.CAMPO_NAMEOFERTA, nameOferta.getText().toString());
        ofertas.put(utilidades.CAMPO_NAMEMPRESA, nameEmpresa.getText().toString());
        ofertas.put(utilidades.CAMPO_UBICACIONEMPRESA, ubicacion.getText().toString());
        ofertas.put(utilidades.CAMPO_DESCRIPCIONOFERTA, descripcionOferta.getText().toString());
        ofertas.put(utilidades.CAMPO_CONTACTO, contacto.getText().toString());
        ofertas.put(utilidades.CAMPO_CODIEMPRESA, codi_ofer.getText().toString());
        ofertas.put(utilidades.CAMPO_AREAOFERTA, spinner.getSelectedItem().toString());


        //Se hace la validacion de todos los campos

        if(nameOferta.getText().toString().isEmpty() || nameEmpresa.getText().toString().isEmpty() || ubicacion.getText().toString().isEmpty() ||
                descripcionOferta.getText().toString().isEmpty() || contacto.getText().toString().isEmpty() || codi_ofer.getText().toString().isEmpty() || spinner.getSelectedItem().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "No se han llenado todos los campos", Toast.LENGTH_SHORT).show();

        }else {

            //inserción de datos

            Long local = db.insert(utilidades.TABLA_OFERTA, utilidades.CAMPO_NAMEOFERTA, ofertas); //El dato que queremos que nos devuelva, en este caso sera el nombre de la empresa
            Toast.makeText(getApplicationContext(), "Oferta registrada: " + local, Toast.LENGTH_SHORT).show();
            db.close();

        }


    }

    //Método para igresar a las ofertas de trabajo

    public void mostrarOfertas(View view){
        Intent mostrar = new Intent (this, config_oferta.class);
        startActivity(mostrar);
    }


}