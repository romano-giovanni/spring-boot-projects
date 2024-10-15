package it.giovanniromano.portale;

import it.giovanniromano.portale.client.album.api.AlbumApi;
import it.giovanniromano.portale.client.album.api.SearchApi;
import it.giovanniromano.portale.client.artista.api.ArtistApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PortaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortaleApplication.class, args);
	}

	@Bean
	public AlbumApi albumApiClient() {
		AlbumApi albumApiClient = new AlbumApi();
		albumApiClient.getApiClient().setBasePath("http://127.0.0.1:8081");
		return albumApiClient;
	}

	@Bean
	public ArtistApi artistApiClient() {
		ArtistApi artistApiClient = new ArtistApi();
		artistApiClient.getApiClient().setBasePath("http://127.0.0.1:8082");
		return artistApiClient;
	}

	@Bean
	public SearchApi searchApiClient() {
		SearchApi searchApiClient = new SearchApi();
		searchApiClient.getApiClient().setBasePath("http://127.0.0.1:8081");
		return searchApiClient;
	}

}
