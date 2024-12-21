package bgtransport.controller;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;

import bgtransport.model.PublicTransportationQueryDB;
import bgtransport.view.LineView;

public class LineController {
	
	public static String selectedItem;
	public static String selectedItem1;
	public static String selectedItem2;

	public static void setStation() throws SQLException{
		LineView.station = PublicTransportationQueryDB.getNameStation();
	}
	
	public static void setLine() throws SQLException {
		LineView.linelist = PublicTransportationQueryDB.getLineList();
	}
	
	public static void setTime() throws SQLException {
		LineView.timelist = PublicTransportationQueryDB.getTimeList();
	}
	
	public static void setWeek() throws SQLException {
		LineView.weeklist = PublicTransportationQueryDB.getWeekList();
	}
	
	public static void getComboboxSelectionStation(JComboBox<String> depaturestation) throws SQLException {
		selectedItem = (String) depaturestation.getSelectedItem();
		LineView.departureList = PublicTransportationQueryDB.getInfo(selectedItem);
	}
	
	public static void getComboboxSelectionTime(JComboBox<String> departuretime) throws SQLException {
		selectedItem1 = (String) departuretime.getSelectedItem();
		LineView.timeListList = PublicTransportationQueryDB.getInfo1(selectedItem1, selectedItem);
	}
	
	public static void getComboboxSelectionFinalStation (JComboBox<String> arrivalstation) throws SQLException{
		selectedItem2 = (String) arrivalstation.getSelectedItem();
		LineView.arriveList = PublicTransportationQueryDB.getInfo2(selectedItem2, selectedItem1, selectedItem);
	}
	
	public static void getValuesOfComboBox(JComboBox<String> depaturestation, JComboBox<String> departuretime, JComboBox<String> arrivestation, JComboBox<String> arrivetime, JComboBox<String> nextstop, JComboBox<String> timestop, JComboBox<String> line, JComboBox<String> week) {
		LineView.allValueList.add((String) depaturestation.getSelectedItem());
		LineView.allValueList.add((String) departuretime.getSelectedItem());
		LineView.allValueList.add((String) arrivestation.getSelectedItem());
		LineView.allValueList.add((String) arrivetime.getSelectedItem());
		LineView.allValueList.add((String) nextstop.getSelectedItem());
		LineView.allValueList.add((String) timestop.getSelectedItem());
		LineView.allValueList.add((String) line.getSelectedItem());
		LineView.allValueList.add((String) week.getSelectedItem());
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

	    for (List<String> list : arrivalList) {
	        uniqueLines.add(list.get(0));
	        uniqueDepartureTimes.add(list.get(1));
	        uniqueArrivalStations.add(list.get(2));
	        uniqueArrivalTimes.add(list.get(3));
	        uniqueNextStops.add(list.get(4));
	        uniqueTimeStops.add(list.get(5));
	        uniqueWeeks.add(list.get(6));
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

	    for (List<String> list : timelist) {
	        uniqueLines.add(list.get(0));
	        uniqueArrivalStations.add(list.get(1));
	        uniqueArrivalTimes.add(list.get(2));
	        uniqueNextStops.add(list.get(3));
	        uniqueTimeStops.add(list.get(4));
	        uniqueWeeks.add(list.get(5));
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
	
	public static void updateComboBoxes2(
			JComboBox<String> line,
	        JComboBox<String> arrivetime,
	        JComboBox<String> nextstop,
	        JComboBox<String> timestop,
	        JComboBox<String> week,
	        List<List<String>> arrivelist) {
		
		Set<String> uniqueLines = new HashSet<>();
	    Set<String> uniqueArrivalTimes = new HashSet<>();
	    Set<String> uniqueNextStops = new HashSet<>();
	    Set<String> uniqueTimeStops = new HashSet<>();
	    Set<String> uniqueWeeks = new HashSet<>();

	    for (List<String> list : arrivelist) {
	        uniqueLines.add(list.get(0));
	        uniqueArrivalTimes.add(list.get(1));
	        uniqueNextStops.add(list.get(2));
	        uniqueTimeStops.add(list.get(3));
	        uniqueWeeks.add(list.get(4));
	    }

	    line.removeAllItems();
	    arrivetime.removeAllItems();
	    nextstop.removeAllItems();
	    timestop.removeAllItems();
	    week.removeAllItems();

	    uniqueLines.forEach(line::addItem);
	    uniqueArrivalTimes.forEach(arrivetime::addItem);
	    uniqueNextStops.forEach(nextstop::addItem);
	    uniqueTimeStops.forEach(timestop::addItem);
	    uniqueWeeks.forEach(week::addItem);
	}
}
