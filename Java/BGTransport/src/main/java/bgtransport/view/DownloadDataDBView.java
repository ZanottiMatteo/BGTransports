package bgtransport.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import bgtransport.model.ConstantString2;

import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;

/**
 * A class representing the view for downloading data from databases. It
 * displays a progress bar to indicate the status of the data download.
 */
public class DownloadDataDBView extends JFrame {

	private static final long serialVersionUID = -3531276515069247770L;

	public JLabel labelDownloadDataDatabases = new JLabel();
	public JLabel lblNewLabel = new JLabel();
	public JLabel control = new JLabel();
	public JProgressBar progressBar = new JProgressBar(0, 100);
	public static int totalRecordCount;

	/**
	 * Constructs the DownloadDataDBView and initializes the UI components. Sets up
	 * the layout, labels, progress bar, and control for the data download process.
	 */
	public DownloadDataDBView() {
		getContentPane().setLayout(null);

		labelDownloadDataDatabases.setBackground(new Color(240, 240, 240));
		labelDownloadDataDatabases.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 20));
		labelDownloadDataDatabases.setForeground(new Color(210, 105, 30));
		labelDownloadDataDatabases.setHorizontalAlignment(SwingConstants.CENTER);
		labelDownloadDataDatabases.setText("Download Data Databases");
		labelDownloadDataDatabases.setBounds(64, 72, 306, 32);
		getContentPane().add(labelDownloadDataDatabases);
		labelDownloadDataDatabases.setBorder(null);

		progressBar.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 17));
		progressBar.setForeground(new Color(0, 168, 0));
		progressBar.setBounds(64, 115, 306, 14);
		getContentPane().add(progressBar);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		lblNewLabel.setBounds(109, 128, 216, 25);
		getContentPane().add(lblNewLabel);

		control.setFont(new Font(ConstantString2.SANSSERIF, Font.BOLD, 12));
		control.setHorizontalAlignment(SwingConstants.LEFT);
		control.setBounds(375, 110, 49, 25);
		getContentPane().add(control);

		setSize(450, 250);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
