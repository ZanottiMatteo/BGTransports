package bgtransport.controller;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;

import bgtransport.model.PublicTransportationQueryDB;
import bgtransport.view.LineView;

/**
 * The LineController class handles the logic and communication between the view and the database
 * for public transportation scheduling. It manages updates to combo boxes, selections, and data retrieval.
 */
public class LineController {

    public static String selectedItem;
    public static String selectedItem1;
    public static String selectedItem2;

    /**
     * Sets the station list by fetching station names from the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public static void setStation() throws SQLException {
        LineView.station = PublicTransportationQueryDB.getNameStation();
    }

    /**
     * Sets the time list by fetching available times from the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public static void setTime() throws SQLException {
        LineView.timelist = PublicTransportationQueryDB.getTimeList();
    }

    /**
     * Handles the selection of a departure station from a combo box and updates the relevant data.
     *
     * @param depaturestation the JComboBox for departure stations
     * @throws SQLException if a database access error occurs
     */
    public static void getComboboxSelectionStation(JComboBox<String> depaturestation) throws SQLException {
        selectedItem = (String) depaturestation.getSelectedItem();
        LineView.departureList = PublicTransportationQueryDB.getInfo(selectedItem);
    }

    /**
     * Handles the selection of a departure time from a combo box and updates the relevant data.
     *
     * @param departuretime the JComboBox for departure times
     * @throws SQLException if a database access error occurs
     */
    public static void getComboboxSelectionTime(JComboBox<String> departuretime) throws SQLException {
        selectedItem1 = (String) departuretime.getSelectedItem();
        LineView.timeListList = PublicTransportationQueryDB.getInfo1(selectedItem1, selectedItem);
    }

    /**
     * Handles the selection of a final station from a combo box and updates the relevant data.
     *
     * @param arrivalstation the JComboBox for arrival stations
     * @throws SQLException if a database access error occurs
     */
    public static void getComboboxSelectionFinalStation(JComboBox<String> arrivalstation) throws SQLException {
        selectedItem2 = (String) arrivalstation.getSelectedItem();
        LineView.arriveList = PublicTransportationQueryDB.getInfo2(selectedItem2, selectedItem1, selectedItem);
    }

    /**
     * Fetches and selects values based on the current selections and updates the view.
     *
     * @throws SQLException if a database access error occurs
     */
    public static void selectValues() throws SQLException {
        LineView.allValueList.addAll(
                PublicTransportationQueryDB.getLineNextStopTimeStopWeek(selectedItem, selectedItem1, selectedItem2));
    }

    /**
     * Adds the selected values from the combo boxes to the view's value list.
     *
     * @param depaturestation the JComboBox for departure stations
     * @param departuretime   the JComboBox for departure times
     * @param arrivestation   the JComboBox for arrival stations
     * @param arrivetime      the JComboBox for arrival times
     */
    public static void getValuesOfComboBox(JComboBox<String> depaturestation, JComboBox<String> departuretime,
                                           JComboBox<String> arrivestation, JComboBox<String> arrivetime) {
        LineView.allValueList.add((String) depaturestation.getSelectedItem());
        LineView.allValueList.add((String) departuretime.getSelectedItem());
        LineView.allValueList.add((String) arrivestation.getSelectedItem());
        LineView.allValueList.add((String) arrivetime.getSelectedItem());
    }

    /**
     * Updates the departure time, arrival station, and arrival time combo boxes with unique values
     * from the provided arrival list.
     *
     * @param departuretime the JComboBox for departure times
     * @param arrivestation the JComboBox for arrival stations
     * @param arrivetime    the JComboBox for arrival times
     * @param arrivalList   the list containing arrival data
     */
    public static void updateComboBoxes(JComboBox<String> departuretime, JComboBox<String> arrivestation,
                                        JComboBox<String> arrivetime, List<List<String>> arrivalList) {

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

    /**
     * Updates the arrival station and arrival time combo boxes with unique values
     * from the provided time list.
     *
     * @param arrivestation the JComboBox for arrival stations
     * @param arrivetime    the JComboBox for arrival times
     * @param timelist      the list containing time data
     */
    public static void updateComboBoxes1(JComboBox<String> arrivestation, JComboBox<String> arrivetime,
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

    /**
     * Updates the arrival time combo box with unique values from the provided arrival list.
     *
     * @param arrivetime the JComboBox for arrival times
     * @param arrivelist the list containing arrival time data
     */
    public static void updateComboBoxes2(JComboBox<String> arrivetime, List<List<String>> arrivelist) {

        Set<String> uniqueArrivalTimes = new HashSet<>();
        for (List<String> list : arrivelist) {
            uniqueArrivalTimes.add(list.get(0));
        }
        arrivetime.removeAllItems();
        uniqueArrivalTimes.forEach(arrivetime::addItem);
    }
}
