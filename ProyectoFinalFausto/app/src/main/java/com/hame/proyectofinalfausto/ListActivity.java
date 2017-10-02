package com.hame.proyectofinalfausto;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hame.proyectofinalfausto.Adapter.itemAdapterListaClientes;
import com.hame.proyectofinalfausto.Clases.Cls_Imagen;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public Context contxt;
    private RecyclerView recyclerViewListCli;
    private itemAdapterListaClientes itemAdapListCli;
    private List<Cls_Imagen> clsImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contxt = this;
        initcomponents();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                    ClsUsuario usr = new ClsUsuario ("System","Sistema","1234");
//                    ClsUsuarioDB DBusr = new ClsUsuarioDB(contxt);
//                    DBusr.InsertUsuario(usr);

                Snackbar.make(view, "Ingresa nuevo cliente", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                PantallaIngresoCliente();

            }
        });
    }
    public void PantallaIngresoCliente(){
        Intent intent = new Intent(this, IngresoClienteActivity.class);
        startActivity(intent);
        finish();
    }
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)

    public void initcomponents()
    {
        contxt = this;
        recyclerViewListCli= (RecyclerView) findViewById(R.id.rv_item_listClientes);
        GridLayoutManager glm = new GridLayoutManager(contxt,1);
        recyclerViewListCli.setLayoutManager(glm);

        ArrayList<Cls_Imagen> imagesClass = new ArrayList<>();
        imagesClass = new ArrayList<>();
        imagesClass.add(new Cls_Imagen(12,"Fausto","12 calle","5577332"));
        imagesClass.add(new Cls_Imagen(15,"Mario","15 calle","2121"));

        itemAdapListCli = new itemAdapterListaClientes(contxt, imagesClass);
        recyclerViewListCli.setAdapter(itemAdapListCli);
    }

}
