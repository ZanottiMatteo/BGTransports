/*
 * This file is generated by jOOQ.
 */
package contatti.jooq.generated.tables.records;


import contatti.jooq.generated.tables.TramStop;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TramStopRecord extends UpdatableRecordImpl<TramStopRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>TRAM STOP.name</code>.
     */
    public void setName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>TRAM STOP.name</code>.
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
     * Create a detached TramStopRecord
     */
    public TramStopRecord() {
        super(TramStop.TRAM_STOP);
    }

    /**
     * Create a detached, initialised TramStopRecord
     */
    public TramStopRecord(String name) {
        super(TramStop.TRAM_STOP);

        setName(name);
        resetChangedOnNotNull();
    }
}
