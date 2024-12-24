package bgtransport.controller;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bgtransport.model.UserQueryDB;

/**
 * The {@code DatabaseController} class provides methods to populate different
 * views with data retrieved from the database. Each method fetches data for a
 * specific type of entity (e.g., users, companies, stations, etc.) and displays
 * it in a JTable within the scroll panel of the main user interface.
 */
public class DatabaseController {

	/**
	 * Populates the user data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelUser(String database) throws SQLException {
		UserQueryDB.getDataFromDatabaseUsers(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}

	/**
	 * Populates the company data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelCompany(String database) throws SQLException {
		UserQueryDB.getDataFromCompany(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}

	/**
	 * Populates the funicular station data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelFunicularStation(String database) throws SQLException {
		UserQueryDB.getDataFromFunicularStation(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}

	/**
	 * Populates the funicular timetable data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelFunicularTimetable(String database) throws SQLException {
		UserQueryDB.getDataFromFunicularTimetable(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}

	/**
	 * Populates the pullman stop data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelPullmanStop(String database) throws SQLException {
		UserQueryDB.getDataFromPullmanStop(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}

	/**
	 * Populates the pullman timetable data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelPullmanTimetable(String database) throws SQLException {
		UserQueryDB.getDataFromPullmanTimetable(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}

	/**
	 * Populates the train station data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelTrainStation(String database) throws SQLException {
		UserQueryDB.getDataFromTrainStation(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}

	/**
	 * Populates the train timetable data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelTrainTimetable(String database) throws SQLException {
		UserQueryDB.getDataFromTrainTimetable(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}

	/**
	 * Populates the tram stop data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelTramStop(String database) throws SQLException {
		UserQueryDB.getDataFromTramStop(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}

	/**
	 * Populates the tram timetable data in the scrollable table panel.
	 * 
	 * @param database The name of the database to query.
	 * @throws SQLException If an SQL error occurs while fetching data from the
	 *                      database.
	 */
	public static void scrollPanelTramTimetable(String database) throws SQLException {
		UserQueryDB.getDataFromTramTimetable(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
	}
}
