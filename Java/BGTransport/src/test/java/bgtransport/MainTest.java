package bgtransport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class MainTest {

	@Test
	void mainApplicationStarts() {
		// Verifica che il contesto Spring Boot si avvii correttamente
		try {
			Main.main(new String[] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(Main.springContext, "Il contesto Spring non dovrebbe essere nullo.");
	}
}
