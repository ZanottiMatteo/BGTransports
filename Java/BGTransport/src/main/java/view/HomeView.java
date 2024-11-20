package view;

import javax.swing.*;
import javax.swing.border.Border;
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
import controller.MainController;
import controller.NewWindowController;
import controller.ResizeController;
import controller.ThemeController;
import model.WeatherModel;
import view.RoundedPanel;
import java.awt.Font;

/**
 * HomeView class represents the main view of the application, displaying a background image, 
 * theme switching button, and user-related components. It provides an interface for the user 
 * to interact with the main functionality of the application.
 */
public class HomeView extends JFrame {
	
	public JPanel mainPanel = new JPanel();  
	
	public RoundedPanel menuPanel = new RoundedPanel();
	public JButton switchThemeButton;
    public JButton userButton;
    
    public RoundedPanel homePanel = new RoundedPanel();
    public RoundedPanel weatherPanel = new RoundedPanel();
    public JLabel lblweather = new JLabel();
    public JLabel lblweatherimg = new JLabel();
    public JLabel lblweathertxt = new JLabel("Meteo di Bergamo");
    
    
    // Background wallpaper (image that adjusts to screen size).
    public ResizableImage lblBGwallpaper = new ResizableImage(LoginView.class.getResource("/images/BG.png")); 
    
    // Icon for the user button.
    public ImageIcon iconUser = new ImageIcon(HomeView.class.getResource("/images/User.png"));
    
    // Map for storing the bounds of each component (used for resizing).
    public Map<Component, Rectangle> componentBounds = new HashMap<>();
    
    // Original and minimum size for the window.
    //public final Dimension originalPanelSize = new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
    public final Dimension originalPanelSize = new Dimension(1920, 1080);
    public final Dimension MenuPanelSize = new Dimension(100, 900);
    public final Dimension WeatherPanelSize = new Dimension(350, 250);
    public final Dimension MinPanelSize = new Dimension(1085, 615);

    /**
     * Constructor that sets up the UI components, layout, and theming for the home view.
     * It also initializes the main panel, menu panel, and other UI elements.
     */
    public HomeView(){
        System.out.println(originalPanelSize);
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
        
        // Update the component tree UI with the selected theme.
        SwingUtilities.updateComponentTreeUI(this);
        
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
        lblweather.setHorizontalAlignment(SwingConstants.CENTER);

        
        lblweather.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblweather.setBounds(40,60,270,50);
        
        try {
			WeatherModel.getMeteo(lblweather);
			WeatherModel.getWeatherIcon(lblweatherimg);
		} catch (IOException e) {
			e.printStackTrace();
		}

		weatherPanel.setLayout(null);
        weatherPanel.setLocation(235, 30);
        weatherPanel.setSize(350, 250);
        weatherPanel.add(lblweather);
        lblweatherimg.setHorizontalAlignment(SwingConstants.CENTER);
        lblweatherimg.setLocation(105, 100);
        lblweatherimg.setSize(125, 125);
        lblweathertxt.setHorizontalAlignment(SwingConstants.CENTER);
        lblweathertxt.setForeground(new Color(210, 105, 30));
        lblweathertxt.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblweathertxt.setSize(270, 50);
        lblweathertxt.setLocation(40, 10);
        weatherPanel.add(lblweathertxt);
        weatherPanel.add(lblweatherimg);
        homePanel.add(weatherPanel);
        
        // Create and configure the user button (with user icon).
        userButton = new JButton();
        userButton.setBounds(20, 20, 60, 60);
        userButton.setRolloverEnabled(false);  
        userButton.setBorderPainted(false);   // Remove border.
        userButton.setIcon(iconUser);         // Set the icon.
        userButton.setBackground(new Color(0, 0, 0, 0));  // Transparent background.
        userButton.addActionListener(e -> NewWindowController.openLoginPanel(MainController.loginV));
        menuPanel.add(userButton);
        
        // Create and configure the theme switch button.
        switchThemeButton = new JButton();
        switchThemeButton.setBounds(20, 830, 60, 60);
        menuPanel.add(switchThemeButton);
        switchThemeButton.setBackground(new Color(0, 0, 0, 0));  
        switchThemeButton.setIcon(new ImageIcon(HomeView.class.getResource("/images/LDMode.png"))); 
        switchThemeButton.setForeground(new Color(230, 230, 250)); 
        switchThemeButton.setRolloverEnabled(false); 
        switchThemeButton.setBorderPainted(false);
        switchThemeButton.addActionListener(e -> ThemeController.setThemeHomePanel(this));
        
        // Store the bounds of each component for possible future resizing.
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        
        for (Component comp : menuPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }        
        
        for (Component comp : weatherPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        // Initialize other components like the title and default window behavior.
        initComponents();
    }

    /**
     * Initializes the window settings such as title, size, close operation, and positioning.
     */
    private void initComponents() {
        setTitle("BGTransport");  // Set the window title.
        setSize(1920, 1080);      // Set the initial size of the window.
        SwingUtilities.updateComponentTreeUI(this);  // Update the UI components after changes.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the application when the window is closed.
        setLocationRelativeTo(null);  // Center the window on the screen.
    }
}
