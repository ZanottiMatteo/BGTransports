package bgtransport.view;

import javax.swing.*;
import java.awt.*;

/**
 * A custom JLabel that displays text inside a circular shape.
 * The circle's color and border can be customized.
 * The label's content can be drawn with an optional image.
 */
public class CircleLabel extends JLabel {

    private static final long serialVersionUID = -6658732530121520664L;

    private Color circleColor = new Color(0, 0, 0, 0);
    private Color borderColor = new Color(0, 0, 0, 0);

    /**
     * Constructs a CircleLabel with the specified text.
     * The text is centered, and the label has a transparent background.
     *
     * @param text The text to be displayed inside the circle.
     */
    public CircleLabel(String text) {
        super(text, SwingConstants.CENTER);
        setOpaque(false);
        setForeground(Color.WHITE);
    }

    /**
     * Constructs a CircleLabel with no text.
     * The label will be empty, with a transparent background.
     */
    public CircleLabel() {
        setOpaque(false);
    }

    /**
     * Sets the color of the circle inside the label.
     * This method triggers a repaint to apply the color change.
     *
     * @param color The color to set for the circle.
     */
    public void setCircleColor(Color color) {
        this.circleColor = color;
        repaint();
    }

    /**
     * Returns the preferred size of the label.
     * The size will be a square based on the larger of the label's width or height.
     *
     * @return The preferred size of the label as a square.
     */
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        int diameter = Math.max(size.width, size.height);
        return new Dimension(diameter, diameter);
    }

    /**
     * Paints the component, drawing the circle and any content inside.
     * This method overrides the default painting behavior to draw a circular background.
     *
     * @param g The graphics context used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        int diameter = Math.min(getWidth(), getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(circleColor);
        g2d.fillOval(0, 0, diameter, diameter);

        super.paintComponent(g2d);
    }

    /**
     * Sets the color of the border around the circle.
     * This method triggers a repaint to apply the color change.
     *
     * @param color The color to set for the border.
     */
    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    /**
     * Paints the border around the circle.
     * This method overrides the default border painting behavior to draw a circular border.
     *
     * @param g The graphics context used for painting.
     */
    @Override
    protected void paintBorder(Graphics g) {
        int diameter = Math.min(getWidth(), getHeight());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(borderColor);
        g2d.drawOval(0, 0, diameter - 1, diameter - 1);
    }

    /**
     * Draws an image inside the circle.
     * This method allows an image to be drawn on the label's background.
     *
     * @param g The graphics context used for painting.
     * @param image The image to be drawn inside the circle.
     */
    public void drawImage(Graphics g, Image image) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
