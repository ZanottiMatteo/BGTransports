package bgtransport.controller;

/**
 * The {@code ThemeController} class is responsible for managing the application's themes, 
 * including light and dark modes. It updates the UI components of various views 
 * to reflect the selected theme and handles look-and-feel changes at a global level.
 */
import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarkLaf;

import bgtransport.model.MyLighterLaf;
import bgtransport.view.DatabaseView;
import bgtransport.view.HomeView;
import bgtransport.view.LineView;
import bgtransport.view.LoginView;
import bgtransport.view.MapView;
import bgtransport.view.UserView;

public class ThemeController {

	/**
	 * Boolean flag to determine the current theme. {@code true} indicates the dark
	 * theme is active, {@code false} indicates the light theme.
	 */
	public static boolean themeLight = true;

	/**
	 * Applies the current theme to the {@code HomeView} panel.
	 * 
	 * @param homeV the {@code HomeView} instance to update.
	 */
	public static void setThemeHomePanel(HomeView homeV) {
		if (themeLight) {
			homeV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background
			homeV.infoPanel.logoLabelD.setVisible(false);
			homeV.infoPanel.logoLabel.setVisible(true);
			homeV.menuPanel.databaseButton.setIcon(homeV.menuPanel.iconDatabase);
			homeV.menuPanel.lineButton.setIcon(homeV.menuPanel.iconLine);
			homeV.menuPanel.mapButton.setIcon(homeV.menuPanel.iconMap);
			homeV.menuPanel.switchThemeButton.setIcon(homeV.menuPanel.iconLDmode);
			homeV.menuPanel.userButton.setIcon(homeV.menuPanel.iconUser);
			homeV.menuPanel.homeButton.setIcon(homeV.menuPanel.iconHome);
		} else {
			homeV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
			homeV.infoPanel.logoLabel.setVisible(false);
			homeV.infoPanel.logoLabelD.setVisible(true);
			homeV.menuPanel.databaseButton.setIcon(homeV.menuPanel.iconDatabaseD);
			homeV.menuPanel.lineButton.setIcon(homeV.menuPanel.iconLineD);
			homeV.menuPanel.mapButton.setIcon(homeV.menuPanel.iconMapD);
			homeV.menuPanel.switchThemeButton.setIcon(homeV.menuPanel.iconLDmodeD);
			homeV.menuPanel.userButton.setIcon(homeV.menuPanel.iconUserD);
			homeV.menuPanel.homeButton.setIcon(homeV.menuPanel.iconHomeD);
		}
		if (homeV.getExtendedState() != JFrame.MAXIMIZED_BOTH) {
			homeV.setSize(homeV.getWidth() + 1, homeV.getHeight());
			homeV.setSize(homeV.getWidth() - 1, homeV.getHeight());
		}
	}

	/**
	 * Applies the current theme to the {@code MapView} panel.
	 * 
	 * @param mapV the {@code MapView} instance to update.
	 */
	public static void setThemeMapPanel(MapView mapV) {
		if (themeLight) {
			mapV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background
			mapV.menuPanel.databaseButton.setIcon(mapV.menuPanel.iconDatabase);
			mapV.menuPanel.lineButton.setIcon(mapV.menuPanel.iconLine);
			mapV.menuPanel.mapButton.setIcon(mapV.menuPanel.iconMap);
			mapV.menuPanel.switchThemeButton.setIcon(mapV.menuPanel.iconLDmode);
			mapV.menuPanel.userButton.setIcon(mapV.menuPanel.iconUser);
			mapV.menuPanel.homeButton.setIcon(mapV.menuPanel.iconHome);
		} else {
			mapV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
			mapV.menuPanel.databaseButton.setIcon(mapV.menuPanel.iconDatabaseD);
			mapV.menuPanel.lineButton.setIcon(mapV.menuPanel.iconLineD);
			mapV.menuPanel.mapButton.setIcon(mapV.menuPanel.iconMapD);
			mapV.menuPanel.switchThemeButton.setIcon(mapV.menuPanel.iconLDmodeD);
			mapV.menuPanel.userButton.setIcon(mapV.menuPanel.iconUserD);
			mapV.menuPanel.homeButton.setIcon(mapV.menuPanel.iconHomeD);
		}
		if ((mapV.getExtendedState() != JFrame.MAXIMIZED_BOTH)) {
		mapV.setSize(mapV.getWidth() + 1, mapV.getHeight());
		mapV.setSize(mapV.getWidth() - 1, mapV.getHeight());
		}
	}

