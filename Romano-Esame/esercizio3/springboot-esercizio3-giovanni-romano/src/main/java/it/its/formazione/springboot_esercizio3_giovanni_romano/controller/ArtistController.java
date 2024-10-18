package it.its.formazione.springboot_esercizio3_giovanni_romano.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.its.formazione.springboot_esercizio3_giovanni_romano.server.api.ArtistApi;
import it.its.formazione.springboot_esercizio3_giovanni_romano.server.model.ArtistDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController implements ArtistApi {

    Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Override
    public ResponseEntity<ArtistDTO> createArtist(
            @Parameter(name = "ArtistDTO", description = "", required = true) @Valid @RequestBody ArtistDTO artistDTO
    ) {
        logger.info("Entrata nel metodo createArtist con il parametro: {}", artistDTO);

        logger.info("Uscita dal metodo createArtist");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ArtistDTO> deleteArtist(
            @Parameter(name = "id", description = "The artist's ID", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        logger.info("Entrata nel metodo deleteArtist con l'ID: {}", id);

        logger.info("Uscita dal metodo deleteArtist");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ArtistDTO> getArtist(
            @Parameter(name = "id", description = "The artist's ID", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        logger.info("Entrata nel metodo getArtist con l'ID: {}", id);

        logger.info("Uscita dal metodo getArtist");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<ArtistDTO>> listArtists() {
        logger.info("Entrata nel metodo listArtists");

        logger.info("Uscita dal metodo listArtists");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ArtistDTO> updateArtist(
            @Parameter(name = "id", description = "The artist's ID", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "ArtistDTO", description = "", required = true) @Valid @RequestBody ArtistDTO artistDTO
    ) {
        logger.info("Entrata nel metodo updateArtist con l'ID: {} e il parametro: {}", id, artistDTO);

        logger.info("Uscita dal metodo updateArtist");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
