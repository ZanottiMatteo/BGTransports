package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VeryBigLabel extends JLabel{

	public VeryBigLabel(String text) {
        super(text, SwingConstants.CENTER);
        setOpaque(false); // Make background transparent
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }
	
	public VeryBigLabel() {
        setOpaque(false); // Make background transparent
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }
}
