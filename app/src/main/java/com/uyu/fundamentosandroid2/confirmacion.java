package com.uyu.fundamentosandroid2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;


import java.util.ArrayList;
import java.util.Objects;

public class confirmacion extends AppCompatActivity {
    public RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    public Button btnback;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button item = findViewById(R.id.BtnActivityOne);
        item.setAlpha(0);

        listaMascotas = (RecyclerView) findViewById(R.id.rvmascotasfavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

    }

    private void MoveToActivityOne(){
        Intent intent = new Intent(confirmacion.this, MainActivity.class);
        startActivity(intent);
    }

    public void inicializarAdaptador(){
        mascotasadaptador adaptador = new mascotasadaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.mono, "Mono"));
        mascotas.add(new Mascota(R.drawable.pez, "pez"));
        mascotas.add(new Mascota(R.drawable.perro, "perro"));
        mascotas.add(new Mascota(R.drawable.vibora, "vibora"));
        mascotas.add(new Mascota(R.drawable.huron, "huron"));
    }

}