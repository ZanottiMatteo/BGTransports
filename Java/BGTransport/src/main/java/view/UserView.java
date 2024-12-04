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
import controller.UserInfoController;
import model.ResizableImage;
import model.TimestampModel;
import model.WeatherModel;


public class UserView extends JFrame {

	// Main application panel.
	public JPanel mainPanel = new JPanel();

	// Panels and layout-related fields.
	public RoundedPanel menuPanel = new RoundedPanel();
	public final Point menupanelpoint = new Point(15, 30);
	public JButton switchThemeButton;
	public JButton userButton;
	public JButton mapButton;
	public JButton homeButton;

	public RoundedPanel homePanel = new RoundedPanel();
	public RoundedPanel weatherPanel = new RoundedPanel();
	
	// Weather-related fields.
	public CircleLabel lblweatherimg = new CircleLabel("");
	public JLabel lblweathertxt = new JLabel("🏠 Bergamo");

	public RoundedPanel centerPanel = new RoundedPanel();
	public final Point centerpanelpoint = new Point(200, 30);
	
	public static CircleLabel profilePhoto = new CircleLabel();
	private BigLabel titlePersonalInfo = new BigLabel("Dati Personali");
	
	private MediumLabel titleUsername = new MediumLabel("Username");
	private MediumLabel titleEmail = new MediumLabel("Email");
	private MediumLabel titleName = new MediumLabel("Nome");
	private MediumLabel titleSurname = new MediumLabel("Cognome");
	private MediumLabel titleBirthday = new MediumLabel("Data di Nascita");
	private MediumLabel titleAddress = new MediumLabel("Indirizzo");
	private MediumLabel titleCity = new MediumLabel("Città");
	private MediumLabel titleZip = new MediumLabel("CAP");
	
	public static JTextField tfUsername = new JTextField();
	public static JTextField tfEmail = new JTextField();
	public static JTextField tfName = new JTextField();
	public static JTextField tfSurname = new JTextField();
	public static JTextField tfBirthday = new JTextField();
	public static JTextField tfAddress = new JTextField();
	public static JTextField tfCity = new JTextField();
	public static JTextField tfZip = new JTextField();
	
	public JButton changeData = new JButton();
	public JButton saveData = new JButton();
	public JButton discardData = new JButton();
	public static JButton chooseIcon = new JButton();
	
	// Background wallpaper.
	public ResizableImage lblBGwallpaper = new ResizableImage(new File("src/main/resources/images/BG.png"));

	// Icons.
	public ImageIcon iconUser = new ImageIcon(UserView.class.getResource("/images/User.png"));
	public ImageIcon iconLDmode = new ImageIcon(UserView.class.getResource("/images/LDMode.png"));
	public ImageIcon iconWeather;
	public ImageIcon iconMap = new ImageIcon(UserView.class.getResource("/images/Map.png"));
	public ImageIcon iconHome = new ImageIcon(UserView.class.getResource("/images/Home.png"));
	//public ImageIcon iconaddImage = 
	
	// Component bounds storage for resizing purposes.
	public Map<Component, Rectangle> componentBounds = new HashMap<>();

	// Window and panel dimensions.
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension MenuPanelSize = new Dimension(100, 900);
	public final Dimension MinPanelSize = new Dimension(1085, 615);
	public final Dimension CenterPanelSize = new Dimension(1600, 900);

	/**
	 * Constructor that sets up the UI components, layout, and theming for the home
	 * view. It also initializes the main panel, menu panel, and other UI elements.
	 */
	public UserView() {
		// Configure window properties.
		setExtendedState(Frame.MAXIMIZED_BOTH); // Launch in maximized state.
		setMinimumSize(MinPanelSize); // Set minimum size.
		// Initialize main panel with custom background rendering.
		
		initializeTheme();
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

		// Menu buttons setup.
		setupMenuButtons();
		
		setupCenterPanel();
		
		// Store initial bounds for resizing purposes.
		storeComponentBounds();
		
		setupActionListeners();
		
		// Initialize other components.
		initComponents();
	}
	
	/**
	 * Configures menu buttons (user, map, theme switch).
	 */
	private void setupMenuButtons() {
		// User button.
		userButton = createMenuButton(iconUser, 20, 20);
		menuPanel.add(userButton);

		// User button.
		homeButton = createMenuButton(iconHome, 20, 140);
		menuPanel.add(homeButton);
		
		// Map button.
		mapButton = createMenuButton(iconMap, 20, 260);
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

	private void initializeTheme() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); // Set light theme
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
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
	
