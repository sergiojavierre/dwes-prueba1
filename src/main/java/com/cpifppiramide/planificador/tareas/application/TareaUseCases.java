package com.cpifppiramide.planificador.tareas.application;

import com.cpifppiramide.planificador.proyectos.domain.Proyecto;
import com.cpifppiramide.planificador.tareas.domain.Tarea;
import com.cpifppiramide.planificador.tareas.domain.TareaRepository;

import java.util.List;

public class TareaUseCases {
    private TareaRepository tareaRepository;

    public TareaUseCases(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> lista(Proyecto proyecto) {
        return this.tareaRepository.lista(proyecto);
    }
}