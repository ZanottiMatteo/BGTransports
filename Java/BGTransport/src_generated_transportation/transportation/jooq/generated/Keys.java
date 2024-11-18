/*
 * This file is generated by jOOQ.
 */
package transportation.jooq.generated;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import transportation.jooq.generated.tables.Company;
import transportation.jooq.generated.tables.Driver;
import transportation.jooq.generated.tables.Funicular;
import transportation.jooq.generated.tables.FunicularStation;
import transportation.jooq.generated.tables.Pullman;
import transportation.jooq.generated.tables.PullmanStop;
import transportation.jooq.generated.tables.State;
import transportation.jooq.generated.tables.Timetable;
import transportation.jooq.generated.tables.Train;
import transportation.jooq.generated.tables.TrainStation;
import transportation.jooq.generated.tables.Tram;
import transportation.jooq.generated.tables.TramStop;
import transportation.jooq.generated.tables.records.CompanyRecord;
import transportation.jooq.generated.tables.records.DriverRecord;
import transportation.jooq.generated.tables.records.FunicularRecord;
import transportation.jooq.generated.tables.records.FunicularStationRecord;
import transportation.jooq.generated.tables.records.PullmanRecord;
import transportation.jooq.generated.tables.records.PullmanStopRecord;
import transportation.jooq.generated.tables.records.StateRecord;
import transportation.jooq.generated.tables.records.TimetableRecord;
import transportation.jooq.generated.tables.records.TrainRecord;
import transportation.jooq.generated.tables.records.TrainStationRecord;
import transportation.jooq.generated.tables.records.TramRecord;
import transportation.jooq.generated.tables.records.TramStopRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CompanyRecord> COMPANY__PK_COMPANY = Internal.createUniqueKey(Company.COMPANY, DSL.name("PK_COMPANY"), new TableField[] { Company.COMPANY.NAME }, true);
    public static final UniqueKey<DriverRecord> DRIVER__PK_DRIVER = Internal.createUniqueKey(Driver.DRIVER, DSL.name("PK_DRIVER"), new TableField[] { Driver.DRIVER.ID }, true);
    public static final UniqueKey<FunicularRecord> FUNICULAR__PK_FUNICULAR = Internal.createUniqueKey(Funicular.FUNICULAR, DSL.name("PK_FUNICULAR"), new TableField[] { Funicular.FUNICULAR.ID }, true);
    public static final UniqueKey<FunicularStationRecord> FUNICULAR_STATION__PK_FUNICULAR_STATION = Internal.createUniqueKey(FunicularStation.FUNICULAR_STATION, DSL.name("PK_FUNICULAR STATION"), new TableField[] { FunicularStation.FUNICULAR_STATION.NAME }, true);
    public static final UniqueKey<PullmanRecord> PULLMAN__PK_PULLMAN = Internal.createUniqueKey(Pullman.PULLMAN, DSL.name("PK_PULLMAN"), new TableField[] { Pullman.PULLMAN.ID }, true);
    public static final UniqueKey<PullmanStopRecord> PULLMAN_STOP__PK_PULLMAN_STOP = Internal.createUniqueKey(PullmanStop.PULLMAN_STOP, DSL.name("PK_PULLMAN STOP"), new TableField[] { PullmanStop.PULLMAN_STOP.NAME }, true);
    public static final UniqueKey<StateRecord> STATE__PK_STATE = Internal.createUniqueKey(State.STATE, DSL.name("PK_STATE"), new TableField[] { State.STATE.DESCRIPTION }, true);
    public static final UniqueKey<TimetableRecord> TIMETABLE__PK_TIMETABLE = Internal.createUniqueKey(Timetable.TIMETABLE, DSL.name("PK_TIMETABLE"), new TableField[] { Timetable.TIMETABLE.TIME }, true);
    public static final UniqueKey<TrainRecord> TRAIN__PK_TRAIN = Internal.createUniqueKey(Train.TRAIN, DSL.name("PK_TRAIN"), new TableField[] { Train.TRAIN.ID }, true);
    public static final UniqueKey<TrainStationRecord> TRAIN_STATION__PK_TRAIN_STATION = Internal.createUniqueKey(TrainStation.TRAIN_STATION, DSL.name("PK_TRAIN STATION"), new TableField[] { TrainStation.TRAIN_STATION.NAME }, true);
    public static final UniqueKey<TramRecord> TRAM__PK_TRAM = Internal.createUniqueKey(Tram.TRAM, DSL.name("PK_TRAM"), new TableField[] { Tram.TRAM.ID }, true);
    public static final UniqueKey<TramStopRecord> TRAM_STOP__PK_TRAM_STOP = Internal.createUniqueKey(TramStop.TRAM_STOP, DSL.name("PK_TRAM STOP"), new TableField[] { TramStop.TRAM_STOP.NAME }, true);
}