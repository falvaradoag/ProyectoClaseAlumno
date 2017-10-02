package com.hame.proyectofinalfausto.Clases;

public class clase_listImages {
    private int imagen;
    private String nombre;

    public clase_listImages(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public clase_listImages() {

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
