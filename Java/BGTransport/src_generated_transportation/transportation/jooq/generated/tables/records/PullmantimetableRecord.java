/*
 * This file is generated by jOOQ.
 */
package transportation.jooq.generated.tables.records;


import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import transportation.jooq.generated.tables.Pullmantimetable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PullmantimetableRecord extends UpdatableRecordImpl<PullmantimetableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>pullmanTimetable.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>pullmanTimetable.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>pullmanTimetable.companyName</code>.
     */
    public void setCompanyname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pullmanTimetable.companyName</code>.
     */
    public String getCompanyname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>pullmanTimetable.line</code>.
     */
    public void setLine(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>pullmanTimetable.line</code>.
     */
    public String getLine() {
        return (String) get(2);
    }

    /**
     * Setter for <code>pullmanTimetable.departurePullmanStop</code>.
     */
    public void setDeparturepullmanstop(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>pullmanTimetable.departurePullmanStop</code>.
     */
    public String getDeparturepullmanstop() {
        return (String) get(3);
    }

    /**
     * Setter for <code>pullmanTimetable.departureTime</code>.
     */
    public void setDeparturetime(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>pullmanTimetable.departureTime</code>.
     */
    public String getDeparturetime() {
        return (String) get(4);
    }

    /**
     * Setter for <code>pullmanTimetable.arrivalPullmanStop</code>.
     */
    public void setArrivalpullmanstop(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>pullmanTimetable.arrivalPullmanStop</code>.
     */
    public String getArrivalpullmanstop() {
        return (String) get(5);
    }

    /**
     * Setter for <code>pullmanTimetable.arrivalTime</code>.
     */
    public void setArrivaltime(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>pullmanTimetable.arrivalTime</code>.
     */
    public String getArrivaltime() {
        return (String) get(6);
    }

    /**
     * Setter for <code>pullmanTimetable.nextStop</code>.
     */
    public void setNextstop(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>pullmanTimetable.nextStop</code>.
     */
    public String getNextstop() {
        return (String) get(7);
    }

    /**
     * Setter for <code>pullmanTimetable.timeStop</code>.
     */
    public void setTimestop(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>pullmanTimetable.timeStop</code>.
     */
    public String getTimestop() {
        return (String) get(8);
    }

    /**
     * Setter for <code>pullmanTimetable.type</code>.
     */
    public void setType(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>pullmanTimetable.type</code>.
     */
    public String getType() {
        return (String) get(9);
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
     * Create a detached PullmantimetableRecord
     */
    public PullmantimetableRecord() {
        super(Pullmantimetable.PULLMANTIMETABLE);
    }

    /**
     * Create a detached, initialised PullmantimetableRecord
     */
    public PullmantimetableRecord(Integer id, String companyname, String line, String departurepullmanstop, String departuretime, String arrivalpullmanstop, String arrivaltime, String nextstop, String timestop, String type) {
        super(Pullmantimetable.PULLMANTIMETABLE);

        setId(id);
        setCompanyname(companyname);
        setLine(line);
        setDeparturepullmanstop(departurepullmanstop);
        setDeparturetime(departuretime);
        setArrivalpullmanstop(arrivalpullmanstop);
        setArrivaltime(arrivaltime);
        setNextstop(nextstop);
        setTimestop(timestop);
        setType(type);
        resetChangedOnNotNull();
    }
}