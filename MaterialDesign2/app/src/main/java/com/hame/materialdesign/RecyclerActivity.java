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

import com.hame.materialdesign.Adapters.item_Adapter;
import com.hame.materialdesign.Clases.clase_imagen;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView rv_item_list;
    private Context contxt;
    private item_Adapter iadapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
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
            }
        });
    }
public void initcomponents(){
    rv_item_list = (RecyclerView) findViewById(R.id.rv_item_list);
    GridLayoutManager glm = new  GridLayoutManager(contxt,3);
    rv_item_list.setLayoutManager(glm);

    int[] img = new int[]{R.drawable.thumbnail_atm,R.drawable.thumbnail_bag,R.drawable.thumbnail_basket,R.drawable.thumbnail_box
            ,R.drawable.thumbnail_briefcase,R.drawable.thumbnail_calculator};

    String []  text = new String[] {getResources().getString(R.string.chx_atm),getResources().getString(R.string.cbx_bag),
            getResources().getString(R.string.cbx_basket),getResources().getString(R.string.cbx_box),getResources().getString(R.string.cbx_briefcase)
            ,getResources().getString(R.string.cbx_calculator)};

    iadapt = new item_Adapter(img,text,contxt);

    rv_item_list.setAdapter(iadapt);
    }
}
