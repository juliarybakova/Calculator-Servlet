package com.Homework.interfaces;

import com.Homework.CalcData;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;

public final class HttpComponClient implements CalcApi{


    @Override
    public void getResult(String e, String r) {
        CloseableHttpClient client =  HttpClientBuilder.create().build();
        HttpUriRequest request = new HttpGet(URI.create("http://localhost:8080/CalculatorServlet/CalcServlet"));
        try {
            CloseableHttpResponse response = client.execute(request);
            final int responseCode = response. getStatusLine().getStatusCode();


        }
        catch (IOException exc) {
            exc.printStackTrace();


                               }
    }

    @Override
    public CalcData postExpression(String e) {
        return null;
    }

    @Override
    public void doPost(String e) {

    }
 }

