package view;

import javax.swing.*;

import controller.LoginController;
import controller.UserInfoController;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.WeatherModel;

/**
 * WeatherPanel class represents a panel displaying weather-related information,
 * including weather conditions, wind information, and a weather icon.
 */
public class UserWidget extends RoundedPanel {

	
    public final Point userpanelpoint = new Point(700, 30);
    public static CircleLabel accounticon = new CircleLabel();
    public static LittleLabel usernamelabel = new LittleLabel();
    public static LittleLabel complnamelabel = new LittleLabel();
    public static LittleLabel emaillabel = new LittleLabel();
    public static JLabel errorlabel = new JLabel("Effettua il Login");
    public static MediumLabel titlelabel = new MediumLabel("Dati Utente");
    
    public Map<Component, Rectangle> componentBounds = new HashMap<>();

    /**
     * Constructor for WeatherPanel.
     * Sets up the layout and adds weather-related components.
     */
    public UserWidget() {
        setLayout(null);
        setBounds(235, 30, 350, 250);
        setupUserComponents();
    }

    /**
     * Sets up the user-related components.
     */
    private void setupUserComponents() {
    	titlelabel.setForeground(new Color(210, 105, 30));
    	titlelabel.setVisible(false);
    	usernamelabel.setHorizontalAlignment(SwingConstants.RIGHT);
    	usernamelabel.setVisible(false);
		complnamelabel.setHorizontalAlignment(SwingConstants.RIGHT);
		complnamelabel.setVisible(false);
		emaillabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emaillabel.setVisible(false);
    	
    	accounticon.setVisible(false);
    	accounticon.setBounds(25, 25, 128, 128); // Circular placeholder
    	accounticon.setCircleColor(Color.GRAY);
        add(accounticon);

        usernamelabel.setBounds(157, 70, 176, 49);
        add(usernamelabel);
        

        complnamelabel.setBounds(157, 130, 176, 49);
        add(complnamelabel);
        

        emaillabel.setBounds(35, 190, 298, 49);
        add(emaillabel);
        
        errorlabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorlabel.setBounds(10, 11, 330, 228);  
        add(errorlabel);
        titlelabel.setBounds(164, 25, 158, 34);
        
        add(titlelabel);

        
        for (Component comp : getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
    }
}
