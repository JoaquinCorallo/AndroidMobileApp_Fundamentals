package com.uyu.fundamentosandroid2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    public Button btnMove;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase mydb;
        BaseDatos db = new BaseDatos(getApplicationContext());


        androidx.appcompat.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvmascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        btnMove = findViewById(R.id.BtnActivityOne);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToActivityTwo();
            }
        });
    }

    private void MoveToActivityTwo(){
        Intent intent = new Intent(MainActivity.this, confirmacion.class);
        startActivity(intent);
    }

    public void inicializarAdaptador(){
        mascotasadaptador adaptador = new mascotasadaptador(mascotas);
        adaptador = new mascotasadaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.mono, "Mono"));
        mascotas.add(new Mascota(R.drawable.pez, "pez"));
        mascotas.add(new Mascota(R.drawable.gato, "gato"));
        mascotas.add(new Mascota(R.drawable.vibora, "vibora"));
        mascotas.add(new Mascota(R.drawable.perro, "perro"));
        mascotas.add(new Mascota(R.drawable.huron, "huron"));
        //mascotas.add(new Mascota(R.drawable.conejo, "conejo"));
        //mascotas.add(new Mascota(R.drawable.hamster, "hamster"));
        mascotas.add(new Mascota(R.drawable.camaleon, "camaleon"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this, ActivityContacto.class);
                startActivity(intent);
                break;
            case R.id.mAcercade:
                Intent i = new Intent(this, ActivityAcercade.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createbd(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.DATABASE_NAME + " (" +
                "id" + " INTEGER primary key autoincrement NOT NULL, " +
                "nombre" + " TEXT, " +
                "likes" + " INTEGER" + " ) ";


        db.execSQL(queryCrearTablaMascotas);

    }

}


