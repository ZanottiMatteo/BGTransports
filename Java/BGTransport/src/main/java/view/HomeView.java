package view;

import javax.swing.*;
import javax.swing.border.Border;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import controller.MainController;
import controller.MapController;
import controller.NewWindowController;
import controller.ResizeController;
import controller.ThemeController;
import model.ResizableImage;
import model.TimestampModel;

/**
 * HomeView class represents the main view of the application, displaying a
 * background image, theme switching button, and user-related components. It
 * provides an interface for the user to interact with the main functionality of
 * the application.
 */
public class HomeView extends JFrame {

    // Main application panel.
    public JPanel mainPanel = new JPanel();

    // Panels and layout-related fields.
    public MenuPanel menuPanel = new MenuPanel();
    
    public RoundedPanel homePanel = new RoundedPanel();
    public WeatherWidget weatherPanel = new WeatherWidget(); // Usa la nuova classe WeatherPanel.
    public TimeWidget timePanel = new TimeWidget();
    public static MiniMapWidget miniMapPanel = new MiniMapWidget();
    public UserWidget userPanel = new UserWidget();
   
    // Background wallpaper.
    public ResizableImage lblBGwallpaper = new ResizableImage(new File("src/main/resources/images/BG.png"));

    // Component bounds storage for resizing purposes.
    public Map<Component, Rectangle> componentBounds = new HashMap<>();

    // Window and panel dimensions.
    public final Dimension originalPanelSize = new Dimension(1920, 1080);
    public final Dimension MenuPanelSize = new Dimension(100, 900);
    public final Dimension WidgetPanelSizeMedium = new Dimension(350, 250);
    public final Dimension WidgetPanelSizeSmall = new Dimension(350, 180);
    public final Dimension MinPanelSize = new Dimension(1085, 615);
    public final Dimension MapSize = new Dimension(550, 350);
    public final Dimension MapPanelSize = new Dimension(600, 400);

    /**
     * Constructor that sets up the UI components, layout, and theming for the home
     * view. It also initializes the main panel, menu panel, and other UI elements.
     */
    public HomeView() {
        // Configure window properties.
        setExtendedState(Frame.MAXIMIZED_BOTH); // Launch in maximized state.
        setMinimumSize(MinPanelSize); // Set minimum size.

        // Initialize main panel with custom background rendering.
        mainPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this); // Draw background image.
            }
        };

        // Configure rounded corners for UI components.
        UIManager.put("Button.arc", 999);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("Component.arc", 15);

        // Configure content layout.
        getContentPane().setLayout(null);
        mainPanel.setBounds(0, 0, 1920, 1041);
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);

        // Initialize the home panel.
        homePanel.setLayout(null);
        homePanel.setOpaque(true);
        homePanel.setBounds(26, 40, 1854, 960);
        mainPanel.add(homePanel);

        // Weather panel setup using the new WeatherPanel class.

        homePanel.add(weatherPanel);
        homePanel.add(timePanel);
        homePanel.add(miniMapPanel);
        homePanel.add(userPanel);
        homePanel.add(menuPanel);
        // Time panel setup.

        // Store initial bounds for resizing purposes.
        storeComponentBounds();

        setupActionListeners();
        // Initialize other components.
        initComponents();
    }

    /**
     * Creates a menu button with a specific icon and position.
     */
    private JButton createMenuButton(ImageIcon icon, int x, int y) {
        JButton button = new JButton();
        button.setBounds(x, y, 60, 60);
        button.setIcon(icon);
        button.setBorderPainted(false);
        button.setRolloverEnabled(false);
        button.setBackground(new Color(0, 0, 0, 0));
        return button;
    }

    /**
     * Stores the bounds of all components for resizing.
     */
    private void storeComponentBounds() {
        for (Component comp : mainPanel.getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
        
    }
    
    private void setupActionListeners() {
        // Action listener for the user button
    	menuPanel.userButton.addActionListener(e -> {
			NewWindowController.choseUserLogin(MainController.userV, MainController.loginV);
			this.setVisible(false);
		});

		// Action listener for the home button
    	menuPanel.mapButton.addActionListener(e -> {
			NewWindowController.openMapPanel(MainController.mapV);
			setVisible(false);
		});
		
        // Action listener for the theme switch button
    	menuPanel.switchThemeButton.addActionListener(e -> ThemeController.updateThemes());
        
    }

    /**
     * Initializes basic window properties.
     */
    private void initComponents() {
        setExtendedState(Frame.MAXIMIZED_BOTH); // Maximize the window at startup
        setMinimumSize(MinPanelSize); // Set minimum window size
        setTitle("BGTransport"); // Set window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center the window on the screen
    }
}
