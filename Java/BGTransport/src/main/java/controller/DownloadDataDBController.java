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

        	DownloadDataDBView.progressBar.setValue(value);
        	DownloadDataDBView.progressBar.repaint();
        	DownloadDataDBView.progressBar.revalidate();

    }

    public static void updateProgressbar() throws Exception {
        // Calcolo totale record
        totalRecordCount = ControlDB.totalRecordCount(Constant.DBUrlPublicTransportation);

        // Avvio di un thread separato per aggiornare il progresso
        new Thread(() -> {
            try {
                // Simula il progresso
                while (ControlDB.progress < totalRecordCount) {
                    // Aggiorna i dati e il progresso
                    

                    // Aggiorna la barra di progresso
                    int progressValue = ControlDB.progressiveTotalCount(Constant.DBUrlPublicTransportation);;
                   updateProgress(progressValue);
					System.out.println(progressValue); 
                    // Aggiorna il nome della tabella in modo asincrono
                    String currentTableName = ControlDB.currentTableName[0];
                    SwingUtilities.invokeLater(() -> {
                        MainModel.db.lblNewLabel.setText("Processing table: " + currentTableName);
                    });

                    // Simula un piccolo delay per test/debug
                    Thread.sleep(500);
                }

                // Quando il progresso è completato
                SwingUtilities.invokeLater(() -> {
                    // Ferma il timer e aggiorna il messaggio di completamento
                    MainModel.db.labelDownloadDataDatabases.setText("Download Complete");

                    // Chiudi la finestra dopo un breve ritardo
                    Timer closeTimer = new Timer(1000, evt -> MainModel.db.dispose());
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
                        MainModel.db.lblNewLabel.setText("Processing table: " + ControlDB.currentTableName[0] + dots);
                    }
                });
            }
        });
        timer.start();
    }
}
