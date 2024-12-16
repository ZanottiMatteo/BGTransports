package bgtransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
	
	 public static ConfigurableApplicationContext springContext;
	
    public static void main(String[] args) throws Exception {
    	
    	bgtransport.model.MainModel.main(new String[] {});
    	bgtransport.controller.MainController.main(new String[] {});
    	springContext = SpringApplication.run(Main.class, args);   
    }
}
