package controller;

import javax.swing.SwingUtilities;

import view.SignUpWindow;

public class NewWindowController {

	public static void openSignUp() {
		SwingUtilities.invokeLater(() -> {new SignUpWindow().setVisible(true); });
	}
}
