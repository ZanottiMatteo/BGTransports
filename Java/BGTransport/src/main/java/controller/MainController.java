package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;


import javax.swing.SwingUtilities;

import view.SignUpWindow;
import view.HomeView;
import view.LoginView;
import model.RegisteredUser;

public class MainController {

	public static LoginView loginV = new LoginView(); 
	public static HomeView homeV = new HomeView(); 
	public static SignUpWindow signupV = new SignUpWindow(); 
	public static List<RegisteredUser> users = new ArrayList<RegisteredUser>();
	
	public static void main(String[] args) {
		System.out.println("BGTransport!"); 

		NewWindowController.openHomePanel(homeV);

		
		users.add(new RegisteredUser("Mario", "Rossi", "12/11/45", 1));
		users.add(new RegisteredUser("Piero", "Rossi", "12/10/45", 2));
		users.add(new RegisteredUser("Gigi", "Rossi", "5/11/45", 1));
        
    }
}
	
	
