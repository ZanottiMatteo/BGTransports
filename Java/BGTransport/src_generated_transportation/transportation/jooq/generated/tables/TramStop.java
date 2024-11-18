/*
 * This file is generated by jOOQ.
 */
package transportation.jooq.generated.tables;


import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import transportation.jooq.generated.DefaultSchema;
import transportation.jooq.generated.Keys;
import transportation.jooq.generated.tables.records.TramStopRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class TramStop extends TableImpl<TramStopRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>TRAM STOP</code>
     */
    public static final TramStop TRAM_STOP = new TramStop();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TramStopRecord> getRecordType() {
        return TramStopRecord.class;
    }

    /**
     * The column <code>TRAM STOP.name</code>.
     */
    public final TableField<TramStopRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    private TramStop(Name alias, Table<TramStopRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private TramStop(Name alias, Table<TramStopRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>TRAM STOP</code> table reference
     */
    public TramStop(String alias) {
        this(DSL.name(alias), TRAM_STOP);
    }

    /**
     * Create an aliased <code>TRAM STOP</code> table reference
     */
    public TramStop(Name alias) {
        this(alias, TRAM_STOP);
    }

    /**
     * Create a <code>TRAM STOP</code> table reference
     */
    public TramStop() {
        this(DSL.name("TRAM STOP"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<TramStopRecord> getPrimaryKey() {
        return Keys.TRAM_STOP__PK_TRAM_STOP;
    }

    @Override
    public TramStop as(String alias) {
        return new TramStop(DSL.name(alias), this);
    }

    @Override
    public TramStop as(Name alias) {
        return new TramStop(alias, this);
    }

    @Override
    public TramStop as(Table<?> alias) {
        return new TramStop(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TramStop rename(String name) {
        return new TramStop(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TramStop rename(Name name) {
        return new TramStop(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TramStop rename(Table<?> name) {
        return new TramStop(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TramStop where(Condition condition) {
        return new TramStop(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TramStop where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TramStop where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TramStop where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TramStop where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TramStop where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TramStop where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public TramStop where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TramStop whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public TramStop whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}