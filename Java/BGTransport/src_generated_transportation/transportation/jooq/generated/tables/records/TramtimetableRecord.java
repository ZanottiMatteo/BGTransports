/*
 * This file is generated by jOOQ.
 */
package transportation.jooq.generated.tables.records;


import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import transportation.jooq.generated.tables.Tramtimetable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TramtimetableRecord extends UpdatableRecordImpl<TramtimetableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>tramTimetable.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>tramTimetable.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>tramTimetable.companyName</code>.
     */
    public void setCompanyname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>tramTimetable.companyName</code>.
     */
    public String getCompanyname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>tramTimetable.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>tramTimetable.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>tramTimetable.departureTramStation</code>.
     */
    public void setDeparturetramstation(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>tramTimetable.departureTramStation</code>.
     */
    public String getDeparturetramstation() {
        return (String) get(3);
    }

    /**
     * Setter for <code>tramTimetable.departureTime</code>.
     */
    public void setDeparturetime(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>tramTimetable.departureTime</code>.
     */
    public String getDeparturetime() {
        return (String) get(4);
    }

    /**
     * Setter for <code>tramTimetable.arrivalTramStation</code>.
     */
    public void setArrivaltramstation(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>tramTimetable.arrivalTramStation</code>.
     */
    public String getArrivaltramstation() {
        return (String) get(5);
    }

    /**
     * Setter for <code>tramTimetable.arrivalTime</code>.
     */
    public void setArrivaltime(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>tramTimetable.arrivalTime</code>.
     */
    public String getArrivaltime() {
        return (String) get(6);
    }

    /**
     * Setter for <code>tramTimetable.nextStop</code>.
     */
    public void setNextstop(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>tramTimetable.nextStop</code>.
     */
    public String getNextstop() {
        return (String) get(7);
    }

    /**
     * Setter for <code>tramTimetable.timeStop</code>.
     */
    public void setTimestop(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>tramTimetable.timeStop</code>.
     */
    public String getTimestop() {
        return (String) get(8);
    }

    /**
     * Setter for <code>tramTimetable.type</code>.
     */
    public void setType(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>tramTimetable.type</code>.
     */
    public String getType() {
        return (String) get(9);
    }

    /**
     * Setter for <code>tramTimetable.numberOfSeats</code>.
     */
    public void setNumberofseats(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>tramTimetable.numberOfSeats</code>.
     */
    public String getNumberofseats() {
        return (String) get(10);
    }

    /**
     * Setter for <code>tramTimetable.numberOfCarriages</code>.
     */
    public void setNumberofcarriages(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>tramTimetable.numberOfCarriages</code>.
     */
    public String getNumberofcarriages() {
        return (String) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TramtimetableRecord
     */
    public TramtimetableRecord() {
        super(Tramtimetable.TRAMTIMETABLE);
    }

    /**
     * Create a detached, initialised TramtimetableRecord
     */
    public TramtimetableRecord(Integer id, String companyname, String name, String departuretramstation, String departuretime, String arrivaltramstation, String arrivaltime, String nextstop, String timestop, String type, String numberofseats, String numberofcarriages) {
        super(Tramtimetable.TRAMTIMETABLE);

        setId(id);
        setCompanyname(companyname);
        setName(name);
        setDeparturetramstation(departuretramstation);
        setDeparturetime(departuretime);
        setArrivaltramstation(arrivaltramstation);
        setArrivaltime(arrivaltime);
        setNextstop(nextstop);
        setTimestop(timestop);
        setType(type);
        setNumberofseats(numberofseats);
        setNumberofcarriages(numberofcarriages);
        resetChangedOnNotNull();
    }
}