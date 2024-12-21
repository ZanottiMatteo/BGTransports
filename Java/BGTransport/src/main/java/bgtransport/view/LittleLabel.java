package bgtransport.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LittleLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3379242768900167677L;

	public LittleLabel(String text) {
        super(text, SwingConstants.CENTER);
        setOpaque(false); // Make background transparent
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }
	
	public LittleLabel() {
        setOpaque(false); // Make background transparent
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }
}
