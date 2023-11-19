package com.cpifppiramide.planificador.tareas.domain;

import com.cpifppiramide.planificador.proyectos.domain.Proyecto;

import java.util.List;

public interface TareaRepository {
    public List<Tarea> lista(Proyecto proyecto);

}
