package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.SwingUtilities;

import view.SignUpWindow;
import view.HomeView;
import view.LoginView;

public class MainController {

	public static LoginView mainV = new LoginView(); 
	public static HomeView homeV = new HomeView(); 
	public static SignUpWindow signupV = new SignUpWindow(); 
	
	public static void main(String[] args) {
		System.out.println("BGTransport!"); 

		NewWindowController.openUserPanel(homeV);

        
    }
}
	
	
