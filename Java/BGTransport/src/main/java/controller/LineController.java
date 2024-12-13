package controller;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;

import model.QueryDB;
import view.LineView;

public class LineController {
	
	public static String selectedItem;
	public static String selectedItem1;

	public static void setStation() throws SQLException{
		LineView.station = QueryDB.getNameStation();
	}
	
	public static void setLine() throws SQLException {
		LineView.linelist = QueryDB.getLineList();
	}
	
	public static void setTime() throws SQLException {
		LineView.timelist = QueryDB.getTimeList();
	}
	
	public static void setWeek() throws SQLException {
		LineView.weeklist = QueryDB.getWeekList();
	}
	
	public static List<List<String>> getComboboxSelectionStation(JComboBox<String> depaturestation) throws SQLException {
		selectedItem = (String) depaturestation.getSelectedItem();
		return QueryDB.getInfo(selectedItem);
	}
	
	public static List<List<String>> getComboboxSelectionTime(JComboBox<String> departuretime) throws SQLException {
		selectedItem1 = (String) departuretime.getSelectedItem();
		return QueryDB.getInfo1(selectedItem1);
	}
	
	public static void updateComboBoxes(
	        JComboBox<String> line,
	        JComboBox<String> departuretime,
	        JComboBox<String> arrivestation,
	        JComboBox<String> arrivetime,
	        JComboBox<String> nextstop,
	        JComboBox<String> timestop,
	        JComboBox<String> week,
	        List<List<String>> arrivalList) {

	    Set<String> uniqueLines = new HashSet<>();
	    Set<String> uniqueDepartureTimes = new HashSet<>();
	    Set<String> uniqueArrivalStations = new HashSet<>();
	    Set<String> uniqueArrivalTimes = new HashSet<>();
	    Set<String> uniqueNextStops = new HashSet<>();
	    Set<String> uniqueTimeStops = new HashSet<>();
	    Set<String> uniqueWeeks = new HashSet<>();

	    for (List<String> record : arrivalList) {
	        uniqueLines.add(record.get(0));
	        uniqueDepartureTimes.add(record.get(1));
	        uniqueArrivalStations.add(record.get(2));
	        uniqueArrivalTimes.add(record.get(3));
	        uniqueNextStops.add(record.get(4));
	        uniqueTimeStops.add(record.get(5));
	        uniqueWeeks.add(record.get(6));
	    }

	    line.removeAllItems();
	    departuretime.removeAllItems();
	    arrivestation.removeAllItems();
	    arrivetime.removeAllItems();
	    nextstop.removeAllItems();
	    timestop.removeAllItems();
	    week.removeAllItems();

	    uniqueLines.forEach(line::addItem);
	    uniqueDepartureTimes.forEach(departuretime::addItem);
	    uniqueArrivalStations.forEach(arrivestation::addItem);
	    uniqueArrivalTimes.forEach(arrivetime::addItem);
	    uniqueNextStops.forEach(nextstop::addItem);
	    uniqueTimeStops.forEach(timestop::addItem);
	    uniqueWeeks.forEach(week::addItem);
	}
	
	public static void updateComboBoxes1(
	        JComboBox<String> line,
	        JComboBox<String> arrivestation,
	        JComboBox<String> arrivetime,
	        JComboBox<String> nextstop,
	        JComboBox<String> timestop,
	        JComboBox<String> week,
	        List<List<String>> timelist) {

	    Set<String> uniqueLines = new HashSet<>();
	    Set<String> uniqueArrivalStations = new HashSet<>();
	    Set<String> uniqueArrivalTimes = new HashSet<>();
	    Set<String> uniqueNextStops = new HashSet<>();
	    Set<String> uniqueTimeStops = new HashSet<>();
	    Set<String> uniqueWeeks = new HashSet<>();

	    for (List<String> record : timelist) {
	        uniqueLines.add(record.get(0));
	        uniqueArrivalStations.add(record.get(1));
	        uniqueArrivalTimes.add(record.get(2));
	        uniqueNextStops.add(record.get(3));
	        uniqueTimeStops.add(record.get(4));
	        uniqueWeeks.add(record.get(5));
	    }

	    line.removeAllItems();
	    arrivestation.removeAllItems();
	    arrivetime.removeAllItems();
	    nextstop.removeAllItems();
	    timestop.removeAllItems();
	    week.removeAllItems();

	    uniqueLines.forEach(line::addItem);
	    uniqueArrivalStations.forEach(arrivestation::addItem);
	    uniqueArrivalTimes.forEach(arrivetime::addItem);
	    uniqueNextStops.forEach(nextstop::addItem);
	    uniqueTimeStops.forEach(timestop::addItem);
	    uniqueWeeks.forEach(week::addItem);
	}
}
