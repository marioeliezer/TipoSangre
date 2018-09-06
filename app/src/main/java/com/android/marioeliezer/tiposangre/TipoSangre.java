package com.android.marioeliezer.tiposangre;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity
class TipoSangre implements Serializable{
    @PrimaryKey(autoGenerate = true )
    int id;
    @NonNull
    String nombre;
    @NonNull
    String genero;
    @NonNull
    String tipo_sangre;
    @NonNull
    int edad;

    public TipoSangre(String nombre, String genero, String tipo_sangre, int edad) {
        this.nombre = nombre;
        this.genero = genero;
        this.tipo_sangre = tipo_sangre;
        this.edad = edad;
    }

    public TipoSangre() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
