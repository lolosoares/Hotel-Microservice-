package Hotel.Microservice.Robson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "Hotel.Microservice.Robson.repositories")
public class RobsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobsonApplication.class, args);
	}

}
