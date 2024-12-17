package bgtransport.view;

import javax.swing.*;

import bgtransport.controller.WeatherController;
import bgtransport.model.ConstantString;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * WeatherPanel class represents a panel displaying weather-related information,
 * including weather conditions, wind information, and a weather icon.
 */
public class WeatherWidget extends RoundedPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3464306536082412512L;
	public JLabel lblweather = new JLabel();
    public JLabel lblweatherwind = new JLabel();
    private JLabel lblweathertxt = new JLabel("🏠 Bergamo");
    public CircleLabel lblweatherimg = new CircleLabel("");
    public final Point weatherpanelpoint = new Point(1450, 270);
    public ImageIcon iconWeather;
    
    public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();
    /**
     * Constructor for WeatherPanel.
     * Sets up the layout and adds weather-related components.
     */
    public WeatherWidget() {
        setLayout(null);
        setupWeatherComponents();
    }

    /**
     * Sets up the weather-related components.
     */
    private void setupWeatherComponents() {
    	iconWeather = WeatherController.getWeatherIcon();
    	
        lblweather.setHorizontalAlignment(SwingConstants.LEFT);
        lblweather.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, 70));
        lblweather.setBounds(140, 170, 200, 50);

        lblweatherwind.setHorizontalAlignment(SwingConstants.LEFT);
        lblweatherwind.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, 70));
        lblweatherwind.setBounds(140, 100, 200, 50);

        lblweatherimg.setVerticalAlignment(SwingConstants.CENTER);
        lblweatherimg.setHorizontalAlignment(SwingConstants.CENTER);
        lblweatherimg.setLocation(25, 75);
        lblweatherimg.setSize(100, 100);
        lblweatherimg.setCircleColor(new Color(76, 170, 252));

        lblweathertxt.setHorizontalAlignment(SwingConstants.LEFT);
        lblweathertxt.setForeground(new Color(210, 105, 30));
        lblweathertxt.setBounds(140, 30, 200, 50);

        try {
            WeatherController.getMeteo(lblweather, lblweatherwind);
            lblweatherimg.setIcon(iconWeather);
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(lblweather);
        add(lblweatherwind);
        add(lblweathertxt);
        add(lblweatherimg);
        
        for (Component comp : getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
    }
}
