package modeltest;

import org.junit.jupiter.api.Test;

import bgtransport.model.PublicTransportationQueryDB;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

class PublicTransportationQueryDBTest {

    /**
     * Tests the `getInfo` method for a successful case.
     * Verifies that the method returns a non-null result with valid data.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetInfo() throws SQLException {
        String departure = "ALME'"; // Replace with an actual departure station

        List<List<String>> result = PublicTransportationQueryDB.getInfo(departure);

        assertNotNull(result, "The result should not be null.");
        assertFalse(result.isEmpty(), "The result should not be empty.");
        for (List<String> info : result) {
            assertEquals(7, info.size(), "Each list should contain 7 elements.");
        }
    }

    /**
     * Tests the `getInfo` method for a case where no results are found.
     * Verifies that the method returns an empty list for a non-existent departure station.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetInfoNoResults() throws SQLException {
        String departure = "NonExistentStation"; // A station that does not exist

        List<List<String>> result = PublicTransportationQueryDB.getInfo(departure);

        assertNotNull(result, "The result should not be null.");
        assertTrue(result.isEmpty(), "The result should be empty.");
    }

    /**
     * Tests the `getInfo1` method for a successful case.
     * Verifies that the method returns a non-null result with valid data.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetInfo1() throws SQLException {
        String departureTime = "06:45"; // Departure time
        String departure = "ALME'"; // Departure station

        List<List<String>> result = PublicTransportationQueryDB.getInfo1(departureTime, departure);

        assertNotNull(result, "The result should not be null.");
        for (List<String> info : result) {
            assertEquals(6, info.size(), "Each list should contain 6 elements.");
        }
    }

    /**
     * Tests the `getInfo1` method for a case where no results are found.
     * Verifies that the method returns an empty list for non-existent departure time or station.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetInfo1NoResults() throws SQLException {
        String departureTime = "10:00"; // A departure time that does not exist
        String departure = "NonExistentStation"; // A station that does not exist

        List<List<String>> result = PublicTransportationQueryDB.getInfo1(departureTime, departure);

        assertNotNull(result, "The result should not be null.");
        assertTrue(result.isEmpty(), "The result should be empty.");
    }

    /**
     * Tests the `getInfo2` method for a successful case.
     * Verifies that the method returns a non-null result with valid data.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetInfo2() throws SQLException {
        String arrival = "CROCETTE"; // Arrival station
        String departureTime = "06:45"; // Departure time
        String departure = "ALME'"; // Departure station

        List<List<String>> result = PublicTransportationQueryDB.getInfo2(arrival, departureTime, departure);

        assertNotNull(result, "The result should not be null.");
        for (List<String> info : result) {
            assertEquals(5, info.size(), "Each list should contain 5 elements.");
        }
    }

    /**
     * Tests the `getInfo2` method for a case where no results are found.
     * Verifies that the method returns an empty list for non-existent arrival station or time.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetInfo2NoResults() throws SQLException {
        String arrival = "NonExistentStation"; // A station that does not exist
        String departureTime = "10:00"; // A departure time that does not exist
        String departure = "NonExistentStation"; // A station that does not exist

        List<List<String>> result = PublicTransportationQueryDB.getInfo2(arrival, departureTime, departure);

        assertNotNull(result, "The result should not be null.");
        assertTrue(result.isEmpty(), "The result should be empty.");
    }

    /**
     * Tests the `getLineNextStopTimeStopWeek` method for a successful case.
     * Verifies that the method returns a non-null result with valid data.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetLineNextStopTimeStopWeek() throws SQLException {
        String departureStation = "ALME'"; // Departure station
        String departureTime = "06:45"; // Departure time
        String arriveStation = "CROCETTE"; // Arrival station

        List<String> result = PublicTransportationQueryDB.getLineNextStopTimeStopWeek(departureStation, departureTime, arriveStation);

        assertNotNull(result, "The result should not be null.");
    }

    /**
     * Tests the `getLineNextStopTimeStopWeek` method for a case where no results are found.
     * Verifies that the method returns an empty list for non-existent stations or times.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetLineNextStopTimeStopWeekNoResults() throws SQLException {
        String departureStation = "NonExistentStation"; // A non-existent departure station
        String departureTime = "10:00"; // A non-existent departure time
        String arriveStation = "NonExistentStation"; // A non-existent arrival station

        List<String> result = PublicTransportationQueryDB.getLineNextStopTimeStopWeek(departureStation, departureTime, arriveStation);

        assertNotNull(result, "The result should not be null.");
        assertTrue(result.isEmpty(), "The result should be empty.");
    }
    
    //Same fot the rest of the tests
}
