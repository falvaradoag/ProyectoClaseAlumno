package com.hame.implementacionparcelablo_fausto.Vistas;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.hame.implementacionparcelablo_fausto.Clases.Alumno;
import com.hame.implementacionparcelablo_fausto.Clases.Clase_salon_materia;
import com.hame.implementacionparcelablo_fausto.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Handler mHandler;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        mHandler=new Handler();
        mHandler.postDelayed(receiveRunnable,5_000);
    }

    private Runnable receiveRunnable = new Runnable() {
        @Override
        public void run() {
            startReceveInfo();
        }
    };

    private void startReceveInfo() {
        Intent intent = new Intent(this, RecibeInformacion.class);

        Clase_salon_materia cs = new Clase_salon_materia();
        ArrayList<Alumno> listAlumn = new ArrayList<>();
        Alumno almn = new Alumno();

        almn.setNombre("Fausto");
        almn.setApellido("Alvarado");

        listAlumn.add(almn);
        almn = new Alumno();
        almn.setNombre("Mario");
        almn.setApellido("Godoy");
        listAlumn.add(almn);

        cs.setNombre("Sociales");
        cs.setDescripcion("Liceo Mont");
        cs.setAlumnos(listAlumn);

        intent.putExtra("DatosEnviados",cs);
        Log.i("MainActivity","Inicio");
        startActivity(intent);
        finish();
    }



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }



}
