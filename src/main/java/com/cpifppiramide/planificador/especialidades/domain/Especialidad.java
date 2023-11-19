package com.cpifppiramide.planificador.especialidades.domain;

import com.cpifppiramide.planificador.especialistas.domain.Especialista;

import java.util.ArrayList;
import java.util.List;

public class Especialidad {

    private final String codigo, nombre;
    private List<Especialista> especialistas;

    public Especialidad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialistas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEspecialistas(List<Especialista> especialistas) {
        this.especialistas = especialistas;
    }

    public List<Especialista> getEspecialistas() {
        return especialistas;
    }
}