	/**
	 * Applies the current theme to the {@code UserView} panel.
	 * 
	 * @param userV the {@code UserView} instance to update.
	 */
	public static void setThemeUserPanel(UserView userV) {
		if (themeLight) {
			userV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background
			userV.menuPanel.databaseButton.setIcon(userV.menuPanel.iconDatabase);
			userV.menuPanel.lineButton.setIcon(userV.menuPanel.iconLine);
			userV.menuPanel.mapButton.setIcon(userV.menuPanel.iconMap);
			userV.menuPanel.switchThemeButton.setIcon(userV.menuPanel.iconLDmode);
			userV.menuPanel.userButton.setIcon(userV.menuPanel.iconUser);
			userV.menuPanel.homeButton.setIcon(userV.menuPanel.iconHome);
		} else {
			userV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
			userV.menuPanel.databaseButton.setIcon(userV.menuPanel.iconDatabaseD);
			userV.menuPanel.lineButton.setIcon(userV.menuPanel.iconLineD);
			userV.menuPanel.mapButton.setIcon(userV.menuPanel.iconMapD);
			userV.menuPanel.switchThemeButton.setIcon(userV.menuPanel.iconLDmodeD);
			userV.menuPanel.userButton.setIcon(userV.menuPanel.iconUserD);
			userV.menuPanel.homeButton.setIcon(userV.menuPanel.iconHomeD);
		}
		if ((userV.getExtendedState() != JFrame.MAXIMIZED_BOTH)) {
		userV.setSize(userV.getWidth() + 1, userV.getHeight());
		userV.setSize(userV.getWidth() - 1, userV.getHeight());
		}
	}

	/**
	 * Applies the current theme to the {@code LineView} panel.
	 * 
	 * @param lineV the {@code LineView} instance to update.
	 */
	public static void setThemeLinePanel(LineView lineV) {
		if (themeLight) {
			lineV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background
			lineV.menuPanel.databaseButton.setIcon(lineV.menuPanel.iconDatabase);
			lineV.menuPanel.lineButton.setIcon(lineV.menuPanel.iconLine);
			lineV.menuPanel.mapButton.setIcon(lineV.menuPanel.iconMap);
			lineV.menuPanel.switchThemeButton.setIcon(lineV.menuPanel.iconLDmode);
			lineV.menuPanel.userButton.setIcon(lineV.menuPanel.iconUser);
			lineV.menuPanel.homeButton.setIcon(lineV.menuPanel.iconHome);
		} else {
			lineV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
			lineV.menuPanel.databaseButton.setIcon(lineV.menuPanel.iconDatabaseD);
			lineV.menuPanel.lineButton.setIcon(lineV.menuPanel.iconLineD);
			lineV.menuPanel.mapButton.setIcon(lineV.menuPanel.iconMapD);
			lineV.menuPanel.switchThemeButton.setIcon(lineV.menuPanel.iconLDmodeD);
			lineV.menuPanel.userButton.setIcon(lineV.menuPanel.iconUserD);
			lineV.menuPanel.homeButton.setIcon(lineV.menuPanel.iconHomeD);
		}
		if ((lineV.getExtendedState() != JFrame.MAXIMIZED_BOTH)) {
			lineV.setSize(lineV.getWidth() + 1, lineV.getHeight());
			lineV.setSize(lineV.getWidth() - 1, lineV.getHeight());
		}
	}

