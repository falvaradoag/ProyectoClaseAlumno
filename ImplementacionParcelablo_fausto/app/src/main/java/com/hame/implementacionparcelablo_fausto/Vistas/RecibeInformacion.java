package com.hame.implementacionparcelablo_fausto.Vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hame.implementacionparcelablo_fausto.Clases.Alumno;
import com.hame.implementacionparcelablo_fausto.Clases.Clase_salon_materia;
import com.hame.implementacionparcelablo_fausto.R;

import java.util.List;

public class RecibeInformacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibe_informacion);

        Clase_salon_materia cs = getIntent().getParcelableExtra("DatosEnviados");

        Log.i("Receive_Inf",cs.getNombre());
        Log.i("Receive_Inf",cs.getDescripcion());

        List<Alumno> listAlumnos = cs.getAlumnos();

        //Recorre los alumnos
        for(int i=0; i<listAlumnos.size();i++)
        {
            Log.i("Receive_Inf",listAlumnos.get(i).getNombre());
            Log.i("Receive_Inf",listAlumnos.get(i).getApellido());
        }
    }
}
