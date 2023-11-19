package com.cpifppiramide.planificador.proyectos.domain;

import com.cpifppiramide.planificador.tareas.domain.Tarea;

import java.util.List;

public interface ProyectoRepository {

    public List<Proyecto> listaTodos();
    public Proyecto detalle(Proyecto proyecto);
    public Proyecto guarda(Proyecto proyecto);
    public void asigna (Proyecto proyecto, Tarea tarea);
    public void borra(Integer id);

}
