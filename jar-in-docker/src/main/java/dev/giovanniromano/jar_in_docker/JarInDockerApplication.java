package dev.giovanniromano.jar_in_docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class JarInDockerApplication {

	Logger logger = LoggerFactory.getLogger(JarInDockerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JarInDockerApplication.class, args);
	}

	@GetMapping("/hello")
	public String sayHello() {
		logger.error("Sei nel LOG");
		return "Risposta";
	}

}
