package bgtransport.controller;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import bgtransport.model.PublicTransportationQueryDB;
import bgtransport.model.ResizableImage;
import bgtransport.view.HomeView;
import bgtransport.view.MapView;

import org.json.JSONObject;
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

public class MapController {
	
	static GeoPosition myposition;

    // List of unique waypoints across all maps
    public static List<GeoPosition> positions = new ArrayList<>();
    public static List<GeoPosition> trainPosition = new ArrayList<>();
    public static List<GeoPosition> busPosition = new ArrayList<>();
    public static List<GeoPosition> funicularPosition = new ArrayList<>();
    public static List<GeoPosition> tramPosition = new ArrayList<>();
    public static List<Painter<JXMapViewer>> staticMarkers = new ArrayList<>();
    private static final List<Painter<JXMapViewer>> painters = new ArrayList<>();
    public static final List<Painter<JXMapViewer>> transport = new ArrayList<>();
    public static JXMapViewer fullMapViewer = new JXMapViewer(); // Create a separate instance for the full map
    public static JXMapViewer miniMapViewer = new JXMapViewer(); // Create a separate instance for the mini map
    private static final double TOLERANCE = 0.0003;
    
    static ResizableImage mypos = new ResizableImage(new File("src/main/resources/images/Myposition.png"));
    static ResizableImage waypoint = new ResizableImage(new File("src/main/resources/images/Waypoint.png"));
    static ResizableImage bus = new ResizableImage(new File("src/main/resources/images/Bus.png"));
    static ResizableImage train = new ResizableImage(new File("src/main/resources/images/Train.png"));
    static ResizableImage funicular = new ResizableImage(new File("src/main/resources/images/Funicular.png"));
    static ResizableImage tram = new ResizableImage(new File("src/main/resources/images/Tram.png"));
     
    public static int checkbus = 0;
    private static int checktrain = 0;
    private static int checkfunicular = 0;
    private static int checktram = 0;
    private static boolean markerAdded = false;
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

