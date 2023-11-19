package com.cpifppiramide.planificador;

import com.cpifppiramide.planificador.proyectos.domain.Proyecto;
import com.cpifppiramide.planificador.tareas.application.TareaUseCases;
import com.cpifppiramide.planificador.tareas.domain.Tarea;
import com.cpifppiramide.planificador.tareas.infrastructure.data.TareaRepositoryMySQL;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TareasUseCasesTests {

    private TareaUseCases tareaUseCases;

    public TareasUseCasesTests(){
        this.tareaUseCases = new TareaUseCases(
                new TareaRepositoryMySQL()
        );
    }

    @Test
    public void lista(){
        List<Tarea> tareas = this.tareaUseCases.lista(new Proyecto(1,null));
        assertEquals(3,tareas.size());
    }

}
