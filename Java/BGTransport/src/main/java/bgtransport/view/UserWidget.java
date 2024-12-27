package bgtransport.view;

import javax.swing.*;

import bgtransport.controller.AccountController;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * WeatherPanel class represents a panel displaying weather-related information,
 * including weather conditions, wind information, and a weather icon.
 */
public class UserWidget extends RoundedPanel {

	private static final long serialVersionUID = -8199651767909840164L;
	public final Point userpanelpoint = new Point(235, 270);
    public static CircleLabel accounticon = new CircleLabel();
    public static LittleLabel usernamelabel = new LittleLabel();
    public static LittleLabel complnamelabel = new LittleLabel();
    public static LittleLabel emaillabel = new LittleLabel();
    public static JLabel errorlabel = new JLabel("Effettua il Login");
    public static JLabel titlelabel = new JLabel("Dati Utente");
    public static ImageIcon image = new ImageIcon(UserWidget.class.getResource("/images/Addimage.png"));
    public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();

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
    	usernamelabel.setHorizontalAlignment(SwingConstants.LEFT);
    	usernamelabel.setVisible(false);
		complnamelabel.setHorizontalAlignment(SwingConstants.LEFT);
		complnamelabel.setVisible(false);
		emaillabel.setHorizontalAlignment(SwingConstants.LEFT);
		emaillabel.setVisible(false);
    	
    	accounticon.setVisible(false);
    	titlelabel.setForeground(new Color(210, 105, 30));
    	titlelabel.setVisible(false);
    	titlelabel.setBounds(20, 25, 185, 34);
    	
    	add(titlelabel);
    	accounticon.setBounds(212, 25, 128, 128);
    	accounticon.setCircleColor(Color.GRAY);
        add(accounticon);

        usernamelabel.setBounds(20, 70, 175, 50);
        add(usernamelabel);

        complnamelabel.setBounds(20, 130, 175, 50);
        add(complnamelabel);

        emaillabel.setBounds(20, 190, 300, 50);
        add(emaillabel);
        
        errorlabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorlabel.setBounds(10, 11, 330, 228);  
        add(errorlabel);

        
        for (Component comp : getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
    }
}