                    if (nearbyPosition != null && !nearbyPosition.equals(myposition)) {
                        // Rimuovi il waypoint se è vicino e non è myPosition
                        positions.remove(nearbyPosition);
                    } else if (nearbyPosition == null && !isWithinTolerance(clickedPosition, myposition)) {
                        // Aggiungi un nuovo waypoint se nessuno è vicino, ma non se è myPosition
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
    public static GeoPosition findNearbyWaypoint(GeoPosition clickedPosition) {
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
    public static boolean isWithinTolerance(GeoPosition pos1, GeoPosition pos2) {
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

    
    public static void addUnchangeableMarker(GeoPosition position) {
        // If the marker has already been added, do nothing
        if (markerAdded) {
            return;
        }
        
        // Create a static marker painter for the position
        Painter<JXMapViewer> staticMarkerPainter = new WaypointController(position);
        
        // Ensure the image is resized or customized
        mypos.resizeImage(30, 30);
        ((WaypointController) staticMarkerPainter).setImage(mypos.getScaledImage());
        
        // Add the static marker to the staticMarkers list
        staticMarkers.add(staticMarkerPainter);
        
        // Set the flag to true indicating the marker has been added
        markerAdded = true;
        
        // Combine static markers with dynamic markers (if any)
        List<Painter<JXMapViewer>> allPainters = new ArrayList<>();
        allPainters.addAll(staticMarkers);   // Static markers (added once and never removed)
        // Create a compound painter with both static and dynamic markers
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        
        // Apply the painters to both the full map and the mini map
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);
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
        allPainters.addAll(staticMarkers);
        
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);
    }
    
    /**
     * This method toggles the state of the bus markers on the map. 
     * If the bus markers are currently not displayed, it fetches the bus positions 
     * from the database and adds them to the map. If they are already displayed, 
     * it clears the bus markers from the map.
     * 
     * @throws SQLException if there is an error accessing the database to retrieve bus positions.
     */
    public static void showBus() throws SQLException {
        // Alterna stato (1: aggiungi bus, 0: rimuovi bus)
        checkbus = 1 - checkbus;
        System.out.println("Checkbus state: " + checkbus);

        // Lista per mantenere i painter dei bus
        List<Painter<JXMapViewer>> busPainters = new ArrayList<>();

        if (checkbus == 1) {
            // Aggiungi i bus
            List<GeoPosition> busPositions = PublicTransportationQueryDB.getPullmanGeopositions();
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
        allPainters.addAll(staticMarkers);
        
        // Ricrea il CompoundPainter
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);
    }
    
    /**
     * This method toggles the state of the train markers on the map. 
     * If the bus markers are currently not displayed, it fetches the trains positions 
     * from the database and adds them to the map. If they are already displayed, 
     * it clears the train markers from the map.
     * 
     * @throws SQLException if there is an error accessing the database to retrieve train positions.
     */
    public static void showTrain() throws SQLException {
        // Toggle state (1: add trains, 0: remove trains)
        checktrain = 1 - checktrain;
        System.out.println("Checktrain state: " + checktrain);

        // List to store train painters
        List<Painter<JXMapViewer>> trainPainters = new ArrayList<>();

        if (checktrain == 1) {
            // Add trains
            List<GeoPosition> trainPositions = PublicTransportationQueryDB.getTrainGeopositions();
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
        allPainters.addAll(staticMarkers);
        // Recreate the CompoundPainter
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);
    }

    /**
     * This method toggles the state of the funicular markers on the map. 
     * If the funicular markers are currently not displayed, it fetches the funicular positions 
     * from the database and adds them to the map. If they are already displayed, 
     * it clears the funicular markers from the map.
     * 
     * @throws SQLException if there is an error accessing the database to retrieve funicular positions.
     */
    public static void showFunicular() throws SQLException {
        // Toggle state (1: add funiculars, 0: remove funiculars)
        checkfunicular = 1 - checkfunicular;
        System.out.println("Checkfunicular state: " + checkfunicular);

        // List to store funicular painters
        List<Painter<JXMapViewer>> funicularPainters = new ArrayList<>();

        if (checkfunicular == 1) {
            // Add funiculars
            List<GeoPosition> funicularPositions = PublicTransportationQueryDB.getFunicularGeopositions();
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
        allPainters.addAll(staticMarkers);
        // Recreate the CompoundPainter
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);

        // Debug to confirm the total number of markers on the map
        System.out.println("Total painters: " + allPainters.size());
    }

    /**
     * This method toggles the state of the tram markers on the map. 
     * If the tram markers are currently not displayed, it fetches the tram positions 
     * from the database and adds them to the map. If they are already displayed, 
     * it clears the tram markers from the map.
     * 
     * @throws SQLException if there is an error accessing the database to retrieve tram positions.
     */

    public static void showTram() throws SQLException {
        // Toggle state (1: add trams, 0: remove trams)
        checktram = 1 - checktram;
        System.out.println("Checktram state: " + checktram);

        // List to store tram painters
        List<Painter<JXMapViewer>> tramPainters = new ArrayList<>();

        if (checktram == 1) {
            // Add trams
            List<GeoPosition> tramPositions = PublicTransportationQueryDB.getTramGeopositions();
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
        allPainters.addAll(staticMarkers);
        // Recreate the CompoundPainter
        CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(allPainters);
        fullMapViewer.setOverlayPainter(compoundPainter);
        miniMapViewer.setOverlayPainter(compoundPainter);

        // Debug to confirm the total number of markers on the map
        System.out.println("Total painters: " + allPainters.size());
    }
    
    
    /**
     * This method open the address "http://localhost:8080/index.html" to catch the gps position
     */
    public static void openHtmlInBrowser() {
        try {
            URI uri = new URI("http://localhost:8080/index.html");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("Browser non supportato.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /**
     * This method attend the longitude and the latitude from the backend of html and after it closes the window
     */
    public static void waitForPositionAndExit() {
        new Thread(() -> {
            try {

                boolean positionReceived = false;
                while (!positionReceived) {
                    String positionData = fetchPositionFromBackend();
                    if (positionData != null) {
                        JSONObject json = new JSONObject(positionData);
                        if (json.has("latitude") && json.has("longitude")) {
                            String lat = json.getString("latitude");
                            String lon = json.getString("longitude");

                            // Aggiorna l'etichetta Swing
                            SwingUtilities.invokeLater(() -> MapView.myposwrite.setText( lat + "," + lon));

                            positionReceived = true;
                            SpringApplication.exit(bgtransport.Main.springContext);
                            
                        }
                    }
                    Thread.currentThread().join();
                }
                // Chiudi l'applicazione
               
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    
    /**
     * This method read the longitude and the latitude from the backend of html 
     */
    private static String fetchPositionFromBackend() {
        try {
            URL url = new URL("http://localhost:8080/api/position");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";  // Restituisce il file index.html dalla cartella /static
    }
}
}
    

