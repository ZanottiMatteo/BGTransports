package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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

import model.QueryDB;
import model.ResizableImage;
import view.HomeView;
import view.MapView;

public class MapController {

    // List of unique waypoints across all maps
    public static List<GeoPosition> positions = new ArrayList<>();
    public static List<GeoPosition> Train = new ArrayList<>();
    public static List<GeoPosition> Bus = new ArrayList<>();
    public static List<GeoPosition> Funicular = new ArrayList<>();
    public static List<GeoPosition> Tram = new ArrayList<>();
    private static final List<Painter<JXMapViewer>> painters = new ArrayList<>();
    private static final List<Painter<JXMapViewer>> transport = new ArrayList<>();
    public static JXMapViewer fullMapViewer = new JXMapViewer(); // Create a separate instance for the full map
    public static JXMapViewer miniMapViewer = new JXMapViewer(); // Create a separate instance for the mini map
    private static final double TOLERANCE = 0.0003;
    
    static ResizableImage waypoint = new ResizableImage(new File("src/main/resources/images/Waypoint.png"));
    static ResizableImage bus = new ResizableImage(new File("src/main/resources/images/Bus.png"));
    static ResizableImage train = new ResizableImage(new File("src/main/resources/images/Train.png"));
    static ResizableImage funicular = new ResizableImage(new File("src/main/resources/images/Funicular.png"));
    static ResizableImage tram = new ResizableImage(new File("src/main/resources/images/Tram.png"));
     
    private static int checkbus = 0;
    private static int checktrain = 0;
    private static int checkfunicular = 0;
    private static int checktram = 0;
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
                    GeoPosition clickedPosition = mapViewer.convertPointToGeoPosition(point);

                    // Cerca un waypoint vicino alla posizione cliccata
                    GeoPosition nearbyPosition = findNearbyWaypoint(clickedPosition);

                    if (nearbyPosition != null) {
                        // Rimuovi il waypoint se è vicino
                        positions.remove(nearbyPosition);
                    } else {
                        // Aggiungi un nuovo waypoint se nessuno è vicino
                        positions.add(clickedPosition);
                    }

