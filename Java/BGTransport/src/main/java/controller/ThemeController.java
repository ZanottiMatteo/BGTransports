package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Window;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import view.HomeView;
import view.LoginView;
import view.MapView;
import view.SignUpWindow;

public class ThemeController {

	public static boolean themeL = false;
	

	public static void setThemeHomePanel(HomeView homeV) {

		if (UIManager.getLookAndFeel() instanceof FlatDarkLaf && !themeL) {
			themeL = true;
			FlatLightLaf.setup();
		} else if (UIManager.getLookAndFeel() instanceof FlatLightLaf && themeL){
			themeL = false;
			FlatDarkLaf.setup();
		}

		// Update the Look and Feel for the entire component tree
		for (Window window : Window.getWindows()) {
			SwingUtilities.updateComponentTreeUI(window);
		}

		// Adjust specific component properties if necessary
		if (themeL) {
			homeV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
		} else {
			homeV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
		}
		
	}
	
	public static void setThemeMapPanel(MapView mapV) {

		if (UIManager.getLookAndFeel() instanceof FlatDarkLaf && !themeL) {
			themeL = true;
			FlatLightLaf.setup();
		} else if (UIManager.getLookAndFeel() instanceof FlatLightLaf && themeL){
			themeL = false;
			FlatDarkLaf.setup();
		}
		
		// Update the Look and Feel for the entire component tree
		for (Window window : Window.getWindows()) {
			SwingUtilities.updateComponentTreeUI(window);
		}

		// Adjust specific component properties if necessary
		if (themeL) {
			mapV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
		} else {
			mapV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
		}
		
		
	}

	public static void setThemeLoginPanel(LoginView loginV) {

		if (UIManager.getLookAndFeel() instanceof FlatDarkLaf && !themeL) {
			themeL = true;
			FlatLightLaf.setup();
		} else if (UIManager.getLookAndFeel() instanceof FlatLightLaf && themeL){
			themeL = false;
			FlatDarkLaf.setup();
		}
	
		for (Window window : Window.getWindows()) {
			SwingUtilities.updateComponentTreeUI(window);
		}
		
		if (themeL) {
			loginV.LogoLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/Logo.png")));
		} else {
			loginV.LogoLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/LogoDark.png")));
		}
	}
		
	public static void setThemeSignUpPanel(SignUpWindow signupV) {
		if (UIManager.getLookAndFeel() instanceof FlatDarkLaf && !themeL) {
			themeL = true;
			FlatLightLaf.setup();
		} else if (UIManager.getLookAndFeel() instanceof FlatLightLaf && themeL){
			themeL = false;
			FlatDarkLaf.setup();
		}
	}
	
	public static void updateThemes() {
		themeL = !themeL;
		 try {
	        if (getTheme()) {
	            UIManager.setLookAndFeel(new FlatLightLaf());
	        } else {
	            UIManager.setLookAndFeel(new FlatDarkLaf());
	        }
	        // Aggiorna tutti i componenti del sistema
	        for (Window window : Window.getWindows()) {
	            SwingUtilities.updateComponentTreeUI(window);
	        }
		 }
	        catch (UnsupportedLookAndFeelException e) {
	            e.printStackTrace();
	        }

		setThemeHomePanel(MainController.homeV);
		setThemeMapPanel(MainController.mapV);
		setThemeLoginPanel(MainController.loginV);
		setThemeSignUpPanel(MainController.signupV);
	}
	
	/*
	 * Theme setted by variable
	 * 
	 * @return theme, if 1 -> dark | 0 -> light
	 */
	public static boolean getTheme() {
		return themeL;
	}
}
