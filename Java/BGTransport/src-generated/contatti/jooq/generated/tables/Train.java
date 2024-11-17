/*
 * This file is generated by jOOQ.
 */
package contatti.jooq.generated.tables;


import contatti.jooq.generated.DefaultSchema;
import contatti.jooq.generated.Keys;
import contatti.jooq.generated.tables.records.TrainRecord;

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


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Train extends TableImpl<TrainRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>TRAIN</code>
     */
    public static final Train TRAIN = new Train();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TrainRecord> getRecordType() {
        return TrainRecord.class;
    }

    /**
     * The column <code>TRAIN.id</code>.
     */
    public final TableField<TrainRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.driver_name</code>.
     */
    public final TableField<TrainRecord, String> DRIVER_NAME = createField(DSL.name("driver_name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.description</code>.
     */
    public final TableField<TrainRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.number_of_seats</code>.
     */
    public final TableField<TrainRecord, String> NUMBER_OF_SEATS = createField(DSL.name("number_of_seats"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.number_of_carriages</code>.
     */
    public final TableField<TrainRecord, String> NUMBER_OF_CARRIAGES = createField(DSL.name("number_of_carriages"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.departure_train_station</code>.
     */
    public final TableField<TrainRecord, String> DEPARTURE_TRAIN_STATION = createField(DSL.name("departure_train_station"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.arrival_train_station</code>.
     */
    public final TableField<TrainRecord, String> ARRIVAL_TRAIN_STATION = createField(DSL.name("arrival_train_station"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.departure_timetable</code>.
     */
    public final TableField<TrainRecord, String> DEPARTURE_TIMETABLE = createField(DSL.name("departure_timetable"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.arrival_timetable</code>.
     */
    public final TableField<TrainRecord, String> ARRIVAL_TIMETABLE = createField(DSL.name("arrival_timetable"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.company_name</code>.
     */
    public final TableField<TrainRecord, String> COMPANY_NAME = createField(DSL.name("company_name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.train_stop</code>.
     */
    public final TableField<TrainRecord, String> TRAIN_STOP = createField(DSL.name("train_stop"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>TRAIN.time</code>.
     */
    public final TableField<TrainRecord, String> TIME = createField(DSL.name("time"), SQLDataType.VARCHAR(255), this, "");

    private Train(Name alias, Table<TrainRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Train(Name alias, Table<TrainRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>TRAIN</code> table reference
     */
    public Train(String alias) {
        this(DSL.name(alias), TRAIN);
    }

    /**
     * Create an aliased <code>TRAIN</code> table reference
     */
    public Train(Name alias) {
        this(alias, TRAIN);
    }

    /**
     * Create a <code>TRAIN</code> table reference
     */
    public Train() {
        this(DSL.name("TRAIN"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<TrainRecord> getPrimaryKey() {
        return Keys.TRAIN__PK_TRAIN;
    }

    @Override
    public Train as(String alias) {
        return new Train(DSL.name(alias), this);
    }

    @Override
    public Train as(Name alias) {
        return new Train(alias, this);
    }

    @Override
    public Train as(Table<?> alias) {
        return new Train(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Train rename(String name) {
        return new Train(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Train rename(Name name) {
        return new Train(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Train rename(Table<?> name) {
        return new Train(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Train where(Condition condition) {
        return new Train(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Train where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Train where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Train where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Train where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Train where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Train where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Train where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Train whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Train whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
