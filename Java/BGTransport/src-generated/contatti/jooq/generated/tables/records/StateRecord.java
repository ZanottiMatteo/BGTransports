/*
 * This file is generated by jOOQ.
 */
package contatti.jooq.generated.tables.records;


import contatti.jooq.generated.tables.State;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class StateRecord extends UpdatableRecordImpl<StateRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>STATE.description</code>.
     */
    public void setDescription(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>STATE.description</code>.
     */
    public String getDescription() {
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
     * Create a detached StateRecord
     */
    public StateRecord() {
        super(State.STATE);
    }

    /**
     * Create a detached, initialised StateRecord
     */
    public StateRecord(String description) {
        super(State.STATE);

        setDescription(description);
        resetChangedOnNotNull();
    }
}
