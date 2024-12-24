package bgtransport.view;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * The MediumLabel class is a custom JLabel designed with specific properties
 * for text display. It allows the creation of labels with a central alignment
 * and a predefined font style. The label's text will be displayed in bold with
 * a default font size of 16.
 */
public class MediumLabel extends JLabel {

	private static final long serialVersionUID = 2874013393477463671L;

	/**
	 * Constructs a MediumLabel with the specified text. The text will be centered
	 * and displayed with a bold SanSerif font of size 16.
	 * 
	 * @param text The text to display on the label
	 */
	public MediumLabel(String text) {
		super(text, SwingConstants.CENTER);
		setOpaque(false);
		setFont(new Font("SanSerif", Font.BOLD, 16));
	}

	/**
	 * Constructs a MediumLabel with no initial text. The label will be empty but
	 * will have the same font properties and centered alignment.
	 */
	public MediumLabel() {
		setOpaque(false);
		setFont(new Font("SanSerif", Font.BOLD, 16));
	}
}
