package dev.giovanniromano.museo.controller;

import dev.giovanniromano.museo.api.ApiUtil;
import dev.giovanniromano.museo.api.ArtistiApi;
import dev.giovanniromano.museo.model.ArtistaDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class ArtistaController implements ArtistiApi {

    public ResponseEntity<List<ArtistaDto>> artistiGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> artistiIdArtistaDelete(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Integer idArtista
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ArtistaDto> artistiIdArtistaGet(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Integer idArtista
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ArtistaDto> artistiIdArtistaPut(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Integer idArtista,
            @Parameter(name = "ArtistaDto", description = "Dati aggiornati dell'artista", required = true) @Valid @RequestBody ArtistaDto artistaDto
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> artistiPost(
            @Parameter(name = "ArtistaDto", description = "Dati del nuovo artista", required = true) @Valid @RequestBody ArtistaDto artistaDto
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
