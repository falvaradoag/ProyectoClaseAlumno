package com.hame.materialdesign.Clases;

public class clase_imagen {
    private int imagen;
    private String nombre;

    public clase_imagen(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public clase_imagen() {

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
}
