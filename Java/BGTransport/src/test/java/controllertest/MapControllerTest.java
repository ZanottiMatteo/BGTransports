package controllertest;

import static org.junit.jupiter.api.Assertions.*;

import org.jxmapviewer.viewer.GeoPosition;

import bgtransport.controller.MapController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapControllerTest {

    @BeforeEach
    void setup() {
        // Reset the static variables in MapController before each test
        MapController.positions.clear();
    }

    @Test
    void testFindNearbyWaypoint() {
        // Add test positions to MapController.positions
        GeoPosition pos1 = new GeoPosition(45.695138, 9.669602);
        GeoPosition pos2 = new GeoPosition(45.700000, 9.670000);
        MapController.positions.add(pos1);
        MapController.positions.add(pos2);

        // Create a nearby position
        GeoPosition nearbyPosition = new GeoPosition(45.695140, 9.669604);

        // Call findNearbyWaypoint
        GeoPosition result = MapController.findNearbyWaypoint(nearbyPosition);

        // Verify that the correct position is found
        assertEquals(pos1, result);
    }

    @Test
    void testIsWithinTolerance() {
        // Create two positions within tolerance
        GeoPosition pos1 = new GeoPosition(45.695138, 9.669602);
        GeoPosition pos2 = new GeoPosition(45.695139, 9.669603);

        // Create two positions outside of tolerance
        GeoPosition pos3 = new GeoPosition(45.695138, 9.669602);
        GeoPosition pos4 = new GeoPosition(45.700000, 9.670000);

        // Verify positions within tolerance
        assertTrue(MapController.isWithinTolerance(pos1, pos2));

        // Verify positions outside of tolerance
        assertFalse(MapController.isWithinTolerance(pos3, pos4));
    }

    @Test
    void testGenerateMap() {
        // Verify that fullMapViewer is initialized correctly
        assertNotNull(MapController.fullMapViewer);

        // Generate the map
        MapController.generateMap();

        // Verify map configuration (e.g., zoom level and tile factory)
        assertEquals(7, MapController.fullMapViewer.getZoom());
        assertNotNull(MapController.fullMapViewer.getTileFactory());
    }

    @Test
    void testAddUnchangeableMarker() {
        // Create a position to add
        GeoPosition position = new GeoPosition(45.695138, 9.669602);

        // Add the unchangeable marker
        MapController.addUnchangeableMarker(position);

        // Verify that a marker has been added
        assertEquals(1, MapController.staticMarkers.size());
    }

    @Test
    void testToggleTransportMarkers() throws Exception {
        // Inizialmente la lista dovrebbe essere vuota
    	assertEquals(0, MapController.checkbus, "Transport list should start empty");

        // Dopo la chiamata a showBus(), i marker dovrebbero essere aggiunti
        MapController.showBus();
        assertEquals(1, MapController.checkbus, "Transport list should not be empty after calling showBus");

        // Dopo un'altra chiamata a showBus(), i marker dovrebbero essere rimossi
        MapController.showBus();
        assertEquals(0, MapController.checkbus, "Transport list should be empty after calling showBus again");
    }

}
