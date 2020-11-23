package com.example.westcoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.westcoast.entidades.oferta;
import com.example.westcoast.utilidades.utilidades;

import java.util.ArrayList;

import static com.example.westcoast.utilidades.utilidades.TABLA_OFERTA;

public class detalles_empresa extends AppCompatActivity {

    ArrayList<oferta> listOferta;
    RecyclerView recyclerViewOferta12;

    ArrayList<String> ofertaslista;
    ArrayList<oferta> lista_oferta;

    //Instancia a la bd
    ConexionSQLiteHelper conn;

    EditText buscar;

    Button hola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_empresa);


        buscar = (EditText) findViewById(R.id.buscar_todo);
        hola = (Button) findViewById(R.id.find);


       //Metodo para mostrar las ofertas de trabajo

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_westcoast",null,1);



        recyclerViewOferta12 = (RecyclerView) findViewById(R.id.reciclador_oferta);
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

        Cursor cursor = db.rawQuery("SELECT * FROM " + utilidades.TABLA_OFERTA + " WHERE " + utilidades.CAMPO_NAMEMPRESA + "=?", parametros);

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




