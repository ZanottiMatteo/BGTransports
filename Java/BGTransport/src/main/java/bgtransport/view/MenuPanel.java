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

	public JButton userButton;
	public JButton homeButton;
	public JButton mapButton;
	public JButton lineButton;
	public JButton switchThemeButton;
	public JButton databaseButton;

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

		setupMenuButtons(iconUserD, iconHomeD, iconMapD, iconLineD, iconDatabaseD, iconLDmodeD);
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
	private void setupMenuButtons(ImageIcon iconUser, ImageIcon iconHome, ImageIcon iconMap, ImageIcon iconLine,
			ImageIcon iconDatabase, ImageIcon iconLDmode) {

		userButton = createMenuButton(iconUser, 20, 20);
		add(userButton);

		homeButton = createMenuButton(iconHome, 20, 140);
		add(homeButton);

		mapButton = createMenuButton(iconMap, 20, 260);
		add(mapButton);

		lineButton = createMenuButton(iconLine, 20, 380);
		add(lineButton);

		databaseButton = createMenuButton(iconDatabase, 20, 500);
		add(databaseButton);

		switchThemeButton = createMenuButton(iconLDmode, 20, 830);
		add(switchThemeButton);

		for (Component comp : getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
	}

	/**
	 * Creates a menu button with a specific icon and position. The button will have
	 * a transparent background and no borders, with a specific size.
	 * 
	 * @param icon The icon to display on the button.
	 * @param x    The x-coordinate of the button's position.
	 * @param y    The y-coordinate of the button's position.
	 * @return The created JButton with the given icon and position.
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
}
