package controllertest;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import bgtransport.controller.DownloadDataDBController;
import bgtransport.controller.MainController;
import bgtransport.model.ControlDB;

public class DownloadDataDBControllerTest {

    @Test
    public void testUpdateProgress() throws InterruptedException {
        DownloadDataDBController.totalRecordCount = 100;
        ControlDB.progress = 25;
        DownloadDataDBController.updateProgress();
        Assertions.assertEquals(25, MainController.dbV.progressBar.getValue());
        Assertions.assertEquals("25%", MainController.dbV.control.getText());
    }

    @Test
    public void testReturnProgress() {
        DownloadDataDBController.totalRecordCount = 100;
        ControlDB.progress = 50;

        int progress = DownloadDataDBController.returnProgress();
        Assertions.assertEquals(DownloadDataDBController.value, progress);
    }

    @Test
    public void testUpdateProgressbar() throws Exception {
        DownloadDataDBController.totalRecordCount = 100;
        ControlDB.progress = 25;
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                DownloadDataDBController.updateProgressbar();
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        latch.await();
        Assertions.assertEquals(25, MainController.dbV.progressBar.getValue());
    }
}

