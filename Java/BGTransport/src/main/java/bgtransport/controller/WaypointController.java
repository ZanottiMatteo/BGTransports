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

    /**
     * Constructs a WaypointController with a specific geographic position.
     *
     * @param position The geographical position (latitude and longitude) of the waypoint.
     */
    public WaypointController(GeoPosition position) {
        this.position = position;
    }

    /**
     * Sets the image to be used for the waypoint marker.
     *
     * @param image The image to be displayed as the waypoint marker.
     */
    public void setImage(Image image) {
        this.waypointImage = image;
    }

    /**
     * Paints the waypoint image on the map at the specified geographic position.
     * The image is drawn centered at the position.
     *
     * @param g The Graphics2D object used for painting.
     * @param map The JXMapViewer where the waypoint is being painted.
     * @param width The width of the map.
     * @param height The height of the map.
     */
    @Override
    public void paint(Graphics2D g, JXMapViewer map, int width, int height) {
        if (waypointImage == null) {
            return;
        }
        // Convert the geo-position to a map point (pixel position)
        Point2D point = map.convertGeoPositionToPoint(position);
        // Calculate the position for the image, centering it on the point
        int x = (int) point.getX() - waypointImage.getWidth(null) / 2;
        int y = (int) point.getY() - waypointImage.getHeight(null) / 2;
        // Draw the waypoint image at the calculated position
        g.drawImage(waypointImage, x, y, null);
    }

}
