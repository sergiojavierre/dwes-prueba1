package com.cpifppiramide.planificador;

import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialistas.domain.Especialista;
import com.cpifppiramide.planificador.proyectos.application.ProyectoUseCases;
import com.cpifppiramide.planificador.proyectos.domain.Proyecto;
import com.cpifppiramide.planificador.proyectos.infrastructure.data.ProyectoRepositoryMySQL;
import com.cpifppiramide.planificador.tareas.domain.Tarea;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ProyectosUseCasesTests {

    private ProyectoUseCases proyectoUseCases;

    public ProyectosUseCasesTests(){
        this.proyectoUseCases = new ProyectoUseCases(
                new ProyectoRepositoryMySQL()
        );
    }

    @Test
    public void listaTodos(){
        List<Proyecto> proyectos = this.proyectoUseCases.listaTodos();
        //comprobamos que existen los proyectos que están en la base
        Proyecto p1 = new Proyecto(1, null);
        Proyecto p2 = new Proyecto(2, null);
        Proyecto p3 = new Proyecto(3, null);
        assertTrue(proyectos.contains(p1));
        assertTrue(proyectos.contains(p2));
        assertTrue(proyectos.contains(p3));
    }

    @Test
    public void detalle(){
        Proyecto proyecto = this.proyectoUseCases.detalle(new Proyecto(1,null));
        assertEquals(1,proyecto.getId());
        assertEquals(3, proyecto.getTareas().size());
    }

    @Test
    public void asigna(){
        Proyecto proyecto = this.proyectoUseCases.guarda(new Proyecto(null, "Proyecto test"));
        Especialidad especialidad = new Especialidad("FRONT", null);
        Especialista especialista = new Especialista(1, null, especialidad);
        Random random = new Random();
        Tarea tarea = new Tarea(String.valueOf(random.nextInt(9999)), "Tarea test", proyecto,especialidad , especialista);
        Proyecto actualizado = this.proyectoUseCases.asigna(proyecto, tarea);
        Boolean existe = actualizado.getTareas().stream().anyMatch(tareaFilter -> tareaFilter.getCodigo().equals(tarea.getCodigo()));
        assertEquals(true, existe);
    }

    @Test
    public void borra(){
        Proyecto proyecto = this.proyectoUseCases.guarda(new Proyecto(null, "Proyecto a borrar"));
        Especialidad especialidad = new Especialidad("FRONT", null);
        Especialista especialista = new Especialista(1, null, especialidad);
        Random random = new Random();
        Tarea tarea = new Tarea(String.valueOf(random.nextInt(9999)), "Tarea test", proyecto,especialidad , especialista);
        Proyecto actualizado = this.proyectoUseCases.asigna(proyecto, tarea);
        this.proyectoUseCases.borra(actualizado.getId());
        List<Proyecto> proyectos = this.proyectoUseCases.listaTodos();
        assertFalse( proyectos.contains(proyecto));
    }

}
