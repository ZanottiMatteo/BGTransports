/*
 * This file is generated by jOOQ.
 */
package contatti.jooq.generated.tables.records;


import contatti.jooq.generated.tables.Timetable;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TimetableRecord extends UpdatableRecordImpl<TimetableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>TIMETABLE.time</code>.
     */
    public void setTime(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>TIMETABLE.time</code>.
     */
    public String getTime() {
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
     * Create a detached TimetableRecord
     */
    public TimetableRecord() {
        super(Timetable.TIMETABLE);
    }

    /**
     * Create a detached, initialised TimetableRecord
     */
    public TimetableRecord(String time) {
        super(Timetable.TIMETABLE);

        setTime(time);
        resetChangedOnNotNull();
    }
}
