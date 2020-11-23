package com.example.westcoast;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.westcoast.entidades.alumno;

import java.util.ArrayList;

public class RecyclerViewAlumno extends RecyclerView.Adapter<RecyclerViewAlumno.ViewHolder> {


    ArrayList<alumno> listAlumno;

    public RecyclerViewAlumno(ArrayList<alumno> listAlumno){
        this.listAlumno = listAlumno;

    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        //Se crea el atributo context para pasar datos
        Context context;

        private TextView nombre, carrera, email, habilidades, intereses;

        private Button ver_detalles;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            nombre = (TextView) itemView.findViewById(R.id.NombreAlu);
            carrera = (TextView) itemView.findViewById(R.id.CarreraAlu);
            email = (TextView) itemView.findViewById(R.id.EmailAlu);
            habilidades = (TextView) itemView.findViewById(R.id.HabilidadesAlu);
            intereses = (TextView) itemView.findViewById(R.id.InteresesAlu);

            ver_detalles = (Button) itemView.findViewById(R.id.ver);
        }


        //Se crea el métododo setOnClickListeners() para acceder a los datos desde el boton a la nueva activity

        public void setOnClickListeners() {

            ver_detalles.setOnClickListener(this);
        }



        //El método Onclick esta dentro de la clase  ViewHolder aqui pasamo a las actividad VER DETALLES
        @Override
        public void onClick(View v) {

            Toast.makeText(context.getApplicationContext(),"Se ha contactado al alumno",Toast.LENGTH_SHORT).show();

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alumno,null,false);
        return new RecyclerViewAlumno.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nombre.setText(listAlumno.get(position).getNombreAlumno());
        holder.carrera.setText(listAlumno.get(position).getCarrera());
        holder.email.setText(listAlumno.get(position).getEmailAlumno());
        holder.habilidades.setText(listAlumno.get(position).getHabilidadesAlumno());
        holder.intereses.setText(listAlumno.get(position).getInteresesAlumno());

        //Metodo que se implementa para ver los detalles del alumno
        holder.setOnClickListeners();

    }


    @Override
    public int getItemCount() {
        return listAlumno.size();
    }


}