package com.hame.proyectofinalfausto;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.hame.proyectofinalfausto.R;
import android.content.Intent;
import android.os.Bundle;

public class ImagesActivity extends AppCompatActivity {

    private ImageView imageHolder;
    private final int requestCode = 20;
    private AlertDialog YesNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        imageHolder = (ImageView)findViewById(R.id.captured_photo);
        Button capturedImageButton = (Button)findViewById(R.id.photo_button);
        capturedImageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, requestCode);
            }
        });
        //Dialogo
        initComponents();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.requestCode == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings1) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }



    private void initComponents()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        YesNo = builder.create();
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Desea guardar los datos ingresados");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(ImagesActivity.this,"La Información ha sido Grabada",Toast.LENGTH_LONG).show();
                SendFormSincroniza();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(ImagesActivity.this, "La información no ha sido Grabada", Toast.LENGTH_LONG).show();
            }

        });
        YesNo = builder.create();
    }

    public void ShowMessage(View view)
    {
        YesNo.show();
    }

    public void SendFormSincroniza()
    {

        Intent intent = new Intent(this, SincronizacionActivity.class);
        startActivity(intent);
        finish();

    }

}
