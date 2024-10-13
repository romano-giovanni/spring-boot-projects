package dev.giovanniromano.artists_api.controller;


import dev.giovanniromano.artist_api.api.ApiUtil;
import dev.giovanniromano.artist_api.api.ArtistApi;
import dev.giovanniromano.artist_api.model.ArtistDto;
import dev.giovanniromano.artists_api.service.ArtistService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController implements ArtistApi {

    @Autowired
    ArtistService service;

    @Override
    public ResponseEntity<ArtistDto> addArtist(
            @Parameter(name = "ArtistDto", description = "Artist you want to add", required = true) @Valid @RequestBody ArtistDto artistDto
    ) {
        ArtistDto dto = service.save(artistDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteArtist(
            @Parameter(name = "artistId", description = "Artist id to delete", required = true, in = ParameterIn.PATH) @PathVariable("artistId") Long artistId
    ) {
        service.deleteById(artistId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<ArtistDto>> findArtistsByNationalityOrYear(
            @Parameter(name = "nationality", description = "Nationality to filter by", in = ParameterIn.QUERY) @Valid @RequestParam(value = "nationality", required = false) String nationality,
            @Parameter(name = "year", description = "Birth year to filter by", in = ParameterIn.QUERY) @Valid @RequestParam(value = "year", required = false) Long year
    ) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @Override
    public ResponseEntity<ArtistDto> getArtistById(
            @Parameter(name = "artistId", description = "ID of the artist to return", required = true, in = ParameterIn.PATH) @PathVariable("artistId") Long artistId
    ) {
        ArtistDto dto = service.findById(artistId);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    public ResponseEntity<ArtistDto> updateArtist(
            @Parameter(name = "artistId", description = "ID of the artist to update", required = true, in = ParameterIn.PATH) @PathVariable("artistId") Long artistId,
            @Parameter(name = "ArtistDto", description = "Update an existent artist in the database") @Valid @RequestBody(required = false) ArtistDto artistDto
    ) {
        ArtistDto dto = service.update(artistId, artistDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
}
