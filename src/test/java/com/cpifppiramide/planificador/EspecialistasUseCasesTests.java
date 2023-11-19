package com.cpifppiramide.planificador;

import com.cpifppiramide.planificador.especialistas.application.EspecialistaUseCases;
import com.cpifppiramide.planificador.especialistas.domain.Especialista;
import com.cpifppiramide.planificador.especialistas.infrastructure.data.EspecialistaRepositoryMySQL;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EspecialistasUseCasesTests {
    //se prueban los valores iniciales
    private final EspecialistaUseCases especialistaUseCases;

    public EspecialistasUseCasesTests(){
        this.especialistaUseCases = new EspecialistaUseCases(
                new EspecialistaRepositoryMySQL()
        );
    }

    @Test
    public void listaTodos(){
        List<Especialista> especialistas = this.especialistaUseCases.listaTodos();
        assertEquals(6, especialistas.size());
    }

}
