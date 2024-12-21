package bgtransport.controller;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bgtransport.model.UserQueryDB;

public class DatabaseController {
	
	public static void scrollPanelUser(String database) throws SQLException {
		UserQueryDB.getDataFromDatabaseUsers(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelCompany(String database) throws SQLException {
		UserQueryDB.getDataFromCompany(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelFunicularStation(String database) throws SQLException {
		UserQueryDB.getDataFromFunicularStation(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelFunicularTimetable(String database) throws SQLException {
		UserQueryDB.getDataFromFunicularTimetable(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelPullmanStop(String database) throws SQLException {
		UserQueryDB.getDataFromPullmanStop(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelPullmanTimetable(String database) throws SQLException {
		UserQueryDB.getDataFromPullmanTimetable(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelTrainStation(String database) throws SQLException {
		UserQueryDB.getDataFromTrainStation(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelTrainTimetable(String database) throws SQLException {
		UserQueryDB.getDataFromTrainTimetable(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelTramStop(String database) throws SQLException {
		UserQueryDB.getDataFromTramStop(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelTramTimetable(String database) throws SQLException {
		UserQueryDB.getDataFromTramTimetable(database);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
}
