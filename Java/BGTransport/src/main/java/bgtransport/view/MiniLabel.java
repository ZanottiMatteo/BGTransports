package bgtransport.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * MiniLabel is a custom JLabel that is used to display text in a small,
 * centered format. It applies a bold SanSerif font with a size of 16 and is
 * transparent.
 */
public class MiniLabel extends JLabel {

	private static final long serialVersionUID = -8782867696914753464L;

	/**
	 * Constructs a MiniLabel with the specified text. The label text is centered
	 * and displayed with a bold SanSerif font of size 16.
	 * 
	 * @param text The text to be displayed in the label.
	 */
	public MiniLabel(String text) {
		super(text, SwingConstants.CENTER);
		setOpaque(false);
		setFont(new Font("SanSerif", Font.BOLD, 16));
	}

	/**
	 * Constructs a MiniLabel with an empty text. The label is centered and
	 * displayed with a bold SanSerif font of size 16.
	 */
	public MiniLabel() {
		setOpaque(false);
		setFont(new Font("SanSerif", Font.BOLD, 16));
	}
}
