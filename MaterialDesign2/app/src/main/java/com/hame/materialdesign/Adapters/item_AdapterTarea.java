package com.hame.materialdesign.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.materialdesign.Clases.clase_imagen;
import com.hame.materialdesign.Holders.item_tarea;
import com.hame.materialdesign.R;

import java.util.ArrayList;


public class item_AdapterTarea extends RecyclerView.Adapter<item_tarea> {
    private Context context;
    private ArrayList<clase_imagen> imagesClass;



    public item_AdapterTarea(Context context, ArrayList<clase_imagen> imagesClass) {
        this.context = context;
        this.imagesClass = imagesClass;
    }


    @Override
    public item_tarea onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.item_tarea, parent,false);
        return new item_tarea(view);
    }

    @Override
    public void onBindViewHolder(item_tarea holder, int position) {
        holder.setData(imagesClass.get(position).getImagen(),imagesClass.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return imagesClass.size();
    }
}
