package com.example.superheroes.controller;

import com.example.superheroes.repository.HeroRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

@WebServlet(name = "InsertDataServlet", value = "/insertData")
public class InsertDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HeroRepository heroRepository = new HeroRepository();
        try {
            heroRepository.insertFakeHeroes();
        } catch (SQLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
