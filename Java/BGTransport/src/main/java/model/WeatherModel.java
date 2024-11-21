package model;

import javax.swing.*;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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
	
	static int weathercode;
	static int isday;
	
	public static void getMeteo() throws IOException{
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=45.7&longitude=9.67&current_weather=true";
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();
            String response = content.toString();           
            JSONObject json = new JSONObject(response);
            JSONObject currentWeather = json.getJSONObject("current_weather");
            weathercode = currentWeather.getInt("weathercode");
            isday = currentWeather.getInt("is_day");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void getMeteo(JLabel label) throws IOException{
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=45.7&longitude=9.67&current_weather=true";
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();
            String response = content.toString();
            
            JSONObject json = new JSONObject(response);

            JSONObject currentWeather = json.getJSONObject("current_weather");
            double temperature = currentWeather.getDouble("temperature");
            weathercode = currentWeather.getInt("weathercode");
            isday = currentWeather.getInt("is_day");

                label.setText("Temperatura: " + temperature + "°C");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@SuppressWarnings("deprecation")
	public static ImageIcon getWeatherIcon() {
		String iconPath;
        String code = Integer.toString(weathercode);
        System.out.println(code);
        try (FileReader openJSON = new FileReader("json/weather_images.json")) {
        	 StringBuilder sb = new StringBuilder();
             int c;
             while ((c = openJSON.read()) != -1) {
                 sb.append((char) c);
             }
            JSONObject root = new JSONObject(sb.toString());

            JSONObject weatherCode = root.getJSONObject(code);
            

            String dayImage = weatherCode.getJSONObject("day").getString("image");
            String nightImage = weatherCode.getJSONObject("night").getString("image");
            String imageUrl;
			if (isday == 1) {
			      imageUrl = dayImage;
            } else {
            	  imageUrl = nightImage;
            }
			
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Check the HTTP response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Get the image stream
                InputStream inputStream = connection.getInputStream();
                BufferedImage image = ImageIO.read(inputStream);
                image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                inputStream.close();
                return new ImageIcon(image);
            } else System.out.println("error");
            


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}   
}


