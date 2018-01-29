package com.Homework.statements;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Planets implements Serializable {
    public String ENDPOINT="planets";

    @SerializedName("name")
    private String name;

    @SerializedName("population")
    private String population;

    @SerializedName("rotation_period")
    private String rotation_period;

    @SerializedName("orbital_period")
    private String orbital_period;

    @SerializedName("diameter")
    private String diameter;

    @SerializedName("url")
    private String url;

    @SerializedName("films")
    private ArrayList<String> films;

    @SerializedName("residents")
    private ArrayList<String> residents;

    public void setENDPOINT(String ENDPOINT) {
        this.ENDPOINT = ENDPOINT;
    }

    public String getENDPOINT() {
        return this.ENDPOINT;
    }

}
