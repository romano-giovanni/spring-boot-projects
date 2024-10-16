package dev.giovanniromano.portale;

import dev.giovanniromano.portale.client.api.AnagraficaApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PortaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortaleApplication.class, args);
	}

	@Bean
	public AnagraficaApi anagrafricaApiClient() {
		AnagraficaApi anagraficaApiClient = new AnagraficaApi();
		anagraficaApiClient.getApiClient().setBasePath("http://127.0.0.1:8080");
		return anagraficaApiClient;
	}
}
