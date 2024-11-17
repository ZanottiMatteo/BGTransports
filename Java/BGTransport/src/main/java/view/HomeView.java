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
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import controller.MainController;
import controller.NewWindowController;
import controller.ResizeController;
import controller.ThemeController;
import view.RoundedPanel;

/**
 * HomeView class represents the main view of the application, displaying a background image, 
 * theme switching button, and user-related components. It provides an interface for the user 
 * to interact with the main functionality of the application.
 */
public class HomeView extends JFrame {

    // Main panel that holds all the components.
    public JPanel mainPanel = new JPanel();  
    
    // Buttons for switching themes and user interactions.
    public JButton switchThemeButton;
    public JButton userButton;
    
    // Background wallpaper (image that adjusts to screen size).
    public ResizableImage lblBGwallpaper = new ResizableImage(LoginView.class.getResource("/images/BG.png")); 
    
    // Icon for the user button.
    public ImageIcon iconUser = new ImageIcon(HomeView.class.getResource("/images/User.png"));
    
    // Map for storing the bounds of each component (used for resizing).
    public Map<Component, Rectangle> componentBounds = new HashMap<>();
    
    // Original and minimum size for the window.
    public final Dimension originalPanelSize = new Dimension(1920, 1080);
    public final Dimension MinPanelSize = new Dimension(1075, 615);

    /**
     * Constructor that sets up the UI components, layout, and theming for the home view.
     * It also initializes the main panel, menu panel, and other UI elements.
     */
    public HomeView() {
        
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
        mainPanel.setBounds(0, 0, 1920, 1080);      
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);
        
        // Create and configure a rounded panel for the main content area.
        RoundedPanel homePanel = new RoundedPanel();
        homePanel.setLayout(null);
        homePanel.setBounds(180, 90, 1700, 900);
        mainPanel.add(homePanel);
        
        // Create and configure a menu panel for user options.
        RoundedPanel menuPanel = new RoundedPanel();
        menuPanel.setBackground(new Color(210, 105, 30));  
        menuPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        menuPanel.setBounds(41, 90, 101, 900);
        mainPanel.add(menuPanel);
        menuPanel.setLayout(null);
                
        // Create and configure the user button (with user icon).
        userButton = new JButton();
        userButton.setBounds(22, 22, 62, 62);
        userButton.setRolloverEnabled(false);  
        userButton.setBorderPainted(false);   // Remove border.
        userButton.setIcon(iconUser);         // Set the icon.
        userButton.setBackground(new Color(0, 0, 0, 0));  // Transparent background.
        
        // Add action listener to the user button to open the user panel when clicked.
        userButton.addActionListener(e -> NewWindowController.openLoginPanel(MainController.loginV));
        menuPanel.add(userButton);
        
        // Create and configure the theme switch button.
        switchThemeButton = new JButton();
        switchThemeButton.setBounds(1855, 1000, 44, 35);  
        mainPanel.add(switchThemeButton);
        switchThemeButton.setBackground(new Color(0, 0, 0, 0));  
        switchThemeButton.setIcon(new ImageIcon(HomeView.class.getResource("/images/LDMode.png"))); 
        switchThemeButton.setForeground(new Color(230, 230, 250)); 
        switchThemeButton.setRolloverEnabled(false); 
        switchThemeButton.setBorderPainted(false);  
        
        // Add action listener to the theme switch button to toggle between light and dark themes.
        switchThemeButton.addActionListener(e -> ThemeController.setTheme());
        
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
