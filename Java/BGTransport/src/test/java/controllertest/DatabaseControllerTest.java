package controllertest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import bgtransport.controller.DatabaseController;

public class DatabaseControllerTest {
	
	private static String database;
	private static String[][] mockData;
	private static String[] mockColumnNames;
	private static Connection connection;

    static class UserQueryDBStub {
        static String[][] data;
        static String[] columnNames;

        static void getDataFromDatabaseUsers() {
            data = mockData;
            columnNames = mockColumnNames;
        }

        static void getDataFromCompany() {
            data = mockData;
            columnNames = mockColumnNames;
        }

        static void getDataFromFunicularStation() {
            data = mockData;
            columnNames = mockColumnNames;
        }
        
        static void getDataFromFunicularTimetable() {
            data = mockData;
            columnNames = mockColumnNames;
        }
        
        static void getDataFromPullmanStop() {
        	data = mockData;
            columnNames = mockColumnNames;
        }
        
        static void getDataFromPullmanTimetable() {
        	data = mockData;
            columnNames = mockColumnNames;
        }
        
        static void getDataFromTrainStation() {
        	data = mockData;
            columnNames = mockColumnNames;
        }
        
        static void getDataFromTrainTimetable() {
        	data = mockData;
            columnNames = mockColumnNames;
        }
        
        static void getDataFromTramStop() {
        	data = mockData;
            columnNames = mockColumnNames;
        }
        
        static void getDataFromTramTimetable() {
        	data = mockData;
            columnNames = mockColumnNames;
        }
    }

    static class MainControllerStub {
        static DatabaseViewStub databaseV = new DatabaseViewStub();

        static class DatabaseViewStub {
            JScrollPane scrollPane = new JScrollPane();
            
            public JScrollPane getScrollPane() {
                return scrollPane;
            }
        }
    }
	
    @BeforeAll
    static void setup() throws SQLException {
    	database = ":memory:";
        mockData = new String[][] {
            {"1", "John", "Doe"},
            {"2", "Jane", "Doe"}
        };
        mockColumnNames = new String[] { "ID", "First Name", "Last Name" };
        
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");

        // Crea una tabella di esempio
        try (Statement stmt = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE users (ID TEXT, first_name TEXT, last_name TEXT)";
            stmt.execute(createTableSQL);

            // Inserisci i dati di esempio nella tabella
            String insertDataSQL = "INSERT INTO users (ID, first_name, last_name) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertDataSQL)) {
                pstmt.setString(1, "1");
                pstmt.setString(2, "John");
                pstmt.setString(3, "Doe");
                pstmt.executeUpdate();
                
                pstmt.setString(1, "2");
                pstmt.setString(2, "Jane");
                pstmt.setString(3, "Doe");
                pstmt.executeUpdate();
            }
        }
    }
    
    @AfterAll
    static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testScrollPanelUser() throws SQLException {
        UserQueryDBStub.getDataFromDatabaseUsers();
        DefaultTableModel model = new DefaultTableModel(UserQueryDBStub.data, UserQueryDBStub.columnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelUser(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
    }
    
    @Test
    public void testScrollPanelCompany() throws SQLException {
        UserQueryDBStub.getDataFromCompany();
        DefaultTableModel model = new DefaultTableModel(mockData, mockColumnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelCompany(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
        for (int i = 0; i < mockColumnNames.length; i++) {
            Assertions.assertEquals(mockColumnNames[i], tableInScrollPane.getColumnName(i));
        }
    }

    @Test
    public void testScrollPanelFunicularStation() throws SQLException {
        UserQueryDBStub.getDataFromFunicularStation();
        DefaultTableModel model = new DefaultTableModel(mockData, mockColumnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelFunicularStation(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
        for (int i = 0; i < mockColumnNames.length; i++) {
            Assertions.assertEquals(mockColumnNames[i], tableInScrollPane.getColumnName(i));
        }
    }
    
    @Test
    public void testScrollPanelFunicularTimetable() throws SQLException {
        UserQueryDBStub.getDataFromFunicularTimetable();
        DefaultTableModel model = new DefaultTableModel(mockData, mockColumnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelFunicularTimetable(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
        for (int i = 0; i < mockColumnNames.length; i++) {
            Assertions.assertEquals(mockColumnNames[i], tableInScrollPane.getColumnName(i));
        }
    }
    
    @Test
    public void testScrollPanelPullmanStop() throws SQLException {
        UserQueryDBStub.getDataFromPullmanStop();
        DefaultTableModel model = new DefaultTableModel(mockData, mockColumnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelPullmanStop(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
        for (int i = 0; i < mockColumnNames.length; i++) {
            Assertions.assertEquals(mockColumnNames[i], tableInScrollPane.getColumnName(i));
        }
    }
    
    @Test
    public void testScrollPanelPullmanTimetable() throws SQLException {
        UserQueryDBStub.getDataFromPullmanTimetable();
        DefaultTableModel model = new DefaultTableModel(mockData, mockColumnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelPullmanTimetable(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
        for (int i = 0; i < mockColumnNames.length; i++) {
            Assertions.assertEquals(mockColumnNames[i], tableInScrollPane.getColumnName(i));
        }
    }
    
    @Test
    public void testScrollPanelTrainStation() throws SQLException {
        UserQueryDBStub.getDataFromTrainStation();
        DefaultTableModel model = new DefaultTableModel(mockData, mockColumnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelTrainStation(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
        for (int i = 0; i < mockColumnNames.length; i++) {
            Assertions.assertEquals(mockColumnNames[i], tableInScrollPane.getColumnName(i));
        }
    }
    
    @Test
    public void testScrollPanelTrainTimetable() throws SQLException {
        UserQueryDBStub.getDataFromTrainTimetable();
        DefaultTableModel model = new DefaultTableModel(mockData, mockColumnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelTrainTimetable(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
        for (int i = 0; i < mockColumnNames.length; i++) {
            Assertions.assertEquals(mockColumnNames[i], tableInScrollPane.getColumnName(i));
        }
    }
    
    @Test
    public void testScrollPanelTramStop() throws SQLException {
        UserQueryDBStub.getDataFromTramStop();
        DefaultTableModel model = new DefaultTableModel(mockData, mockColumnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelTramStop(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
        for (int i = 0; i < mockColumnNames.length; i++) {
            Assertions.assertEquals(mockColumnNames[i], tableInScrollPane.getColumnName(i));
        }
    }
    
    @Test
    public void testScrollPanelTramTimetable() throws SQLException {
        UserQueryDBStub.getDataFromTramTimetable();
        DefaultTableModel model = new DefaultTableModel(mockData, mockColumnNames);
        JTable table = new JTable(model);
        MainControllerStub.databaseV.scrollPane.setViewportView(table);
        DatabaseController.scrollPanelTramTimetable(database);
        JTable tableInScrollPane = (JTable) MainControllerStub.databaseV.scrollPane.getViewport().getView();
        Assertions.assertNotNull(tableInScrollPane);
        Assertions.assertEquals(tableInScrollPane.getModel(), table.getModel());
        for (int i = 0; i < mockColumnNames.length; i++) {
            Assertions.assertEquals(mockColumnNames[i], tableInScrollPane.getColumnName(i));
        }
    }
}
