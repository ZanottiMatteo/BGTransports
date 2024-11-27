package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.cache.FileBasedLocalCache;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanKeyListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor;
import org.jxmapviewer.painter.CompoundPainter;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;

import view.HomeView;
import view.MapView;

public class MapController {

    // List of unique waypoints across all maps
    public static List<GeoPosition> positions = new ArrayList<>();
    private static final List<Painter<JXMapViewer>> painters = new ArrayList<>();
    public static JXMapViewer fullMapViewer = new JXMapViewer(); // Create a separate instance for the full map
    public static JXMapViewer miniMapViewer = new JXMapViewer(); // Create a separate instance for the mini map
    /**
     * Method to configure and generate a map with OpenStreetMap
     * 
     * @param mapViewer the map view
     */
    private static void configureMap(JXMapViewer mapViewer) {
        // Create a TileFactoryInfo for OpenStreetMap
        TileFactoryInfo info = new OSMTileFactoryInfo();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);

        // Configure the local cache
        File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
        tileFactory.setLocalCache(new FileBasedLocalCache(cacheDir, false));
        GeoPosition initialPosition = new GeoPosition(45.695138, 9.669602);

        // Configure JXMapViewer
        mapViewer.setTileFactory(tileFactory);
        MouseInputListener mia = new PanMouseInputListener(mapViewer);

        mapViewer.setZoom(7);
        mapViewer.setAddressLocation(initialPosition);

        // Add interactions
        mapViewer.addMouseListener(mia);
        mapViewer.addMouseMotionListener(mia);
        mapViewer.addMouseListener(new CenterMapListener(mapViewer));
        mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
        mapViewer.addKeyListener(new PanKeyListener(mapViewer));

        // Remove previous center map listener if exists
        for (MouseListener listener : mapViewer.getMouseListeners()) {
            if (listener instanceof CenterMapListener) {
                mapViewer.removeMouseListener(listener);
            }
        }

        // Add double-click listener to add markers
        mapViewer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    Point2D point = e.getPoint();
                    GeoPosition geoPosition = mapViewer.convertPointToGeoPosition(point);
                    if (!positions.contains(geoPosition)) { // Ensure uniqueness of waypoints
                        positions.add(geoPosition);
                        addMarkers(positions);
                    }
                }
            }
        });
    }

    /**
     * Method to generate the main map
     */
    public static void generateMap() {        
        configureMap(fullMapViewer);
        MapView.externmapPanel.add(fullMapViewer, 0);
    }

    /**
     * Method to generate the mini map
     */
    public static void generateMiniMap() {
        configureMap(miniMapViewer);
        HomeView.miniMapPanel.add(miniMapViewer, 0);
    }

    /**
     * Adds markers on the map at the specified positions
     * 
     * @param mapViewer the map view
     * @param positions the positions of the markers
     */
    public static void addMarkers(List<GeoPosition> positions) {
        // Clear previous painters and add new ones
        painters.clear();
        for (GeoPosition position : positions) {
            Painter<JXMapViewer> markerPainter = new WaypointController(position);
            painters.add(markerPainter);
        }
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(painters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);
    }
}
