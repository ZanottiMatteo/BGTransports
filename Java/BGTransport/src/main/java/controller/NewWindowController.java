package controller;

import javax.swing.SwingUtilities;

import view.LogInWindow;

public class NewWindowController {

	public static void openSignUp() {
		SwingUtilities.invokeLater(() -> {new LogInWindow().setVisible(true); });
	}
}
