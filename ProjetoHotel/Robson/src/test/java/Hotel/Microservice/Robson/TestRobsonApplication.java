package Hotel.Microservice.Robson;

import org.springframework.boot.SpringApplication;

public class TestRobsonApplication {

	public static void main(String[] args) {
		SpringApplication.from(RobsonApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
