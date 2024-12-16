package bgtransport.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * MenuPanel class represents the side menu of the application,
 * encapsulating the layout and components like buttons for navigation.
 */
public class MenuPanel extends RoundedPanel {

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

    public transient Map<Component, Rectangle> componentBounds = new HashMap<>();

    /**
     * Constructor for MenuPanel.
     * Sets up the layout and buttons within the menu.
     */
    public MenuPanel() {
        setLayout(null);
        setBounds(15, 30, 100, 900); // Position and size of the menu panel
        setBackground(new Color(210, 105, 30));
        setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        setupMenuButtons(iconUser, iconHome, iconMap, iconLine, iconDatabase, iconLDmode);
    }

    /**
     * Sets up the menu buttons with the provided icons.
     */
    private void setupMenuButtons(ImageIcon iconUser, ImageIcon iconHome, ImageIcon iconMap, ImageIcon iconLine, ImageIcon iconDatabase, ImageIcon iconLDmode) {
        // User button
        userButton = createMenuButton(iconUser, 20, 20);
        add(userButton);

        // Home button
        homeButton = createMenuButton(iconHome, 20, 140);
        add(homeButton);

        // Map button
        mapButton = createMenuButton(iconMap, 20, 260);
        add(mapButton);
        
        // Map button
        lineButton = createMenuButton(iconLine, 20, 380);
        add(lineButton);
        
        databaseButton = createMenuButton(iconDatabase, 20, 500);
        add(databaseButton);

        // Theme switch button
        switchThemeButton = createMenuButton(iconLDmode, 20, 830);
        add(switchThemeButton);

        // Store component bounds for resizing
        for (Component comp : getComponents()) {
            componentBounds.put(comp, comp.getBounds());
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
}
