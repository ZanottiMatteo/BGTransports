package controller;

import org.jxmapviewer.viewer.GeoPosition;

import view.MapView;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.painter.Painter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class WaypointController implements Painter<JXMapViewer> {
	private final GeoPosition position;
	private BufferedImage markerImage;
	private Image waypointImage;

	public WaypointController(GeoPosition position) {
		this.position = position;
		
	}

	public void setImage(Image image) {
		this.waypointImage = image;
	}
	
	private Image loadImage(String path) {
	    try {
	        // Make sure the path is correct, relative to the classpath
	        URL imageUrl = getClass().getClassLoader().getResource(path);
	        
	        if (imageUrl == null) {
	            throw new IOException("Image not found: " + path);
	        }
	        
	        Image image = ImageIO.read(imageUrl);
	        if (image == null) {
	            throw new IOException("Failed to load image: " + path);
	        }
	        
	        return image;
	    } catch (IOException e) {
	        e.printStackTrace(); // Add better logging here if needed
	        return null;
	    }
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
