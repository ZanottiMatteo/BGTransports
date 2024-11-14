package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g.create();
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setColor(getBackground());
	        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
	        g2d.dispose();
	    }

	    @Override
	    public void setOpaque(boolean isOpaque) {
	        super.setOpaque(false);
	    }
}
