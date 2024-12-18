package bgtransport.view;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import bgtransport.controller.LineController;
import bgtransport.controller.MainController;
import bgtransport.controller.MapController;
import bgtransport.controller.NewWindowController;
import bgtransport.controller.ThemeController;
import bgtransport.model.ConstantString;
import bgtransport.model.ResizableImage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Font;

/**
 * HomeView class represents the main view of the application, displaying a
 * background image, theme switching button, and user-related components. It
 * provides an interface for the user to interact with the main functionality of
 * the application.
 */
public class LineView extends JFrame {

	// Main container panel for the application.
	public JPanel mainPanel = new JPanel();

	// Side menu panel with rounded corners.
	public MenuPanel menuPanel = new MenuPanel();
	// Main content panel with rounded corners.
	public RoundedPanel homePanel = new RoundedPanel();
	// Position of the map panel within the layout.
	public final Point mappoint = new Point(100, 50);

	public RoundedPanel centerPanel = new RoundedPanel();
	public final Point centerpanelpoint = new Point(200, 30);

	// Resizable background wallpaper that adjusts to the screen size.
	public final transient ResizableImage lblBGwallpaper = new ResizableImage(
			new File("src/main/resources/images/BG.png"));

	// Icons for the user and map buttons.
	public ImageIcon iconUser = new ImageIcon(LineView.class.getResource("/images/User.png")); // Icon for the user																						// button.
	public ImageIcon iconMap = new ImageIcon(LineView.class.getResource("/images/Map.png")); // Icon for the map button.
	public ImageIcon iconHome = new ImageIcon(LineView.class.getResource("/images/Home.png"));

	// A map to store the bounds (dimensions and positions) of each component for
	// resizing purposes.
	public transient Map<Component, Rectangle> componentBounds = new HashMap<>();

	// Original size of the application window when maximized.
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
	
	private final BigLabel titlelabel = new BigLabel("Trova la tua fermata");
	
	private final MediumLabel departurelabel = new MediumLabel("Punto di Partenza:");

	private final MediumLabel arrivelabel = new MediumLabel("Punto di Arrivo:");
	
	private final MediumLabel linelabel = new MediumLabel("Linea:");
	
	private final MediumLabel departuretimelabel = new MediumLabel("Orario di Partenza:");
	
	private final MediumLabel arrivaltimelabel = new MediumLabel("Orario di Arrivo:");
	
	private final MediumLabel nextstoplabel = new MediumLabel("Prossima Fermata:");
	
	private final MediumLabel nextstoptimelabel = new MediumLabel("Orario Prossima Fermata:");
	
	private final MediumLabel weeklabel = new MediumLabel("Periodo:");

	public JButton selectbutton = new JButton();
	
	public static JComboBox<String> depaturestation;
		
	public static JComboBox<String> arrivestation;
	
	public static JComboBox<String> line;
	
	public static JComboBox<String> arrivetime;
	
	public static JComboBox<String> departuretime;
	
	public static JComboBox<String> week;
	
	public static JComboBox<String> nextstop;
	
	public static JComboBox<String> timestop;
	
	public static List<String> station;
	
	public static List<String> linelist;
	
	public static List<String> timelist;
	
	public static List<String> weeklist;
	
	public static List<List<String>> departureList;
	
	public static List<List<String>> timeList;
	
	public static List<List<String>> arriveList;
	
	/**
	 * Constructor that sets up the UI components, layout, and theming for the home
	 * view. It also initializes the main panel, menu panel, and other UI elements.
	 */
	/**
	 * Constructor initializes the MapView window, setting up UI components and
	 * behavior.
	 */
	public LineView() {
		// Configure the main window
		configureWindow();
		setupComponentArcs();
		setupMainPanel();
		setupCenterPanel();	
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
		mainPanel.add(homePanel);
		
		// Configure the home panel
		homePanel.setLayout(null);
		homePanel.setBounds(26, 40, 1854, 960);
		homePanel.add(menuPanel);
		
		centerPanel.setBounds(200, 30, 1600, 900); // Adjust the panel size as needed
		centerPanel.setLayout(null);
		homePanel.add(centerPanel);
		titlelabel.setForeground(new Color(210, 105, 30));
		titlelabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		titlelabel.setBounds(0, 50, 1600, 60);
		
		centerPanel.add(titlelabel);		
	}
	
