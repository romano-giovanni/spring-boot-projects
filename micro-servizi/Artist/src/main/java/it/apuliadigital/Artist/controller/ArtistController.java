package it.apuliadigital.Artist.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.Artist.api.ArtistsApi;
import it.apuliadigital.Artist.model.Artist;
import it.apuliadigital.Artist.service.ArtistService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController implements ArtistsApi {

    @Autowired
    private ArtistService artistService;

    Logger logger = LoggerFactory.getLogger(ArtistController.class);

    @Override
    public ResponseEntity<Artist> createArtist(@Parameter(name = "Artist",description = "Data for the new artist",required = true) @RequestBody @Valid Artist artist) {
        Artist newArtist = artistService.createArtist(artist);
        logger.info("Artist created: " + newArtist);
        return new ResponseEntity<Artist>(newArtist, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Artist> deleteArtist(@Parameter(name = "artistId",description = "",required = true,in = ParameterIn.PATH) @PathVariable("artistId") Long artistId) {
        artistService.deleteArtist(artistId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Artist>> getAllArtists() {
        List<Artist> artists = artistService.getAllArtists();
        return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Artist> getArtistById(@Parameter(name = "artistId",description = "",required = true,in = ParameterIn.PATH) @PathVariable("artistId") Long artistId) {
        Artist artist = artistService.getArtistById(artistId);
        return new ResponseEntity<Artist>(artist, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Artist>> getArtistsByNationality(@Parameter(name = "nationality",description = "",required = true,in = ParameterIn.PATH) @PathVariable("nationality") String nationality) {
        List<Artist> artists = artistService.searchArtistsByNationality(nationality);
        return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Artist>> getArtistsByYear(@Parameter(name = "year",description = "",required = true,in = ParameterIn.PATH) @PathVariable("year") Integer year) {
        List<Artist> artists = artistService.searchArtistsByBirthYear(year);
        return new ResponseEntity<List<Artist>>(artists, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Artist> updateArtist(@Parameter(name = "artistId",description = "",required = true,in = ParameterIn.PATH) @PathVariable("artistId") Long artistId, @Parameter(name = "Artist",description = "Updated artist data",required = true) @RequestBody @Valid Artist artist) {
        boolean updated = artistService.updateArtist(artistId, artist);
        if (updated) {
            return new ResponseEntity<Artist>(artist, HttpStatus.OK);
        } else {
            return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
        }
    }
}
