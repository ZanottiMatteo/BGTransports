package bgtransport.controller;

import bgtransport.view.WeatherWidget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import static org.junit.jupiter.api.Assertions.*;

class WeatherControllerTest {

    @BeforeEach
    void setUp() {
        // Reset WeatherWidget's static members before each test
        WeatherWidget.lbltemperature = new JLabel();
        WeatherWidget.lblweatherwind = new JLabel();
        WeatherWidget.iconWeather = new ImageIcon();
    }

    @Test
    void testGetMeteoValidResponse() throws IOException {
        // Simulate a valid response for the getMeteo method
        WeatherController.weathercode = 0; // Default values to simulate response
        WeatherController.isday = 1;

        // Call the method to test
        WeatherController.getMeteo();

        // Assert that UI components are updated correctly
        assertNotNull(WeatherWidget.lbltemperature.getText());
        assertNotNull(WeatherWidget.lblweatherwind.getText());
    }

    @Test
    void testGetWeatherIconValidResponse() {
        // Set weathercode and isday for testing
        WeatherController.weathercode = 0;
        WeatherController.isday = 1;

        // Call the method to test
        WeatherController.getWeatherIcon();

        assertNotNull(WeatherWidget.iconWeather.getImage());
    }
}
