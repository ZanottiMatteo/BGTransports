package controllertest;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import bgtransport.controller.DatabaseController;
import bgtransport.controller.MainController;
import bgtransport.model.ConstantDB;
import bgtransport.model.UserQueryDB;

class DatabaseControllerTest {

	private static String databasePublicTransport;
	private static String databaseUser;

	@BeforeAll
	static void setup() {
		databasePublicTransport = ConstantDB.DB_URL_PUBLIC_TRANSPORTATION;
		databaseUser = ConstantDB.DB_URL_USERS;
	}

	@Test
	void testScrollPanelUser() throws SQLException {
		UserQueryDB.getDataFromDatabaseUsers(databaseUser);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelUser(databaseUser);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);
	}

	@Test
	void testScrollPanelCompany() throws SQLException {
		UserQueryDB.getDataFromCompany(databasePublicTransport);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelCompany(databasePublicTransport);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);

	}

	@Test
	void testScrollPanelFunicularStation() throws SQLException {
		UserQueryDB.getDataFromFunicularStation(databasePublicTransport);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelFunicularStation(databasePublicTransport);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);

	}

	@Test
	void testScrollPanelFunicularTimetable() throws SQLException {
		UserQueryDB.getDataFromFunicularTimetable(databasePublicTransport);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelFunicularTimetable(databasePublicTransport);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);

	}

	@Test
	void testScrollPanelPullmanStop() throws SQLException {
		UserQueryDB.getDataFromPullmanStop(databasePublicTransport);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelPullmanStop(databasePublicTransport);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);

	}

	@Test
	void testScrollPanelPullmanTimetable() throws SQLException {
		UserQueryDB.getDataFromPullmanTimetable(databasePublicTransport);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelPullmanTimetable(databasePublicTransport);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);

	}

	@Test
	void testScrollPanelTrainStation() throws SQLException {
		UserQueryDB.getDataFromTrainStation(databasePublicTransport);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelTrainStation(databasePublicTransport);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);

	}

	@Test
	void testScrollPanelTrainTimetable() throws SQLException {
		UserQueryDB.getDataFromTrainTimetable(databasePublicTransport);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelTrainTimetable(databasePublicTransport);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);

	}

	@Test
	void testScrollPanelTramStop() throws SQLException {
		UserQueryDB.getDataFromTramStop(databasePublicTransport);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelTramStop(databasePublicTransport);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);

	}

	@Test
	void testScrollPanelTramTimetable() throws SQLException {
		UserQueryDB.getDataFromTramTimetable(databasePublicTransport);
		DefaultTableModel model = new DefaultTableModel(UserQueryDB.data, UserQueryDB.columnNames);
		JTable table = new JTable(model);
		MainController.databaseV.scrollPane.setViewportView(table);
		DatabaseController.scrollPanelTramTimetable(databasePublicTransport);
		JTable tableInScrollPane = (JTable) MainController.databaseV.scrollPane.getViewport().getView();
		Assertions.assertNotNull(tableInScrollPane);
	}
}
