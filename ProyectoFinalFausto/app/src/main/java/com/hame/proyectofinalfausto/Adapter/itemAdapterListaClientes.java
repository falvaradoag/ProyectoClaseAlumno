package com.hame.proyectofinalfausto.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.proyectofinalfausto.Clases.Cls_Imagen;
import com.hame.proyectofinalfausto.Holder.listClientes;
import com.hame.proyectofinalfausto.R;

import java.util.ArrayList;

/**
 * Created by falvarado on 28/09/2017.
 */

public class itemAdapterListaClientes extends RecyclerView.Adapter<listClientes> {

    private Context context;
    private ArrayList<Cls_Imagen> imagesClass;

    public itemAdapterListaClientes(Context context, ArrayList<Cls_Imagen> imagesClass) {
        this.context = context;
        this.imagesClass = imagesClass;
    }


    @Override
    public listClientes onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.listclientes, parent,false);
        return new listClientes(view);
    }

    @Override
    public void onBindViewHolder(listClientes holder, int position) {
        holder.setData(imagesClass.get(position).getNombre(), imagesClass.get(position).getDireccion(), imagesClass.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return imagesClass.size();
    }
}

