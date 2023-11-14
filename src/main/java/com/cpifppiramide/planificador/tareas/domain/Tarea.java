package com.cpifppiramide.planificador.tareas.domain;

import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialistas.domain.Especialista;
import com.cpifppiramide.planificador.proyectos.domain.Proyecto;

public class Tarea {

    private final String codigo, nombre;
    private final Proyecto proyecto;
    private final Especialidad especialidad;
    private final Especialista especialista;

    public Tarea(String codigo, String nombre, Proyecto proyecto, Especialidad especialidad, Especialista especialista){
        this.codigo = codigo;
        this.nombre = nombre;
        this.proyecto = proyecto;
        this.especialidad = especialidad;
        this.especialista = especialista;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Especialista getEspecialista() {
        return especialista;
    }
}
