package com.example.superheroes.repository;

import com.example.superheroes.model.Hero;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private DatabaseConnection database;

    public HeroRepository() {
        this.database = new DatabaseConnection();
    }

    /**
     * Insère un nouveau héro en base de données
     * @param hero
     * @return
     * @throws SQLException
     */
    public boolean insertHero(Hero hero) throws SQLException {
        Connection conn = database.getDatabaseConnection();
        String query = "INSERT INTO hero(name,incidents,home,phoneNumber) VALUES(?,?,?,?)";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, hero.name);
        statement.setString(2, hero.incidents);
        statement.setString(3, hero.home);
        statement.setString(4, hero.phoneNumber);
        return statement.execute();
    }

    /**
     * Retourne tous les héros
     * @return List<>
     * @throws SQLException
     */
    public List<Hero> getAll() throws SQLException {
        try{
            Connection conn = database.getDatabaseConnection();
            String query = "SELECT name,incidents,home,phoneNumber FROM hero";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<Hero> heroList = new ArrayList<>();
            while (resultSet.next()){
                Hero hero = new Hero(resultSet.getString("name"),resultSet.getString("incidents"),resultSet.getString("home"),resultSet.getString("phoneNumber"));
                heroList.add(hero);
            }

            return heroList;
        }catch (SQLException exception){
            throw exception;
        }
    }

    /**
     * Insère des héroes pour chaque ville de France
     * @throws SQLException
     * @throws URISyntaxException
     * @throws IOException
     */
    public void insertFakeHeroes() throws SQLException, URISyntaxException, IOException {
        Connection conn = database.getDatabaseConnectionFrenchZipCode();
        String query = "SELECT name FROM frenchzipcode.cities";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        int incidentMin = 1;
        int incidentMax = 10;
        int heroPerCity = 10;

        while(resultSet.next()){
            for (int i = 0; i < heroPerCity; i++){
                int incident1 = (int)Math.floor(Math.random()*(incidentMax-incidentMin+1)+incidentMin);
                int incident2 = (int)Math.floor(Math.random()*(incidentMax-incidentMin+1)+incidentMin);
                int incident3 = (int)Math.floor(Math.random()*(incidentMax-incidentMin+1)+incidentMin);

                if (incident2 == incident1){
                    if (incident2 + 1 < 10){
                        incident2 = incident2 + 1;
                    }else{
                        incident2 = incident2 - 1;
                    }
                }
                if (incident3 == incident2){
                    if (incident3 + 1 < 10){
                        incident3 = incident3 + 1;
                    }else{
                        incident3 = incident3 - 1;
                    }
                }

                String incidents = String.format("%d,%d,%d",incident1,incident2,incident3);
                String gps = LocalisationRepository.GetCityCoordinates(resultSet.getString("name"));

                Hero hero = new Hero(resultSet.getString("name") + i,incidents,gps,"07 83 89 02 7" + i);

                this.insertHero(hero);
            }
        }
    }
}
