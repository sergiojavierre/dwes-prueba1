package com.cpifppiramide.planificador.especialidades.domain;

public class Especialidad {

    private final String codigo, nombre;

    public Especialidad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
