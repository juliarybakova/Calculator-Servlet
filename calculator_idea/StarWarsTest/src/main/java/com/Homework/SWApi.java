package com.Homework;

import com.Homework.statements.People;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

public class SWApi {

    private Properties properties;

    public SWApi() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public  String getServerHost () {
        return properties.getProperty("host", "localhost");
    }

    public int getServerPort () {
        return Integer.parseInt(properties.getProperty("port", "8080"));

    }
    public String getPathUrl (String path) {
        return new StringBuilder().append(properties.getProperty("scheme"))
                .append("://")
                .append(properties.getProperty("host"))
                .append("/")
                .append(path)
                .toString();
    }


public JsonObject parseApiResponseMainEndpoint(String Uri) throws IOException, ParseException {

    String json = ClientBuilder
            .newClient()
            .target(Uri)
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .get(String.class);


    JSONParser jsonParser = new JSONParser();
    JsonObject jO = new JsonParser().parse(json).getAsJsonObject();;

    return jO;

}

public String getValue(JsonObject j, String value) throws IOException, ParseException {
        return j.get(value).toString().replaceAll("\"", "");
}

public JsonArray getJsonArray (JsonObject j, String value) throws IOException, ParseException {
        return j.getAsJsonArray(value);
        }

public int searchArrayInt (JsonArray ja, String value, String key)   throws IOException, ParseException {

        int INT = 0;

        for (int i=0; i<ja.size(); i++) {
            JsonObject Ji = ja.get(i).getAsJsonObject();
            if (Ji.get(key).toString()==value) {
                INT=i;
                break;
            }
    }
    return INT;

}




    public static void main(String[] args) {
        SWApi propertiesProvider = new SWApi();
        People Luk = new People();
        System.out.println(Luk.getENDPOINT());
        System.out.println(propertiesProvider.getPathUrl(Luk.getENDPOINT()));
    }





}
