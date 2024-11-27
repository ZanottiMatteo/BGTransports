package view;

import javax.swing.*;
import javax.swing.border.Border;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.GeoPosition;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	// Main container panel for the application.
	public JPanel mainPanel = new JPanel();

	// Side menu panel with rounded corners.
	public RoundedPanel menuPanel = new RoundedPanel();
	// Position of the menu panel within the main layout.
	public final Point menupanelpoint = new Point(15, 30);

	// Buttons for user interaction and navigation.
	public JButton switchThemeButton; // Button to toggle between light and dark themes.
	public JButton userButton;        // Button to navigate to the user menu.
	public JButton mapButton;         // Button to navigate to the map view.

	// Main content panel with rounded corners.
	public RoundedPanel homePanel = new RoundedPanel();
	// Position of the map panel within the layout.
	public final Point mappoint = new Point(50, 50);

	// Container panel for the map, designed with rounded corners. 
	public static RoundedPanel externmapPanel = new RoundedPanel();
	// Position of the external map panel within the layout.
	public final Point mappanelpoint = new Point(200, 30);

	// Resizable background wallpaper that adjusts to the screen size.
	public ResizableImage lblBGwallpaper = new ResizableImage(LoginView.class.getResource("/images/BG.png"));

	// Icons for the user and map buttons.
	public ImageIcon iconUser = new ImageIcon(MapView.class.getResource("/images/User.png")); // Icon for the user button.
	public ImageIcon iconMap = new ImageIcon(MapView.class.getResource("/images/Map.png"));   // Icon for the map button.

	// A map to store the bounds (dimensions and positions) of each component for resizing purposes.
	public Map<Component, Rectangle> componentBounds = new HashMap<>();

	// Original size of the application window when maximized.
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	// Fixed size of the menu panel.
	public final Dimension MenuPanelSize = new Dimension(100, 900);
	// Minimum size of the application window to prevent it from being resized too small.
	public final Dimension MinPanelSize = new Dimension(1085, 615);
	// Size of the panel containing the map.
	public final Dimension MapPanelSize = new Dimension(1600, 900);
	// Default size of the map itself within the map panel.
	public final Dimension MapSize = new Dimension(1500, 800);

	/**
     * Constructor that sets up the UI components, layout, and theming for the home view.
     * It also initializes the main panel, menu panel, and other UI elements.
     */
	/**
     * Constructor initializes the MapView window, setting up UI components and behavior.
     */
    public MapView() {
        // Configure the main window
        configureWindow();

        // Initialize components
        initializeTheme();
        setupComponentArcs();
        setupMainPanel();
        setupMenuPanel();
        setupMapPanel();
        setupActionListeners();
        
        // Store bounds for resizing
        storeComponentBounds();
    }

    /**
     * Configures the main window properties.
     */
    private void configureWindow() {
        setExtendedState(Frame.MAXIMIZED_BOTH); // Maximize the window at startup
        setMinimumSize(MinPanelSize); // Set minimum window size
        setTitle("BGTransport"); // Set window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
    }

    /**
     * Configures the theme for the application.
     */
    private void initializeTheme() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); // Set light theme
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets rounded UI properties for components.
     */
    private void setupComponentArcs() {
        UIManager.put("Button.arc", 999); // Fully rounded buttons
        UIManager.put("TextComponent.arc", 15); // Slightly rounded text components
        UIManager.put("Component.arc", 15); // Rounded corners for general components
    }

    /**
     * Sets up the main panel and background.
     */
    private void setupMainPanel() {
        // Override the paintComponent method to draw the background image
        mainPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this); // Draw background image
            }
        };

        mainPanel.setBounds(0, 0, 1920, 1080);
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);

        // Configure the home panel
        homePanel.setLayout(null);
        homePanel.setBounds(26, 40, 1854, 960);
        mainPanel.add(homePanel);
    }

    /**
     * Sets up the side menu panel and its components.
     */
    private void setupMenuPanel() {
        // Configure the menu panel
        menuPanel.setBounds(15, 30, 100, 900);
        menuPanel.setBackground(new Color(210, 105, 30));
        menuPanel.setLayout(null);
        homePanel.add(menuPanel);

        // Add user button
        userButton = createIconButton(iconUser, 20, 20);
        menuPanel.add(userButton);

        // Add map button
        mapButton = createIconButton(iconMap, 20, 150);
        menuPanel.add(mapButton);

        // Add theme switch button
        switchThemeButton = createIconButton(new ImageIcon(MapView.class.getResource("/images/LDMode.png")), 20, 830);
        menuPanel.add(switchThemeButton);
    }

    /**
     * Creates a JButton with an icon and specific dimensions.
     */
    private JButton createIconButton(ImageIcon icon, int x, int y) {
        JButton button = new JButton();
        button.setBounds(x, y, 60, 60);
        button.setRolloverEnabled(false);
        button.setBorderPainted(false); // Remove border
        button.setIcon(icon); // Set the icon
        button.setBackground(new Color(0, 0, 0, 0)); // Transparent background
        return button;
    }
    
    /**
     * Sets up the map panel and its container.
     */
    private void setupMapPanel() {
        // Configure the map panel
        externmapPanel.setBounds(200, 30, 1600, 900);
        externmapPanel.setLayout(null);
        homePanel.add(externmapPanel);
    }

    /**
     * Adds action listeners to buttons for handling user interactions.
     */
    private void setupActionListeners() {
        // Action listener for the user button
        userButton.addActionListener(e -> {
            NewWindowController.openLoginPanel(MainController.loginV);
            this.setVisible(false);
        });

        // Action listener for the map button
        mapButton.addActionListener(e -> {
            NewWindowController.openMapPanel(MainController.mapV);
            this.setVisible(false);
        });

        // Action listener for the theme switch button
        switchThemeButton.addActionListener(e -> ThemeController.updateThemes());
    }

    /**
     * Stores the bounds of each component for resizing purposes.
     */
    private void storeComponentBounds() {
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        for (Component comp : menuPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
    }
}

