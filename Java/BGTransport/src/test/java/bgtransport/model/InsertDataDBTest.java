package bgtransport.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import transportation.jooq.generated.tables.Company;
import transportation.jooq.generated.tables.records.CompanyRecord;

/**
 * The InsertDataDBTest class is responsible for testing the insertion of company data
 * into a database using jOOQ and verifying that the data is correctly inserted.
 */
class InsertDataDBTest {

    private static DSLContext create1;
    private static Connection connection1;

    /**
     * Sets up the test environment by initializing in-memory H2 databases and
     * creating the necessary tables for public transportation in the first database.
     * This method is executed before all tests.
     * 
     * @throws SQLException if there is an error establishing a connection or creating tables
     */
    @BeforeAll
    static void setUp() throws SQLException {
        // Setting up an in-memory H2 database
        connection1 = DriverManager.getConnection("jdbc:h2:mem:testdb1;DB_CLOSE_DELAY=-1", "sa", "");
        
        // Create DSLContext for interacting with the database
        create1 = DSL.using(connection1, SQLDialect.H2);

        // Creating tables for public transportation in the database
        CreateTablesDB.createTablesPublicTransportation(create1);
    }

    /**
     * Tears down the test environment by closing the database connection.
     * This method is executed after all tests.
     * 
     * @throws SQLException if there is an error closing the database connection
     */
    @AfterAll
    static void tearDown() throws SQLException {
        if (connection1 != null && !connection1.isClosed()) {
            connection1.close();
        }
    }

    /**
     * Tests the insertion of company data into the public transportation database.
     * It creates a new company record, inserts it into the database, and then
     * verifies that the company was inserted correctly by querying the database.
     * 
     * @throws Exception if there is an error during the insertion or validation process
     */
    @Test
    void testCompanyInsertion() throws Exception {
        // Create test company data
        String companyName = "Test Company";
        String legalStructure = "Ltd";
        String businessTaxCode = "123456789";
        String companyRegistrationNumber = "987654321";
        String incorporationDate = "2024-01-01";

        // Create a company record to insert into the database
        CompanyRecord companyRecord = new CompanyRecord(companyName, legalStructure, businessTaxCode,
                companyRegistrationNumber, incorporationDate, companyName, companyName, companyName, companyName, companyName, companyName, companyName, companyName, companyName, companyName, companyName, companyName);

        // Insert the company record into the public transportation database (create1)
        create1.insertInto(Company.COMPANY)
                .set(companyRecord)
                .execute();

        // Verify that the company was inserted correctly into the database
        String insertedCompanyName = create1.select(Company.COMPANY.NAME)
                .from(Company.COMPANY)
                .where(Company.COMPANY.NAME.eq(companyName))
                .fetchOne(Company.COMPANY.NAME);

        // Assert that the company name in the database matches the expected value
        assertEquals(companyName, insertedCompanyName);
    }
    
    /**
     * A placeholder for additional tests to validate insertion of other values and
     * tables as needed. This can be extended for other records such as 
     * pullman stops, train stations, etc.
     */
}