                    // Aggiorna i marker sulla mappa
                    addMarkers(positions);
                    
                }
            }
        });
    }
    
    /**
     * Trova un waypoint vicino alla posizione specificata entro una certa tolleranza.
     * 
     * @param clickedPosition la posizione cliccata
     * @return il waypoint vicino, o null se nessun waypoint è vicino
     */
    private static GeoPosition findNearbyWaypoint(GeoPosition clickedPosition) {
        for (GeoPosition position : positions) {
            if (isWithinTolerance(position, clickedPosition)) {
                return position;
            }
        }
        return null;
    }
    
    /**
     * Controlla se due posizioni sono entro una certa tolleranza.
     * 
     * @param pos1 la prima posizione
     * @param pos2 la seconda posizione
     * @return true se le posizioni sono vicine, false altrimenti
     */
    private static boolean isWithinTolerance(GeoPosition pos1, GeoPosition pos2) {
        double latDiff = Math.abs(pos1.getLatitude() - pos2.getLatitude());
        double lonDiff = Math.abs(pos1.getLongitude() - pos2.getLongitude());
        return latDiff <= TOLERANCE && lonDiff <= TOLERANCE;
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
    public static void addMarkers (List<GeoPosition> positions) {
        // Clear previous painters and add new ones
        painters.clear();
        for (GeoPosition position : positions) {
            Painter<JXMapViewer> markerPainter = new WaypointController(position);
            waypoint.resizeImage(30, 30);
            ((WaypointController) markerPainter).setImage(waypoint.getScaledImage());
            painters.add(markerPainter);
        }
     // Combina tutti i painter (senza toccare 'positions')
        List<Painter<JXMapViewer>> allPainters = new ArrayList<>();
        allPainters.addAll(painters);  // Waypoints dinamici
        allPainters.addAll(transport); // Marker statici
        
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);
    }
    
    public static void showBus() throws SQLException {
        // Alterna stato (1: aggiungi bus, 0: rimuovi bus)
        checkbus = 1 - checkbus;
        System.out.println("Checkbus state: " + checkbus);

        // Lista per mantenere i painter dei bus
        List<Painter<JXMapViewer>> busPainters = new ArrayList<>();

        if (checkbus == 1) {
            // Aggiungi i bus
            List<GeoPosition> busPositions = QueryDB.getPullmanGeopositions();
            if (busPositions != null) {
                for (GeoPosition position : busPositions) {
                    // Crea un painter per ogni posizione
                    Painter<JXMapViewer> markerPainter = new WaypointController(position);

                    // Ridimensiona e assegna l'immagine del bus
                    bus.resizeImage(15, 15);
                    ((WaypointController) markerPainter).setImage(bus.getScaledImage());

                    // Aggiungi il painter alla lista
                    busPainters.add(markerPainter);
                }
            }
            transport.addAll(busPainters); // Aggiungi i nuovi painter dei bus
        } else {
            // Rimuovi i bus
            transport.clear(); // Rimuove tutti i marker dei bus dalla mappa
            checkfunicular = 0;
            checktram = 0;
            checktrain = 0;   
        }

        // Aggiorna i painter (dinamici + statici)
        List<Painter<JXMapViewer>> allPainters = new ArrayList<>();
        allPainters.addAll(painters);  // Waypoints dinamici
        allPainters.addAll(transport); // Marker statici (inclusi i bus)

        // Ricrea il CompoundPainter
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);

        // Debug per confermare il numero di marker sulla mappa
        System.out.println("Total painters: " + allPainters.size());
    }
    
    public static void showTrain() throws SQLException {
        // Toggle state (1: add trains, 0: remove trains)
        checktrain = 1 - checktrain;
        System.out.println("Checktrain state: " + checktrain);

        // List to store train painters
        List<Painter<JXMapViewer>> trainPainters = new ArrayList<>();

        if (checktrain == 1) {
            // Add trains
            List<GeoPosition> trainPositions = QueryDB.getTrainGeopositions();
            if (trainPositions != null) {
                for (GeoPosition position : trainPositions) {
                    // Create a painter for each position
                    Painter<JXMapViewer> markerPainter = new WaypointController(position);

                    // Resize and assign the train image
                    train.resizeImage(15, 15);
                    ((WaypointController) markerPainter).setImage(train.getScaledImage());

                    // Add the painter to the list
                    trainPainters.add(markerPainter);
                }
            }
            transport.addAll(trainPainters); // Add new train painters
        } else {
            // Remove trains
            transport.clear(); // Remove all train markers from the map
            checkfunicular = 0;
            checktram = 0;
            checkbus = 0;      
        }

        // Update painters (dynamic + static)
        List<Painter<JXMapViewer>> allPainters = new ArrayList<>();
        allPainters.addAll(painters);  // Dynamic waypoints
        allPainters.addAll(transport); // Static markers (including trains)

        // Recreate the CompoundPainter
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);

        // Debug to confirm the total number of markers on the map
        System.out.println("Total painters: " + allPainters.size());
    }

    public static void showFunicular() throws SQLException {
        // Toggle state (1: add funiculars, 0: remove funiculars)
        checkfunicular = 1 - checkfunicular;
        System.out.println("Checkfunicular state: " + checkfunicular);

        // List to store funicular painters
        List<Painter<JXMapViewer>> funicularPainters = new ArrayList<>();

        if (checkfunicular == 1) {
            // Add funiculars
            List<GeoPosition> funicularPositions = QueryDB.getFunicularGeopositions();
            if (funicularPositions != null) {
                for (GeoPosition position : funicularPositions) {
                    // Create a painter for each position
                    Painter<JXMapViewer> markerPainter = new WaypointController(position);

                    // Resize and assign the funicular image
                    funicular.resizeImage(15, 15);
                    ((WaypointController) markerPainter).setImage(funicular.getScaledImage());

                    // Add the painter to the list
                    funicularPainters.add(markerPainter);
                }
            }
            transport.addAll(funicularPainters); // Add new funicular painters
        } else {
            // Remove funiculars
            transport.clear(); // Remove all funicular markers from the map
            checktrain = 0;
            checktram = 0;
            checkbus = 0;
        }

        // Update painters (dynamic + static)
        List<Painter<JXMapViewer>> allPainters = new ArrayList<>();
        allPainters.addAll(painters);  // Dynamic waypoints
        allPainters.addAll(transport); // Static markers (including funiculars)

        // Recreate the CompoundPainter
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);

        // Debug to confirm the total number of markers on the map
        System.out.println("Total painters: " + allPainters.size());
    }

    public static void showTram() throws SQLException {
        // Toggle state (1: add trams, 0: remove trams)
        checktram = 1 - checktram;
        System.out.println("Checktram state: " + checktram);

        // List to store tram painters
        List<Painter<JXMapViewer>> tramPainters = new ArrayList<>();

        if (checktram == 1) {
            // Add trams
            List<GeoPosition> tramPositions = QueryDB.getTramGeopositions();
            if (tramPositions != null) {
                for (GeoPosition position : tramPositions) {
                    // Create a painter for each position
                    Painter<JXMapViewer> markerPainter = new WaypointController(position);

                    // Resize and assign the tram image
                    tram.resizeImage(20, 20);
                    ((WaypointController) markerPainter).setImage(tram.getScaledImage());

                    // Add the painter to the list
                    tramPainters.add(markerPainter);
                }
            }
            transport.addAll(tramPainters); // Add new tram painters
        } else {
            transport.clear(); // Remove all tram markers from the map
            checktrain = 0;
            checkfunicular = 0;
            checkbus = 0;
        }

        // Update painters (dynamic + static)
        List<Painter<JXMapViewer>> allPainters = new ArrayList<>();
        allPainters.addAll(painters);  // Dynamic waypoints
        allPainters.addAll(transport); // Static markers (including trams)

        // Recreate the CompoundPainter
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);

        // Debug to confirm the total number of markers on the map
        System.out.println("Total painters: " + allPainters.size());
    }

}
