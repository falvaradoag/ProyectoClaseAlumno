package com.hame.proyectofinalfausto.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hame.proyectofinalfausto.R;

/**
 * Created by falvarado on 28/09/2017.
 */


public class listClientes extends RecyclerView.ViewHolder{

    private ImageView img;
    private TextView txtNombre;
    private TextView txtDireccion;
    private TextView txtTelefono;

    public listClientes(View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.imageCli);
        txtNombre = itemView.findViewById(R.id.txtNombre );
        txtDireccion = itemView.findViewById(R.id.txtDireccion);
        txtTelefono = itemView.findViewById(R.id.txtTelefono);

    }
    public void setData(String nom, String dir, String tel)
    {
        txtNombre.setText(nom);
        txtDireccion.setText(dir);
        txtTelefono.setText(tel);
    }
}
