package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Point;

import controller.MainController;
import controller.MapController;
import controller.NewWindowController;
import controller.ThemeController;
import model.ResizableImage;

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
	public MenuPanel menuPanel = new MenuPanel();

	public JButton busButton;
	public JButton trainButton;
	public JButton funicularButton;
	public JButton tramButton;
	
	// Main content panel with rounded corners.
	public RoundedPanel homePanel = new RoundedPanel();
	// Position of the map panel within the layout.
	public final Point mappoint = new Point(100, 50);

	// Container panel for the map, designed with rounded corners. 
	public static RoundedPanel externmapPanel = new RoundedPanel();
	// Position of the external map panel within the layout.
	public final Point mappanelpoint = new Point(200, 30);

	// Resizable background wallpaper that adjusts to the screen size.
	public final transient ResizableImage lblBGwallpaper = new ResizableImage(new File("src/main/resources/images/BG.png"));

	// Icons for the user and map buttons.
	public ImageIcon iconUser = new ImageIcon(MapView.class.getResource("/images/User.png")); // Icon for the user button.
	public ImageIcon iconMap = new ImageIcon(MapView.class.getResource("/images/Map.png"));   // Icon for the map button.
	public ImageIcon iconHome = new ImageIcon(MapView.class.getResource("/images/Home.png"));
	public ImageIcon iconBus = new ImageIcon(MapView.class.getResource("/images/Bus.png"));
	public ImageIcon iconTrain = new ImageIcon(MapView.class.getResource("/images/Train.png"));
	public ImageIcon iconTram = new ImageIcon(MapView.class.getResource("/images/Tram.png"));
	public ImageIcon iconFunicular = new ImageIcon(MapView.class.getResource("/images/Funicular.png"));


	// A map to store the bounds (dimensions and positions) of each component for resizing purposes.
	public transient Map<Component, Rectangle> componentBounds = new HashMap<>();

	// Original size of the application window when maximized.
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	// Fixed size of the menu panel.
	public final Dimension menuPanelSize = new Dimension(100, 900);
	// Minimum size of the application window to prevent it from being resized too small.
	public final Dimension minPanelSize = new Dimension(1085, 615);
	// Size of the panel containing the map.
	public final Dimension mapPanelSize = new Dimension(1600, 900);
	// Default size of the map itself within the map panel.
	public final Dimension mapSize = new Dimension(1450, 800);

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

        setupComponentArcs();
        setupMainPanel();
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
        setMinimumSize(minPanelSize); // Set minimum window size
        setTitle("BGTransport"); // Set window title
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
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
        homePanel.add(menuPanel);
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
        
        busButton = createIconButton(iconBus, 20, 300);
        externmapPanel.add(busButton);
        trainButton = createIconButton(iconTrain, 20, 380);
        externmapPanel.add(trainButton);
        funicularButton = createIconButton(iconFunicular, 20, 460);
        externmapPanel.add(funicularButton);
        tramButton = createIconButton(iconTram, 20, 540);
        externmapPanel.add(tramButton);
        homePanel.add(externmapPanel);
    }

    /**
     * Adds action listeners to buttons for handling user interactions.
     */
    private void setupActionListeners() {
        // Action listener for the user button
    	menuPanel.userButton.addActionListener(e -> {
			NewWindowController.choseUserLogin(MainController.userV, MainController.loginV);
			this.setVisible(false);
		});

		// Action listener for the home button
    	menuPanel.homeButton.addActionListener(e -> {
			NewWindowController.openHomePanel(MainController.homeV);
			setVisible(false);
		});
    	
    	menuPanel.lineButton.addActionListener(e -> {
			NewWindowController.openLinePanel(MainController.lineV);
			setVisible(false);
		});
    	
    	menuPanel.databaseButton.addActionListener(e -> {
			NewWindowController.openDatabasePanel(MainController.databaseV);
			setVisible(false);
		});
		
        // Action listener for the theme switch button
        busButton.addActionListener(e -> {
			try {
				MapController.showBus();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
        
        // Action listener for the theme switch button
        trainButton.addActionListener(e -> {
			try {
				MapController.showTrain();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
        
        // Action listener for the theme switch button
        funicularButton.addActionListener(e -> {
			try {
				MapController.showFunicular();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
        
        // Action listener for the theme switch button
        tramButton.addActionListener(e -> {
			try {
				MapController.showTram();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

        // Action listener for the theme switch button
        menuPanel.switchThemeButton.addActionListener(e -> ThemeController.updateThemes());
        
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
        for (Component comp : externmapPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
    }
}

