package com.example.superheroes.controller;

import com.example.superheroes.model.Hero;
import com.example.superheroes.model.Incident;
import com.example.superheroes.repository.HeroRepository;
import com.example.superheroes.repository.IncidentRepository;
import com.example.superheroes.repository.LocalisationRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "heroController", value = "/hero")
public class HeroServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //LocalisationRepository.distance();


        try {
            HeroRepository heroRepository = new HeroRepository();
            IncidentRepository incidentRepository = new IncidentRepository();

            List<Hero> allHeros = heroRepository.getAll();
            Incident latestIncident = incidentRepository.getLastIncident();
            List<Hero> availableHeros = new ArrayList<>();

            String[] incidentCoordinates = latestIncident.lattitudeLongitude.split(",");
            double incidentLattitude = Double.parseDouble(incidentCoordinates[0]);
            double incidentLongitude = Double.parseDouble(incidentCoordinates[1]);

            for (Hero hero : allHeros) {
                String[] heroCoordinates = hero.home.split(",");
                double heroLattitude = Double.parseDouble(heroCoordinates[0]);
                double heroLongitude = Double.parseDouble(heroCoordinates[1]);

                int distanceBetweenIncidentAndHero = LocalisationRepository.GetDistanceBetweenIncidentAndHero(heroLattitude,incidentLattitude,heroLongitude,incidentLongitude);

                if (distanceBetweenIncidentAndHero <= 50){
                    availableHeros.add(hero);
                }else{
                    continue;
                }
            }

            req.setAttribute("availableHeros", availableHeros);
            req.getRequestDispatcher("/pages/availableHeroes.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("heroName");
            String phoneNumber = req.getParameter("phoneNumber");
            String city = req.getParameter("city");
            String incidents = Arrays.toString(req.getParameterValues("heroIncidents"))
                    .replace("[","")
                    .replace("]","")
                    .trim();
            String gps = LocalisationRepository.GetCityCoordinates(city);

            Hero newHero = new Hero(name,incidents,gps,phoneNumber);
            HeroRepository heroRepository = new HeroRepository();
            heroRepository.insertHero(newHero);

            this.doGet(req,resp);
        } catch (SQLException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
