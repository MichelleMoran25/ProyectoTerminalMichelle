package com.example.westcoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.westcoast.utilidades.utilidades;

public class config_empressa extends AppCompatActivity {

    EditText nombre, direccion, cp, telefono, email, contrasena, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_empressa);

        //nombre = (EditText) findViewById(R.id.job_nombre);
        direccion = (EditText) findViewById(R.id.job_direccion);
        cp = (EditText) findViewById(R.id.job_cp);
        telefono = (EditText) findViewById(R.id.job_telefono);
        email = (EditText) findViewById(R.id.job_email);
        contrasena = (EditText) findViewById(R.id.job_contrasena);
        descripcion = (EditText) findViewById(R.id.job_descripcion);

    }


    //metodo para consultar los datos
    public void OnClick(View view){

        switch (view.getId()){

            case R.id.busc:
                consultar_empresa();
                break;

            case R.id.act_empresa:
                alert_dialog1();
                break;

            case R.id.elim_empresa:
                alert_dialog();
                break;
        }

    }



    //Consulta con método SQL

    private void consultar_empresa() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //Abrimos la base de Datos
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] parametros = {contrasena.getText().toString()};

        try {

            Cursor cursor = db.rawQuery("SELECT * FROM " + utilidades.TABLA_EMPRESA + " WHERE " + utilidades.CAMPO_CONTRAEMPRESA+"=?", parametros);

            cursor.moveToFirst();

            direccion.setText(cursor.getString(2));
            cp.setText(cursor.getString(3));
            telefono.setText(cursor.getString(4));
            email.setText(cursor.getString(5));
            descripcion.setText(cursor.getString(7));

            cursor.close();

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "La contraseña no existe", Toast.LENGTH_SHORT).show();

            limpiar();
        }

    }



    //Actualizar datos con el método Content Values

    private void actualizar() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //Abrimos la base de Datos
        SQLiteDatabase db = conexion.getWritableDatabase();

        String[] parametros = {contrasena.getText().toString()};

        ContentValues values=new ContentValues();

        values.put(utilidades.CAMPO_DIRECCIONEMPRESA, direccion.getText().toString());
        values.put(utilidades.CAMPO_CPEMPRESA, cp.getText().toString());
        values.put(utilidades.CAMPO_TELEFONOEMPRESA, telefono.getText().toString());
        values.put(utilidades.CAMPO_EMAILEMPRESA,email.getText().toString());
        values.put(utilidades.CAMPO_DESCRIPCIONEMPRESA, descripcion.getText().toString());

        db.update(utilidades.TABLA_EMPRESA,values,utilidades.CAMPO_CONTRAEMPRESA+"=?", parametros);

        Toast.makeText(getApplicationContext(),"Los datos fueron actualizados",Toast.LENGTH_LONG).show();

        db.close();

        limpiar();


    }


    //Metodo para elimnar los datos de la empresa
    private void eliminar() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //Abrimos la base de Datos
        SQLiteDatabase db = conexion.getWritableDatabase();

        String[] parametros = {contrasena.getText().toString()};

        db.delete(utilidades.TABLA_EMPRESA,utilidades.CAMPO_CONTRAEMPRESA+"=?", parametros);

        Toast.makeText(getApplicationContext(),"Los datos fueron eliminados",Toast.LENGTH_LONG).show();

        contrasena.setText("");
        limpiar();
        db.close();




    }


    private void limpiar() {

        contrasena.setText("");
        direccion.setText("");
        cp.setText("");
        telefono.setText("");
        email.setText("");
        descripcion.setText("");


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
                .setMessage("¿Estás seguro de actulizar los datos?")
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