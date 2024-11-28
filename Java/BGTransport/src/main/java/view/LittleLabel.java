package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LittleLabel extends JLabel{

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
