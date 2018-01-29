package com.Homework.interfaces;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static org.hamcrest.Matchers.containsString;

public class RestAssuredClientNo {


    Response response = RestAssured.given()
            .log().all()
            .baseUri("http://localhost:8080")
            .expect()
            .statusCode(200)
            .when()
            .get("/CalculatorServlet");




    public int getStatus (){
        return response.getStatusCode();
           }


    public void printLog () {
        response.getBody().print();
        response.body().print();
        response.contentType();

    }

    public int getStatusPost (String Expression){


        Response response2 =         RestAssured.given()
                .baseUri("http://localhost:8080")
                .formParam("INPUT", Expression)
                .expect()
                .when()
                .post("/CalculatorServlet/CalcServlet");
                return response2.getStatusCode();

    }


    public void printLogPost(String initialExpression, String actual) {
        Response response2 =         RestAssured.given()
                .baseUri("http://localhost:8080")
                .formParam("INPUT", initialExpression)
                .expect()
                .body(containsString(actual))
                .when()
                .post("/CalculatorServlet/CalcServlet");

        response2.getBody().print();



    }

}
