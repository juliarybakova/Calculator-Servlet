package com.Homework.statements;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Starships implements Serializable {

    public String ENDPOINT="starships";

    @SerializedName("name")
    private String name;

    @SerializedName("birth_year")
    private String birth_year;

    @SerializedName("eye_color")
    private String eye_color;

    @SerializedName("gender")
    private String gender;

    @SerializedName("homeworld")
    private String homeworld;

    @SerializedName("url")
    private String url;

    @SerializedName("films")
    private ArrayList<String> films;

    @SerializedName("starships")
    private ArrayList<String> starships;

    public void setENDPOINT(String ENDPOINT) {
        this.ENDPOINT = ENDPOINT;
    }

    public String getENDPOINT() {
        return this.ENDPOINT;
    }
}
