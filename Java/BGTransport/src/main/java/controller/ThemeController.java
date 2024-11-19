package controller;

import java.awt.Color;
import java.awt.Window;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import view.HomeView;
import view.LoginView;

public class ThemeController {
	
	public static boolean themeL = true;
	
	public static void setTheme() {
	       
		if (UIManager.getLookAndFeel() instanceof FlatDarkLaf) 
        {
        	themeL = true;
            FlatLightLaf.setup();
        } 
        else 
        {
        	themeL = false;
            FlatDarkLaf.setup();
        }
        for (Window window : Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window);
        }
    }
	
	public static void setThemeHomePanel(HomeView homeV) {
	       
		if (UIManager.getLookAndFeel() instanceof FlatDarkLaf) 
        {
        	themeL = true;
            FlatLightLaf.setup();
            homeV.homePanel.setBackground(new Color(255, 255, 255, 100));
        } 
        else 
        {
        	themeL = false;
            FlatDarkLaf.setup();
            homeV.homePanel.setBackground(new Color(0, 0, 0, 100));
        }
    }
	
	public static void setThemeLabel(JLabel logoLabel) {
       
		if (UIManager.getLookAndFeel() instanceof FlatDarkLaf) 
        {
        	themeL = true;
            FlatLightLaf.setup();
            logoLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/Logo.png")));           
        } 
        else 
        {
        	themeL = false;
            FlatDarkLaf.setup();
            logoLabel.setIcon(new ImageIcon(LoginView.class.getResource("/images/LogoDark.png")));
        }
        for (Window window : Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window);
        }
    }

	/*
	 * Theme setted by variable
	 * @return theme, if 1 -> dark | 0 -> light
	 */
	public static boolean getTheme() {
		return themeL;		
	}
}
