package com.uyu.fundamentosandroid2;

public class Mascota {

    public String nombre;
    public int foto;


    public Mascota(int foto, String nombre){
        this.foto = foto;
        this.nombre = nombre;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
