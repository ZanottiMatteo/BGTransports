package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import model.ControlDB;

import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;

public class DownloadDataDB extends JFrame {

    private JTextField txtDownloadDataDatabases;
    private JProgressBar progressBar;

    // Assuming ControlDB.sum provides the total number of records to download
    private static final int TOTAL_RECORDS = ControlDB.sum;  // Use ControlDB.sum for the total number of records
    private static final int BATCH_SIZE = 50;  // Update progress every BATCH_SIZE records

    public DownloadDataDB() {
        // Set layout and initialize components
        getContentPane().setLayout(null);

        txtDownloadDataDatabases = new JTextField();
        txtDownloadDataDatabases.setEditable(false);
        txtDownloadDataDatabases.setBackground(new Color(240, 240, 240));
        txtDownloadDataDatabases.setFont(new Font("SansSerif", Font.BOLD, 20));
        txtDownloadDataDatabases.setForeground(new Color(210, 105, 30));
        txtDownloadDataDatabases.setHorizontalAlignment(SwingConstants.CENTER);
        txtDownloadDataDatabases.setText("Download Data Databases...");
        txtDownloadDataDatabases.setBounds(69, 72, 306, 32);
        getContentPane().add(txtDownloadDataDatabases);
        txtDownloadDataDatabases.setColumns(10);
        txtDownloadDataDatabases.setBorder(null);

        progressBar = new JProgressBar(0, TOTAL_RECORDS); // Set the progress bar range (0 to TOTAL_RECORDS)
        progressBar.setFont(new Font("SansSerif", Font.BOLD, 17));
        progressBar.setForeground(new Color(0, 168, 0));
        progressBar.setBounds(69, 115, 306, 14);
        getContentPane().add(progressBar);

        // Set window size and close operation
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        // Create and display the frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DownloadDataDB().setVisible(true); // Make the window visible
            }
        });
    }
}
