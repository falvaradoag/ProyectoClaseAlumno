package com.hame.proyectofinalfausto.Clases;

/**
 * Created by falvarado on 28/09/2017.
 */

public class Cls_Imagen {
    private int imagen;
    private String nombre;
    private String direccion;
    private String telefono;

    public Cls_Imagen(int imagen, String nombre, String direccion, String telefono) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
