package com.hame.proyectofinalfausto;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.hame.proyectofinalfausto.Adapter.item_AdapterImages;
import com.hame.proyectofinalfausto.Clases.clase_listImages;

import java.util.ArrayList;

public class ImagesRecyclerActivity extends AppCompatActivity {

    private ImageView imageHolder;
    private final int requestCode = 20;
    private AlertDialog YesNo;

    private static final int TAKE_PICTURE = 1;
    private Button button1;
    private Uri imageUri;
    private GridView gridview;
    private Bitmap help1;


    private RecyclerView rv_item_list_images;
    private Context contxt;
    private ArrayList<clase_listImages> lista;
    private item_AdapterImages iadapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_recycler);

        contxt = this;
        //MostrarImagenes();
        imageHolder = (ImageView)findViewById(R.id.captured_photo);

        FloatingActionButton photo_button = (FloatingActionButton) findViewById(R.id.photo_button);
        photo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, requestCode);
                //Agregar imágenes
//                lista.add(new clase_listImages(R.drawable.thumbnail_calculator,getResources().getString(R.string.cbx_calculator)));
//                iadapt= new item_AdapterImages(contxt,lista);
//                rv_item_list_images.setAdapter(iadapt);

            }
        });
        DialogInterface();
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

    public void MostrarImagenes (Bitmap bitmap, ImageView imageHolder){

        rv_item_list_images= (RecyclerView) findViewById(R.id.rv_item_list_images);

        GridLayoutManager glm = new GridLayoutManager(contxt,3);
        rv_item_list_images.setLayoutManager(glm);

        lista= new ArrayList<>();

        imageHolder.setImageBitmap(bitmap);

        lista.add(new clase_listImages(R.drawable.thumbnail_bag,getResources().getString(R.string.cbx_bag)));
        lista.add(new clase_listImages(R.drawable.thumbnail_basket,getResources().getString(R.string.cbx_basket)));
        lista.add(new clase_listImages(R.drawable.thumbnail_box,getResources().getString(R.string.cbx_box)));
        lista.add(new clase_listImages(R.drawable.thumbnail_briefcase,getResources().getString(R.string.cbx_briefcase)));
        lista.add(new clase_listImages(R.drawable.thumbnail_calculator,getResources().getString(R.string.cbx_calculator)));

        iadapt= new item_AdapterImages(contxt,lista);
        rv_item_list_images.setAdapter(iadapt);

    }




    private void DialogInterface()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        YesNo = builder.create();
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Desea guardar los datos ingresados");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(ImagesRecyclerActivity.this,"La Información ha sido Grabada",Toast.LENGTH_LONG).show();
                SendFormSincroniza();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Toast.makeText(ImagesRecyclerActivity.this, "La información no ha sido Grabada", Toast.LENGTH_LONG).show();
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
