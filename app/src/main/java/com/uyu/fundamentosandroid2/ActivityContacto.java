package com.uyu.fundamentosandroid2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityContacto extends AppCompatActivity {

    public Button btnSend;
    public EditText tvemail;
    public String semail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button item = findViewById(R.id.BtnActivityOne);
        item.setAlpha(0);

        btnSend = findViewById(R.id.btnSend);
        tvemail = findViewById(R.id.email);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                semail = tvemail.getText().toString();
                Toast.makeText(getApplicationContext(), "Message Sent To:" + semail, Toast.LENGTH_LONG).show();

            }
        });
    }
}