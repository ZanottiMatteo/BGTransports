package bgtransport.view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * MenuPanel class represents the side menu of the application, encapsulating
 * the layout and components like buttons for navigation. It provides buttons
 * for the user to navigate through various sections of the application.
 */
public class MenuPanel extends RoundedPanel {

	private static final long serialVersionUID = 7341471637413744104L;

	public final Point menupanelpoint = new Point(15, 30);

	public JButton userButton = new JButton();
	public JButton homeButton = new JButton();
	public JButton mapButton = new JButton();
	public JButton lineButton = new JButton();
	public JButton switchThemeButton = new JButton();
	public JButton databaseButton = new JButton();

	public final ImageIcon iconUser = new ImageIcon(MenuPanel.class.getResource("/images/User.png"));
	public final ImageIcon iconLDmode = new ImageIcon(MenuPanel.class.getResource("/images/LDMode.png"));
	public final ImageIcon iconMap = new ImageIcon(MenuPanel.class.getResource("/images/Map.png"));
	public final ImageIcon iconHome = new ImageIcon(MenuPanel.class.getResource("/images/Home.png"));
	public final ImageIcon iconLine = new ImageIcon(MenuPanel.class.getResource("/images/Line.png"));
	public final ImageIcon iconDatabase = new ImageIcon(MenuPanel.class.getResource("/images/Database.png"));
	
	public final ImageIcon iconUserD = new ImageIcon(MenuPanel.class.getResource("/images/UserDark.png"));
	public final ImageIcon iconLDmodeD = new ImageIcon(MenuPanel.class.getResource("/images/LDModeDark.png"));
	public final ImageIcon iconMapD = new ImageIcon(MenuPanel.class.getResource("/images/MapDark.png"));
	public final ImageIcon iconHomeD = new ImageIcon(MenuPanel.class.getResource("/images/HomeDark.png"));
	public final ImageIcon iconLineD = new ImageIcon(MenuPanel.class.getResource("/images/LineDark.png"));
	public final ImageIcon iconDatabaseD = new ImageIcon(MenuPanel.class.getResource("/images/DatabaseDark.png"));

	public transient Map<Component, Rectangle> componentBounds = new HashMap<>();

	/**
	 * Constructor for MenuPanel. Sets up the layout and buttons within the menu.
	 * Initializes all components, including buttons with their icons and positions.
	 */
	public MenuPanel() {
		setLayout(null);
		setBounds(15, 30, 100, 900); // Position and size of the menu panel
		setBackground(new Color(210, 105, 30));
		setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

		setupMenuButtons();
	}

	/**
	 * Sets up the menu buttons with the provided icons. Each button is positioned
	 * within the menu and given an icon.
	 * 
	 * @param iconUser     The icon for the user button.
	 * @param iconHome     The icon for the home button.
	 * @param iconMap      The icon for the map button.
	 * @param iconLine     The icon for the line button.
	 * @param iconDatabase The icon for the database button.
	 * @param iconLDmode   The icon for the switch theme button.
	 */
	private void setupMenuButtons() {

		userButton.setBounds(20, 20, 60, 60);
		userButton.setBorderPainted(false);
		userButton.setRolloverEnabled(false);
		userButton.setBackground(new Color(0, 0, 0, 0));
		add(userButton);
		
		homeButton.setBounds(20, 140, 60, 60);
		homeButton.setBorderPainted(false);
		homeButton.setRolloverEnabled(false);
		homeButton.setBackground(new Color(0, 0, 0, 0));
		add(homeButton);

		mapButton.setBounds(20, 260, 60, 60);
		mapButton.setBorderPainted(false);
		mapButton.setRolloverEnabled(false);
		mapButton.setBackground(new Color(0, 0, 0, 0));
		add(mapButton);

		lineButton.setBounds(20, 380, 60, 60);
		lineButton.setBorderPainted(false);
		lineButton.setRolloverEnabled(false);
		lineButton.setBackground(new Color(0, 0, 0, 0));
		add(lineButton);

		databaseButton.setBounds(20, 500, 60, 60);
		databaseButton.setBorderPainted(false);
		databaseButton.setRolloverEnabled(false);
		databaseButton.setBackground(new Color(0, 0, 0, 0));
		add(databaseButton);

		switchThemeButton.setBounds(20, 830, 60, 60);
		switchThemeButton.setBorderPainted(false);
		switchThemeButton.setRolloverEnabled(false);
		switchThemeButton.setBackground(new Color(0, 0, 0, 0));
		add(switchThemeButton);

		for (Component comp : getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
	}
}
