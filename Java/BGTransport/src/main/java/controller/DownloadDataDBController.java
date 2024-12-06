package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import model.ConstantDB;
import model.ControlDB;

public class DownloadDataDBController {

	public static int totalRecordCount = 0;
	public static int value;

	public static void updateProgress() {
		if (totalRecordCount != -1) {
			value = (ControlDB.progress * 100) / totalRecordCount;
			MainController.dbV.progressBar.setValue(value);
			String str = Integer.toString(value);
			MainController.dbV.control.setText(str + "%");
		}
	}

	public static int returnProgress() {
		if (totalRecordCount == -1)
			return 100;
		else
			return value;
	}

	public static void updateProgressbar() throws Exception {
		totalRecordCount = ControlDB.totalRecordCount(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);

		new Thread(() -> {
			try {
				while (ControlDB.progress < totalRecordCount) {
					ControlDB.progressiveTotalCount(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);

					String currentTableName = ControlDB.currentTableName[0];
					SwingUtilities.invokeLater(() -> value = (ControlDB.progress / totalRecordCount) * 100);

					SwingUtilities.invokeLater(
							() -> MainController.dbV.lblNewLabel.setText("Processing table: " + currentTableName));
				}

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
