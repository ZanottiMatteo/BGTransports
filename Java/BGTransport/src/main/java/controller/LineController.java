package controller;

import java.sql.SQLException;

import model.QueryDB;
import view.LineView;

public class LineController {

	public static void setStation() throws SQLException{
		LineView.station = QueryDB.getNameStation();
	}
	
	public static void getComboboxselection () {
		
	}
}