	private void setupCenterPanel() {
		depaturestation = createSearchableComboBox(station);
		arrivestation = createSearchableComboBox(station);
		line = createSearchableComboBox(linelist);
		arrivetime = createSearchableComboBox(timelist);
		departuretime = createSearchableComboBox(timelist);
		timestop = createSearchableComboBox(timelist);
		nextstop = createSearchableComboBox(station);
		week = createSearchableComboBox(weeklist);
		
		int y = 150;
		departurelabel.setLocation(30, y);
		departurelabel.setSize(500, 50);
		centerPanel.add(departurelabel);
		depaturestation.setLocation(80, y + 70);
		depaturestation.setSize(500, 50);
		centerPanel.add(depaturestation);
		
		departuretimelabel.setLocation(540, y);
		departuretimelabel.setSize(500, 50);
		centerPanel.add(departuretimelabel);
		departuretime.setLocation(690, y + 70);
		departuretime.setSize(200, 50);
		centerPanel.add(departuretime);
		
		arrivelabel.setLocation(30, y + 140);
		arrivelabel.setSize(500, 50);		
		centerPanel.add(arrivelabel);
		arrivestation.setLocation(80, y + 210);
		arrivestation.setSize(500, 50);
		centerPanel.add(arrivestation);
		
		arrivaltimelabel.setLocation(540, y + 140);
		arrivaltimelabel.setSize(500, 50);
		centerPanel.add(arrivaltimelabel);
		arrivetime.setLocation(690, y + 210);
		arrivetime.setSize(200, 50);
		arrivetime.setEnabled(false);
		centerPanel.add(arrivetime);
		
		linelabel.setLocation(1000, y);
		linelabel.setSize(500, 50);
		centerPanel.add(linelabel);
		line.setLocation(1150, y + 70);
		line.setSize(200, 50);
		line.setEnabled(false);
		centerPanel.add(line);

		nextstoplabel.setLocation(30, y + 280);
		nextstoplabel.setSize(500, 50);
		centerPanel.add(nextstoplabel);
		nextstop.setLocation(80, y + 350);
		nextstop.setSize(500, 50);
		nextstop.setEnabled(false);
		centerPanel.add(nextstop);
		
		nextstoptimelabel.setLocation(540, y + 280);
		nextstoptimelabel.setSize(500, 50);
		centerPanel.add(nextstoptimelabel);
		timestop.setLocation(690, y + 350);
		timestop.setSize(200, 50);
		timestop.setEnabled(false);
		centerPanel.add(timestop);
		
		weeklabel.setLocation(1000, y + 140);
		weeklabel.setSize(500, 50);
		centerPanel.add(weeklabel);
		week.setLocation(1000, y + 210);
		week.setSize(500, 50);
		centerPanel.add(week);
		
		selectbutton.setText("Conferma");
		selectbutton.setFont(new Font(ConstantString.SANSSERIF, Font.BOLD, 16));
		selectbutton.setHorizontalAlignment(SwingConstants.CENTER);
		selectbutton.setBackground(new Color(210, 105, 30));
		selectbutton.setForeground(new Color(255, 255, 255));
		selectbutton.setLocation(650, 800);
		selectbutton.setSize(300, 70);
		selectbutton.setEnabled(false);
		centerPanel.add(selectbutton);
	}
	
	private static JComboBox<String> createSearchableComboBox(List<String> options) {
        JComboBox<String> comboBox = new JComboBox<>();
        for (int i = 0; i < options.size(); i++) comboBox.addItem(options.get(i));
        comboBox.setEditable(true);

        JTextComponent editor = (JTextComponent) comboBox.getEditor().getEditorComponent();
        editor.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                String input = editor.getText();
                comboBox.removeAllItems();

                // Filtraggio delle opzioni
                options.stream()
                        .filter(option -> option.toLowerCase().contains(input.toLowerCase()))
                        .forEach(comboBox::addItem);

                editor.setText(input);
                comboBox.showPopup();
            }
        });

        return comboBox;
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
	 * Adds action listeners to buttons for handling user interactions.
	 */
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
		menuPanel.homeButton.addActionListener(e -> {
			NewWindowController.openHomePanel(MainController.homeV);
			setVisible(false);
		});
		
		menuPanel.databaseButton.addActionListener(e -> {
			NewWindowController.openDatabasePanel(MainController.databaseV);
			setVisible(false);
		});
		
		depaturestation.addActionListener(e -> {
			try {
				LineController.getComboboxSelectionStation(depaturestation);
				LineController.updateComboBoxes(line, departuretime, arrivestation, arrivetime, nextstop, timestop, week, departureList);
				selectbutton.setEnabled(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		departuretime.addActionListener(e -> {
			try {
				LineController.getComboboxSelectionTime(departuretime);
				LineController.updateComboBoxes1(line, arrivestation, arrivetime, nextstop, timestop, week, timeList);
				selectbutton.setEnabled(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		arrivestation.addActionListener(e -> {
			try {
				LineController.getComboboxSelectionFinalStation(arrivestation);
				LineController.updateComboBoxes2(line, arrivetime, nextstop, timestop, week, arriveList);
				selectbutton.setEnabled(true);
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
		for (Component comp : centerPanel.getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
	}
}
