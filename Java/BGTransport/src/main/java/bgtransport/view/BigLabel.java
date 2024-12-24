package bgtransport.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import bgtransport.model.ConstantString2;

/**
 * A custom JLabel class that represents a large, centered label with a specific font style.
 * This class provides a label with a default font and customization options.
 */
public class BigLabel extends JLabel {

    private static final long serialVersionUID = 4985667376776908255L;

    /**
     * Constructs a BigLabel with the specified text.
     * The text will be centered, and the label will have a bold font with size 16.
     * The label will not have a background color (opaque set to false).
     * 
     * @param text The text to be displayed on the label.
     */
    public BigLabel(String text) {
        super(text, SwingConstants.CENTER);
        setOpaque(false);
        setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
    }
    
    /**
     * Constructs a BigLabel with no text.
     * The label will be empty, centered, with a bold font of size 16, and no background color.
     */
    public BigLabel() {
        setOpaque(false);
        setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 16));
    }
}
