package com.example.superheroes.model;

public class Incident {
    public int incidentType;
    public String city;
    public String lattitudeLongitude;

    public Incident(String incidentType, String lattitudeLongitude, String city) {
        this.incidentType = Integer.parseInt(incidentType);
        this.lattitudeLongitude = lattitudeLongitude;
        this.city = city;
    }
}
