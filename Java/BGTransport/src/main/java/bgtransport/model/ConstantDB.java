package bgtransport.model;

public class ConstantDB {
	public static final String JDBC = "org.sqlite.JDBC";
	public static final String SQLITEDATABASE = "org.jooq.meta.sqlite.SQLiteDatabase";

	public static final String SRC_TRANSPORTATION = "src_generated_transportation/";
	public static final String SRC_USER = "src_generated_user/";

	public static final String DB_PUBLIC_TRANSPORTATION = "database/PublicTransportation.db3";
	public static final String DB_URL_PUBLIC_TRANSPORTATION = "jdbc:sqlite:" + DB_PUBLIC_TRANSPORTATION;
	public static final String DB_USERS = "database/Users.db3";
	public static final String DB_URL_USERS = "jdbc:sqlite:" + DB_USERS;

	public static final String JOOQ_TRANSPORTATION = "transportation.jooq.generated";
	public static final String JOOQ_USER = "user.jooq.generated";
}
