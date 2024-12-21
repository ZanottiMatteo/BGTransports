package bgtransport.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BigLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4985667376776908255L;

	public BigLabel(String text) {
        super(text, SwingConstants.CENTER);
        setOpaque(false); // Make background transparent
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }
	
	public BigLabel() {
        setOpaque(false); // Make background transparent
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }
}
