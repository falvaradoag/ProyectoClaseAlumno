package com.hame.implementacionparcelablo_fausto.Clases;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by falvarado on 06/09/2017.
 */



public class Clase_salon_materia implements Parcelable {
    public String nombre;
    public String descripcion;
    public ArrayList<Alumno> alumnos;

    protected Clase_salon_materia(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        if (in.readByte() == 0x01) {
            alumnos = new ArrayList<Alumno>();
            in.readList(alumnos, Alumno.class.getClassLoader());
        } else {
            alumnos = null;
        }
    }

    public Clase_salon_materia(String nombre, String descripcion, ArrayList<Alumno> alumnos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.alumnos = alumnos;
    }

    public Clase_salon_materia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(descripcion);
        if (alumnos == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(alumnos);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Clase_salon_materia> CREATOR = new Parcelable.Creator<Clase_salon_materia>() {
        @Override
        public Clase_salon_materia createFromParcel(Parcel in) {
            return new Clase_salon_materia(in);
        }

        @Override
        public Clase_salon_materia[] newArray(int size) {
            return new Clase_salon_materia[size];
        }
    };
}
