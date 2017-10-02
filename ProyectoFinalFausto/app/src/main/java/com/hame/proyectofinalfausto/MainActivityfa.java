package com.hame.proyectofinalfausto;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivityfa extends AppCompatActivity {

    private Handler myHandler;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityfa);

        //Modificar título principal
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Sistema de Datos");
        //setSupportActionBar(toolbar);

        //Retardo de Imagen
        //myHandler = new Handler();
        //myHandler.postDelayed(rRunnable, 5_000);
        PantallaInicial();
    }
    public Runnable rRunnable = new Runnable(){

        @Override
        public void run() {
            PantallaInicial();
        }
    };

    public void PantallaInicial(){
        //Intent intent = new Intent(this, LoginActivity.class);
        Intent intent = new Intent(this, ImagesRecyclerActivity.class);
        startActivity(intent);
        finish();
    }


}
