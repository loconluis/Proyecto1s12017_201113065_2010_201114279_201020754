package com.projects.loconluis.myapp;

/**
 * Created by luisl on 23/03/2017.
 */

public class NodoRenta {
    private NodoRenta ant, sig;
    private String id;
    private String nombre;
    private String des;
    private int dias;

    public NodoRenta(String id, String nombre, String des, int dias){
        this.setId(id);
        this.setNombre(nombre);
        this.setDes(des);
        this.setDias(dias);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public NodoRenta getSig(){
        return sig;
    }

    public void setSig(NodoRenta siguiente){
        this.sig = siguiente;
    }
    public NodoRenta getAnt(){
        return ant;
    }

    public void setAnt(NodoRenta anterior){
        this.ant = anterior;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
