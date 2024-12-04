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

    public DownloadDataDB(int totalRecordCount) {
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

        progressBar = new JProgressBar(0, totalRecordCount); // Set the progress bar range (0 to TOTAL_RECORDS)
        progressBar.setFont(new Font("SansSerif", Font.BOLD, 17));
        progressBar.setForeground(new Color(0, 168, 0));
        progressBar.setBounds(69, 115, 306, 14);
        getContentPane().add(progressBar);

        // Set window size and close operation
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startDownloadProcess(totalRecordCount);
    }
    
    private void startDownloadProcess(int totalRecordCount) {
        // Use a SwingWorker or Thread to simulate a download process
        new Thread(() -> {
            for (int i = 0; i <= totalRecordCount; i++) {
                try {
                    // Simulate downloading by sleeping for a while
                    Thread.sleep(10); // Adjust the sleep time as needed

                    // Update the progress bar
                    final int progress = (int) ((i / (double) totalRecordCount) * 100);
                    SwingUtilities.invokeLater(() -> progressBar.setValue(progress));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // When download finishes, you could update the label or show a message
            SwingUtilities.invokeLater(() -> txtDownloadDataDatabases.setText("Download Complete"));
        }).start();
    }
}
