package com.example.dm2.recu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad1 extends AppCompatActivity {

    private EditText txt1;
    private Spinner spinner1;
    private String cita="";
    private String dia="";
    private RadioButton radio1,radio2;
    private int medicos=0;
    private int enfermeras=0;
    private TextView lblmedicos,lblenfermeras;
    private Button btnsolicitar,btnexit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        lblmedicos = (TextView) findViewById(R.id.lblmedicos);
        lblmedicos.setText(lblmedicos.getText().toString()+" "+medicos);
        lblenfermeras = (TextView) findViewById(R.id.lblenfermeras);
        lblenfermeras.setText(lblenfermeras.getText().toString()+" "+enfermeras);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        txt1 = (EditText) findViewById(R.id.txt1);
        spinner1 = (Spinner) findViewById(R.id.spiner1);
        String [] datos = new String[] {"Lunes","Martes","Miercoles","Jueves","Viernes"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,datos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);
        btnsolicitar = (Button) findViewById(R.id.btnsolicitar);
        btnexit = (Button) findViewById(R.id.btnexit);
    }
    public void evaluar (View v)
    {
        if (spinner1.getSelectedItem().equals("Lunes"))
        {
            dia="Lunes";
        }
        if (spinner1.getSelectedItem().equals("Martes"))
        {
            dia="Martes";
        }
        if (spinner1.getSelectedItem().equals("Miercoles"))
        {
            dia="Miercoles";
        }
        if (spinner1.getSelectedItem().equals("Jueves"))
        {
            dia="Jueves";
        }
        if (spinner1.getSelectedItem().equals("Viernes"))
        {
            dia="Viernes";
        }
        if (radio1.isChecked())
        {
            cita="Medico";
        }
        else
        {
            if (radio2.isChecked())
            {
                cita="Enfermera";
            }
            else
            {
                Toast toast = Toast.makeText(getApplicationContext(), "Elige medico o enfermero", Toast.LENGTH_LONG);
                toast.show();
            }
        }
        if (txt1.getText().toString().isEmpty())
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Nombre necesario", Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Intent intent = new Intent(Actividad1.this, Actividad1b.class);
            intent.putExtra("dia",dia);
            intent.putExtra("cita",cita);
            intent.putExtra("nombre",txt1.getText().toString());
            startActivityForResult(intent, 1234);
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234&&resultCode==RESULT_OK)
        {
            if (cita.equals("Medico"))
            {
                medicos++;
                lblmedicos.setText("Medico:"+medicos);
                cita="";
                dia="";
                radio1.setSelected(false);
                radio2.setSelected(false);
                txt1.setText("");
                spinner1.setSelection(0);
                if (medicos==3)
                {
                    btnsolicitar.setEnabled(false);
                    btnexit.setEnabled(true);
                }
            }
            else
            {
                enfermeras++;
                lblenfermeras.setText("Enfermera:"+enfermeras);
                cita="";
                dia="";
                radio1.setSelected(false);
                radio2.setSelected(false);
                txt1.setText("");
                spinner1.setSelection(0);
                if (enfermeras==3)
                {
                    btnsolicitar.setEnabled(false);
                    btnexit.setEnabled(true);
                }
            }

        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Consulta cancelada por el cliente", Toast.LENGTH_LONG);
            toast.show();
            cita="";
            dia="";
            radio1.setSelected(false);
            radio2.setSelected(false);
            txt1.setText("");
            spinner1.setSelection(0);
        }
    }
    public void salir (View v)
    {
        finish();
    }
}
