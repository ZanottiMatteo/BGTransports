package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import view.SignUpWindow;
import view.HomeView;
import view.LoginView;
import view.MapView;
import model.RegisteredUser;
import model.WeatherModel;

public class MainController {

	
	public static HomeView homeV = new HomeView();
	public static SignUpWindow signupV = new SignUpWindow();
	public static MapView mapV = new MapView();
	public static LoginView loginV = new LoginView();
	public static List<RegisteredUser> users = new ArrayList<RegisteredUser>();

	public static void main(String[] args) {
		System.out.println("BGTransport!");
		ThemeController.updateThemes();
		NewWindowController.openHomePanel(homeV);

	}
}
