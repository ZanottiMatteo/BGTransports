package model;

import javax.swing.*;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.imageio.ImageIO;

public class TimestampModel {
	
	public static void getTime(JLabel label) throws IOException{
        Thread thread = new Thread(() -> {
            while (true) {
                // Get the current timestamp
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                // Format the timestamp
                String formattedTimestamp = new SimpleDateFormat("HH:mm:ss").format(timestamp);

                // Update the label on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> label.setText("🕦 " + formattedTimestamp));

                try {
                    // Sleep for 1 second
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start(); // Start the thread
	}
	
	public static void getDate(JLabel label) throws IOException{
		Thread thread = new Thread(() -> {
            while (true) {
                // Get the current timestamp
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                // Format the timestamp
                String formattedTimestamp = new SimpleDateFormat("dd/MM/yyyy").format(timestamp);

                // Update the label on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> label.setText("🗓 " + formattedTimestamp));

                try {
                    // Sleep for 1 second
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start(); // Start the thread
	}
}


