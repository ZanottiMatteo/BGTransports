/*
 * This file is generated by jOOQ.
 */
package transportation.jooq.generated.tables.records;


import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import transportation.jooq.generated.tables.Pullmanstop;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PullmanstopRecord extends UpdatableRecordImpl<PullmanstopRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>pullmanStop.name</code>.
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>pullmanStop.name</code>.
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>pullmanStop.town</code>.
     */
    public void setTown(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pullmanStop.town</code>.
     */
    public String getTown() {
        return (String) get(1);
    }

    /**
     * Setter for <code>pullmanStop.province</code>.
     */
    public void setProvince(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>pullmanStop.province</code>.
     */
    public String getProvince() {
        return (String) get(2);
    }

    /**
     * Setter for <code>pullmanStop.lat</code>.
     */
    public void setLat(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>pullmanStop.lat</code>.
     */
    public String getLat() {
        return (String) get(3);
    }

    /**
     * Setter for <code>pullmanStop.lon</code>.
     */
    public void setLon(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>pullmanStop.lon</code>.
     */
    public String getLon() {
        return (String) get(4);
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
     * Create a detached PullmanstopRecord
     */
    public PullmanstopRecord() {
        super(Pullmanstop.PULLMANSTOP);
    }

    /**
     * Create a detached, initialised PullmanstopRecord
     */
    public PullmanstopRecord(String name, String town, String province, String lat, String lon) {
        super(Pullmanstop.PULLMANSTOP);

        setName(name);
        setTown(town);
        setProvince(province);
        setLat(lat);
        setLon(lon);
        resetChangedOnNotNull();
    }
}
