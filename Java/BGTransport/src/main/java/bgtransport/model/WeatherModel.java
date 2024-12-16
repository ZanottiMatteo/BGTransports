package bgtransport.model;

import javax.swing.*;

import org.json.JSONObject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

public class WeatherModel {
	
	static int weathercode;
	static int isday = 1;
		
	public static void getMeteo(JLabel label, JLabel label2) throws IOException{
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
            double windspeed = currentWeather.getDouble("windspeed");
            weathercode = currentWeather.getInt("weathercode");
            isday = currentWeather.getInt("is_day");

                label.setText("🌡 " + temperature + "°C");
                label2.setText("💨 " + windspeed + "Km/h");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	

	public static ImageIcon getWeatherIcon() {
        String code = Integer.toString(weathercode);
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
            String imageUrl = (isday == 1) ? dayImage : nightImage;
			
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);

            // Check the HTTP response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Get the image stream
                InputStream inputStream = connection.getInputStream();
                BufferedImage image = ImageIO.read(inputStream);
                inputStream.close();
                return new ImageIcon(image);
            } else System.out.println("error");
            


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}   
}


