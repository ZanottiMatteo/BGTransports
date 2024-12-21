package bgtransport.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import bgtransport.controller.DatabaseController;
import bgtransport.controller.MainController;
import bgtransport.controller.NewWindowController;
import bgtransport.controller.ThemeController;
import bgtransport.model.ConstantDB;
import bgtransport.model.ConstantString2;
import bgtransport.model.ResizableImage;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class DatabaseView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2944688991697850488L;
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
	private final JButton company = new JButton("COMPANY");
	private final JButton user = new JButton("USER");
	
	public JScrollPane scrollPane = new JScrollPane();
	private final JButton funicularStation = new JButton("FUNICULAR STATION");
	private final JButton funicularTimetable = new JButton("FUNICULAR TIMETABLE");
	private final JButton pullmanStop = new JButton("PULLMAN STOP");
	private final JButton trainStation = new JButton("TRAIN STATION");
	private final JButton trainTimetable = new JButton("TRAIN TIMETABLE");
	private final JButton pullmanTimetable = new JButton("PULLMAN TIMETABLE");
	private final JButton tramStop = new JButton("TRAM STOP");

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
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

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

		scrollPane.setBounds(23, 24, 1550, 804);
		centerPanel.add(scrollPane);
		
		JLabel selectTable = new JLabel("Select the table");
		scrollPane.setViewportView(selectTable);
		selectTable.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 25));
		selectTable.setHorizontalAlignment(SwingConstants.CENTER);
		
		user.setBounds(65, 850, 85, 40);
		user.setForeground(Color.WHITE);
		user.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		user.setBackground(new Color(210, 105, 30));
		centerPanel.add(user);
		
		company.setBounds(157, 850, 120, 40);
		company.setForeground(Color.WHITE);
		company.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		company.setBackground(new Color(210, 105, 30));
		centerPanel.add(company);
		
		funicularStation.setBounds(284, 850, 180, 40);
		funicularStation.setForeground(Color.WHITE);
		funicularStation.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		funicularStation.setBackground(new Color(210, 105, 30));
		centerPanel.add(funicularStation);
		
		funicularTimetable.setBounds(471, 850, 190, 40);
		funicularTimetable.setForeground(Color.WHITE);
		funicularTimetable.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		funicularTimetable.setBackground(new Color(210, 105, 30));
		centerPanel.add(funicularTimetable);
		
		pullmanStop.setBounds(668, 850, 160, 40);
		pullmanStop.setForeground(Color.WHITE);
		pullmanStop.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		pullmanStop.setBackground(new Color(210, 105, 30));
		centerPanel.add(pullmanStop);
		
		pullmanTimetable.setBounds(835, 850, 180, 40);
		pullmanTimetable.setForeground(Color.WHITE);
		pullmanTimetable.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		pullmanTimetable.setBackground(new Color(210, 105, 30));
		centerPanel.add(pullmanTimetable);
		
		trainStation.setBounds(1022, 850, 160, 40);
		trainStation.setForeground(Color.WHITE);
		trainStation.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		trainStation.setBackground(new Color(210, 105, 30));
		centerPanel.add(trainStation);
		
		trainTimetable.setBounds(1189, 850, 160, 40);
		trainTimetable.setForeground(Color.WHITE);
		trainTimetable.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		trainTimetable.setBackground(new Color(210, 105, 30));
		centerPanel.add(trainTimetable);
		
		tramStop.setBounds(1356, 850, 160, 40);
		tramStop.setForeground(Color.WHITE);
		tramStop.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		tramStop.setBackground(new Color(210, 105, 30));
		centerPanel.add(tramStop);
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
		
		user.addActionListener(e -> {
			try {
				DatabaseController.scrollPanelUser(ConstantDB.DB_URL_USERS);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		company.addActionListener(e -> {
			try {
				DatabaseController.scrollPanelCompany(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		funicularStation.addActionListener(e -> {
			try {
				DatabaseController.scrollPanelFunicularStation(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		funicularTimetable.addActionListener(e -> {
			try {
				DatabaseController.scrollPanelFunicularTimetable(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		pullmanStop.addActionListener(e -> {
			try {
				DatabaseController.scrollPanelPullmanStop(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		pullmanTimetable.addActionListener(e -> {
			try {
				DatabaseController.scrollPanelPullmanTimetable(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		trainStation.addActionListener(e -> {
			try {
				DatabaseController.scrollPanelTrainStation(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		trainTimetable.addActionListener(e -> {
			try {
				DatabaseController.scrollPanelTrainTimetable(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		tramStop.addActionListener(e -> {
			try {
				DatabaseController.scrollPanelTramStop(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		// Action listener for the theme switch button
		menuPanel.switchThemeButton.addActionListener(e -> ThemeController.updateThemes());

	}
}
