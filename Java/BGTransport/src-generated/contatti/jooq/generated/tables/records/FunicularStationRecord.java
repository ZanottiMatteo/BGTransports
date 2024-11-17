/*
 * This file is generated by jOOQ.
 */
package contatti.jooq.generated.tables.records;


import contatti.jooq.generated.tables.FunicularStation;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class FunicularStationRecord extends UpdatableRecordImpl<FunicularStationRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>FUNICULAR STATION.name</code>.
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>FUNICULAR STATION.name</code>.
     */
    public String getName() {
        return (String) get(0);
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
     * Create a detached FunicularStationRecord
     */
    public FunicularStationRecord() {
        super(FunicularStation.FUNICULAR_STATION);
    }

    /**
     * Create a detached, initialised FunicularStationRecord
     */
    public FunicularStationRecord(String name) {
        super(FunicularStation.FUNICULAR_STATION);

        setName(name);
        resetChangedOnNotNull();
    }
}