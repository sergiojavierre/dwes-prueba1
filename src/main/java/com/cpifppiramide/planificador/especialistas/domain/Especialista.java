package com.cpifppiramide.planificador.especialistas.domain;

import com.cpifppiramide.planificador.especialidades.domain.Especialidad;

public class Especialista {

    private Integer id;
    private String nombre;
    private Especialidad especialidad;

    public Especialista(Integer id, String nombre, Especialidad especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
