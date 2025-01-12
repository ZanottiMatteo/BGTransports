package bgtransport.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * A JPanel with rounded corners.
 */
public class RoundedPanel extends JPanel {

	private static final long serialVersionUID = -9132459862294043178L;

	/**
	 * Paints the component with rounded corners.
	 * 
	 * @param g The Graphics object used for painting.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(getBackground());
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
		g2d.dispose();
	}

	/**
	 * Sets the panel to be non-opaque.
	 * 
	 * @param isOpaque The opacity flag (ignored).
	 */
	@Override
	public void setOpaque(boolean isOpaque) {
		super.setOpaque(false);
	}
}
