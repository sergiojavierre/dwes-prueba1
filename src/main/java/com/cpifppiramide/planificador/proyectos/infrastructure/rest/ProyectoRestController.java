package com.cpifppiramide.planificador.proyectos.infrastructure.rest;

import com.cpifppiramide.planificador.proyectos.application.ProyectoUseCases;
import com.cpifppiramide.planificador.proyectos.domain.Proyecto;
import com.cpifppiramide.planificador.proyectos.infrastructure.data.ProyectoRepositoryMySQL;
import com.cpifppiramide.planificador.tareas.domain.Tarea;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProyectoRestController {

    private ProyectoUseCases proyectoUseCases;

    public ProyectoRestController(){
        this.proyectoUseCases = new ProyectoUseCases(
                new ProyectoRepositoryMySQL()
        );
    }

    @GetMapping("/api/proyectos")
    public List<Proyecto> listaTodos(){
        return this.proyectoUseCases.listaTodos();
    }

    @GetMapping("/api/proyecto/{id}")
    public Proyecto detalle(@PathVariable Integer id){
        return this.proyectoUseCases.detalle(new Proyecto(id, null));
    }

    @PostMapping(path = "/api/proyecto/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Proyecto asigna(@PathVariable Integer id, @RequestBody Tarea tarea){
        return this.proyectoUseCases.asigna(new Proyecto(id, null), tarea);
    }

    @DeleteMapping("/api/proyecto/{id}")
    public List<Proyecto> borra(@PathVariable Integer id){
        this.proyectoUseCases.borra(id);
        return this.proyectoUseCases.listaTodos();
    }
}
