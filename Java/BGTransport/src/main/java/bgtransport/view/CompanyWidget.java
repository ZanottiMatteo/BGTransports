package bgtransport.view;

import javax.swing.*;

import bgtransport.controller.WebPageController;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * CompanyWidget is a panel that displays buttons representing different companies,
 * each with an associated logo and link to their respective web pages.
 */
public class CompanyWidget extends RoundedPanel {

	private static final long serialVersionUID = -3464306536082412512L;
	
	/** Button for ATB company information. */
	public static JButton atbButton = new JButton();
	
	/** Button for TEB company information. */
	public static JButton tebButton = new JButton();
	
	/** Button for Trenord company information. */
	public static JButton trenordButton = new JButton();
	
	/** Button for University of Bergamo (Unibg) information. */
	public static JButton usButton = new JButton();
    
    /** Icon for ATB company. */
    public final ImageIcon iconatb = new ImageIcon(MenuPanel.class.getResource("/images/ATB.png"));
    
    /** Icon for TEB company. */
	public final ImageIcon iconteb = new ImageIcon(MenuPanel.class.getResource("/images/TEB.png"));
	
	/** Icon for Trenord company. */
	public final ImageIcon icontrenord = new ImageIcon(MenuPanel.class.getResource("/images/Trenord.png"));
	
	/** Icon for University of Bergamo (Unibg). */
	public final ImageIcon iconbgt = new ImageIcon(MenuPanel.class.getResource("/images/Unibg.png"));
    
    /** Default position for the company panel. */
    public final Point companypanelpoint = new Point(235, 620);
   
    /** Map to store the bounds of components within the panel. */
    public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();
    
    /**
     * Constructor for CompanyWidget.
     * Initializes the layout and adds components for displaying company-related buttons.
     */
    public CompanyWidget() {
        setLayout(null);
        setupWeatherComponents();
        setupActionListeners();
    }

    /**
     * Sets up the components for the company buttons and their respective layouts.
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

        // Store the bounds of each component in the panel
        for (Component comp : getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
    }
    
    /**
     * Sets up action listeners for the company buttons to open respective web pages.
     */
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
