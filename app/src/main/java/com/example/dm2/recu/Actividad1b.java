package com.example.dm2.recu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad1b extends AppCompatActivity {

    TextView lblnombre2,lblcita2,lbldia2;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1b);
        extras = getIntent().getExtras();
        lblnombre2 = (TextView) findViewById(R.id.lblnombre2);
        lblnombre2.setText(extras.getString("nombre"));
        lblcita2 = (TextView) findViewById(R.id.lblcita2);
        lblcita2.setText(lblcita2.getText().toString()+" "+extras.getString("cita")+"\n");
        lbldia2 = (TextView) findViewById(R.id.lbldia2);
        lbldia2.setText(lbldia2.getText().toString()+" "+extras.getString("dia"));
    }

    public void aceptar (View v)
    {
        Intent intent = new Intent();
        intent.putExtra("resultado","aceptar");
        setResult(RESULT_OK,intent);
        finish();
    }

    public void rechazar (View v)
    {
        Intent intent = new Intent();
        intent.putExtra("resultado","rechazar");
        setResult(RESULT_CANCELED,intent);
        finish();
    }
}
