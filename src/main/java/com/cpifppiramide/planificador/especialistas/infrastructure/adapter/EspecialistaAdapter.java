package com.cpifppiramide.planificador.especialistas.infrastructure.adapter;

import com.cpifppiramide.planificador.especialistas.application.EspecialistaUseCases;
import com.cpifppiramide.planificador.especialistas.domain.Especialista;
import com.cpifppiramide.planificador.especialistas.infrastructure.data.EspecialistaRepositoryMySQL;

import java.util.List;

public class EspecialistaAdapter {

    private EspecialistaUseCases especialistaUseCases;

    public EspecialistaAdapter(){
        this.especialistaUseCases = new EspecialistaUseCases(
                new EspecialistaRepositoryMySQL()
        );
    }

    public List<Especialista> listaTodos() {
        return this.especialistaUseCases.listaTodos();
    }

}
