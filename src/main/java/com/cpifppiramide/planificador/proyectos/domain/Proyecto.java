package com.cpifppiramide.planificador.proyectos.domain;


import com.cpifppiramide.planificador.tareas.domain.Tarea;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Proyecto {

    private Integer id;
    private String nombre;

    private List<Tarea> tareas;

    public Proyecto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
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

    public void setTareas(List<Tarea> tareas){
        this.tareas.clear();
        this.tareas.addAll(tareas);
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    @Override
    public boolean equals(Object obj) {
        Proyecto comparar = (Proyecto) obj;
        return Objects.equals(this.id, comparar.getId());
    }
}
