package com.cpifppiramide.planificador.proyectos.application;

import com.cpifppiramide.planificador.proyectos.domain.Proyecto;
import com.cpifppiramide.planificador.proyectos.domain.ProyectoRepository;
import com.cpifppiramide.planificador.tareas.domain.Tarea;

import java.util.List;

public class ProyectoUseCases {
    private ProyectoRepository proyectoRepository;

    public ProyectoUseCases(ProyectoRepository proyectoRepository){
        this.proyectoRepository = proyectoRepository;
    }

    public List<Proyecto> listaTodos(){
        return this.proyectoRepository.listaTodos();
    }

    public Proyecto detalle(Proyecto proyecto){
        return this.proyectoRepository.detalle(proyecto);
    }

    public Proyecto asigna(Proyecto proyecto, Tarea tarea){
        this.proyectoRepository.asigna(proyecto, tarea);
        return this.detalle(proyecto);
    }

    public Proyecto guarda(Proyecto proyecto){
        this.proyectoRepository.guarda(proyecto);
        return this.detalle(proyecto);
    }

    public void borra(Integer id){
        this.proyectoRepository.borra(id);
    }

}
