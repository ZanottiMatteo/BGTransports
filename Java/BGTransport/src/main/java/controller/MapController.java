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

public class MapController {

	public static List<GeoPosition> positions = new ArrayList<>();
	private static final List<Painter<JXMapViewer>> painters = new ArrayList<>();

	public static JXMapViewer generateMap() {
		// Crea un TileFactoryInfo per OpenStreetMap
		TileFactoryInfo info = new OSMTileFactoryInfo();
		DefaultTileFactory tileFactory = new DefaultTileFactory(info);

		// Configura la cache locale
		File cacheDir = new File(System.getProperty("user.home") + File.separator + ".jxmapviewer2");
		tileFactory.setLocalCache(new FileBasedLocalCache(cacheDir, false));
		GeoPosition initialPosition = new GeoPosition(45.695138, 9.669602);

		// Configura JXMapViewer
		JXMapViewer mapViewer = new JXMapViewer();
		mapViewer.setTileFactory(tileFactory);
		MouseInputListener mia = new PanMouseInputListener(mapViewer);

		mapViewer.setZoom(7);
		mapViewer.setAddressLocation(initialPosition);

		// Aggiungi interazioni

		mapViewer.addMouseListener(mia);
		mapViewer.addMouseMotionListener(mia);

		mapViewer.addMouseListener(new CenterMapListener(mapViewer));
		mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCursor(mapViewer));
		mapViewer.addKeyListener(new PanKeyListener(mapViewer));

		for (MouseListener listener : mapViewer.getMouseListeners()) {
			if (listener instanceof CenterMapListener) {
				mapViewer.removeMouseListener(listener);
			}
		}

		mapViewer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					Point2D point = e.getPoint();
					GeoPosition geoPosition = mapViewer.convertPointToGeoPosition(point);
					positions.add(geoPosition);
					addMarkers(mapViewer, positions);
				}
			}
		});
		return mapViewer;
	}

	public static void addMarkers(JXMapViewer mapViewer, List<GeoPosition> positions) {
		for (GeoPosition position : positions) {
			Painter<JXMapViewer> markerPainter = new WaypointController(position);
			painters.add(markerPainter);
		}
		CompoundPainter<JXMapViewer> compoundPainter = new CompoundPainter<>(painters);
		mapViewer.setOverlayPainter(compoundPainter);
	}
}
