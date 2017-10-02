package com.hame.proyectofinalfausto.bdmoduloVentas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by falvarado on 27/09/2017.
 */

public class ClsBD extends SQLiteOpenHelper {
    private SQLiteDatabase mdb;

    public static final String FormularioVentas = "formularioVentas.db";
    public static int versionBD = 1;

    private static final String text_type = " Text";
    private static final String int_type = " Int";
    private static final String coma = ",";

    public static final String tabla_Usuario = " Usuario ";
    public static final String usuario_Id = " IdUsuario ";
    public static final String usuario_Nombre = " Nombre ";
    public static final String usuario_Password = " Password ";

    public ClsBD(Context context) {

        super(context, FormularioVentas, null, versionBD);
    }

    public void openReadableBD()
    {
        mdb = this.getReadableDatabase();
    }
    public void openWriteableBD()
    {
        mdb = this.getWritableDatabase();
    }

    public void ClaseBD()
    {
        if(mdb != null)
        {
            mdb.close();
        }
    }

    // Create table Usuario (IdUsuario TEXT, Nombre TEXT, Password TEXT );

    public static final String Usuario = "Create table "
                    + tabla_Usuario
                    + "("
                    + usuario_Id
                    + text_type
                    + coma
                    + usuario_Nombre
                    + text_type
                    + coma
                    + usuario_Password
                    + text_type
                    + ");";

    @Override
    public void onOpen(SQLiteDatabase sqldb)
    {
        super.onOpen(sqldb);
        if (!sqldb.isReadOnly())
        {
            sqldb.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Mostrar script de creación de tabla
        //Log.e("query", Usuario);
        sqLiteDatabase.execSQL(Usuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

