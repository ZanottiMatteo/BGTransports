package bgtransport.controller;

import javax.swing.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimestampController {
	
	public static void getTime(JLabel label) throws Exception{
        Thread thread = new Thread(() -> {
            while (true) {
                // Get the current timestamp
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                // Format the timestamp
                String formattedTimestamp = new SimpleDateFormat("HH:mm").format(timestamp);

                // Update the label on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> label.setText(formattedTimestamp));

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
                String formattedTimestamp = new SimpleDateFormat("dd MMMM yyyy", Locale.ITALIAN).format(timestamp);

                // Update the label on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> label.setText(formattedTimestamp));

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


