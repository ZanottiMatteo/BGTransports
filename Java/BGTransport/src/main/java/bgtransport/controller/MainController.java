package bgtransport.controller;

import bgtransport.view.AccountIconView;
import bgtransport.view.DatabaseView;
import bgtransport.view.DownloadDataDBView;
import bgtransport.view.HomeView;
import bgtransport.view.LineView;
import bgtransport.view.LoginView;
import bgtransport.view.MapView;
import bgtransport.view.SignUpView;
import bgtransport.view.UserView;

public class MainController {

	public static DownloadDataDBView dbV = new DownloadDataDBView();
	public static HomeView homeV = new HomeView();
	public static SignUpView signupV = new SignUpView();
	public static MapView mapV = new MapView();
	public static LoginView loginV = new LoginView();
	public static UserView userV = new UserView();
	public static AccountIconView accountV = new AccountIconView();
	public static LineView lineV;
	public static DatabaseView databaseV = new DatabaseView();
    
	//public static List<RegisteredUser> users = new ArrayList<RegisteredUser>();

	public static void main(String[] args) throws Exception {
        // Pass the map to the view
		TimestampController.getTime();
        TimestampController.getDate();
		WeatherController.getMeteo();
        WeatherController.getWeatherIcon();
		LineController.setStation();
		LineController.setLine();
		LineController.setTime();
		LineController.setWeek();
		lineV = new LineView();
		ThemeController.updateThemes();
		NewWindowController.openDBloader(dbV);
		DownloadDataDBController.updateProgressbar();
		
		}
}
