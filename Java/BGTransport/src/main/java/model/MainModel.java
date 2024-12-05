package model;

import javax.swing.SwingUtilities;

import controller.DownloadDataDBController;
import controller.MainController;
import view.DownloadDataDBView;

public class MainModel {
	
	public static DownloadDataDBView db = new DownloadDataDBView();

	public static void main(String[] args) throws Exception {
		// create database Public Transportation
		ControlDB.controlJSON(Constant.jsonFunicularStation, Constant.excelFunicularStation);
		ControlDB.controlJSON(Constant.jsonCompany, Constant.excelCompany);
		ControlDB.controlJSON(Constant.jsonPullmanStop, Constant.excelPullmanStop);
		ControlDB.controlJSON(Constant.jsonTrainStation, Constant.excelTrainStation);
		ControlDB.controlJSON(Constant.jsonTramStop, Constant.excelTramStop);
		ControlDB.controlJSON(Constant.jsonFunicularTimetable, Constant.excelFunicularTimetable);
		ControlDB.controlJSON(Constant.jsonTramTimetable, Constant.excelTramTimetable);
		ControlDB.controlJSON(Constant.jsonTrainTimetable, Constant.excelTrainTimetable);
		ControlDB.controlJSON(Constant.jsonPullmanTimetable, Constant.excelPullmanTimetable);
		
		ControlDB.DBcheck(Constant.DBPublicTransportation, Constant.DBUrlPublicTransportation, Constant.jooqTransportation, Constant.srcTransportation);
		
		SwingUtilities.invokeLater(() -> {
			db.setVisible(true);
		});
		DownloadDataDBController.updateProgressbar();
		
		ControlDB.DBupdate(Constant.update, Constant.DBUrlPublicTransportation);
		
		// create database User
		ControlDB.DBcheck(Constant.DBUsers, Constant.DBUrlUsers, Constant.jooqUser, Constant.srcUser);
	}

}
