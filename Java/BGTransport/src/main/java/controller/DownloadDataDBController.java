package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import model.Constant;
import model.ControlDB;
import model.MainModel;
import view.DownloadDataDBView;

public class DownloadDataDBController {

	public static int totalRecordCount = 0;

	public static void updateProgress(int value) {
		SwingUtilities.invokeLater(() -> DownloadDataDBView.progressBar.setValue(value));
	}

	public static void updateProgressbar() throws Exception {
		
		DownloadDataDBView.totalRecordCount=ControlDB.totalRecordCount(Constant.DBUrlPublicTransportation);
		ControlDB.progressiveTotalCount(Constant.DBUrlPublicTransportation);
		updateProgress(ControlDB.progress);
		
		Timer timer = new Timer(500, new ActionListener() {
			private int dotCount = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				dotCount = (dotCount + 1) % 4; // Cicla tra 0, 1, 2, 3
				String dots = ".".repeat(dotCount);
				SwingUtilities.invokeLater(() -> MainModel.db.lblNewLabel
						.setText("Processing table: " + ControlDB.currentTableName + dots));
			}
		});
		timer.start();

		SwingUtilities.invokeLater(() -> {
			MainModel.db.labelDownloadDataDatabases.setText("Download Complete");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MainModel.db.dispose();
		});
	}
}
