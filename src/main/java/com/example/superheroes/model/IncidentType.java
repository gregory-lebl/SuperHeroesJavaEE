package com.example.superheroes.model;

public class IncidentType {
    public int id;
    public String incidentName;

    public IncidentType(int id, String incidentName) {
        this.incidentName = incidentName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIncidentName() {
        return incidentName;
    }

    public void setIncidentName(String incidentName) {
        this.incidentName = incidentName;
    }
}
