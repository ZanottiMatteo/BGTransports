package bgtransport.controller;

import java.awt.Color;
import java.awt.Window;
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

	public static boolean themeDark = true;
	

	public static void setThemeHomePanel(HomeView homeV) {
		if (themeDark) {
			homeV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
			homeV.infoPanel.logoLabelD.setVisible(false);
			homeV.infoPanel.logoLabel.setVisible(true);			 
		} else {
			homeV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
			homeV.infoPanel.logoLabel.setVisible(false); 
			homeV.infoPanel.logoLabelD.setVisible(true); 
		}
		
	}
	
	public static void setThemeMapPanel(MapView mapV) {		
		if (themeDark) {
			mapV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
		} else {
			mapV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
		}	
	}

	public static void setThemeUserPanel(UserView userV) {	
		if (themeDark) {
			userV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
		} else {
			userV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
		}	
	}
	
	public static void setThemeLinePanel(LineView lineV) {	
		if (themeDark) {
			lineV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
		} else {
			lineV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
		}	
	}
	
	public static void setThemeDatabasePanel(DatabaseView datbaseV) {	
		if (themeDark) {
			datbaseV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
		} else {
			datbaseV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
		}	
	}
	
	public static void setThemeLoginPanel(LoginView loginV) {
		if (themeDark) {
			loginV.logoLabelD.setVisible(false);
			loginV.logoLabel.setVisible(true);			
		} else {
			loginV.logoLabel.setVisible(false);	
			loginV.logoLabelD.setVisible(true);				
		}
	}
	
	public static void updateThemes() {
		themeDark = !themeDark;
		 try {
	        if (getTheme()) {
	            UIManager.setLookAndFeel(new MyLighterLaf());
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
		    setThemeUserPanel(MainController.userV); 
		    setThemeLinePanel(MainController.lineV);
		    setThemeDatabasePanel(MainController.databaseV);
	}
	
	/*
	 * Theme setted by variable
	 * 
	 * @return theme, if 1 -> dark | 0 -> light
	 */
	public static boolean getTheme() {
		return themeDark;
	}
}
