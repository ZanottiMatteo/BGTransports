/*
 * This file is generated by jOOQ.
 */
package transportation.jooq.generated.tables.records;


import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import transportation.jooq.generated.tables.Train;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TrainRecord extends UpdatableRecordImpl<TrainRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>TRAIN.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>TRAIN.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>TRAIN.driver_name</code>.
     */
    public void setDriverName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>TRAIN.driver_name</code>.
     */
    public String getDriverName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>TRAIN.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>TRAIN.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>TRAIN.number_of_seats</code>.
     */
    public void setNumberOfSeats(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>TRAIN.number_of_seats</code>.
     */
    public String getNumberOfSeats() {
        return (String) get(3);
    }

    /**
     * Setter for <code>TRAIN.number_of_carriages</code>.
     */
    public void setNumberOfCarriages(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>TRAIN.number_of_carriages</code>.
     */
    public String getNumberOfCarriages() {
        return (String) get(4);
    }

    /**
     * Setter for <code>TRAIN.departure_train_station</code>.
     */
    public void setDepartureTrainStation(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>TRAIN.departure_train_station</code>.
     */
    public String getDepartureTrainStation() {
        return (String) get(5);
    }

    /**
     * Setter for <code>TRAIN.arrival_train_station</code>.
     */
    public void setArrivalTrainStation(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>TRAIN.arrival_train_station</code>.
     */
    public String getArrivalTrainStation() {
        return (String) get(6);
    }

    /**
     * Setter for <code>TRAIN.departure_timetable</code>.
     */
    public void setDepartureTimetable(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>TRAIN.departure_timetable</code>.
     */
    public String getDepartureTimetable() {
        return (String) get(7);
    }

    /**
     * Setter for <code>TRAIN.arrival_timetable</code>.
     */
    public void setArrivalTimetable(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>TRAIN.arrival_timetable</code>.
     */
    public String getArrivalTimetable() {
        return (String) get(8);
    }

    /**
     * Setter for <code>TRAIN.company_name</code>.
     */
    public void setCompanyName(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>TRAIN.company_name</code>.
     */
    public String getCompanyName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>TRAIN.train_stop</code>.
     */
    public void setTrainStop(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>TRAIN.train_stop</code>.
     */
    public String getTrainStop() {
        return (String) get(10);
    }

    /**
     * Setter for <code>TRAIN.time</code>.
     */
    public void setTime(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>TRAIN.time</code>.
     */
    public String getTime() {
        return (String) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TrainRecord
     */
    public TrainRecord() {
        super(Train.TRAIN);
    }

    /**
     * Create a detached, initialised TrainRecord
     */
    public TrainRecord(String id, String driverName, String description, String numberOfSeats, String numberOfCarriages, String departureTrainStation, String arrivalTrainStation, String departureTimetable, String arrivalTimetable, String companyName, String trainStop, String time) {
        super(Train.TRAIN);

        setId(id);
        setDriverName(driverName);
        setDescription(description);
        setNumberOfSeats(numberOfSeats);
        setNumberOfCarriages(numberOfCarriages);
        setDepartureTrainStation(departureTrainStation);
        setArrivalTrainStation(arrivalTrainStation);
        setDepartureTimetable(departureTimetable);
        setArrivalTimetable(arrivalTimetable);
        setCompanyName(companyName);
        setTrainStop(trainStop);
        setTime(time);
        resetChangedOnNotNull();
    }
}