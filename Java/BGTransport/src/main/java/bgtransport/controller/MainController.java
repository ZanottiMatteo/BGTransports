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

/**
 * MainController is the central controller class for managing different views
 * and interacting with various controllers in the BGTransport system. This
 * class initializes and manages the views, handles data updates, and
 * coordinates the actions between different components of the application.
 */
public class MainController {

	// Views for the application
	public static DownloadDataDBView dbV = new DownloadDataDBView();
	public static HomeView homeV = new HomeView();
	public static SignUpView signupV = new SignUpView();
	public static MapView mapV = new MapView();
	public static LoginView loginV = new LoginView();
	public static UserView userV = new UserView();
	public static AccountIconView accountV = new AccountIconView();
	public static LineView lineV;
	public static DatabaseView databaseV = new DatabaseView();

	/**
	 * Main entry point of the application. This method initializes the required
	 * controllers and views and starts the application. It also sets up data and
	 * theme for the application.
	 * 
	 * @param args command-line arguments (not used in this implementation)
	 * @throws Exception if there is any issue during the initialization of
	 *                   components
	 */
	public static void main(String[] args) throws Exception {
		// Initialize time and date controllers
		TimestampController.getTime();
		TimestampController.getDate();

		// Initialize weather controllers
		WeatherController.getMeteo();
		WeatherController.getWeatherIcon();

		// Initialize line-related controllers
		LineController.setStation();
		LineController.setTime();
		// Initialize line view
		lineV = new LineView();

		// Update application theme
		ThemeController.updateThemes();

		// Open the Database Loader window
		NewWindowController.openDBloader(dbV);

		// Update progress bar for DB data download
		DownloadDataDBController.updateProgressbar();

		// Manage user roles
		RoleController.roleManager();
	}
}
