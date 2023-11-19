package com.cpifppiramide.planificador.tareas.infrastructure.data;

import com.cpifppiramide.planificador.context.DBConnection;
import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialidades.infrastructure.adapter.EspecialidadAdapter;
import com.cpifppiramide.planificador.especialistas.domain.Especialista;
import com.cpifppiramide.planificador.especialistas.infrastructure.adapter.EspecialistaAdapter;
import com.cpifppiramide.planificador.proyectos.domain.Proyecto;
import com.cpifppiramide.planificador.tareas.domain.Tarea;
import com.cpifppiramide.planificador.tareas.domain.TareaRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TareaRepositoryMySQL implements TareaRepository {

    private final EspecialidadAdapter especialidadAdapter;
    private final EspecialistaAdapter especialistaAdapter;

    public TareaRepositoryMySQL(){
        this.especialidadAdapter = new EspecialidadAdapter();
        this.especialistaAdapter = new EspecialistaAdapter();
    }

    @Override
    public List<Tarea> lista(Proyecto proyecto) {
        List<Tarea> tareas = new ArrayList<>();
        //pido a otros dominios los datos para simplificar las consultas SQL
        List<Especialidad> especialidades = this.especialidadAdapter.listaTodas();
        List<Especialista> especialistas = this.especialistaAdapter.listaTodos();
        try {
            String query = "select * from tareas where proyecto = ?";
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(query);
            statement.setInt(1,proyecto.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String especialidadID = rs.getString("especialidad");
                Optional<Especialidad> optionalEspecialidad = especialidades.stream().filter(actual -> actual.getCodigo().equals(especialidadID)).findAny();
                Especialidad especialidad = null;
                if(optionalEspecialidad.isPresent()) especialidad = optionalEspecialidad.get();
                Integer especialistaID = rs.getInt("especialista");
                Optional<Especialista> optionalEspecialista = especialistas.stream().filter(actual -> actual.getId().equals(especialistaID)).findAny();
                Especialista especialista = null;
                if(optionalEspecialista.isPresent()) {
                    especialista = optionalEspecialista.get();
                    especialista.setEspecialidad(especialidad);
                }

                Tarea tarea = new Tarea(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        null,
                        especialidad,
                        especialista
                );
                tareas.add(tarea);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tareas;
    }
}
