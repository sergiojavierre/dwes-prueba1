package com.cpifppiramide.planificador.proyectos.domain;


public class Proyecto {

    private final Integer id;
    private final String nombre;

    public Proyecto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
