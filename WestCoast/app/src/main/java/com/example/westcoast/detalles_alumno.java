package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.westcoast.entidades.alumno;
import com.example.westcoast.entidades.oferta;
import com.example.westcoast.utilidades.utilidades;

import java.util.ArrayList;

public class detalles_alumno extends AppCompatActivity {

    ArrayList<alumno> listAlumno;
    RecyclerView recyclerView_alumno;

    ArrayList<String> alumnoslista;
    ArrayList<alumno> lista_alumno;

    //Instancia a la bd
    ConexionSQLiteHelper conn;

    EditText buscar;

    Button find;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_alumno);


        buscar = (EditText) findViewById(R.id.buscar_todo3);
        find = (Button) findViewById(R.id.find_3);


        //Metodo para mostrar a los alumnos

        //conexion a la base de datos
        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_westcoast",null,1);


        recyclerView_alumno= (RecyclerView) findViewById(R.id.recilador_alumno);
        recyclerView_alumno.setLayoutManager(new LinearLayoutManager(this));

        listAlumno = new ArrayList<>();


        RecyclerViewAlumno adapter = new RecyclerViewAlumno(listAlumno);
        recyclerView_alumno.setAdapter(adapter);

        consultarListaAlumnos();



    }



    //metodo para consultar los datos
    public void OnClick(View view) {

        //pruebas();
        consultarListaAlumnos();

    }


    public void newcon(View view){

        overridePendingTransition(0, 0);
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }


    private void consultarListaAlumnos() {

        SQLiteDatabase db = conn.getReadableDatabase();
        alumno alumno1 = null;

        String[] parametros = {buscar.getText().toString()};

        Cursor cursor = db.rawQuery("SELECT * FROM " + utilidades.TABLA_ALUMNO + " WHERE " + utilidades.CAMPO_INTERESESALUMNO + "=?", parametros);

        //Cursor cursor = db.rawQuery("SELECT * FROM " + utilidades.TABLA_ALUMNO, null);

        //Llenado y recorrido de la lista

        while(cursor.moveToNext()){

            alumno1 = new alumno();
            alumno1.setNombreAlumno(cursor.getString(0));
            alumno1.setCarrera(cursor.getString(3));
            alumno1.setEmailAlumno(cursor.getString(5));
            alumno1.setHabilidadesAlumno(cursor.getString(7));
            alumno1.setInteresesAlumno(cursor.getString(8));

            listAlumno.add(alumno1);

        }

        db.close();
    }

}

