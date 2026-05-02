package br.com.solarium.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost:3306/solarium";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado! Verifique a pasta lib do Tomcat ou WEB-INF/lib.", e);
        }

        return DriverManager.getConnection(URL, USER, PASS);
    }
}