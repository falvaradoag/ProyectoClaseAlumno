package com.hame.proyectofinalfausto.bdmoduloVentas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by falvarado on 27/09/2017.
 */

public class ClsUsuarioDB {
    private SQLiteDatabase db;
    private ClsBD base;

    public ClsUsuarioDB(Context context)
    {
        base = new ClsBD(context);
    }

    //Llenar Datos
    public static ContentValues UsuarioContent (ClsUsuario usr){
        ContentValues usrCV = new ContentValues();
        usrCV.put(ClsBD.usuario_Id, usr.getIdUsuario());
        usrCV.put(ClsBD.usuario_Nombre, usr.getNombre());
        usrCV.put(ClsBD.usuario_Password, usr.getPassword());
        return usrCV;
    }
    //Inserta Datos
    public String InsertUsuario(ClsUsuario usr)
    {
        db = base.getWritableDatabase();
        db.insert(ClsBD.tabla_Usuario,null,UsuarioContent(usr));
        String msj = "Datos Ingresados Correctamente";
        return msj;
    }


}
