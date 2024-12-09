package controller;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.QueryDB;

public class DatabaseController {
	
	public static void scrollPanelUser(String database) throws SQLException {
		QueryDB.getDataFromDatabaseUsers(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelCompany(String database) throws SQLException {
		QueryDB.getDataFromCompany(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelFunicularStation(String database) throws SQLException {
		QueryDB.getDataFromFunicularStation(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelFunicularTimetable(String database) throws SQLException {
		QueryDB.getDataFromFunicularTimetable(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelPullmanStop(String database) throws SQLException {
		QueryDB.getDataFromPullmanStop(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelPullmanTimetable(String database) throws SQLException {
		QueryDB.getDataFromPullmanTimetable(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelTrainStation(String database) throws SQLException {
		QueryDB.getDataFromTrainStation(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelTrainTimetable(String database) throws SQLException {
		QueryDB.getDataFromTrainTimetable(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelTramStop(String database) throws SQLException {
		QueryDB.getDataFromTramStop(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
	
	public static void scrollPanelTramTimetable(String database) throws SQLException {
		QueryDB.getDataFromTramTimetable(database);
		DefaultTableModel model = new DefaultTableModel(QueryDB.data, QueryDB.columnNames);
        JTable table = new JTable(model);
        MainController.databaseV.scrollPane.setViewportView(table);
	}
}
