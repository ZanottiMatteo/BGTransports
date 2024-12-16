package bgtransport.controller;

import org.json.JSONObject;
import org.jxmapviewer.viewer.GeoPosition;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bgtransport.view.MapView;

@RestController
public class MyLocationController {

	public ResponseEntity<?> getPosition() {
        JSONObject position = new JSONObject();
        position.put("latitude", 40.7128);
        position.put("longitude", -74.0060);
        return ResponseEntity.ok(position.toString());  // Return position as JSON
    }
	
    @PostMapping("/api/position")
    public void receivePosition(@RequestBody Position position) {
        System.out.println("Received position: " + position);
        MapView.myposwrite.setText(position.toString());
        MapController.myposition = new GeoPosition(position.getLatitude(), position.getLongitude());
        MapController.addUnchangeableMarker(new GeoPosition(position.getLatitude(), position.getLongitude()));
        // You can process the latitude and longitude here, save them to a database, etc.
    }

    public static class Position {
        private double latitude;
        private double longitude;

        // Getters and setters
        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return  "Sei Qui: " + latitude + ", " + longitude;
        }
    }
}
