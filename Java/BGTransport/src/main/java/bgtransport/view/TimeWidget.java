package bgtransport.view;

import javax.swing.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * TimeWidget class represents a panel displaying time-related information,
 * including the current time and date.
 */
public class TimeWidget extends RoundedPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3853592167184484370L;
	public static VeryBigLabel lbltime = new VeryBigLabel();
    public static JLabel lbldate = new JLabel();
    public final Point timepanelpoint = new Point(1450, 620);

    public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();

    /**
     * Constructor for TimeWidget.
     * Sets up the layout and adds time-related components.
     * @throws Exception 
     */
    public TimeWidget() {
        setLayout(null);
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

    	lbltime.setHorizontalAlignment(SwingConstants.CENTER);
        lbltime.setFont(new Font("SansSerif", Font.BOLD, 20));
        lbltime.setBounds(25, 25, 300, 130);

        lbldate.setHorizontalAlignment(SwingConstants.CENTER);
        lbldate.setFont(new Font("SansSerif", Font.BOLD, 20));
        lbldate.setBounds(25, 166, 300, 60);

        add(lbltime);
        add(lbldate);

        // Store initial component bounds for resizing.
        for (Component comp : getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
    }
}
