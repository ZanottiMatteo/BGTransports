/*
 * This file is generated by jOOQ.
 */
package transportation.jooq.generated.tables.records;


import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import transportation.jooq.generated.tables.Traintimetable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TraintimetableRecord extends UpdatableRecordImpl<TraintimetableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>trainTimetable.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>trainTimetable.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>trainTimetable.companyName</code>.
     */
    public void setCompanyname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>trainTimetable.companyName</code>.
     */
    public String getCompanyname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>trainTimetable.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>trainTimetable.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>trainTimetable.departureTrainStation</code>.
     */
    public void setDeparturetrainstation(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>trainTimetable.departureTrainStation</code>.
     */
    public String getDeparturetrainstation() {
        return (String) get(3);
    }

    /**
     * Setter for <code>trainTimetable.departureTime</code>.
     */
    public void setDeparturetime(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>trainTimetable.departureTime</code>.
     */
    public String getDeparturetime() {
        return (String) get(4);
    }

    /**
     * Setter for <code>trainTimetable.arrivalTrainStation</code>.
     */
    public void setArrivaltrainstation(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>trainTimetable.arrivalTrainStation</code>.
     */
    public String getArrivaltrainstation() {
        return (String) get(5);
    }

    /**
     * Setter for <code>trainTimetable.arrivalTime</code>.
     */
    public void setArrivaltime(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>trainTimetable.arrivalTime</code>.
     */
    public String getArrivaltime() {
        return (String) get(6);
    }

    /**
     * Setter for <code>trainTimetable.nextStop</code>.
     */
    public void setNextstop(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>trainTimetable.nextStop</code>.
     */
    public String getNextstop() {
        return (String) get(7);
    }

    /**
     * Setter for <code>trainTimetable.timeStop</code>.
     */
    public void setTimestop(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>trainTimetable.timeStop</code>.
     */
    public String getTimestop() {
        return (String) get(8);
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
     * Create a detached TraintimetableRecord
     */
    public TraintimetableRecord() {
        super(Traintimetable.TRAINTIMETABLE);
    }

    /**
     * Create a detached, initialised TraintimetableRecord
     */
    public TraintimetableRecord(Integer id, String companyname, String name, String departuretrainstation, String departuretime, String arrivaltrainstation, String arrivaltime, String nextstop, String timestop) {
        super(Traintimetable.TRAINTIMETABLE);

        setId(id);
        setCompanyname(companyname);
        setName(name);
        setDeparturetrainstation(departuretrainstation);
        setDeparturetime(departuretime);
        setArrivaltrainstation(arrivaltrainstation);
        setArrivaltime(arrivaltime);
        setNextstop(nextstop);
        setTimestop(timestop);
        resetChangedOnNotNull();
    }
}
