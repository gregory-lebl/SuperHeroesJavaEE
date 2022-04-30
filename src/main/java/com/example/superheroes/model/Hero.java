package com.example.superheroes.model;

public class Hero {
    public String name;
    public String incidents;
    public String home;
    public String phoneNumber;

    /**
     * Constructor
     * @param name Nom du héros
     * @param incidents
     * @param home
     * @param phoneNumber
     */
    public Hero(String name, String incidents, String home, String phoneNumber) {
        this.name = name;
        this.incidents = incidents;
        this.home = home;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIncidents() {
        return incidents;
    }

    public void setIncidents(String incidents) {
        this.incidents = incidents;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
