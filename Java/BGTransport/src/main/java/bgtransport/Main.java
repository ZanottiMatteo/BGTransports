package bgtransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * The Main class serves as the entry point for the Spring Boot application. It
 * initializes and runs the Spring Boot application context and also starts
 * other components such as the MainModel and MainController.
 * 
 * It is responsible for bootstrapping the application and initializing
 * essential components for the bgtransport project.
 * 
 * @author Your Name
 */
@SpringBootApplication
public class Main {

	/**
	 * A reference to the Spring Application Context that is returned by the Spring
	 * Boot application startup.
	 */
	public static ConfigurableApplicationContext springContext;

	/**
	 * The main method is the entry point of the Spring Boot application. It first
	 * runs the MainModel and MainController components, followed by starting the
	 * Spring Boot application.
	 * 
	 * @param args command-line arguments for the application, which are not used in
	 *             this case
	 * @throws Exception if an error occurs during the execution
	 */
	public static void main(String[] args) throws Exception {

		// Initializing and running the MainModel
		bgtransport.model.MainModel.main(new String[] {});

		// Initializing and running the MainController
		bgtransport.controller.MainController.main(new String[] {});

		// Running the Spring Boot application and obtaining the Spring Context
		springContext = SpringApplication.run(Main.class, args);
	}
}
