package bgtransport.view;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * A custom JLabel that is used to display large text. This class extends
 * {@link JLabel} and provides default font settings with centered text
 * alignment.
 */
public class VeryBigLabel extends JLabel {

	private static final long serialVersionUID = 4243870959613480583L;

	/**
	 * Constructs a {@code VeryBigLabel} with the specified text. The text is
	 * centered, and the font is set to "SanSerif", bold, and size 16.
	 *
	 * @param text the text to be displayed in the label
	 */
	public VeryBigLabel(String text) {
		super(text, SwingConstants.CENTER);
		setOpaque(false);
		setFont(new Font("SanSerif", Font.BOLD, 16));
	}

	/**
	 * Constructs a {@code VeryBigLabel} with no text. The font is set to
	 * "SanSerif", bold, and size 16 by default.
	 */
	public VeryBigLabel() {
		setOpaque(false);
		setFont(new Font("SanSerif", Font.BOLD, 16));
	}
}
