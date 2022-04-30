package com.example.superheroes.repository;

import com.example.superheroes.model.Incident;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class IncidentRepository {
    private DatabaseConnection database;

    public IncidentRepository() {
        this.database = new DatabaseConnection();
    }

    /**
     * Insère un nouvel incident en base de données
     * @param incident
     * @return
     * @throws SQLException
     */
    public boolean InsertNewIncident(Incident incident) throws SQLException {
        Connection conn = database.getDatabaseConnection();
        String query = "INSERT INTO incident(incidentType,city,lattitudeLongitude) VALUES(?,?,?)";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, incident.incidentType);
        statement.setString(2, incident.city);
        statement.setString(3, incident.lattitudeLongitude);
        return statement.execute();
    }

    /**
     * Retourne le dernier incident inséré en base de données
     * @return
     * @throws SQLException
     */
    public Incident getLastIncident() throws SQLException {
        Connection conn = database.getDatabaseConnection();
        String query = "SELECT id, incidentType, city, lattitudeLongitude FROM incident ORDER BY id DESC LIMIT 1";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        Incident incident = null;
        if (resultSet.next()){
            incident = new Incident(resultSet.getString("incidentType"),resultSet.getString("lattitudeLongitude"),resultSet.getString("city"));
        }
        return incident;
    }


}
