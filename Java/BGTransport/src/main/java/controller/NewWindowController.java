package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.SwingUtilities;

import view.HomeView;
import view.LoginView;
import view.RoundedPanel;
import view.SignUpWindow;
import controller.ThemeController;;

public class NewWindowController {

	
	
	public static void openHomePanel(HomeView homeV) {
		
		SwingUtilities.invokeLater(() -> {homeV.setVisible(true); });
		ThemeController.setThemeHomePanel(homeV);
		homeV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.componentBounds, homeV.mainPanel);				
				ResizeController.resizeImagePanel(homeV, homeV.lblBGwallpaper, homeV.mainPanel);
           		ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.iconUser, homeV.userButton);
           		ResizeController.resizePanel(homeV.originalPanelSize, homeV, homeV.menuPanel, homeV.MenuPanelSize);
        	}
		});
	}
	
	public static void openLoginPanel(LoginView loginV) {
		SwingUtilities.invokeLater(() -> {loginV.setVisible(true); });
		
		loginV.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
               ResizeController.resizeComponents(loginV.originalPanelSize, loginV, loginV.componentBounds, loginV.mainPanel);
               ResizeController.resizeImagePanel(loginV, loginV.lblBGwallpaper, loginV.mainPanel);            
            }
        });   
	}
	
	public static void openSignUp(SignUpWindow signupV) {
		SwingUtilities.invokeLater(() -> {signupV.setVisible(true); });
	}
	
}
