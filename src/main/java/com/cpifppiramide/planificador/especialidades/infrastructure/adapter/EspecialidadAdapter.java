package com.cpifppiramide.planificador.especialidades.infrastructure.adapter;

import com.cpifppiramide.planificador.especialidades.application.EspecialidadUseCases;
import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialidades.infrastructure.data.EspecialidadRepositoryMySQL;

import java.util.List;

public class EspecialidadAdapter {

    private EspecialidadUseCases especialidadUseCases;

    public EspecialidadAdapter(){
        this.especialidadUseCases = new EspecialidadUseCases(
                new EspecialidadRepositoryMySQL()
        );
    }

    public List<Especialidad> listaTodas(){
        return this.especialidadUseCases.listaTodas();
    }

}
