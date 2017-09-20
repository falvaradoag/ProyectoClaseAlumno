package com.hame.materialdesign;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hame.materialdesign.Adapters.item_AdapterTarea;
import com.hame.materialdesign.Clases.clase_imagen;

import java.util.ArrayList;

public class TareaRecyclerActivity extends AppCompatActivity {
    private RecyclerView rv_item_list_tarea;
    private Context contxt;
    private ArrayList<clase_imagen> lista;
    private item_AdapterTarea iadapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_recycler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contxt = this;
        initcomponents();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                lista.add(new clase_imagen(R.drawable.thumbnail_calculator,getResources().getString(R.string.cbx_calculator)));

                iadapt= new item_AdapterTarea(contxt,lista);
                rv_item_list_tarea.setAdapter(iadapt);
            }
        });
    }

    public void initcomponents (){

        rv_item_list_tarea= (RecyclerView) findViewById(R.id.rv_item_list_tarea);

        GridLayoutManager glm = new  GridLayoutManager(contxt,3);
        rv_item_list_tarea.setLayoutManager(glm);

        lista= new ArrayList<>();

        lista.add(new clase_imagen(R.drawable.thumbnail_atm,getResources().getString(R.string.chx_atm)));
        lista.add(new clase_imagen(R.drawable.thumbnail_bag,getResources().getString(R.string.cbx_bag)));
        lista.add(new clase_imagen(R.drawable.thumbnail_basket,getResources().getString(R.string.cbx_basket)));
        lista.add(new clase_imagen(R.drawable.thumbnail_box,getResources().getString(R.string.cbx_box)));
        lista.add(new clase_imagen(R.drawable.thumbnail_briefcase,getResources().getString(R.string.cbx_briefcase)));
        lista.add(new clase_imagen(R.drawable.thumbnail_calculator,getResources().getString(R.string.cbx_calculator)));

        iadapt= new item_AdapterTarea(contxt,lista);
        rv_item_list_tarea.setAdapter(iadapt);



    }
}
