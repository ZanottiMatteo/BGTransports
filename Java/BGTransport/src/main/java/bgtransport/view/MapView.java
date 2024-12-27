package bgtransport.view;

import javax.swing.*;
import bgtransport.controller.MainController;
import bgtransport.controller.MapController;
import bgtransport.controller.NewWindowController;
import bgtransport.controller.ThemeController;
import bgtransport.model.ResizableImage;

import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * The MapView class represents the map screen of the BGTransport application.
 * It provides the user with interactive buttons for different transportation
 * options (bus, train, tram, funicular) and their respective map view. It also
 * allows the user to switch themes and navigate through various application
 * panels.
 */
public class MapView extends JFrame {

	private static final long serialVersionUID = -3601220816542830205L;

	// Declare UI components
	public JPanel mainPanel = new JPanel();
	public MenuPanel menuPanel = new MenuPanel();

	public JButton busButton;
	public JButton trainButton;
	public JButton funicularButton;
	public JButton tramButton;
	public JButton myposButton = new JButton("P");
	public static MediumLabel myposwrite = new MediumLabel();

	public RoundedPanel homePanel = new RoundedPanel();
	public final Point mappoint = new Point(100, 50);

	public static RoundedPanel externmapPanel = new RoundedPanel();
	public final Point mappanelpoint = new Point(200, 30);
	public final transient ResizableImage lblBGwallpaper = new ResizableImage(
			new File("src/main/resources/images/BG.png"));

	public ImageIcon iconBus = new ImageIcon(MapView.class.getResource("/images/Bus.png"));
	public ImageIcon iconTrain = new ImageIcon(MapView.class.getResource("/images/Train.png"));
	public ImageIcon iconTram = new ImageIcon(MapView.class.getResource("/images/Tram.png"));
	public ImageIcon iconFunicular = new ImageIcon(MapView.class.getResource("/images/Funicular.png"));
	public ImageIcon iconmypos = new ImageIcon(MapView.class.getResource("/images/Myposition.png"));

	public transient Map<Component, Rectangle> componentBounds = new HashMap<>();

	public final Dimension originalPanelSize = new Dimension(1920, 1080);
	public final Dimension menuPanelSize = new Dimension(100, 900);
	public final Dimension minPanelSize = new Dimension(1085, 615);
	public final Dimension mapPanelSize = new Dimension(1600, 900);
	public final Dimension mapSize = new Dimension(1450, 800);

	/**
	 * Constructs the MapView instance and sets up all necessary UI components. It
	 * configures the window properties, sets up the panels, and adds action
	 * listeners to buttons.
	 */
	public MapView() {
		configureWindow();
		setupComponentArcs();
		setupMainPanel();
		setupMapPanel();
		setupActionListeners();
		storeComponentBounds();
	}

	/**
	 * Configures the window properties such as maximizing it, setting the minimum
	 * size, title, and close operation. It also ensures the window is centered on
	 * the screen.
	 */
	private void configureWindow() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setMinimumSize(minPanelSize);
		setTitle("BGTransport");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	/**
	 * Sets rounded UI properties for various components like buttons and text
	 * fields. This method applies a consistent rounded look to all components.
	 */
	private void setupComponentArcs() {
		UIManager.put("Button.arc", 999);
		UIManager.put("TextComponent.arc", 15);
		UIManager.put("Component.arc", 15);
	}

	/**
	 * Sets up the main panel for the MapView. The main panel serves as the
	 * background and container for other components.
	 */
	private void setupMainPanel() {
		mainPanel = new JPanel() {
			private static final long serialVersionUID = 289126945885214701L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(lblBGwallpaper.getScaledImage(), 0, 0, this);
			}
		};

		mainPanel.setBounds(0, 0, 1920, 1080);
		mainPanel.setLayout(null);
		getContentPane().add(mainPanel);
		homePanel.setLayout(null);
		homePanel.setBounds(26, 40, 1854, 960);
		mainPanel.add(homePanel);
		homePanel.add(menuPanel);
	}

	/**
	 * Creates a JButton with an icon and specific dimensions. This method reduces
	 * repetition in button creation by encapsulating the logic in one place.
	 * 
	 * @param icon The icon to display on the button
	 * @param x    The x-coordinate for button placement
	 * @param y    The y-coordinate for button placement
	 * @return The created JButton with the specified icon and dimensions
	 */
	private JButton createIconButton(ImageIcon icon, int x, int y) {
		JButton button = new JButton();
		button.setBounds(x, y, 60, 60);
		button.setRolloverEnabled(false);
		button.setBorderPainted(false);
		button.setIcon(icon);
		button.setBackground(new Color(0, 0, 0, 0));
		return button;
	}

	/**
	 * Sets up the map panel, including the buttons for transportation options and
	 * the user's position. Each button is positioned and added to the map panel.
	 */
	private void setupMapPanel() {
		externmapPanel.setBounds(200, 30, 1600, 900);
		externmapPanel.setLayout(null);

		myposButton = createIconButton(iconmypos, 20, 800);
		externmapPanel.add(myposButton);

		myposwrite.setHorizontalAlignment(SwingConstants.CENTER);
		myposwrite.setBounds(550, 850, 500, 40);
		externmapPanel.add(myposwrite);

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
	 * Adds action listeners to the buttons for handling user interactions. Each
	 * button is associated with a specific action, such as showing different
	 * transportation types or switching between application panels.
	 */
	private void setupActionListeners() {
		menuPanel.userButton.addActionListener(e -> {
			NewWindowController.choseUserLogin(MainController.userV, MainController.loginV);
			this.setVisible(false);
		});

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

		busButton.addActionListener(e -> {
			try {
				MapController.showBus();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		trainButton.addActionListener(e -> {
			try {
				MapController.showTrain();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		funicularButton.addActionListener(e -> {
			try {
				MapController.showFunicular();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		tramButton.addActionListener(e -> {
			try {
				MapController.showTram();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		myposButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
			MapController.openHtmlInBrowser();
			MapController.waitForPositionAndExit();
		}));

		menuPanel.switchThemeButton.addActionListener(e -> ThemeController.updateThemes());
	}

	/**
	 * Stores the bounds (position and size) of each component for future resizing
	 * purposes. This allows for adaptive resizing of components when the window is
	 * resized.
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
