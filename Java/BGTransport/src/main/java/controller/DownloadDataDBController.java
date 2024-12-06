package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import model.Constant;
import model.ControlDB;
import model.MainModel;

public class DownloadDataDBController {

	public static int totalRecordCount = 0;
	public static double value;
	
	public static void updateProgress() {
		if (totalRecordCount != -1) {
		value = (ControlDB.progress*100)/totalRecordCount;			
		MainController.dbV.progressBar.setValue((int) value);
		String str = Integer.toString((int) value);
		MainController.dbV.control.setText(str + "%");		
		}
	}

	public static int returnProgress() {
		if (totalRecordCount == -1) return 100;
		else return (int)value;
	}
	
	public static void updateProgressbar() throws Exception {
		// Calcolo totale record
		totalRecordCount = ControlDB.totalRecordCount(Constant.DBUrlPublicTransportation);

		// Avvio di un thread separato per aggiornare il progresso
		new Thread(() -> {
			try {
				// Simula il progresso
				while (ControlDB.progress < totalRecordCount) {
					

						ControlDB.progressiveTotalCount(Constant.DBUrlPublicTransportation);
					
					// Aggiorna i dati e il progresso
					String currentTableName = ControlDB.currentTableName[0];
					// Aggiorna la barra di progresso
					SwingUtilities.invokeLater(() -> {
	                    // Aggiorna la percentuale sulla label
						value = (ControlDB.progress/totalRecordCount)*100;
                      
	                    String str = Integer.toString((int) value);
	                     
	                    // Aggiorna la barra di progresso
	                    
	                });

					// Aggiorna il nome della tabella in modo asincrono
					SwingUtilities.invokeLater(() -> {
						MainController.dbV.lblNewLabel.setText("Processing table: " + currentTableName);
					});

					// Simula un piccolo delay per test/debug
					Thread.sleep(500);
				}

				// Quando il progresso è completato
				SwingUtilities.invokeLater(() -> {
					// Ferma il timer e aggiorna il messaggio di completamento
					MainController.dbV.labelDownloadDataDatabases.setText("Download Complete");
					NewWindowController.openHomePanel(MainController.homeV);
					// Chiudi la finestra dopo un breve ritardo
					Timer closeTimer = new Timer(1000, evt -> MainController.dbV.dispose());
					closeTimer.setRepeats(false);
					closeTimer.start();
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

		// Timer per i "dot" animati nella label
		Timer timer = new Timer(500, new ActionListener() {
			private int dotCount = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				dotCount = (dotCount + 1) % 4; // Cicla tra 0, 1, 2, 3
				String dots = ".".repeat(dotCount);

				SwingUtilities.invokeLater(() -> {
					if (ControlDB.currentTableName != null && ControlDB.currentTableName.length > 0) {
						MainController.dbV.lblNewLabel.setText("Processing table: " + ControlDB.currentTableName[0] + dots);

							updateProgress();

					}
				});
			}
		});
		timer.start();
	}
}
