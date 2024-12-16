package bgtransport.view;

import javax.swing.*;
import java.awt.*;

public class CircleLabel extends JLabel {

	private Color circleColor = new Color(0, 0, 0, 0);
	private Color borderColor = new Color(0, 0, 0, 0);

	public CircleLabel(String text) {
		super(text, SwingConstants.CENTER);
		setOpaque(false); // Make background transparent
		setForeground(Color.WHITE); // Text color
	}

	public CircleLabel() {
		setOpaque(false);
	}

	public void setCircleColor(Color color) {
		this.circleColor = color;
		repaint(); // Repaint the label with the new color
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension size = super.getPreferredSize();
		int diameter = Math.max(size.width, size.height);
		return new Dimension(diameter, diameter); // Ensure the label is a perfect circle
	}

	@Override
	protected void paintComponent(Graphics g) {
		int diameter = Math.min(getWidth(), getHeight());
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw the circular background
		g2d.setColor(circleColor);
		g2d.fillOval(0, 0, diameter, diameter);

		// Draw the label text
		super.paintComponent(g2d);
	}

	public void setBorderColor(Color color) {
		this.borderColor = color; // Set the desired border color
		repaint(); // Trigger a repaint to update the border color
	}

	@Override
	protected void paintBorder(Graphics g) {
		int diameter = Math.min(getWidth(), getHeight());
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Optional: Draw a border
		g2d.setColor(borderColor);
		g2d.drawOval(0, 0, diameter - 1, diameter - 1);
	}

	public void drawImage(Graphics g, Image image) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this); // Draw background image.
	}

}