package com.cpifppiramide.planificador.proyectos.domain;

import com.cpifppiramide.planificador.tareas.domain.Tarea;

import java.util.List;

public interface ProyectoRepository {

    public List<Proyecto> listaTodas();
    public List<Tarea> listaTareas(Proyecto proyecto);
    public Proyecto guarda(Proyecto proyecto);

}
