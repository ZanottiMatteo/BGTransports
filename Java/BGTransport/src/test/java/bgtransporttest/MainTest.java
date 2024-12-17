package bgtransporttest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import bgtransport.Main;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class MainTest {

	@Test
	void mainApplicationStarts() {
		// Verifica che il contesto Spring Boot si avvii correttamente
		try {
			Main.main(new String[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(Main.springContext, "Il contesto Spring non dovrebbe essere nullo.");
	}
}
