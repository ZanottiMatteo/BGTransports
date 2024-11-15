package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.SwingUtilities;

import view.HomeView;
import view.LoginView;
import view.SignUpWindow;

public class NewWindowController {

	public static void openUserPanel(HomeView homeV) {
		SwingUtilities.invokeLater(() -> {homeV.setVisible(true); });
		homeV.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ResizeController.resizeComponents(homeV.originalPanelSize, homeV, homeV.componentBounds, homeV.mainPanel);
				ResizeController.resizeImagePanel(homeV, homeV.lblBGwallpaper, homeV.mainPanel);
           		ResizeController.resizeImageButton(homeV.originalPanelSize, homeV, homeV.iconUser, homeV.userButton);
        	}
		});
	}
	
	public static void openUserPanel(LoginView mainV) {
		SwingUtilities.invokeLater(() -> {mainV.setVisible(true); });
		mainV.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
               ResizeController.resizeComponents(mainV.originalPanelSize, mainV, mainV.componentBounds, mainV.mainPanel);
               ResizeController.resizeImagePanel(mainV, mainV.lblBGwallpaper, mainV.mainPanel);            
            }
        });   
	}
	
	public static void openSignUp(SignUpWindow signupV) {
		SwingUtilities.invokeLater(() -> {signupV.setVisible(true); });
	}
	
}
