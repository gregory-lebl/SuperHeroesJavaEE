package com.example.superheroes.repository;

import com.example.superheroes.model.Hero;
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
import java.util.List;

public class LocalisationRepository {
    /**
     * Récupère la longitude et la lattitude du premier résultat de nominatim.openstreetmap.org
     * depuis le nom d'une ville
     * @param city nom d'une ville
     * @return longitude et lattitude
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String GetCityCoordinates(String city) throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //requête HTTP en GET avec paramètres optionnels
        HttpGet httpGetRequest = new HttpGet("https://nominatim.openstreetmap.org/search");
        //Construction de l'url complète
        URI uri = new URIBuilder(httpGetRequest.getURI())
                .addParameter("q", city)
                .addParameter("format","json")
                .build();

        httpGetRequest.setURI(uri);
        //Execution et récupération de la réponse
        CloseableHttpResponse response = httpClient.execute(httpGetRequest);
        HttpEntity entity = response.getEntity();
        httpClient.close();

        String result = EntityUtils.toString(entity);
        //Conversion de mon résult en Array
        JSONArray array = new JSONArray(result);
        //Récupération du premier élément
        JSONObject json = (JSONObject) array.get(0);
        //Récupération valeur de la clé "lon"
        String longitude = json.getString("lon");
        //Récupération valeur de la clé "lon"
        String lattitude = json.getString("lat");
        //Concaténation pour insertion en bdd
        return lattitude + "," + longitude  ;
    }

    /**
     * Retourne la distance entre 2 coordonnées GPS en KM
     * @param lat1
     * @param lat2
     * @param lon1
     * @param lon2
     * @return La distance entre 2 coordonées GPS
     */
    public static int GetDistanceBetweenIncidentAndHero(double lat1, double lat2, double lon1, double lon2) {
        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return (int)Math.round(c * r);
    }
}
