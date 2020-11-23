package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_2);
    }

    public void onClick(View view){
        Intent i = new Intent(this, detalles_empresa.class);
        startActivity(i);
    }

    public void oferta(View view){

        Intent i = new Intent(this, detalles_oferta.class);
        startActivity(i);
    }
}