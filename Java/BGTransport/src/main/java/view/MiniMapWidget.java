package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * MiniMapWidget class represents a panel displaying a small map.
 * It is designed to encapsulate all functionalities related to the map panel.
 */
public class MiniMapWidget extends RoundedPanel {

    public final Point miniMapPanelPoint = new Point(1200, 30);
    public final Point mappoint = new Point(25, 25);
    public Map<Component, Rectangle> componentBounds = new HashMap<>();

    /**
     * Constructor for MiniMapWidget.
     * Sets up the layout and initial configuration for the map panel.
     */
    public MiniMapWidget() {
        setLayout(null);
        setBounds(1200, 30, 600, 400);

        setupMiniMapComponents();
    }

    /**
     * Sets up the components for the MiniMap panel.
     */
    private void setupMiniMapComponents() {
        // Example: Add a JLabel or placeholder for the map
        JLabel mapPlaceholder = new JLabel("Mini Map");
        mapPlaceholder.setHorizontalAlignment(SwingConstants.CENTER);
        mapPlaceholder.setFont(new Font("SansSerif", Font.BOLD, 20));
        mapPlaceholder.setBounds(25, 25, 550, 350);
        mapPlaceholder.setBackground(new Color(200, 200, 200));
        mapPlaceholder.setOpaque(true);

        add(mapPlaceholder);

        // Store component bounds for resizing purposes
        for (Component comp : getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
    }
}