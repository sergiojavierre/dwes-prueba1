package com.cpifppiramide.planificador.especialistas.application;

import com.cpifppiramide.planificador.especialistas.domain.Especialista;
import com.cpifppiramide.planificador.especialistas.domain.EspecialistaRepository;

import java.util.List;

public class EspecialistaUseCases {
    private EspecialistaRepository especialistaRepository;

    public EspecialistaUseCases(EspecialistaRepository especialistaRepository){
        this.especialistaRepository = especialistaRepository;
    }

    public List<Especialista> listaTodos() {
        return this.especialistaRepository.listaTodos();
    }
}
