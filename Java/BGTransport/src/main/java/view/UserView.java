package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import controller.MainController;
import controller.NewWindowController;
import controller.ThemeController;
import controller.UserInfoController;
import model.ConstantString;
import model.ResizableImage;

public class UserView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6180578220567180030L;

	// Main application panel.
	public JPanel mainPanel = new JPanel();

	// Panels and layout-related fields.
	public MenuPanel menuPanel = new MenuPanel();

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
	public final transient ResizableImage lblBGwallpaper = new ResizableImage(new File("src/main/resources/images/BG.png"));

	// Component bounds storage for resizing purposes.
	public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();

	// Window and panel dimensions.
	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension menuPanelSize = new Dimension(100, 900);
	public final Dimension minPanelSize = new Dimension(1085, 615);
	public final Dimension centerPanelSize = new Dimension(1600, 900);

	/**
	 * Constructor that sets up the UI components, layout, and theming for the home
	 * view. It also initializes the main panel, menu panel, and other UI elements.
	 */
	public UserView() {
		// Configure window properties.
		setExtendedState(Frame.MAXIMIZED_BOTH); // Launch in maximized state.
		setMinimumSize(minPanelSize); // Set minimum size.

		mainPanel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 8925281806572340340L;

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

		homePanel.add(menuPanel);

		setupCenterPanel();

		// Store initial bounds for resizing purposes.
		storeComponentBounds();

		setupActionListeners();

		// Initialize other components.
		initComponents();
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

		profilePhoto.setBounds(110, 70, 250, 250); // Circular placeholder
		profilePhoto.setCircleColor(Color.GRAY); // Placeholder color for the profile picture

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
		changeData.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, 16));
		changeData.setBackground(new Color(210, 105, 30));
		centerPanel.add(changeData);

		saveData.setBounds(650, yPosition, 200, 50);
		saveData.setVisible(false);
		saveData.setText("Salva");
		saveData.setForeground(Color.WHITE);
		saveData.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, 16));
		saveData.setBackground(new Color(210, 105, 30));
		centerPanel.add(saveData);

		discardData.setBounds(950, yPosition, 200, 50);
		discardData.setVisible(false);
		discardData.setText("Annulla");
		discardData.setForeground(Color.WHITE);
		discardData.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, 16));
		discardData.setBackground(new Color(210, 105, 30));
		centerPanel.add(discardData);
	}

	private void setupActionListeners() {
		// Action listener for the home button
		menuPanel.homeButton.addActionListener(e -> {
			NewWindowController.openHomePanel(MainController.homeV);
			setVisible(false);
		});

		// Action listener for the home button
		menuPanel.mapButton.addActionListener(e -> {
			NewWindowController.openMapPanel(MainController.mapV);
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
		menuPanel.switchThemeButton.addActionListener(e -> ThemeController.updateThemes());

		changeData.addActionListener(e -> {
			UserInfoController.enableTextFields();
			saveData.setVisible(true);
			discardData.setVisible(true);
			changeData.setVisible(false);
		});

		saveData.addActionListener(e -> {
			try {
				UserInfoController.setDataFromTF();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			UserInfoController.disableTextFields();
			UserInfoController.showDataWidget();
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

		chooseIcon.addActionListener(e -> NewWindowController.openAccountIconPanel(MainController.accountV));
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
		setMinimumSize(minPanelSize); // Set minimum window size
		setTitle("BGTransport"); // Set window title
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close the application when the window is closed
		setLocationRelativeTo(null); // Center the window on the screen
	}
}
