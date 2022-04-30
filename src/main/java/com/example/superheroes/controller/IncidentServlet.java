package com.example.superheroes.controller;

import com.example.superheroes.model.Incident;
import com.example.superheroes.repository.IncidentRepository;
import com.example.superheroes.repository.LocalisationRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "incidentServlet", value = "/incident")
public class IncidentServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("availableHeroes.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IncidentRepository IncidentRepository = new IncidentRepository();
        try {
            String city = req.getParameter("city");
            String IncidentType = req.getParameter("heroIncidents");
            String incidentCoordinates = LocalisationRepository.GetCityCoordinates(city);

            Incident Incident = new Incident(IncidentType,incidentCoordinates,city);
            IncidentRepository.InsertNewIncident(Incident);

            resp.sendRedirect(req.getContextPath() + "/hero");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
