package it.its.formazione.springboot_esercizio3_giovanni_romano.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.its.formazione.springboot_esercizio3_giovanni_romano.server.api.AlbumApi;
import it.its.formazione.springboot_esercizio3_giovanni_romano.server.model.AlbumDTO;
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
public class AlbumController implements AlbumApi {

    Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Override
    public ResponseEntity<AlbumDTO> createAlbum(
            @Parameter(name = "AlbumDTO", description = "", required = true) @Valid @RequestBody AlbumDTO albumDTO
    ) {
        logger.info("Entrata nel metodo createAlbum con il parametro: {}", albumDTO);

        logger.info("Uscita dal metodo createAlbum");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<AlbumDTO> deleteAlbum(
            @Parameter(name = "id", description = "The album's ID", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        logger.info("Entrata nel metodo deleteAlbum con l'ID: {}", id);

        logger.info("Uscita dal metodo deleteAlbum");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<AlbumDTO> getAlbum(
            @Parameter(name = "id", description = "The album's ID", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        logger.info("Entrata nel metodo getAlbum con l'ID: {}", id);

        logger.info("Uscita dal metodo getAlbum");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<AlbumDTO>> listAlbums() {
        logger.info("Entrata nel metodo listAlbums");

        logger.info("Uscita dal metodo listAlbums");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
