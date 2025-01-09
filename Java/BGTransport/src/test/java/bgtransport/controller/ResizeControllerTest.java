package bgtransport.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.jxmapviewer.JXMapViewer;

class ResizeControllerTest {

    private Dimension originalPanelSize;
    private JFrame jframe;
    private JPanel panel;
    private Map<Component, Rectangle> componentBounds;

    @BeforeEach
    void setUp() {
        originalPanelSize = new Dimension(800, 600);
        jframe = new JFrame();
        jframe.setSize(1600, 1200); // Simulate resizing the frame
        panel = new JPanel();
        panel.setPreferredSize(originalPanelSize);

        componentBounds = new HashMap<>();
        JLabel label = new JLabel("Test Label");
        JButton button = new JButton("Test Button");

        // Set initial bounds for components
        componentBounds.put(label, new Rectangle(50, 50, 100, 30));
        componentBounds.put(button, new Rectangle(200, 200, 150, 50));

        panel.add(label);
        panel.add(button);
    }

    @Test
    void testResizeComponents() {
        ResizeController.resizeComponents(originalPanelSize, jframe, componentBounds, panel);

        // Verify that each component has been resized and repositioned
        for (Map.Entry<Component, Rectangle> entry : componentBounds.entrySet()) {
            Component component = entry.getKey();
            Rectangle originalBounds = entry.getValue();
            Rectangle expectedBounds = new Rectangle(
                    (int) (originalBounds.x * 2),
                    (int) (originalBounds.y * 2),
                    (int) (originalBounds.width * 2),
                    (int) (originalBounds.height * 2)
            );
            assertEquals(expectedBounds, component.getBounds());
        }
    }

    @Test
    void testResizePanel() {
        Point originalPoint = new Point(100, 100);
        Dimension panelDimension = new Dimension(400, 300);

        ResizeController.resizePanel(originalPanelSize, jframe, panel, panelDimension, originalPoint);

        Rectangle expectedBounds = new Rectangle(
                (int) (originalPoint.x * 2),
                (int) (originalPoint.y * 2),
                (int) (panelDimension.width * 2),
                (int) (panelDimension.height * 2)
        );

        assertEquals(expectedBounds, panel.getBounds());
    }

    @Test
    void testResizeImageButton() {
        ImageIcon originalImage = new ImageIcon(new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB));
        JButton button = new JButton();

        ResizeController.resizeImageButton(originalPanelSize, jframe, originalImage, button);

        // Verify that the button's icon has been resized
        ImageIcon resizedIcon = (ImageIcon) button.getIcon();
        assertNotNull(resizedIcon);
        assertEquals(200, resizedIcon.getIconWidth());
        assertEquals(100, resizedIcon.getIconHeight());
    }

    @Test
    void testResizeImageLabel() {
        ImageIcon originalImage = new ImageIcon(new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB));
        JLabel label = new JLabel();

        ResizeController.resizeImageLabel(originalPanelSize, jframe, originalImage, label);

        // Verify that the label's icon has been resized
        ImageIcon resizedIcon = (ImageIcon) label.getIcon();
        assertNotNull(resizedIcon);
        assertEquals(400, resizedIcon.getIconWidth());
        assertEquals(200, resizedIcon.getIconHeight());
    }

    @Test
    void testResizeJXMapViewer() {
        JXMapViewer mapViewer = new JXMapViewer();
        Dimension mapDimension = new Dimension(600, 400);
        Point mapPoint = new Point(50, 50);

        ResizeController.resizePanel(originalPanelSize, jframe, mapViewer, mapDimension, mapPoint);

        Rectangle expectedBounds = new Rectangle(
                (int) (mapPoint.x * 2),
                (int) (mapPoint.y * 2),
                (int) (mapDimension.width * 2),
                (int) (mapDimension.height * 2)
        );

        assertEquals(expectedBounds, mapViewer.getBounds());
    }
}
