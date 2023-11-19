package com.cpifppiramide.planificador.proyectos.infrastructure.data;

import com.cpifppiramide.planificador.context.DBConnection;
import com.cpifppiramide.planificador.proyectos.domain.Proyecto;
import com.cpifppiramide.planificador.proyectos.domain.ProyectoRepository;
import com.cpifppiramide.planificador.tareas.domain.Tarea;
import com.cpifppiramide.planificador.tareas.infrastructure.adapter.TareaAdapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProyectoRepositoryMySQL implements ProyectoRepository {

    private final TareaAdapter tareaAdapter;

    public ProyectoRepositoryMySQL(){
        this.tareaAdapter = new TareaAdapter();
    }

    @Override
    public List<Proyecto> listaTodos() {
        List<Proyecto> proyectos = new ArrayList<>();
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from proyectos");
            while (rs.next()){
                Proyecto proyecto = new Proyecto(
                  rs.getInt("id"),
                  rs.getString("nombre")
                );
                proyectos.add(proyecto);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return proyectos;
    }

    @Override
    public Proyecto detalle(Proyecto proyecto) {
        try {
            String query = "select * from proyectos where id = ?";
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(query);
            statement.setInt(1,proyecto.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                proyecto.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        List<Tarea> tareas = this.tareaAdapter.lista(proyecto);
        proyecto.setTareas(tareas);
        return proyecto;
    }

    @Override
    public Proyecto guarda(Proyecto proyecto) {
        String query = "insert into proyectos (nombre) values (?)";
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,proyecto.getNombre());
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                proyecto.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proyecto;
    }

    @Override
    public void asigna(Proyecto proyecto, Tarea tarea) {
        String query = "insert into tareas (codigo, nombre, proyecto, especialidad, especialista) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,tarea.getCodigo());
            statement.setString(2, tarea.getNombre());
            statement.setInt(3, proyecto.getId());
            statement.setString(4, tarea.getEspecialidad().getCodigo());
            statement.setInt(5, tarea.getEspecialista().getId());
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            if(rs.next()){
                proyecto.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borra(Integer id){
        String query = "delete from proyectos where id = ?";
        try {
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
