package bgtransport.controller;

import javax.swing.*;

import bgtransport.view.TimeWidget;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * The TimestampController class provides methods to update UI components
 * with the current time and date in real-time using separate threads.
 */
public class TimestampController {

    /**
     * Updates the `lbltime` label in the TimeWidget with the current time in HH:mm format.
     * This method runs in a continuous loop using a separate thread.
     *
     * @throws Exception if any error occurs during thread execution
     */
    public static void getTime() throws Exception {
        Thread thread = new Thread(() -> {
            while (true) {
                // Get the current timestamp
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                // Format the timestamp
                String formattedTimestamp = new SimpleDateFormat("HH:mm").format(timestamp);

                // Update the label on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> TimeWidget.lbltime.setText(formattedTimestamp));

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

    /**
     * Updates the `lbldate` label in the TimeWidget with the current date in dd MMMM yyyy format (Italian locale).
     * This method runs in a continuous loop using a separate thread.
     *
     * @throws IOException if any I/O error occurs during execution
     */
    public static void getDate() throws IOException {
        Thread thread = new Thread(() -> {
            while (true) {
                // Get the current timestamp
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                // Format the timestamp
                String formattedTimestamp = new SimpleDateFormat("dd MMMM yyyy", Locale.ITALIAN).format(timestamp);

                // Update the label on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> TimeWidget.lbldate.setText(formattedTimestamp));

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
