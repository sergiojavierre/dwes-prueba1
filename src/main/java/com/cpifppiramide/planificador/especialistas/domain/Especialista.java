package com.cpifppiramide.planificador.especialistas.domain;

import com.cpifppiramide.planificador.especialidades.domain.Especialidad;

public class Especialista {

    private final Integer id;
    private final String nombre;
    private final Especialidad especialidad;

    public Especialista(Integer id, String nombre, Especialidad especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
