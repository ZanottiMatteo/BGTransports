package bgtransport.controller;

import org.jxmapviewer.viewer.GeoPosition;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.painter.Painter;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;

public class WaypointController implements Painter<JXMapViewer> {
	private final GeoPosition position;
	private Image waypointImage;

	public WaypointController(GeoPosition position) {
		this.position = position;
		
	}

	public void setImage(Image image) {
		this.waypointImage = image;
	}

	@Override
	public void paint(Graphics2D g, JXMapViewer map, int width, int height) {
		if (waypointImage == null) {
			return;
		}
		Point2D point = map.convertGeoPositionToPoint(position);
		int x = (int) point.getX() - waypointImage.getWidth(null) / 2;
		int y = (int) point.getY() - waypointImage.getHeight(null) / 2;
		g.drawImage(waypointImage, x, y, null);
	}

}
