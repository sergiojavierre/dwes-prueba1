package com.cpifppiramide.planificador.especialistas.infrastructure.data;

import com.cpifppiramide.planificador.context.DBConnection;
import com.cpifppiramide.planificador.especialidades.domain.Especialidad;
import com.cpifppiramide.planificador.especialistas.domain.Especialista;
import com.cpifppiramide.planificador.especialistas.domain.EspecialistaRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EspecialistaRepositoryMySQL implements EspecialistaRepository {
    @Override
    public List<Especialista> listaTodos() {
        List<Especialista> especialistas = new ArrayList<>();
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from especialistas");
            while (rs.next()){
                Especialista especialista = new Especialista(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        new Especialidad(rs.getString("especialidad"), null)
                );
                especialistas.add(especialista);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return especialistas;
    }

}
