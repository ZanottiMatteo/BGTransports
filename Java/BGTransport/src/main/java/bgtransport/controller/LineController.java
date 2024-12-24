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

public static void setTime() throws SQLException {
LineView.timelist = PublicTransportationQueryDB.getTimeList();
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

public static void selectValues() throws SQLException {
LineView.allValueList.addAll(PublicTransportationQueryDB.getLineNextStopTimeStopWeek(selectedItem, selectedItem1, selectedItem2));
}

public static void getValuesOfComboBox(JComboBox<String> depaturestation, JComboBox<String> departuretime, JComboBox<String> arrivestation, JComboBox<String> arrivetime) {
LineView.allValueList.add((String) depaturestation.getSelectedItem());
LineView.allValueList.add((String) departuretime.getSelectedItem());
LineView.allValueList.add((String) arrivestation.getSelectedItem());
LineView.allValueList.add((String) arrivetime.getSelectedItem());
}

public static void updateComboBoxes(
        JComboBox<String> departuretime,
        JComboBox<String> arrivestation,
        JComboBox<String> arrivetime,
        List<List<String>> arrivalList) {

    Set<String> uniqueDepartureTimes = new HashSet<>();
    Set<String> uniqueArrivalStations = new HashSet<>();
    Set<String> uniqueArrivalTimes = new HashSet<>();
    for (List<String> list : arrivalList) {
        uniqueDepartureTimes.add(list.get(0));
        uniqueArrivalStations.add(list.get(1));
        uniqueArrivalTimes.add(list.get(2));
    }
    departuretime.removeAllItems();
    arrivestation.removeAllItems();
    arrivetime.removeAllItems();
    uniqueDepartureTimes.forEach(departuretime::addItem);
    uniqueArrivalStations.forEach(arrivestation::addItem);
    uniqueArrivalTimes.forEach(arrivetime::addItem);
}

public static void updateComboBoxes1(
        JComboBox<String> arrivestation,
        JComboBox<String> arrivetime,
        List<List<String>> timelist) {

    Set<String> uniqueArrivalStations = new HashSet<>();
    Set<String> uniqueArrivalTimes = new HashSet<>();
    for (List<String> list : timelist) {
        uniqueArrivalStations.add(list.get(0));
        uniqueArrivalTimes.add(list.get(1));
    }
    arrivestation.removeAllItems();
    arrivetime.removeAllItems();
    uniqueArrivalStations.forEach(arrivestation::addItem);
    uniqueArrivalTimes.forEach(arrivetime::addItem);
}
	
	public static void updateComboBoxes2(
			JComboBox<String> arrivetime,
	        List<List<String>> arrivelist) {
		
	    Set<String> uniqueArrivalTimes = new HashSet<>();
	    for (List<String> list : arrivelist) {
	        uniqueArrivalTimes.add(list.get(0));
	    }
	    arrivetime.removeAllItems();
	    uniqueArrivalTimes.forEach(arrivetime::addItem);
	}
}