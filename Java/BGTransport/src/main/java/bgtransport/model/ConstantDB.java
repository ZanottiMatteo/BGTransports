package bgtransport.model;

/**
 * The ConstantDB class contains constants used for configuring and accessing
 * the transportation and user databases, as well as other necessary configurations for interacting with JOOQ and SQLite.
 * 
 * The constants in this class are used for connecting to SQLite databases, configuring
 * JOOQ, and managing the generated source files.
 * 
 */
public class ConstantDB {

    /**
     * The JDBC driver for SQLite.
     */
    public static final String JDBC = "org.sqlite.JDBC";
    
    /**
     * The class used to access the SQLite database through JOOQ.
     */
    public static final String SQLITEDATABASE = "org.jooq.meta.sqlite.SQLiteDatabase";

    /**
     * The folder where the transportation-related generated files are stored.
     */
    public static final String SRC_TRANSPORTATION = "src_generated_transportation/";

    /**
     * The folder where the user-related generated files are stored.
     */
    public static final String SRC_USER = "src_generated_user/";

    /**
     * The path to the public transportation database file.
     */
    public static final String DB_PUBLIC_TRANSPORTATION = "database/PublicTransportation.db3";
    
    /**
     * The JDBC connection URL for the public transportation database.
     * 
     * This uses the SQLite JDBC format to connect to the public transportation database.
     */
    public static final String DB_URL_PUBLIC_TRANSPORTATION = "jdbc:sqlite:" + DB_PUBLIC_TRANSPORTATION;

    /**
     * The path to the users database file.
     */
    public static final String DB_USERS = "database/Users.db3";
    
    /**
     * The JDBC connection URL for the users database.
     * 
     * This uses the SQLite JDBC format to connect to the users database.
     */
    public static final String DB_URL_USERS = "jdbc:sqlite:" + DB_USERS;

    /**
     * The package name generated by JOOQ for the transportation database.
     */
    public static final String JOOQ_TRANSPORTATION = "transportation.jooq.generated";

    /**
     * The package name generated by JOOQ for the users database.
     */
    public static final String JOOQ_USER = "user.jooq.generated";
}
