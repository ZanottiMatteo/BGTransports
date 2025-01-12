package bgtransport.view;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * The TitleWidget class displays the application logo. It supports both light and dark themes.
 */
public class TitleWidget extends RoundedPanel {

    private static final long serialVersionUID = -3241355394732881103L;
    
    public final Point infopanelpoint = new Point(235, 30);
    public JLabel logoLabel = new JLabel();
    public JLabel logoLabelD = new JLabel();
    public ImageIcon iconLogo = new ImageIcon(TitleWidget.class.getResource("/images/Logo.png"));
    public ImageIcon iconLogoD = new ImageIcon(TitleWidget.class.getResource("/images/LogoDark.png"));
    public final transient Map<Component, Rectangle> componentBounds = new HashMap<>();

    /**
     * Constructs a TitleWidget and sets up the components (logos).
     */
    public TitleWidget() {
        setLayout(null);
        setupUserComponents();
    }

    /**
     * Initializes and adds the logo labels to the widget.
     */
    private void setupUserComponents() {
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setBounds(484, -65, 596, 260);
        logoLabel.setIcon(iconLogo);
        add(logoLabel);
        
        logoLabelD.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabelD.setBounds(484, -65, 596, 260);
        logoLabelD.setIcon(iconLogoD);
        add(logoLabelD);

        for (Component comp : getComponents()) {
            componentBounds.put(comp, comp.getBounds());
        }
    }
}
