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

public class config_oferta extends AppCompatActivity {

    EditText nombre_oferta, codi, ubicacion, descripcion, contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_oferta);



        codi = (EditText) findViewById(R.id.codi_oferta);
        nombre_oferta = (EditText) findViewById(R.id.ofer_name);
        ubicacion = (EditText) findViewById(R.id.ofer_ub);
        descripcion = (EditText) findViewById(R.id.ofer_tarea);
        contacto = (EditText) findViewById(R.id.ofer_contacto);

    }

    //metodo para consultar los datos
    public void OnClick(View view){

        switch (view.getId()){

            case R.id.buscar_oferta:
                consultar();
                break;
            case R.id.act_oferta:
                alert_dialog1();
                break;
            case R.id.elim_oferta:
                alert_dialog();
                break;
        }


    }

    //Con el método SQL se realiza la consulta

    private void consultar() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //Abrimos la base de Datos
        SQLiteDatabase db = conexion.getReadableDatabase();

        String[] parametros = {codi.getText().toString()};

        try {

            Cursor cursor = db.rawQuery("SELECT * FROM " + utilidades.TABLA_OFERTA + " WHERE " + utilidades.CAMPO_CODIEMPRESA + "=?", parametros);

            cursor.moveToFirst();

            nombre_oferta.setText(cursor.getString(0));
            ubicacion.setText(cursor.getString(2));
            descripcion.setText(cursor.getString(3));
            contacto.setText(cursor.getString(4));

            cursor.close();

        }catch (Exception e){

            Toast.makeText(getApplicationContext(), "La oferta de trabajo no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }

    }


    //Se realiza la actualizacion con el metodo content Values

    private void actualizar() {

            //se inserta la conexion
            ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

            //Abrimos la base de Datos
            SQLiteDatabase db = conexion.getWritableDatabase();

            String[] parametros = {codi.getText().toString()};

            ContentValues values=new ContentValues();

            values.put(utilidades.CAMPO_NAMEOFERTA, nombre_oferta.getText().toString());
            values.put(utilidades.CAMPO_UBICACIONEMPRESA, ubicacion.getText().toString());
            values.put(utilidades.CAMPO_DESCRIPCIONOFERTA, descripcion.getText().toString());
            values.put(utilidades.CAMPO_CONTACTO, contacto.getText().toString());

            db.update(utilidades.TABLA_OFERTA,values,utilidades.CAMPO_CODIEMPRESA+"=?", parametros);

            Toast.makeText(getApplicationContext(),"La oferta fue actualizada",Toast.LENGTH_LONG).show();

            db.close();



    }

    private void eliminar() {

        //se inserta la conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bd_westcoast", null, 1);

        //Abrimos la base de Datos
        SQLiteDatabase db = conexion.getWritableDatabase();

        String[] parametros = {codi.getText().toString()};

        db.delete(utilidades.TABLA_OFERTA,utilidades.CAMPO_CODIEMPRESA+"=?", parametros);

        Toast.makeText(getApplicationContext(),"La oferta fue eliminada",Toast.LENGTH_LONG).show();

        codi.setText("");

        limpiar();
        db.close();

    }



    private void limpiar() {

        codi.setText("");
        nombre_oferta.setText("");
        ubicacion.setText("");
        descripcion.setText("");
        contacto.setText("");
    }


    public void home(View view){
        Intent i = new Intent(this, inicio_empresa.class);
        startActivity(i);
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