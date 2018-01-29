package com.Homework;

import com.Homework.statements.People;
import com.Homework.statements.Planets;
import com.Homework.statements.Starships;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;




public class SWApiTest  {
    People people = new People();
    Planets planets = new Planets();
    Starships starships = new Starships();
    SWApi SWapi = new SWApi();
    String UriPeople = SWapi.getPathUrl(people.getENDPOINT());
    String UriPlanet = SWapi.getPathUrl(planets.getENDPOINT());
    String UriStarships = SWapi.getPathUrl(starships.getENDPOINT());


    @Test
    public void testPlanet() throws IOException, ParseException {
        System.out.println("1. Test of: Luk's homeworld is Tatooine");
        JsonObject jO = SWapi.parseApiResponseMainEndpoint(UriPeople);
        JsonArray ja = jO.getAsJsonArray("results");

        int arrayInt = SWapi.searchArrayInt(ja, "Luke Skywalker", "name");
        JsonObject jO1 = ja.get(arrayInt).getAsJsonObject();
        String UrlPlanet = SWapi.getValue(jO1, "homeworld");
        String nameOfPlanet = SWapi.getValue
                (SWapi.parseApiResponseMainEndpoint(UrlPlanet), "name");

        Assert.assertEquals("Other name", nameOfPlanet, "Tatooine");
      }


     @Test
    public void testPlanetFilms() throws IOException, ParseException {

         System.out.println("2. Test of: Tatooine is in 5 films");

         JsonObject jO = SWapi.parseApiResponseMainEndpoint(UriPeople);
         JsonArray ja = jO.getAsJsonArray("results");

         int arrayInt = SWapi.searchArrayInt(ja, "Luke Skywalker", "name");
         JsonObject jO1 = ja.get(arrayInt).getAsJsonObject();
         String UrlPlanet = SWapi.getValue(jO1, "homeworld");

         JsonObject jT = SWapi.parseApiResponseMainEndpoint(UrlPlanet);
         JsonArray jaT = jT.getAsJsonArray("films");

         int arraySize = jaT.size();


         Assert.assertEquals("Other size", arraySize, 5);
     }

     @Test
    public void testStarshipsCount() throws IOException, ParseException {
         System.out.println("3. Test of: There are 37 types of starships");

         JsonObject jO = SWapi.parseApiResponseMainEndpoint(UriStarships);
         String count = SWapi.getValue(jO, "count");


         Assert.assertEquals("Other number", count, "37");

     }


}
