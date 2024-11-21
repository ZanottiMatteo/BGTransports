package view;

import javax.swing.*;
import javax.swing.border.Border;

import org.jxmapviewer.JXMapViewer;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;

import controller.MainController;
import controller.MapController;
import controller.NewWindowController;
import controller.ResizeController;
import controller.ThemeController;
import model.WeatherModel;
import view.RoundedPanel;
import java.awt.Font;

/**
 * HomeView class represents the main view of the application, displaying a
 * background image, theme switching button, and user-related components. It
 * provides an interface for the user to interact with the main functionality of
 * the application.
 */
public class MapView extends JFrame {

	public JPanel mainPanel = new JPanel();

	public RoundedPanel menuPanel = new RoundedPanel();
	public final Point menupanelpoint = new Point(15, 30);
	public JButton switchThemeButton;
	public JButton userButton;
	public JButton mapButton;

	public RoundedPanel homePanel = new RoundedPanel();
	public JXMapViewer mapPanel = new JXMapViewer();
	public final Point mappoint = new Point(50, 50);
	
	public RoundedPanel externmapPanel = new RoundedPanel();
	public final Point mappanelpoint = new Point(200, 30);
	// Background wallpaper (image that adjusts to screen size).
	public ResizableImage lblBGwallpaper = new ResizableImage(LoginView.class.getResource("/images/BG.png"));

	// Icon for the user button.
	public ImageIcon iconUser = new ImageIcon(MapView.class.getResource("/images/User.png"));
	public ImageIcon iconMap = new ImageIcon(MapView.class.getResource("/images/Map.png"));

	// Map for storing the bounds of each component (used for resizing).
	public Map<Component, Rectangle> componentBounds = new HashMap<>();

	// Original and minimum size for the window.
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension MenuPanelSize = new Dimension(100, 900);
	public final Dimension MinPanelSize = new Dimension(1085, 615);
	public final Dimension MapPanelSize = new Dimension(1600, 900);
	public final Dimension MapSize = new Dimension(1500, 800);
	/**
     * Constructor that sets up the UI components, layout, and theming for the home view.
     * It also initializes the main panel, menu panel, and other UI elements.
     */
    public MapView(){
        // Set the window to be maximized on launch.
        setExtendedState(Frame.MAXIMIZED_BOTH);
        
        // Set the minimum size for the window to prevent resizing below this threshold.
        setMinimumSize(MinPanelSize);
        
        // Set the main panel and override its paintComponent method to draw the background image.
        mainPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this);  // Draw background image
            }
        };
        System.out.println("map:" + ThemeController.getTheme());
        // Apply the selected theme (Light or Dark).
        if (ThemeController.getTheme()) {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());  // Set light theme
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        } else {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());  // Set dark theme
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        }

        
        // Set rounded corner UI properties.
        UIManager.put("Button.arc", 999);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("Component.arc", 15);
        
        // Set the layout for the content pane.
        getContentPane().setLayout(null);
        
        // Initialize and configure the main panel.
        mainPanel.setBounds(0, 0, 1920, 1041);      
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);
        
        // Create and configure a rounded panel for the main content area.
        homePanel.setLayout(null);
        homePanel.setOpaque(true);
         
        homePanel.setBounds(26, 40, 1854, 960);
        mainPanel.add(homePanel);
        
        // Create and configure a menu panel for user options.
       
        menuPanel.setBounds(15, 30, 100, 900);       
        menuPanel.setBackground(new Color(210, 105, 30));  
        menuPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        menuPanel.setLayout(null);
        homePanel.add(menuPanel);
        
        // Create and configure the user button (with user icon).
        userButton = new JButton();
        userButton.setBounds(20, 20, 60, 60);
        userButton.setRolloverEnabled(false);  
        userButton.setBorderPainted(false);   // Remove border.
        userButton.setIcon(iconUser);         // Set the icon.
        userButton.setBackground(new Color(0, 0, 0, 0));  // Transparent background.
        userButton.addActionListener(e -> {
        	NewWindowController.openLoginPanel(MainController.loginV);
        	this.setVisible(false);
        });
        menuPanel.add(userButton);
        
        mapButton = new JButton();
        mapButton.setBounds(20, 150, 60, 60);
        mapButton.setRolloverEnabled(false);  
        mapButton.setBorderPainted(false);   // Remove border.
        mapButton.setIcon(iconUser);         // Set the icon.
        mapButton.setBackground(new Color(0, 0, 0, 0));  // Transparent background.
        mapButton.addActionListener(e -> {
        	NewWindowController.openMapPanel(MainController.mapV);
        	this.setVisible(false);
        });
        menuPanel.add(mapButton);
        
        // Create and configure the theme switch button.
        switchThemeButton = new JButton();
        switchThemeButton.setBounds(20, 830, 60, 60);       
        switchThemeButton.setBackground(new Color(0, 0, 0, 0));  
        switchThemeButton.setIcon(new ImageIcon(MapView.class.getResource("/images/LDMode.png"))); 
        switchThemeButton.setForeground(new Color(230, 230, 250)); 
        switchThemeButton.setRolloverEnabled(false); 
        switchThemeButton.setBorderPainted(false);
        menuPanel.add(switchThemeButton);
        
        switchThemeButton.addActionListener(e -> ThemeController.updateThemes(MainController.homeV, MainController.mapV, MainController.loginV,
				MainController.signupV));
        
        mapPanel = MapController.generateMap();
        mapPanel.setBounds(50, 50, 1500, 800);
        externmapPanel.setBounds(200, 30, 1600, 900);
        externmapPanel.add(mapPanel);
        homePanel.add(externmapPanel);
        externmapPanel.setLayout(null);
        
        
        // Store the bounds of each component for possible future resizing.
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        
        for (Component comp : menuPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }        
        // Initialize other components like the title and default window behavior.
        initComponents();
    }

	/**
	 * Initializes the window settings such as title, size, close operation, and
	 * positioning.
	 */
	private void initComponents() {
		setTitle("BGTransport"); // Set the window title.
		setSize(1920, 1080); // Set the initial size of the window.

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed.
		SwingUtilities.updateComponentTreeUI(this); // Update the UI components after changes.
		setLocationRelativeTo(null); // Center the window on the screen.
	}
}
