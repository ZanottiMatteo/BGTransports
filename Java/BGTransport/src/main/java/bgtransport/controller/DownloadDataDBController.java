package bgtransport.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import bgtransport.model.ConstantDB;
import bgtransport.model.ControlDB;

/**
 * Controller class responsible for downloading data from the database and
 * updating the progress in the UI.
 */
public class DownloadDataDBController {

	/** Total number of records to be processed. */
	public static int totalRecordCount = 0;

	/** Current progress percentage value. */
	public static int value;

	/**
	 * Updates the progress bar and text in the user interface with the current
	 * progress percentage.
	 */
	public static void updateProgress() {
		if (totalRecordCount != -1) {
			value = (ControlDB.progress * 100) / totalRecordCount;
			MainController.dbV.progressBar.setValue(value);
			String str = Integer.toString(value);
			MainController.dbV.control.setText(str + "%");
		}
	}

	/**
	 * Returns the current progress as a percentage. If total record count is
	 * unknown, returns 100%.
	 * 
	 * @return The current progress percentage.
	 */
	public static int returnProgress() {
		if (totalRecordCount == -1)
			return 100;
		else
			return value;
	}

	/**
	 * Initiates the data download process and updates the progress bar in the user
	 * interface. This method runs the download in a separate thread to prevent
	 * blocking the UI.
	 * 
	 * @throws Exception if an error occurs during the process.
	 */
	public static void updateProgressbar() throws Exception {
		totalRecordCount = ControlDB.totalRecordCount(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);

		new Thread(() -> {
			try {
				// Loop to process records and update progress
				while (ControlDB.progress < totalRecordCount) {
					ControlDB.progressiveTotalCount(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);

					String currentTableName = ControlDB.currentTableName[0];
					SwingUtilities.invokeLater(() -> value = (ControlDB.progress / totalRecordCount) * 100);

					SwingUtilities.invokeLater(
							() -> MainController.dbV.lblNewLabel.setText("Processing table: " + currentTableName));
				}

				// After processing is complete, update UI and close the progress window
				SwingUtilities.invokeLater(() -> {
					MainController.dbV.labelDownloadDataDatabases.setText("Download Complete");
					NewWindowController.openHomePanel(MainController.homeV);
					Timer closeTimer = new Timer(1000, evt -> MainController.dbV.dispose());
					closeTimer.setRepeats(false);
					closeTimer.start();
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

		// Timer to periodically update the UI with progress and current table being
		// processed
		Timer timer = new Timer(500, new ActionListener() {
			private int dotCount = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				dotCount = (dotCount + 1) % 4;
				String dots = ".".repeat(dotCount);

				SwingUtilities.invokeLater(() -> {
					if (ControlDB.currentTableName != null && ControlDB.currentTableName.length > 0) {
						MainController.dbV.lblNewLabel
								.setText("Processing table: " + ControlDB.currentTableName[0] + dots);

						updateProgress();
					}
				});
			}
		});
		timer.start();
	}
}
