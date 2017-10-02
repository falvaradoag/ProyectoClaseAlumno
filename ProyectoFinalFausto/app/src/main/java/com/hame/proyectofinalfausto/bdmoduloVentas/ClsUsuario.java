package com.hame.proyectofinalfausto.bdmoduloVentas;

/**
 * Created by falvarado on 27/09/2017.
 */

public class ClsUsuario {
    String idUsuario;
    String Nombre;

    public ClsUsuario(String idUsuario, String nombre, String password) {
        this.idUsuario = idUsuario;
        Nombre = nombre;
        Password = password;
    }

    public ClsUsuario() {

    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    String Password;
}

