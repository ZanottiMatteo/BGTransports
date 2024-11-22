package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class ControlDB {

	public static Boolean control(String json) {
		File jsonFile = new File(json);
		if (!jsonFile.exists()) {
			return false;
		}
		return true;
	}
	
	public static DSLContext DSLContext(String database) throws SQLException {
		Connection connection = DriverManager.getConnection(database);
		DSLContext create = DSL.using(connection, SQLDialect.SQLITE);
		return create;
	}
}
