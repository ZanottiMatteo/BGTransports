package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.TimestampModel;

/**
 * TimeWidget class represents a panel displaying time-related information,
 * including the current time and date.
 */
public class TimeWidget extends RoundedPanel {

    public JLabel lbltime = new JLabel();
    public JLabel lbldate = new JLabel();
    public final Point timepanelpoint = new Point(235, 310);

    public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();

    /**
     * Constructor for TimeWidget.
     * Sets up the layout and adds time-related components.
     * @throws Exception 
     */
    public TimeWidget() {
        setLayout(null);
        setBounds(235, 310, 350, 180);

        try {
			setupTimeComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * Sets up the time-related components.
     * @throws Exception 
     */
    private void setupTimeComponents() throws Exception {
        try {
            TimestampModel.getTime(lbltime);
            TimestampModel.getDate(lbldate);
        } catch (IOException e) {
            e.printStackTrace();
        }

        lbltime.setHorizontalAlignment(SwingConstants.CENTER);
        lbltime.setFont(new Font("SansSerif", Font.BOLD, 20));
        lbltime.setBounds(65, 25, 220, 50);

        lbldate.setHorizontalAlignment(SwingConstants.CENTER);
        lbldate.setFont(new Font("SansSerif", Font.BOLD, 20));
        lbldate.setBounds(65, 110, 220, 50);

        add(lbltime);
        add(lbldate);

        // Store initial component bounds for resizing.
        for (Component comp : getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
    }
}
