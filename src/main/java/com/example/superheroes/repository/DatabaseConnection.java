package com.example.superheroes.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    protected Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/superheroes","root","");
    }
    protected Connection getDatabaseConnectionFrenchZipCode() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/frenchzipcode","root","");
    }
}
