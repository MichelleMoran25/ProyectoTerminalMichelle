package com.example.westcoast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Se crea el metodo del boton iniciar

    public void inicio(View view){
        Intent iniciar = new Intent(this, Activity2.class);
        startActivity(iniciar);
    }
}