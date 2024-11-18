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
import transportation.jooq.generated.tables.records.PullmanRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Pullman extends TableImpl<PullmanRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>PULLMAN</code>
     */
    public static final Pullman PULLMAN = new Pullman();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PullmanRecord> getRecordType() {
        return PullmanRecord.class;
    }

    /**
     * The column <code>PULLMAN.id</code>.
     */
    public final TableField<PullmanRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>PULLMAN.company_name</code>.
     */
    public final TableField<PullmanRecord, String> COMPANY_NAME = createField(DSL.name("company_name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.name</code>.
     */
    public final TableField<PullmanRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.line</code>.
     */
    public final TableField<PullmanRecord, String> LINE = createField(DSL.name("line"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.departure_stop</code>.
     */
    public final TableField<PullmanRecord, String> DEPARTURE_STOP = createField(DSL.name("departure_stop"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.departure_timetable</code>.
     */
    public final TableField<PullmanRecord, String> DEPARTURE_TIMETABLE = createField(DSL.name("departure_timetable"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.arrival_stop</code>.
     */
    public final TableField<PullmanRecord, String> ARRIVAL_STOP = createField(DSL.name("arrival_stop"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.arrival_timetable</code>.
     */
    public final TableField<PullmanRecord, String> ARRIVAL_TIMETABLE = createField(DSL.name("arrival_timetable"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.pullman_stop_name</code>.
     */
    public final TableField<PullmanRecord, String> PULLMAN_STOP_NAME = createField(DSL.name("pullman_stop_name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.time</code>.
     */
    public final TableField<PullmanRecord, String> TIME = createField(DSL.name("time"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.number_of_seats</code>.
     */
    public final TableField<PullmanRecord, String> NUMBER_OF_SEATS = createField(DSL.name("number_of_seats"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.license_plate</code>.
     */
    public final TableField<PullmanRecord, String> LICENSE_PLATE = createField(DSL.name("license_plate"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PULLMAN.description</code>.
     */
    public final TableField<PullmanRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(255), this, "");

    private Pullman(Name alias, Table<PullmanRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Pullman(Name alias, Table<PullmanRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>PULLMAN</code> table reference
     */
    public Pullman(String alias) {
        this(DSL.name(alias), PULLMAN);
    }

    /**
     * Create an aliased <code>PULLMAN</code> table reference
     */
    public Pullman(Name alias) {
        this(alias, PULLMAN);
    }

    /**
     * Create a <code>PULLMAN</code> table reference
     */
    public Pullman() {
        this(DSL.name("PULLMAN"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<PullmanRecord> getPrimaryKey() {
        return Keys.PULLMAN__PK_PULLMAN;
    }

    @Override
    public Pullman as(String alias) {
        return new Pullman(DSL.name(alias), this);
    }

    @Override
    public Pullman as(Name alias) {
        return new Pullman(alias, this);
    }

    @Override
    public Pullman as(Table<?> alias) {
        return new Pullman(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Pullman rename(String name) {
        return new Pullman(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Pullman rename(Name name) {
        return new Pullman(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Pullman rename(Table<?> name) {
        return new Pullman(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Pullman where(Condition condition) {
        return new Pullman(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Pullman where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Pullman where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Pullman where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Pullman where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Pullman where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Pullman where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Pullman where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Pullman whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Pullman whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
