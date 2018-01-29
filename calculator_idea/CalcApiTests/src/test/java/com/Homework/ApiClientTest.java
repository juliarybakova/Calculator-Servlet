package com.Homework;

import com.Homework.interfaces.RestAssuredClientNo;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

public class ApiClientTest {
    final String initialExpression =  "15*5";
    final String expected = "75";

    @Test
    public void restAssuredClientTest() {

        RestAssuredClientNo apiClientNo = new RestAssuredClientNo();

        System.out.println("TEST 1 = GET QUERY - STATUS CODE");
        System.out.println("StatusCode= "+ apiClientNo.getStatus());
        System.out.println("TEST 2 = GET QUERY - LOG");
        apiClientNo.printLog();

        System.out.println("TEST 3 = POST QUERY - STATUS CODE");
        System.out.println("StatusCode= "+ apiClientNo.getStatusPost(initialExpression));
        System.out.println("TEST 4 = POST QUERY - LOG");
        apiClientNo.printLogPost(initialExpression, expected);
    }

    @Test
    public void httpClientTest () {

        CloseableHttpClient client =  HttpClientBuilder.create().build();
        HttpUriRequest request = new HttpGet(URI.create("http://localhost:8080/CalculatorServlet/CalcServlet"));
        try {
            CloseableHttpResponse response = client.execute(request);
            final int responseCode = response. getStatusLine().getStatusCode();


        }
        catch (IOException e) {
            e.printStackTrace();

        }





    }





}
