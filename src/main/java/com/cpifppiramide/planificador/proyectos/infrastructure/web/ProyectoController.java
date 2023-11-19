package com.cpifppiramide.planificador.proyectos.infrastructure.web;

import com.cpifppiramide.planificador.proyectos.application.ProyectoUseCases;
import com.cpifppiramide.planificador.proyectos.domain.Proyecto;
import com.cpifppiramide.planificador.proyectos.infrastructure.data.ProyectoRepositoryMySQL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProyectoController {

    private ProyectoUseCases proyectoUseCases;

    public ProyectoController(){
        this.proyectoUseCases = new ProyectoUseCases(
                new ProyectoRepositoryMySQL()
        );
    }

    @GetMapping("/proyectos")
    public String listaTodos(Model model){
        List<Proyecto> proyectos = this.proyectoUseCases.listaTodos();
        model.addAttribute("proyectos", proyectos);
        return "proyectos/index";
    }

    @GetMapping("/proyecto/{id}")
    public String detalle(Model model, @PathVariable Integer id){
        Proyecto proyecto = this.proyectoUseCases.detalle(new Proyecto(id, null));
        model.addAttribute("proyecto", proyecto);
        return "proyectos/detail";
    }

    @GetMapping("/proyecto/nuevo")
    public String nuevo(Model model){
        return "proyectos/new";
    }

    @PostMapping("/proyecto/save")
    public String guardar(String nombre){
        Proyecto nuevo = new Proyecto(null, nombre);
        this.proyectoUseCases.guarda(nuevo);
        return "redirect:../proyectos";
    }

    @PostMapping("/proyecto/borrar")
    public String borrar(Integer id){
        this.proyectoUseCases.borra(id);
        return "redirect:../proyectos";
    }
}
