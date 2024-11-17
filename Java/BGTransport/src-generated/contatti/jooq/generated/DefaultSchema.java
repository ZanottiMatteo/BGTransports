/*
 * This file is generated by jOOQ.
 */
package contatti.jooq.generated;


import contatti.jooq.generated.tables.Company;
import contatti.jooq.generated.tables.Driver;
import contatti.jooq.generated.tables.Funicular;
import contatti.jooq.generated.tables.FunicularStation;
import contatti.jooq.generated.tables.Pullman;
import contatti.jooq.generated.tables.PullmanStop;
import contatti.jooq.generated.tables.State;
import contatti.jooq.generated.tables.Timetable;
import contatti.jooq.generated.tables.Train;
import contatti.jooq.generated.tables.TrainStation;
import contatti.jooq.generated.tables.Tram;
import contatti.jooq.generated.tables.TramStop;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>COMPANY</code>.
     */
    public final Company COMPANY = Company.COMPANY;

    /**
     * The table <code>DRIVER</code>.
     */
    public final Driver DRIVER = Driver.DRIVER;

    /**
     * The table <code>FUNICULAR</code>.
     */
    public final Funicular FUNICULAR = Funicular.FUNICULAR;

    /**
     * The table <code>FUNICULAR STATION</code>.
     */
    public final FunicularStation FUNICULAR_STATION = FunicularStation.FUNICULAR_STATION;

    /**
     * The table <code>PULLMAN</code>.
     */
    public final Pullman PULLMAN = Pullman.PULLMAN;

    /**
     * The table <code>PULLMAN STOP</code>.
     */
    public final PullmanStop PULLMAN_STOP = PullmanStop.PULLMAN_STOP;

    /**
     * The table <code>STATE</code>.
     */
    public final State STATE = State.STATE;

    /**
     * The table <code>TIMETABLE</code>.
     */
    public final Timetable TIMETABLE = Timetable.TIMETABLE;

    /**
     * The table <code>TRAIN</code>.
     */
    public final Train TRAIN = Train.TRAIN;

    /**
     * The table <code>TRAIN STATION</code>.
     */
    public final TrainStation TRAIN_STATION = TrainStation.TRAIN_STATION;

    /**
     * The table <code>TRAM</code>.
     */
    public final Tram TRAM = Tram.TRAM;

    /**
     * The table <code>TRAM STOP</code>.
     */
    public final TramStop TRAM_STOP = TramStop.TRAM_STOP;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Company.COMPANY,
            Driver.DRIVER,
            Funicular.FUNICULAR,
            FunicularStation.FUNICULAR_STATION,
            Pullman.PULLMAN,
            PullmanStop.PULLMAN_STOP,
            State.STATE,
            Timetable.TIMETABLE,
            Train.TRAIN,
            TrainStation.TRAIN_STATION,
            Tram.TRAM,
            TramStop.TRAM_STOP
        );
    }
}