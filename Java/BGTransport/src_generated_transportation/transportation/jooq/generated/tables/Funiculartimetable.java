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
import transportation.jooq.generated.tables.records.FuniculartimetableRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Funiculartimetable extends TableImpl<FuniculartimetableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>funicularTimetable</code>
     */
    public static final Funiculartimetable FUNICULARTIMETABLE = new Funiculartimetable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FuniculartimetableRecord> getRecordType() {
        return FuniculartimetableRecord.class;
    }

    /**
     * The column <code>funicularTimetable.id</code>.
     */
    public final TableField<FuniculartimetableRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>funicularTimetable.companyName</code>.
     */
    public final TableField<FuniculartimetableRecord, String> COMPANYNAME = createField(DSL.name("companyName"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>funicularTimetable.name</code>.
     */
    public final TableField<FuniculartimetableRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>funicularTimetable.departureFunicularStation</code>.
     */
    public final TableField<FuniculartimetableRecord, String> DEPARTUREFUNICULARSTATION = createField(DSL.name("departureFunicularStation"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>funicularTimetable.departureTime</code>.
     */
    public final TableField<FuniculartimetableRecord, String> DEPARTURETIME = createField(DSL.name("departureTime"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>funicularTimetable.arrivalFunicularStation</code>.
     */
    public final TableField<FuniculartimetableRecord, String> ARRIVALFUNICULARSTATION = createField(DSL.name("arrivalFunicularStation"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>funicularTimetable.arrivalTime</code>.
     */
    public final TableField<FuniculartimetableRecord, String> ARRIVALTIME = createField(DSL.name("arrivalTime"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>funicularTimetable.type</code>.
     */
    public final TableField<FuniculartimetableRecord, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>funicularTimetable.numberOfSeats</code>.
     */
    public final TableField<FuniculartimetableRecord, String> NUMBEROFSEATS = createField(DSL.name("numberOfSeats"), SQLDataType.VARCHAR(255), this, "");

    private Funiculartimetable(Name alias, Table<FuniculartimetableRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Funiculartimetable(Name alias, Table<FuniculartimetableRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>funicularTimetable</code> table reference
     */
    public Funiculartimetable(String alias) {
        this(DSL.name(alias), FUNICULARTIMETABLE);
    }

    /**
     * Create an aliased <code>funicularTimetable</code> table reference
     */
    public Funiculartimetable(Name alias) {
        this(alias, FUNICULARTIMETABLE);
    }

    /**
     * Create a <code>funicularTimetable</code> table reference
     */
    public Funiculartimetable() {
        this(DSL.name("funicularTimetable"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<FuniculartimetableRecord> getPrimaryKey() {
        return Keys.FUNICULARTIMETABLE__PK_FUNICULARTIMETABLE;
    }

    @Override
    public Funiculartimetable as(String alias) {
        return new Funiculartimetable(DSL.name(alias), this);
    }

    @Override
    public Funiculartimetable as(Name alias) {
        return new Funiculartimetable(alias, this);
    }

    @Override
    public Funiculartimetable as(Table<?> alias) {
        return new Funiculartimetable(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Funiculartimetable rename(String name) {
        return new Funiculartimetable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Funiculartimetable rename(Name name) {
        return new Funiculartimetable(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Funiculartimetable rename(Table<?> name) {
        return new Funiculartimetable(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Funiculartimetable where(Condition condition) {
        return new Funiculartimetable(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Funiculartimetable where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Funiculartimetable where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Funiculartimetable where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Funiculartimetable where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Funiculartimetable where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Funiculartimetable where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Funiculartimetable where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Funiculartimetable whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Funiculartimetable whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