	/**
	 * Applies the current theme to the {@code DatabaseView} panel.
	 * 
	 * @param databaseV the {@code DatabaseView} instance to update.
	 */
	public static void setThemeDatabasePanel(DatabaseView databaseV) {
		if (themeLight) {
			databaseV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background
			databaseV.menuPanel.databaseButton.setIcon(databaseV.menuPanel.iconDatabase);
			databaseV.menuPanel.lineButton.setIcon(databaseV.menuPanel.iconLine);
			databaseV.menuPanel.mapButton.setIcon(databaseV.menuPanel.iconMap);
			databaseV.menuPanel.switchThemeButton.setIcon(databaseV.menuPanel.iconLDmode);
			databaseV.menuPanel.userButton.setIcon(databaseV.menuPanel.iconUser);
			databaseV.menuPanel.homeButton.setIcon(databaseV.menuPanel.iconHome);
		} else {
			databaseV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
			databaseV.menuPanel.databaseButton.setIcon(databaseV.menuPanel.iconDatabaseD);
			databaseV.menuPanel.lineButton.setIcon(databaseV.menuPanel.iconLineD);
			databaseV.menuPanel.mapButton.setIcon(databaseV.menuPanel.iconMapD);
			databaseV.menuPanel.switchThemeButton.setIcon(databaseV.menuPanel.iconLDmodeD);
			databaseV.menuPanel.userButton.setIcon(databaseV.menuPanel.iconUserD);
			databaseV.menuPanel.homeButton.setIcon(databaseV.menuPanel.iconHomeD);
		}
		if ((databaseV.getExtendedState() != JFrame.MAXIMIZED_BOTH)) {
		databaseV.setSize(databaseV.getWidth() + 1, databaseV.getHeight());
		databaseV.setSize(databaseV.getWidth() - 1, databaseV.getHeight());
		}
	}

	/**
	 * Applies the current theme to the {@code LoginView} panel.
	 * 
	 * @param loginV the {@code LoginView} instance to update.
	 */
	public static void setThemeLoginPanel(LoginView loginV) {
		if (themeLight) {
			loginV.logoLabelD.setVisible(false);
			loginV.logoLabel.setVisible(true);
			loginV.switchThemeButton.setIcon(loginV.iconLDmode);
			loginV.returnButton.setIcon(loginV.iconReturn);
		} else {
			loginV.logoLabel.setVisible(false);
			loginV.logoLabelD.setVisible(true);
			loginV.switchThemeButton.setIcon(loginV.iconLDmodeD);
			loginV.returnButton.setIcon(loginV.iconReturnD);
		}
		
		if ((loginV.getExtendedState() != JFrame.MAXIMIZED_BOTH)) {
			loginV.setSize(loginV.getWidth() + 1, loginV.getHeight());
			loginV.setSize(loginV.getWidth() - 1, loginV.getHeight());
		}
	}

	/**
	 * Toggles the theme between light and dark modes, updating the global
	 * look-and-feel and refreshing all views to reflect the change.
	 */
	public static void toggleThemes() {
		themeLight = !themeLight;
		updateThemes();

	}

	public static void updateThemes() {
		try {
			if (themeLight) {
				UIManager.setLookAndFeel(new MyLighterLaf());
			} else if (!themeLight) {
				UIManager.setLookAndFeel(new FlatDarkLaf());
			}
			// Update all windows with the new look-and-feel
			for (Window window : Window.getWindows()) {
				SwingUtilities.updateComponentTreeUI(window);
			}
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		setThemeLoginPanel(MainController.loginV);
		setThemeHomePanel(MainController.homeV);
		setThemeMapPanel(MainController.mapV);

		setThemeUserPanel(MainController.userV);
		setThemeLinePanel(MainController.lineV);
		setThemeDatabasePanel(MainController.databaseV);
	}

	/**
	 * Retrieves the current theme status.
	 * 
	 * @return {@code true} if the dark theme is active, {@code false} otherwise.
	 */
	public static boolean getTheme() {
		return themeLight;
	}
}