	 private void setupCenterPanel() {
		// Set layout to absolute positioning
		 centerPanel.setBounds(200, 30, 1600, 900); // Adjust the panel size as needed
		 centerPanel.setLayout(null);
		 homePanel.add(centerPanel);
		 
		 chooseIcon.setBounds(105, 70, 250, 250);
		 chooseIcon.setBorderPainted(false);
		 chooseIcon.setBackground(new Color(0, 0, 0, 0));
		 centerPanel.add(chooseIcon);

		 // Profile Picture Placeholder (circular placeholder)
		 
		 profilePhoto.setBounds(110, 70, 250, 250);  // Circular placeholder
		 profilePhoto.setCircleColor(Color.GRAY);  // Placeholder color for the profile picture
		 
		 centerPanel.add(profilePhoto);
		 
		 // Define left and right positions for alternating columns
		 int leftX = 500;
		 int rightX = 1000;
		 int yOffset = 40; 
		 int yPosition = 100; // Start from this Y posit

		 titlePersonalInfo.setBounds(leftX + 150, yPosition, 500, 50);
		 centerPanel.add(titlePersonalInfo);
		 yPosition += 80;
		 
		 // Set the bounds for each title and text field in alternating positions
		 titleUsername.setBounds(leftX, yPosition, 200, 25);
		 tfUsername.setBounds(leftX, yPosition + yOffset, 300, 50); // Place text field below the title
		 titleUsername.setHorizontalAlignment(SwingConstants.LEADING); // Align title to leading
		 tfUsername.setHorizontalAlignment(SwingConstants.LEADING); // Align text field to leading
		 centerPanel.add(titleUsername);
		 centerPanel.add(tfUsername);

		 titleEmail.setBounds(rightX, yPosition, 200, 25);
		 tfEmail.setBounds(rightX, yPosition + yOffset, 300, 50); // Place text field below the title
		 titleEmail.setHorizontalAlignment(SwingConstants.LEADING); // Align title to leading
		 tfEmail.setHorizontalAlignment(SwingConstants.LEADING); // Align text field to leading
		 centerPanel.add(titleEmail);
		 centerPanel.add(tfEmail);
		 yPosition += 150; // Increase the Y position for the next row

		 titleName.setBounds(leftX, yPosition, 200, 25);
		 tfName.setBounds(leftX, yPosition + yOffset, 300, 50); // Place text field below the title
		 titleName.setHorizontalAlignment(SwingConstants.LEADING); // Align title to leading
		 tfName.setHorizontalAlignment(SwingConstants.LEADING); // Align text field to leading
		 centerPanel.add(titleName);
		 centerPanel.add(tfName);

		 titleSurname.setBounds(rightX, yPosition, 200, 25);
		 tfSurname.setBounds(rightX, yPosition + yOffset, 300, 50); // Place text field below the title
		 titleSurname.setHorizontalAlignment(SwingConstants.LEADING); // Align title to leading
		 tfSurname.setHorizontalAlignment(SwingConstants.LEADING); // Align text field to leading
		 centerPanel.add(titleSurname);
		 centerPanel.add(tfSurname);
		 yPosition += 150; // Increase the Y position for the next row

		 titleBirthday.setBounds(leftX, yPosition, 200, 25);
		 tfBirthday.setBounds(leftX, yPosition + yOffset, 300, 50); // Place text field below the title
		 titleBirthday.setHorizontalAlignment(SwingConstants.LEADING); // Align title to leading
		 tfBirthday.setHorizontalAlignment(SwingConstants.LEADING); // Align text field to leading
		 centerPanel.add(titleBirthday);
		 centerPanel.add(tfBirthday);

		 titleAddress.setBounds(rightX, yPosition, 200, 25);
		 tfAddress.setBounds(rightX, yPosition + yOffset, 300, 50); // Place text field below the title
		 titleAddress.setHorizontalAlignment(SwingConstants.LEADING); // Align title to leading
		 tfAddress.setHorizontalAlignment(SwingConstants.LEADING); // Align text field to leading
		 centerPanel.add(titleAddress);
		 centerPanel.add(tfAddress);
		 yPosition += 150; // Increase the Y position for the next row

		 titleCity.setBounds(leftX, yPosition, 200, 25);
		 tfCity.setBounds(leftX, yPosition + yOffset, 300, 50); // Place text field below the title
		 titleCity.setHorizontalAlignment(SwingConstants.LEADING); // Align title to leading
		 tfCity.setHorizontalAlignment(SwingConstants.LEADING); // Align text field to leading
		 centerPanel.add(titleCity);
		 centerPanel.add(tfCity);

		 titleZip.setBounds(rightX, yPosition, 200, 25);
		 tfZip.setBounds(rightX, yPosition + yOffset, 300, 50); // Place text field below the title
		 titleZip.setHorizontalAlignment(SwingConstants.LEADING); // Align title to leading
		 tfZip.setHorizontalAlignment(SwingConstants.LEADING); // Align text field to leading
		 centerPanel.add(titleZip);
		 centerPanel.add(tfZip);
		 yPosition += 150;
		 
		 changeData.setBounds(800, yPosition, 200, 50);
		 changeData.setText("Modifica");
		 changeData.setForeground(Color.WHITE);
		 changeData.setFont(new Font("SansSerif", Font.BOLD, 16));
		 changeData.setBackground(new Color(210, 105, 30));
		 centerPanel.add(changeData);
	    }

	 private void setupActionListeners() {	
	        // Action listener for the home button
	        homeButton.addActionListener(e -> {
				NewWindowController.openHomePanel(MainController.homeV);
				setVisible(false);
			});
			
	        // Action listener for the theme switch button
	        switchThemeButton.addActionListener(e -> ThemeController.updateThemes());
	        
	        changeData.addActionListener(e -> {
	        	UserInfoController.enableTextFields();
	        	saveData.setVisible(true);
	        	discardData.setVisible(true);
	        	changeData.setVisible(false);
	        });
	        
	        saveData.addActionListener(e -> {
	        	UserInfoController.disableTextFields();
	        	saveData.setVisible(false);
	        	discardData.setVisible(false);
	        	changeData.setVisible(true);
	        });
	        
	        discardData.addActionListener(e -> {
	        	UserInfoController.disableTextFields();
	        	saveData.setVisible(false);
	        	discardData.setVisible(false);
	        	changeData.setVisible(true);
	        });
	        
	        chooseIcon.addActionListener(e -> {
	        	NewWindowController.openAccountIconPanel(MainController.accountV);
	        });
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
		for (Component comp : centerPanel.getComponents()) {
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
