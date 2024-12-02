package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MiniLabel extends JLabel{

	public MiniLabel(String text) {
        super(text, SwingConstants.CENTER);
        setOpaque(false); // Make background transparent
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }
	
	public MiniLabel() {
        setOpaque(false); // Make background transparent
        setFont(new Font("SanSerif", Font.BOLD, 16));
    }
}
