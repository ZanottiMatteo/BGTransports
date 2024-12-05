package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

	public JLabel labelDownloadDataDatabases = new JLabel();
	public JLabel lblNewLabel = new JLabel();
    private JProgressBar progressBar;

    public DownloadDataDB(int totalRecordCount) {
        getContentPane().setLayout(null);
        
        labelDownloadDataDatabases.setBackground(new Color(240, 240, 240));
        labelDownloadDataDatabases.setFont(new Font("SansSerif", Font.BOLD, 20));
        labelDownloadDataDatabases.setForeground(new Color(210, 105, 30));
        labelDownloadDataDatabases.setHorizontalAlignment(SwingConstants.CENTER);
        labelDownloadDataDatabases.setText("Download Data Databases");
        labelDownloadDataDatabases.setBounds(69, 72, 306, 32);
        getContentPane().add(labelDownloadDataDatabases);
        labelDownloadDataDatabases.setBorder(null);

        progressBar = new JProgressBar(0, totalRecordCount); // Set the progress bar range (0 to TOTAL_RECORDS)
        progressBar.setFont(new Font("SansSerif", Font.BOLD, 17));
        progressBar.setForeground(new Color(0, 168, 0));
        progressBar.setBounds(69, 115, 306, 14);
        getContentPane().add(progressBar);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNewLabel.setBounds(121, 128, 216, 25);
        getContentPane().add(lblNewLabel);

        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void updateProgress(int value) {
        SwingUtilities.invokeLater(() -> progressBar.setValue(value));
    }
}
