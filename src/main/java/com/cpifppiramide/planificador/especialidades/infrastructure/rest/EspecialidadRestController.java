package com.cpifppiramide.planificador.especialidades.infrastructure.rest;

import com.cpifppiramide.planificador.especialidades.application.EspecialidadUseCases;
import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialidades.infrastructure.data.EspecialidadRepositoryMySQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EspecialidadRestController {

    private EspecialidadUseCases especialidadUseCases;

    public EspecialidadRestController(){
        this.especialidadUseCases = new EspecialidadUseCases(
                new EspecialidadRepositoryMySQL()
        );
    }

    @GetMapping("/api/especialidades")
    public List<Especialidad> lista(){
        return this.especialidadUseCases.listaTodasDetalle();
    }
}
