package controller;

import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.jxmapviewer.JXMapViewer;

import view.SignUpView;
import view.UserView;
import view.HomeView;
import view.LoginView;
import view.MapView;
import model.QueryDB;
import model.RegisteredUser;
import model.User;
import model.WeatherModel;

public class MainController {

	
	public static HomeView homeV = new HomeView();
	public static SignUpView signupV = new SignUpView();
	public static MapView mapV = new MapView();
	public static LoginView loginV = new LoginView();
	public static UserView userV = new UserView();
	public static List<RegisteredUser> users = new ArrayList<RegisteredUser>();

	public static void main(String[] args) {
		System.out.println("BGTransport!");
        // Pass the map to the view
		MapController.generateMap();
		MapController.generateMiniMap();
		ThemeController.updateThemes();
		NewWindowController.openHomePanel(homeV);
		
	}
}
