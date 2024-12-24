package bgtransport.view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a widget that displays the current time and date. The
 * widget shows the time and date on a custom panel with graphical components
 * (labels for the time and date). It extends the {@link RoundedPanel} class for
 * the rounded panel design.
 */
public class TimeWidget extends RoundedPanel {

	private static final long serialVersionUID = 3853592167184484370L;

	public static VeryBigLabel lbltime = new VeryBigLabel();
	public static JLabel lbldate = new JLabel();

	public final Point timepanelpoint = new Point(1450, 620);

	public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();

	/**
	 * Constructor for the TimeWidget. It initializes the layout and sets up the
	 * components.
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
	 * Configures the visual components for displaying the time and date. It sets
	 * the labels for time and date with specific styles and sizes, and then adds
	 * them to the panel.
	 * 
	 * @throws Exception If an error occurs during the configuration of the
	 *                   components.
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

		for (Component comp : getComponents()) {
			componentBounds.put(comp, comp.getBounds());
		}
	}
}
