package com.example.superheroes.repository;

import com.example.superheroes.model.IncidentType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IncidentTypeRepository {
    private DatabaseConnection database;

    public IncidentTypeRepository() {
        this.database = new DatabaseConnection();
    }

    /**
     *
     * @return List<>
     * @throws SQLException
     */
    public List<IncidentType> getAllIncidentType() throws SQLException {
        Connection conn = database.getDatabaseConnection();
        String query = "SELECT id, incidentName from incidentType";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query);

        ArrayList<IncidentType> incidents = new ArrayList<>();

        while(result.next()){
            IncidentType incident = new IncidentType(result.getInt("id"),result.getString("incidentName"));
            incidents.add(incident);
        }

        return incidents;
    }
}
