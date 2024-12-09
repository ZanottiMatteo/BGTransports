package controller;

import view.SignUpView;
import view.UserView;
import model.ConstantDB;
import view.AccountIconView;
import view.DatabaseView;
import view.DownloadDataDBView;
import view.HomeView;
import view.LineView;
import view.LoginView;
import view.MapView;

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
		LineController.setStation();
		lineV = new LineView();
		ThemeController.updateThemes();
		NewWindowController.openDBloader(dbV);
		DownloadDataDBController.updateProgressbar();
		DatabaseController.scrollPanelUser(ConstantDB.DB_URL_USERS);
		DatabaseController.scrollPanelCompany(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		DatabaseController.scrollPanelFunicularStation(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		DatabaseController.scrollPanelFunicularTimetable(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		DatabaseController.scrollPanelPullmanStop(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		DatabaseController.scrollPanelPullmanTimetable(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		DatabaseController.scrollPanelTrainStation(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		DatabaseController.scrollPanelTrainTimetable(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		DatabaseController.scrollPanelTramStop(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		DatabaseController.scrollPanelTramTimetable(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		}
}
