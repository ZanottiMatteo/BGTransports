package bgtransport.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class CreateTablesDBTest {

    private static DSLContext create1;
    private static DSLContext create2;
    private static Connection connection1;
    private static Connection connection2;

    @BeforeAll
    static void setUp() throws SQLException {
        connection1 = DriverManager.getConnection("jdbc:h2:mem:testdb1;DB_CLOSE_DELAY=-1", "sa", "");
        connection2 = DriverManager.getConnection("jdbc:h2:mem:testdb2;DB_CLOSE_DELAY=-1", "sa", "");
        create1 = DSL.using(connection1, SQLDialect.H2);
        create2 = DSL.using(connection2, SQLDialect.H2);
        CreateTablesDB.createTablesPublicTransportation(create1);
        CreateTablesDB.createTablesUsers(create2);
    }

    @AfterAll
    static void tearDown() throws SQLException {
        if (connection1 != null && !connection1.isClosed()) {
            connection1.close();
        }
        
        if (connection2 != null && !connection2.isClosed()) {
            connection2.close();
        }
    }

    @Test
    void testTableCreationPublicTransportation() {
        List<String> tableNames = create1.select(DSL.field("TABLE_NAME"))
            								.from("INFORMATION_SCHEMA.TABLES")
                                            .where(DSL.field("TABLE_SCHEMA").eq("PUBLIC"))
                                            .fetch(DSL.field("TABLE_NAME", String.class));

        assertTrue(tableNames.contains("pullmanTimetable"), "La tabella PULLMAN_TIMETABLE non è stata creata.");
        assertTrue(tableNames.contains("funicularTimetable"), "La tabella FUNICULAR_TIMETABLE non è stata creata.");
        assertTrue(tableNames.contains("trainTimetable"), "La tabella TRAIN_TIMETABLE non è stata creata.");
        assertTrue(tableNames.contains("tramTimetable"), "La tabella TRAM_TIMETABLE non è stata creata.");
        assertTrue(tableNames.contains("company"), "La tabella COMPANY non è stata creata.");
        assertTrue(tableNames.contains("pullmanStop"), "La tabella PULLMAN_STOP non è stata creata.");
        assertTrue(tableNames.contains("tramStop"), "La tabella TRAM_STOP non è stata creata.");
        assertTrue(tableNames.contains("funicularStation"), "La tabella FUNICULAR_STATION non è stata creata.");
        assertTrue(tableNames.contains("trainStation"), "La tabella TRAIN_STATION non è stata creata.");
    }

    @Test
    void testTableCreationUsers() {
        List<String> tableNames = create2.select(DSL.field("TABLE_NAME"))
    										.from("INFORMATION_SCHEMA.TABLES")
                                            .where(DSL.field("TABLE_SCHEMA").eq("PUBLIC"))
                                            .fetch(DSL.field("TABLE_NAME", String.class));

        assertTrue(tableNames.contains("user"), "La tabella USER non è stata creata.");
    }
}

