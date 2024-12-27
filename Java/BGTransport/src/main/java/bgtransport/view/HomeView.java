package bgtransport.view;

import javax.swing.*;
import bgtransport.controller.MainController;
import bgtransport.controller.NewWindowController;
import bgtransport.controller.ThemeController;
import bgtransport.model.ResizableImage;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * A class representing the main home view of the BGTransport application. It
 * includes various widgets such as weather, time, map, user information, and
 * navigation menu.
 */
public class HomeView extends JFrame {

	private static final long serialVersionUID = -7834222396903699529L;

	public JPanel mainPanel = new JPanel();
	public final MenuPanel menuPanel = new MenuPanel();
	public final RoundedPanel homePanel = new RoundedPanel();
	public final WeatherWidget weatherPanel = new WeatherWidget();
	public final TimeWidget timePanel = new TimeWidget();
	public static MiniMapWidget miniMapPanel = new MiniMapWidget();
	public final UserWidget userPanel = new UserWidget();
	public final TitleWidget infoPanel = new TitleWidget();
	public final CompanyWidget companyPanel = new CompanyWidget();

	public final transient ResizableImage lblBGwallpaper = new ResizableImage(
			new File("src/main/resources/images/BG.png"));

	public transient Map<Component, Rectangle> componentBounds = new HashMap<>();

	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension menuPanelSize = new Dimension(100, 900);
	public final Dimension widgetPanelTitle = new Dimension(1565, 135);
	public final Dimension widgetPanelSizeLarge = new Dimension(600, 400);
	public final Dimension widgetPanelSizeMedium = new Dimension(350, 250);
	public final Dimension widgetPanelSizeSmall = new Dimension(350, 180);
	public final Dimension minPanelSize = new Dimension(1085, 615);
	public final Dimension mapSize = new Dimension(550, 350);

	/**
	 * Constructs the HomeView and initializes the UI components. Sets up the
	 * layout, widgets, and action listeners for navigation.
	 */
	public HomeView() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setMinimumSize(minPanelSize);

		mainPanel = new JPanel() {
			private static final long serialVersionUID = 7765985167942887712L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this);
			}
		};

		UIManager.put("Button.arc", 999);
		UIManager.put("TextComponent.arc", 15);
		UIManager.put("Component.arc", 15);

		getContentPane().setLayout(null);
		mainPanel.setBounds(0, 0, 1920, 1041);
		mainPanel.setLayout(null);
		getContentPane().add(mainPanel);

		homePanel.setLayout(null);
		homePanel.setOpaque(true);
		homePanel.setBounds(26, 40, 1854, 960);
		mainPanel.add(homePanel);

		homePanel.add(weatherPanel);
		homePanel.add(timePanel);
		homePanel.add(miniMapPanel);
		homePanel.add(userPanel);
		homePanel.add(menuPanel);
		homePanel.add(infoPanel);
		homePanel.add(companyPanel);

		storeComponentBounds();
		setupActionListeners();
		initComponents();
	}

	/**
	 * Stores the bounds of all components on the main panel for later use (e.g.,
	 * resizing).
	 */
	private void storeComponentBounds() {
		for (Component comp : mainPanel.getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
	}

	/**
	 * Sets up action listeners for buttons on the menu panel. These listeners
	 * handle navigation to different views within the application.
	 */
	private void setupActionListeners() {
		menuPanel.userButton.addActionListener(e -> {
			NewWindowController.choseUserLogin(MainController.userV, MainController.loginV);
			this.setVisible(false);
		});

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

		menuPanel.switchThemeButton.addActionListener(e -> ThemeController.updateThemes());
	}

	/**
	 * Initializes window properties such as title, close operation, and layout.
	 */
	private void initComponents() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setMinimumSize(minPanelSize);
		setTitle("BGTransport");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
