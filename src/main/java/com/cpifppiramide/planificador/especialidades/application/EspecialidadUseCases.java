package com.cpifppiramide.planificador.especialidades.application;

import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialidades.domain.EspecialidadRepository;

import java.util.List;

public class EspecialidadUseCases {

    private EspecialidadRepository especialidadRepository;

    public EspecialidadUseCases(EspecialidadRepository especialidadRepository){
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> listaTodas(){
        return this.especialidadRepository.listaTodas();
    }
    public List<Especialidad> listaTodasDetalle(){
        return this.especialidadRepository.listaTodasDetalle();
    }
}
