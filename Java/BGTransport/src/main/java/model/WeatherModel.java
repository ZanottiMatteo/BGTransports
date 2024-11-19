package model;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.imageio.ImageIO;

public class WeatherModel {
	private static final String BASE_URL = "https://wttr.in/";

    public static void getMeteo(JLabel label) throws IOException {
    	
    	String temp;
    	String weatherDesc;
        String city = "Bergamo";
        String url = BASE_URL + city + "?format=j1";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Errore nella chiamata API: " + response);
            }

            // Parsing della risposta JSON
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.body().string());

            JsonNode currentCondition = rootNode.get("current_condition").get(0);
            temp = currentCondition.get("temp_C").asText(); // Temperatura in °C
            weatherDesc = currentCondition.get("weatherDesc").get(0).get("value").asText(); // Descrizione meteo       
        } 
        label.setText("Meteo Bergamo: " + weatherDesc + " Temperatura: " + temp + " °C");
    }
}
