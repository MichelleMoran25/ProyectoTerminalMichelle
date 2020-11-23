package com.example.westcoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.westcoast.entidades.alumno;
import com.example.westcoast.utilidades.utilidades;
import com.google.android.gms.common.internal.Constants;

import java.util.ArrayList;

import static com.example.westcoast.utilidades.utilidades.CAMPO_NOMBREALUMNO;


public class inicio_empresa extends AppCompatActivity {


    ArrayList<alumno> listAlumno;
    RecyclerView recyclerViewAlu;

    //Instancia a la bd
    ConexionSQLiteHelper conn;

    //boton salir
    Button exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_empresa);

        //Metodo para mostrar a los alumnos

        //conexion a la base de datos
        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_westcoast",null,1);
        listAlumno = new ArrayList<>();

        recyclerViewAlu = (RecyclerView) findViewById(R.id.recyclerViewalu);
        recyclerViewAlu.setLayoutManager(new LinearLayoutManager(this));

        consultarListaAlumnos();



        RecyclerViewAlumno adapter = new RecyclerViewAlumno(listAlumno);
        recyclerViewAlu.setAdapter(adapter);


        exit = (Button) findViewById(R.id.salir_app);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_dialog();
            }
        });



    }



    //metodo para mostrar lista alumnos

    private void consultarListaAlumnos() {

        SQLiteDatabase db = conn.getReadableDatabase();
        alumno alumno1 = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + utilidades.TABLA_ALUMNO, null);

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

    }



    //metodo de configuracion de la empresa
    public void update(View view){
        Intent config = new Intent (this, config_empressa.class);
        startActivity(config);
    }

    //Agregar una nueva oferta de trabajo

    public void oferta(View view){
        Intent nuevaoferta = new Intent(this, OfertaTrabajo.class);
        startActivity(nuevaoferta);
    }

    //metodo del perfil alumno
    public void ratingAlumno(View view){
        Intent ra_alumno = new Intent (this, ratingbar_alumno.class);
        startActivity(ra_alumno);
    }


    public void config_oferta(View view){
        Intent i = new Intent(this,config_oferta.class);
        startActivity(i);
    }

    public void find(View view){
        Intent i = new Intent(this,detalles_alumno.class);
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
