package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import controller.DatabaseController;
import controller.MainController;
import controller.NewWindowController;
import controller.ThemeController;
import model.ConstantDB;
import model.ResizableImage;
import model.Utility;

public class DatabaseView extends JFrame {

	public JLabel databaseLabel = new JLabel();
	public JPanel mainPanel = new JPanel();
	public final MenuPanel menuPanel = new MenuPanel();
	public RoundedPanel homePanel = new RoundedPanel();
	public RoundedPanel centerPanel = new RoundedPanel();
	public final Point centerpanelpoint = new Point(200, 30);

	public final transient ResizableImage lblBGwallpaper = new ResizableImage(
			new File("src/main/resources/images/BG.png"));

	public transient Map<Component, Rectangle> componentBounds = new HashMap<>();

	public ImageIcon iconUser = new ImageIcon(LineView.class.getResource("/images/User.png")); // Icon for the user
	// button.
	public ImageIcon iconMap = new ImageIcon(LineView.class.getResource("/images/Map.png")); // Icon for the map button.
	public ImageIcon iconHome = new ImageIcon(LineView.class.getResource("/images/Home.png"));

	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	// Fixed size of the menu panel.
	public final Dimension menuPanelSize = new Dimension(100, 900);
	// Minimum size of the application window to prevent it from being resized too
	// small.
	public final Dimension minPanelSize = new Dimension(1085, 615);
	// Size of the panel containing the map.
	public final Dimension linePanelSize = new Dimension(1600, 900);
	// Default size of the map itself within the map panel.
	public final Dimension lineSize = new Dimension(1450, 800);

	public final Dimension centerPanelSize = new Dimension(1600, 900);

	public DatabaseView() {
		configureWindow();
		setupComponentArcs();
		setupMainPanel();
		setupActionListeners();
		storeComponentBounds();
	}

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

	private void configureWindow() {
		setExtendedState(Frame.MAXIMIZED_BOTH); // Maximize the window at startup
		setMinimumSize(minPanelSize); // Set minimum window size
		setTitle("BGTransport"); // Set window title
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close the application when the window is closed
		setLocationRelativeTo(null); // Center the window on the screen
	}

	private void setupComponentArcs() {
		UIManager.put("Button.arc", 999); // Fully rounded buttons
		UIManager.put("TextComponent.arc", 15); // Slightly rounded text components
		UIManager.put("Component.arc", 15); // Rounded corners for general components
	}

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
		mainPanel.add(homePanel);

		// Configure the home panel
		homePanel.setLayout(null);
		homePanel.setBounds(26, 40, 1854, 960);
		homePanel.add(menuPanel);

		centerPanel.setBounds(200, 30, 1600, 900); // Adjust the panel size as needed
		centerPanel.setLayout(null);
		homePanel.add(centerPanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 93, 373, 118);
		centerPanel.add(scrollPane);

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

		// Action listener for the home button
		menuPanel.lineButton.addActionListener(e -> {
			NewWindowController.openLinePanel(MainController.lineV);
			setVisible(false);
		});

		// Action listener for the home button
		menuPanel.homeButton.addActionListener(e -> {
			NewWindowController.openHomePanel(MainController.homeV);
			setVisible(false);
		});

		// Action listener for the theme switch button
		menuPanel.switchThemeButton.addActionListener(e -> ThemeController.updateThemes());

	}
}
