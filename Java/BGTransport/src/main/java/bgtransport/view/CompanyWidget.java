package bgtransport.view;

import javax.swing.*;

import bgtransport.controller.MainController;
import bgtransport.controller.NewWindowController;
import bgtransport.controller.ThemeController;
import bgtransport.controller.WebPageController;
import bgtransport.model.ConstantString2;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * WeatherPanel class represents a panel displaying weather-related information,
 * including weather conditions, wind information, and a weather icon.
 */
public class CompanyWidget extends RoundedPanel {

	private static final long serialVersionUID = -3464306536082412512L;
	
	public static JButton atbButton = new JButton();
	public static JButton tebButton = new JButton();
	public static JButton trenordButton = new JButton();
	public static JButton usButton = new JButton();
    
    public final ImageIcon iconatb = new ImageIcon(MenuPanel.class.getResource("/images/ATB.png"));
	public final ImageIcon iconteb = new ImageIcon(MenuPanel.class.getResource("/images/TEB.png"));
	public final ImageIcon icontrenord = new ImageIcon(MenuPanel.class.getResource("/images/Trenord.png"));
	public final ImageIcon iconbgt = new ImageIcon(MenuPanel.class.getResource("/images/Unibg.png"));
    
    public final Point companypanelpoint = new Point(235, 620);
   
    public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();
    
    /**
     * Constructor for WeatherPanel.
     * Sets up the layout and adds weather-related components.
     */
    public CompanyWidget() {
        setLayout(null);
        setupWeatherComponents();
        setupActionListeners();
    }

    /**
     * Sets up the weather-related components.
     */
    private void setupWeatherComponents() {
    	 atbButton.setBounds(20, 15, 150, 100);
    	 atbButton.setBorderPainted(false);
    	 atbButton.setIcon(iconatb);
    	 atbButton.setRolloverEnabled(false);
    	 atbButton.setBackground(new Color(0, 0, 0, 0));
         add(atbButton);    

         tebButton.setBounds(180, 15, 150, 100);
         tebButton.setBorderPainted(false);
         tebButton.setIcon(iconteb);
         tebButton.setRolloverEnabled(false);
         tebButton.setBackground(new Color(0, 0, 0, 0));
         add(tebButton);
         
         trenordButton.setBounds(20, 125, 150, 100);
         trenordButton.setBorderPainted(false);
         trenordButton.setIcon(icontrenord);
         trenordButton.setRolloverEnabled(false);
         trenordButton.setBackground(new Color(0, 0, 0, 0));
         add(trenordButton);

         usButton.setBounds(180, 125, 150, 100);
         usButton.setBorderPainted(false);
         usButton.setIcon(iconbgt);
         usButton.setRolloverEnabled(false);
         usButton.setBackground(new Color(0, 0, 0, 0));
         add(usButton);

        
        for (Component comp : getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
    }
    
    private void setupActionListeners() {
    	atbButton.addActionListener(e -> {
			WebPageController.openWebPage("https://atb.bergamo.it/il-gruppo/societa");
		});

    	tebButton.addActionListener(e -> {
    		WebPageController.openWebPage("https://www.teb.bergamo.it/it/dati-societari");
		});

    	trenordButton.addActionListener(e -> {
    		WebPageController.openWebPage("https://www.trenord.it/chi-siamo/");
		});

    	usButton.addActionListener(e -> {
    		WebPageController.openWebPage("https://github.com/ZanottiMatteo/BGTransports");
		});
	}
}
