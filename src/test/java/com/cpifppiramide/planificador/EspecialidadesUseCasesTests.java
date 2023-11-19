package com.cpifppiramide.planificador;

import com.cpifppiramide.planificador.especialidades.application.EspecialidadUseCases;
import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialidades.infrastructure.data.EspecialidadRepositoryMySQL;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EspecialidadesUseCasesTests {
    //se prueban los valores iniciales
    private final EspecialidadUseCases especialidadUseCases;

    public EspecialidadesUseCasesTests(){
        this.especialidadUseCases = new EspecialidadUseCases(
                new EspecialidadRepositoryMySQL()
        );
    }

    @Test
    public void listaTodas(){
        List<Especialidad> especialidades = this.especialidadUseCases.listaTodas();
        assertEquals(3, especialidades.size());
    }

    @Test
    public void listaTodasDetalle(){
        List<Especialidad> especialidades = this.especialidadUseCases.listaTodasDetalle();
        assertEquals(3, especialidades.size());
        //las especialidades tienen 2 especialistas cada una
        for (int i = 0; i < 2; i++) {
            assertEquals(2, especialidades.get(i).getEspecialistas().size());
        }
    }

}
