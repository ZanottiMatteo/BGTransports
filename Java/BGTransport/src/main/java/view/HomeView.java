package view;

import javax.swing.*;
import javax.swing.border.Border;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import controller.MainController;
import controller.NewWindowController;
import controller.ResizeController;
import controller.ThemeController;
import model.TimestampModel;
import model.WeatherModel;

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
	public RoundedPanel menuPanel = new RoundedPanel();
	public final Point menupanelpoint = new Point(15, 30);
	public JButton switchThemeButton;
	public JButton userButton;
	public JButton mapButton;

	public RoundedPanel homePanel = new RoundedPanel();
	public RoundedPanel weatherPanel = new RoundedPanel();
	public final Point weatherpanelpoint = new Point(235, 30);
	public JLabel lblweather = new JLabel();
	public JLabel lblweatherwind = new JLabel();

	public RoundedPanel timePanel = new RoundedPanel();
	public final Point timepanelpoint = new Point(235, 310);
	public JLabel lbltime = new JLabel();
	public JLabel lbldate = new JLabel();

	public static RoundedPanel miniMapPanel = new RoundedPanel();
	public final Point miniMapPanelPoint = new Point(1200, 30);
	public final Point mappoint = new Point(25, 25);
	
	// Weather-related fields.
	public CircleLabel lblweatherimg = new CircleLabel("");
	public JLabel lblweathertxt = new JLabel("🏠 Bergamo");

	// Background wallpaper.
	public ResizableImage lblBGwallpaper = new ResizableImage(LoginView.class.getResource("/images/BG.png"));

	// Icons.
	public ImageIcon iconUser = new ImageIcon(HomeView.class.getResource("/images/User.png"));
	public ImageIcon iconLDmode = new ImageIcon(HomeView.class.getResource("/images/LDMode.png"));
	public ImageIcon iconWeather;
	public ImageIcon iconMap = new ImageIcon(MapView.class.getResource("/images/Map.png"));

	// Component bounds storage for resizing purposes.
	public Map<Component, Rectangle> componentBounds = new HashMap<>();

	// Window and panel dimensions.
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension MenuPanelSize = new Dimension(100, 900);
	public final Dimension WidgetPanelSizeMedium = new Dimension(350, 250);
	public final Dimension WidgetPanelSizeSmall = new Dimension(250, 180);
	public final Dimension MinPanelSize = new Dimension(1085, 615);
	public final Dimension MapSize = new Dimension(550, 350);
	public final Dimension MapPanelSize = new Dimension(600, 400);
	/**
	 * Constructor that sets up the UI components, layout, and theming for the home
	 * view. It also initializes the main panel, menu panel, and other UI elements.
	 */
	public HomeView() {
		try {
			WeatherModel.getMeteo();
		} catch (IOException e) {
			e.printStackTrace();
		}

		iconWeather = WeatherModel.getWeatherIcon();

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

		// Initialize the menu panel.
		menuPanel.setBounds(15, 30, 100, 900);
		menuPanel.setBackground(new Color(210, 105, 30));
		menuPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		menuPanel.setLayout(null);
		homePanel.add(menuPanel);

		// Weather panel setup.
		setupWeatherPanel();

		// Time panel setup.
		setupTimePanel();

		// Menu buttons setup.
		setupMenuButtons();
		
		// Mini Map panel setup.
		setupMiniMapPanel();

		// Store initial bounds for resizing purposes.
		storeComponentBounds();

		// Initialize other components.
		initComponents();
	}

	/**
	 * Configures the weather panel.
	 */
	private void setupWeatherPanel() {
		lblweather.setHorizontalAlignment(SwingConstants.LEFT);
		lblweather.setFont(new Font("SansSerif", Font.BOLD, 70));
		lblweather.setBounds(140, 170, 200, 50);

		lblweatherwind.setHorizontalAlignment(SwingConstants.LEFT);
		lblweatherwind.setFont(new Font("SansSerif", Font.BOLD, 70));
		lblweatherwind.setBounds(140, 100, 200, 50);

		lblweatherimg.setVerticalAlignment(SwingConstants.TOP);
		lblweatherimg.setHorizontalAlignment(SwingConstants.LEFT);
		lblweatherimg.setIcon(iconWeather);
		lblweatherimg.setLocation(25, 75);
		lblweatherimg.setSize(100, 100);
		lblweatherimg.setCircleColor(new Color(87, 198, 250));

		lblweathertxt.setHorizontalAlignment(SwingConstants.LEFT);
		lblweathertxt.setForeground(new Color(210, 105, 30));
		lblweathertxt.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblweathertxt.setBounds(140, 30, 200, 50);

		try {
			WeatherModel.getMeteo(lblweather, lblweatherwind);
		} catch (IOException e) {
			e.printStackTrace();
		}

		weatherPanel.setLayout(null);
		weatherPanel.setBounds(235, 30, 350, 250);
		weatherPanel.add(lblweather);
		weatherPanel.add(lblweatherwind);
		weatherPanel.add(lblweathertxt);
		weatherPanel.add(lblweatherimg);
		homePanel.add(weatherPanel);
	}

	/**
	 * Configures the time panel.
	 */
	private void setupTimePanel() {
		try {
			TimestampModel.getTime(lbltime);
			TimestampModel.getDate(lbldate);
		} catch (IOException e) {
			e.printStackTrace();
		}

		lbltime.setHorizontalAlignment(SwingConstants.CENTER);
		lbltime.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbltime.setBounds(15, 25, 220, 50);

		lbldate.setHorizontalAlignment(SwingConstants.CENTER);
		lbldate.setFont(new Font("SansSerif", Font.BOLD, 20));
		lbldate.setBounds(15, 110, 220, 50);

		timePanel.setLayout(null);
		timePanel.setBounds(235, 310, 250, 180);
		timePanel.add(lbltime);
		timePanel.add(lbldate);
		homePanel.add(timePanel);
	}

	/**
	 * Configures the time panel.
	 */
	private void setupMiniMapPanel() {
		miniMapPanel.setLayout(null);
		miniMapPanel.setBounds(1200, 30, 600, 400);
		homePanel.add(miniMapPanel);
	}

	
	/**
	 * Configures menu buttons (user, map, theme switch).
	 */
	private void setupMenuButtons() {
		// User button.
		userButton = createMenuButton(iconUser, 20, 20);
		userButton.addActionListener(e -> {
			NewWindowController.openLoginPanel(MainController.loginV);
			setVisible(false);
		});
		menuPanel.add(userButton);

		// Map button.
		mapButton = createMenuButton(iconMap, 20, 150);
		mapButton.addActionListener(e -> {
			NewWindowController.openMapPanel(MainController.mapV);
			setVisible(false);
		});
		menuPanel.add(mapButton);

		// Theme switch button.
		switchThemeButton = createMenuButton(iconLDmode, 20, 830);
		switchThemeButton.addActionListener(e -> ThemeController.updateThemes());
		menuPanel.add(switchThemeButton);
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
		for (Component comp : menuPanel.getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
		for (Component comp : weatherPanel.getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
		for (Component comp : timePanel.getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
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
