package bgtransport.controller;

import org.json.JSONObject;
import org.jxmapviewer.viewer.GeoPosition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bgtransport.view.MapView;

/**
 * Controller that handles location-related requests. Provides an endpoint for
 * retrieving and receiving geographic positions.
 */
@RestController
public class MyLocationController {

	/**
	 * Endpoint to retrieve a hardcoded position. Returns a JSON object with the
	 * latitude and longitude.
	 * 
	 * @return ResponseEntity containing the JSON representation of the position
	 */
	public ResponseEntity<?> getPosition() {
		JSONObject position = new JSONObject();
		position.put("latitude", 40.7128); // Example latitude (New York)
		position.put("longitude", -74.0060); // Example longitude (New York)
		return ResponseEntity.ok(position.toString()); // Return position as JSON
	}

	/**
	 * Endpoint to receive a geographic position from the client. The position is
	 * extracted from the request body, and further actions are performed such as
	 * updating the map view and adding an unchangeable marker.
	 * 
	 * @param position The position received from the client in the request body
	 */
	@PostMapping("/api/position")
	public void receivePosition(@RequestBody Position position) {
		System.out.println("Received position: " + position);
		MapView.myposwrite.setText(position.toString()); // Update the map view with the received position
		MapController.myposition = new GeoPosition(position.getLatitude(), position.getLongitude());
		MapController.addUnchangeableMarker(new GeoPosition(position.getLatitude(), position.getLongitude()));
		// Additional processing, such as saving the latitude and longitude to a
		// database, can be done here.
	}

	/**
	 * Inner class to represent a geographic position with latitude and longitude.
	 * This class is used to map the incoming JSON data for the position.
	 */
	public static class Position {
		private double latitude; // Latitude of the position
		private double longitude; // Longitude of the position

		/**
		 * Gets the latitude of the position.
		 * 
		 * @return the latitude value
		 */
		public double getLatitude() {
			return latitude;
		}

		/**
		 * Sets the latitude of the position.
		 * 
		 * @param latitude the latitude value to set
		 */
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		/**
		 * Gets the longitude of the position.
		 * 
		 * @return the longitude value
		 */
		public double getLongitude() {
			return longitude;
		}

		/**
		 * Sets the longitude of the position.
		 * 
		 * @param longitude the longitude value to set
		 */
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		/**
		 * Returns a string representation of the position.
		 * 
		 * @return a string with the format "Sei Qui: latitude, longitude"
		 */
		@Override
		public String toString() {
			return "Sei Qui: " + latitude + ", " + longitude;
		}
	}
}
