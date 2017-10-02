package com.hame.proyectofinalfausto.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.proyectofinalfausto.Clases.clase_listImages;
import com.hame.proyectofinalfausto.Holder.listImages;
import com.hame.proyectofinalfausto.R;

import java.util.ArrayList;


public class item_AdapterImages extends RecyclerView.Adapter<listImages> {
    private Context context;
    private ArrayList<clase_listImages> imagesClass;



    public item_AdapterImages(Context context, ArrayList<clase_listImages> imagesClass) {
        this.context = context;
        this.imagesClass = imagesClass;
    }


    @Override
    public listImages onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.item_tarea, parent,false);
        return new listImages(view);
    }

    @Override
    public void onBindViewHolder(listImages holder, int position) {
        holder.setData(imagesClass.get(position).getImagen(),imagesClass.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return imagesClass.size();
    }
}
