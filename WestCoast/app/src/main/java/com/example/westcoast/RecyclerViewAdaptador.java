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
import com.example.westcoast.entidades.oferta;

import java.util.ArrayList;


public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>{

    ArrayList<oferta> listOferta;



    public RecyclerViewAdaptador(ArrayList<oferta> listOferta){
        this.listOferta = listOferta;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Se crea el atributo context para pasar datos
        Context context;

        private TextView nombreOferta, nombreEmpresa, ubicacion, actividades, areaoferta,  contacto;


        private Button consultar1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();


            nombreOferta = (TextView) itemView.findViewById(R.id.Ofertanombre);
            nombreEmpresa = (TextView) itemView.findViewById(R.id.OfertaEmpresa);
            ubicacion = (TextView) itemView.findViewById(R.id.OfertaUbicacion);
            actividades = (TextView) itemView.findViewById(R.id.ContactoOferta);
            areaoferta = (TextView) itemView.findViewById(R.id.OfertaArea);
            contacto = (TextView) itemView.findViewById(R.id.OfertaContacto);


            //Creacion del boton consultar
            consultar1 = (Button) itemView.findViewById(R.id.consultar);

        }


        public void setOnClickListeners() {
            consultar1.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Aqui va un intent en caso de abrir una nueva actividad
            Toast.makeText(context.getApplicationContext(),"Se ha contactado a la empresa",Toast.LENGTH_SHORT).show();
        }



    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_oferta,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nombreOferta.setText(listOferta.get(position).getNombreOferta());
        holder.nombreEmpresa.setText(listOferta.get(position).getNombreempresa());
        holder.ubicacion.setText(listOferta.get(position).getUbicacionEmpresa());
        holder.actividades.setText(listOferta.get(position).getDescripcionoerta());
        holder.areaoferta.setText(listOferta.get(position).getAreaOferta());
        holder.contacto.setText(listOferta.get(position).getContacto());

        //Metodo que se implementa para ver los detalles del alumno
        holder.setOnClickListeners();

    }

    @Override
    public int getItemCount() {
        return listOferta.size();
    }


}


