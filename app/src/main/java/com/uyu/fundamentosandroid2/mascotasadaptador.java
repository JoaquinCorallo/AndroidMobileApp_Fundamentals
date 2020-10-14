package com.uyu.fundamentosandroid2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;


public class mascotasadaptador extends RecyclerView.Adapter<mascotasadaptador.MascotaViewHolder> {

    public mascotasadaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    ArrayList<Mascota> mascotas;

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgfoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());



        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int val = 0;
                try{

                    val = Integer.parseInt(mascotaViewHolder.number.getText().toString());
                }catch(Exception e) {
                    val = 0;
                }
                val = val + 1;
                mascotaViewHolder.number.setText (String.valueOf (val));
                Log.d("ADebugTag", "Value: " + Float.toString(val));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgfoto;
        public TextView tvNombreCV;
        public ImageButton btnLike;
        public TextView number;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgfoto = (ImageView) itemView.findViewById(R.id.imgfoto);
            tvNombreCV = (TextView) itemView.findViewById((R.id.tvNombreCV));
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            number = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
