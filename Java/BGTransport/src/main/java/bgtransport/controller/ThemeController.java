package bgtransport.controller;

/**
 * The {@code ThemeController} class is responsible for managing the application's themes, 
 * including light and dark modes. It updates the UI components of various views 
 * to reflect the selected theme and handles look-and-feel changes at a global level.
 */
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

    /**
     * Boolean flag to determine the current theme.
     * {@code true} indicates the dark theme is active, {@code false} indicates the light theme.
     */
    public static boolean themeDark = true;

    /**
     * Applies the current theme to the {@code HomeView} panel.
     * @param homeV the {@code HomeView} instance to update.
     */
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
    
    /**
     * Applies the current theme to the {@code MapView} panel.
     * @param mapV the {@code MapView} instance to update.
     */
    public static void setThemeMapPanel(MapView mapV) {        
        if (themeDark) {
            mapV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
        } else {
            mapV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
        }    
    }

    /**
     * Applies the current theme to the {@code UserView} panel.
     * @param userV the {@code UserView} instance to update.
     */
    public static void setThemeUserPanel(UserView userV) {    
        if (themeDark) {
            userV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
        } else {
            userV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
        }    
    }
    
    /**
     * Applies the current theme to the {@code LineView} panel.
     * @param lineV the {@code LineView} instance to update.
     */
    public static void setThemeLinePanel(LineView lineV) {    
        if (themeDark) {
            lineV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
        } else {
            lineV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
        }    
    }
    
    /**
     * Applies the current theme to the {@code DatabaseView} panel.
     * @param databaseV the {@code DatabaseView} instance to update.
     */
    public static void setThemeDatabasePanel(DatabaseView databaseV) {    
        if (themeDark) {
            databaseV.homePanel.setBackground(new Color(0, 0, 0, 40)); // Light theme background 
        } else {
            databaseV.homePanel.setBackground(new Color(0, 0, 0, 80)); // Dark theme background
        }    
    }
    
    /**
     * Applies the current theme to the {@code LoginView} panel.
     * @param loginV the {@code LoginView} instance to update.
     */
    public static void setThemeLoginPanel(LoginView loginV) {
        if (themeDark) {
            loginV.logoLabelD.setVisible(false);
            loginV.logoLabel.setVisible(true);            
        } else {
            loginV.logoLabel.setVisible(false);    
            loginV.logoLabelD.setVisible(true);                
        }
    }
    
    /**
     * Toggles the theme between light and dark modes, updating the global look-and-feel 
     * and refreshing all views to reflect the change.
     */
    public static void updateThemes() {
        themeDark = !themeDark;
        try {
            if (getTheme()) {
                UIManager.setLookAndFeel(new MyLighterLaf());
            } else {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            }
            // Update all windows with the new look-and-feel
            for (Window window : Window.getWindows()) {
                SwingUtilities.updateComponentTreeUI(window);
            }
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setThemeHomePanel(MainController.homeV);            
        setThemeMapPanel(MainController.mapV);
        setThemeLoginPanel(MainController.loginV);
        setThemeUserPanel(MainController.userV); 
        setThemeLinePanel(MainController.lineV);
        setThemeDatabasePanel(MainController.databaseV);
    }
    
    /**
     * Retrieves the current theme status.
     * @return {@code true} if the dark theme is active, {@code false} otherwise.
     */
    public static boolean getTheme() {
        return themeDark;
    }
}
