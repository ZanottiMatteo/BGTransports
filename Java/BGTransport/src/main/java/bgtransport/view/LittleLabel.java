package bgtransport.view;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * A custom JLabel with a smaller font style and centered alignment. 
 * This label is used for displaying smaller text in the application.
 */
public class LittleLabel extends JLabel {

    private static final long serialVersionUID = 3379242768900167677L;

    /**
     * Constructs a LittleLabel with the specified text.
     * The label will have centered text and a bold font of size 16.
     * 
     * @param text The text to display in the label.
     */
    public LittleLabel(String text) {
        super(text, SwingConstants.CENTER);
        setOpaque(false);
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }

    /**
     * Constructs an empty LittleLabel.
     * The label will have centered text and a bold font of size 16.
     */
    public LittleLabel() {
        setOpaque(false);
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }
}
