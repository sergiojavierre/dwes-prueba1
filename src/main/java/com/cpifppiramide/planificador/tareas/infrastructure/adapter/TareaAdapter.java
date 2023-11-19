package com.cpifppiramide.planificador.tareas.infrastructure.adapter;

import com.cpifppiramide.planificador.proyectos.domain.Proyecto;
import com.cpifppiramide.planificador.tareas.application.TareaUseCases;
import com.cpifppiramide.planificador.tareas.domain.Tarea;
import com.cpifppiramide.planificador.tareas.infrastructure.data.TareaRepositoryMySQL;

import java.util.List;

public class TareaAdapter {

    private TareaUseCases tareaUseCases;

    public TareaAdapter() {
        this.tareaUseCases = new TareaUseCases(new TareaRepositoryMySQL());
    }

    public List<Tarea> lista(Proyecto proyecto) {
        return this.tareaUseCases.lista(proyecto);
    }
}