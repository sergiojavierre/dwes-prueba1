package com.cpifppiramide.planificador.especialidades.domain;

import com.cpifppiramide.planificador.especialistas.domain.Especialista;

import java.util.List;

public interface EspecialidadRepository {

    public List<Especialidad> listaTodas();
    public List<Especialidad> listaTodasDetalle();

}
