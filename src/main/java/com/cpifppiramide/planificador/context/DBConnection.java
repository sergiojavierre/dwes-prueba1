package com.cpifppiramide.planificador.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    private DBConnection(){}

    public static Connection getInstance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/planificador",
                        "admin", "admin");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

}
