package com.cpifppiramide.planificador.especialidades.infrastructure.data;

import com.cpifppiramide.planificador.context.DBConnection;
import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialidades.domain.EspecialidadRepository;
import com.cpifppiramide.planificador.especialistas.domain.Especialista;
import com.cpifppiramide.planificador.especialistas.domain.EspecialistaRepository;
import com.cpifppiramide.planificador.especialistas.infrastructure.adapter.EspecialistaAdapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadRepositoryMySQL implements EspecialidadRepository {

    private EspecialistaAdapter especialistaAdapter;

    public EspecialidadRepositoryMySQL(){
        this.especialistaAdapter = new EspecialistaAdapter();
    }

    @Override
    public List<Especialidad> listaTodas() {
        List<Especialidad> especialidades = new ArrayList<>();
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from especialidades");
            while (rs.next()){
                Especialidad especialidad = new Especialidad(
                        rs.getString("codigo"),
                        rs.getString("nombre")
                );
                especialidades.add(especialidad);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return especialidades;
    }

    @Override
    public List<Especialidad> listaTodasDetalle() {
        List<Especialidad> especialidades = this.listaTodas();
        List<Especialista> especialistas = this.especialistaAdapter.listaTodos();
        for(Especialidad especialidad: especialidades){
            especialidad.setEspecialistas(especialistas.stream().filter(especialista -> especialista.getEspecialidad().getCodigo().equals(especialidad.getCodigo())).toList());
        }
        return especialidades;
    }
}
