package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.westcoast.entidades.oferta;
import com.example.westcoast.utilidades.utilidades;

import java.util.ArrayList;

public class detalles_oferta extends AppCompatActivity {

    ArrayList<oferta> listOferta;
    RecyclerView recyclerViewOferta12;

    ArrayList<String> ofertaslista;
    ArrayList<oferta> lista_oferta;

    //Instancia a la bd
    ConexionSQLiteHelper conn;

    EditText buscar;

    Button hola2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_oferta);

        buscar = (EditText) findViewById(R.id.buscar_todo2);
        hola2 = (Button) findViewById(R.id.find_2);


        //Metodo para mostrar las ofertas de trabajo

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_westcoast",null,1);



        recyclerViewOferta12 = (RecyclerView) findViewById(R.id.reciclador_oferta2);
        recyclerViewOferta12.setLayoutManager(new LinearLayoutManager(this));

        listOferta = new ArrayList<>();

        RecyclerViewAdaptador adapter = new RecyclerViewAdaptador(listOferta);
        recyclerViewOferta12.setAdapter(adapter);


    }

    public void onClick(View view){

        pruebas();


    }



    public void newcon(View view){

        overridePendingTransition(0, 0);
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }




    private void pruebas(){


        SQLiteDatabase db = conn.getReadableDatabase();

        oferta oferta1 = null;

        String[] parametros = {buscar.getText().toString()};

        Cursor cursor = db.rawQuery("SELECT * FROM " + utilidades.TABLA_OFERTA + " WHERE " + utilidades.CAMPO_AREAOFERTA + "=?", parametros);

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



        db.close();


    }



}