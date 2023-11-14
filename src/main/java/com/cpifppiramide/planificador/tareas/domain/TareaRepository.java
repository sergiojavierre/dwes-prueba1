package com.cpifppiramide.planificador.tareas.domain;

import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialistas.domain.Especialista;
import com.cpifppiramide.planificador.proyectos.domain.Proyecto;

import java.util.List;

public interface TareaRepository {
    public List<Tarea> listaTodas();
    public List<Tarea> lista(Proyecto proyecto);
    public List<Tarea> lista(Especialista especialista);
    public List<Tarea> lista(Especialidad especialidad);

    public Tarea guarda(Tarea nueva);
    public Tarea asigna(Tarea tarea, Especialista especialista);
    public Boolean borra(Tarea tarea);

}
