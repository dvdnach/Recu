package com.example.dm2.recu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Actividad3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);
    }
    public class Instituto {
        private String nombre;
        private String direccion;
        private String web;

        public Instituto(String nombre) {
            this.nombre = nombre;
        }
    }
}

