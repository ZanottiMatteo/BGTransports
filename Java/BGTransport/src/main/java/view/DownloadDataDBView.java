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

public class DownloadDataDBView extends JFrame {

	public JLabel labelDownloadDataDatabases = new JLabel();
	public JLabel lblNewLabel = new JLabel();
    public static JProgressBar progressBar;
    public static int totalRecordCount;
    
    public DownloadDataDBView() {
        getContentPane().setLayout(null);
        
        labelDownloadDataDatabases.setBackground(new Color(240, 240, 240));
        labelDownloadDataDatabases.setFont(new Font("SansSerif", Font.BOLD, 20));
        labelDownloadDataDatabases.setForeground(new Color(210, 105, 30));
        labelDownloadDataDatabases.setHorizontalAlignment(SwingConstants.CENTER);
        labelDownloadDataDatabases.setText("Download Data Databases");
        labelDownloadDataDatabases.setBounds(64, 72, 306, 32);
        getContentPane().add(labelDownloadDataDatabases);
        labelDownloadDataDatabases.setBorder(null);

        progressBar = new JProgressBar(0, totalRecordCount);
        progressBar.setFont(new Font("SansSerif", Font.BOLD, 17));
        progressBar.setForeground(new Color(0, 168, 0));
        progressBar.setBounds(64, 115, 306, 14);
        getContentPane().add(progressBar);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        lblNewLabel.setBounds(109, 128, 216, 25);
        getContentPane().add(lblNewLabel);

        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
