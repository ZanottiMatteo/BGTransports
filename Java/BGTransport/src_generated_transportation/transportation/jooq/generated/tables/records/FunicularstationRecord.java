/*
 * This file is generated by jOOQ.
 */
package transportation.jooq.generated.tables.records;


import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import transportation.jooq.generated.tables.Funicularstation;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class FunicularstationRecord extends UpdatableRecordImpl<FunicularstationRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>funicularStation.name</code>.
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>funicularStation.name</code>.
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>funicularStation.address</code>.
     */
    public void setAddress(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>funicularStation.address</code>.
     */
    public String getAddress() {
        return (String) get(1);
    }

    /**
     * Setter for <code>funicularStation.town</code>.
     */
    public void setTown(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>funicularStation.town</code>.
     */
    public String getTown() {
        return (String) get(2);
    }

    /**
     * Setter for <code>funicularStation.province</code>.
     */
    public void setProvince(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>funicularStation.province</code>.
     */
    public String getProvince() {
        return (String) get(3);
    }

    /**
     * Setter for <code>funicularStation.lat</code>.
     */
    public void setLat(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>funicularStation.lat</code>.
     */
    public String getLat() {
        return (String) get(4);
    }

    /**
     * Setter for <code>funicularStation.lon</code>.
     */
    public void setLon(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>funicularStation.lon</code>.
     */
    public String getLon() {
        return (String) get(5);
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
     * Create a detached FunicularstationRecord
     */
    public FunicularstationRecord() {
        super(Funicularstation.FUNICULARSTATION);
    }

    /**
     * Create a detached, initialised FunicularstationRecord
     */
    public FunicularstationRecord(String name, String address, String town, String province, String lat, String lon) {
        super(Funicularstation.FUNICULARSTATION);

        setName(name);
        setAddress(address);
        setTown(town);
        setProvince(province);
        setLat(lat);
        setLon(lon);
        resetChangedOnNotNull();
    }
}