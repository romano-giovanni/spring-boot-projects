package it.apuliadigital.musicapiv4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigital.musicapiv4.api.SearchApi;
import it.apuliadigital.musicapiv4.model.AlbumDTO;
import it.apuliadigital.musicapiv4.model.AlbumDTO.GenreEnum;
import it.apuliadigital.musicapiv4.service.SearchService;
import jakarta.validation.Valid;

@RestController
public class SearchController implements SearchApi {

	@Autowired
	SearchService searchService;

	@Override
	public ResponseEntity<List<AlbumDTO>> searchAlbums(@Valid String title, @Valid String idArtist, @Valid String genre) {

		if (title != null) {
			return new ResponseEntity<List<AlbumDTO>>(searchService.albumByTitle(title), HttpStatus.OK);
		} else if (idArtist != null) {
			return new ResponseEntity<List<AlbumDTO>>(searchService.albumByArtistId(Long.parseLong(idArtist)),HttpStatus.OK);
		} else if (genre != null) {
			try {
				return new ResponseEntity<List<AlbumDTO>>(searchService.albumByGenre(GenreEnum.fromValue(genre)),HttpStatus.OK);
			}
			catch(IllegalArgumentException ex) {
				return new ResponseEntity<List<AlbumDTO>>(HttpStatus.NOT_FOUND);
			}
			
		}

		return new ResponseEntity<List<AlbumDTO>>(HttpStatus.NOT_FOUND);
	}

}
