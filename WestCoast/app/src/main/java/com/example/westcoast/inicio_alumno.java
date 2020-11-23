package com.example.westcoast;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.westcoast.entidades.oferta;

import java.util.ArrayList;

import static com.example.westcoast.utilidades.utilidades.TABLA_OFERTA;

public class inicio_alumno extends AppCompatActivity {

    ArrayList<oferta> listOferta;
    RecyclerView recyclerViewOferta1;

    //Instancia a la bd
    ConexionSQLiteHelper conn;

    Button salir1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_alumno);

        //Metodo para mostrar las ofertas de trabajo

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_westcoast",null,1);

        listOferta = new ArrayList<>();

        recyclerViewOferta1 = (RecyclerView) findViewById(R.id.recicleyViewOferta);
        recyclerViewOferta1.setLayoutManager(new LinearLayoutManager(this));

        consultarListaOfertas();

        RecyclerViewAdaptador adapter = new RecyclerViewAdaptador(listOferta);
        recyclerViewOferta1.setAdapter(adapter);


        salir1 = (Button) findViewById(R.id.salir_alumno);

        salir1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alert_dialog();
            }
        });


    }


    //metodo para mostrar lista de ofertas

    private void consultarListaOfertas() {

        SQLiteDatabase db = conn.getReadableDatabase();
        oferta oferta1 = null;
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLA_OFERTA, null);

        //llenado y recorrido de la Lista

        while(cursor.moveToNext()) {

            oferta1 = new oferta();

            oferta1.setNombreOferta(cursor.getString(0));
            oferta1.setNombreempresa(cursor.getString(1));
            oferta1.setUbicacionEmpresa(cursor.getString(2));
            oferta1.setDescripcionoerta(cursor.getString(3));
            oferta1.setAreaOferta(cursor.getString(4));
            oferta1.setContacto(cursor.getString(5));

            listOferta.add(oferta1);

        }

    }

    //metodo del perfil alumno
    public void perfilalumno2(View view){
        Intent alumnoperfil2 = new Intent (this, config_alumno.class);
        startActivity(alumnoperfil2);
    }

    //metodo del perfil alumno
    public void bar(View view){
        Intent bar_job = new Intent (this, raitingbar_empresa.class);
        startActivity(bar_job);
    }

    //metodo del perfil alumno
    public void find(View view){
        Intent i = new Intent (this, menu_2.class);
        startActivity(i);
    }

    public void alert_dialog(){
        new AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("¿Deseas salir de la aplicación?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                          Intent i = new Intent(Intent.ACTION_MAIN);
                          i.addCategory(Intent.CATEGORY_HOME);
                          i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                          startActivity(i);

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