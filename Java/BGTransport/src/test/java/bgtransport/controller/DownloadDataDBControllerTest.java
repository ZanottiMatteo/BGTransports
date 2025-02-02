package bgtransport.controller;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import bgtransport.model.ControlDB;

class DownloadDataDBControllerTest {

    @Test
    void testUpdateProgress() {
        DownloadDataDBController.totalRecordCount = 100;
        ControlDB.progress = 25;
        DownloadDataDBController.updateProgress();
        Assertions.assertEquals(25, MainController.dbV.progressBar.getValue());
        Assertions.assertEquals("25%", MainController.dbV.control.getText());
    }

    @Test
    void testReturnProgress() {
        DownloadDataDBController.totalRecordCount = 100;
        ControlDB.progress = 50;

        int progress = DownloadDataDBController.returnProgress();
        Assertions.assertEquals(DownloadDataDBController.value, progress);
    }

    @Test
    void testUpdateProgressbar() throws Exception {
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

