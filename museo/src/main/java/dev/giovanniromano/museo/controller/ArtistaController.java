package dev.giovanniromano.museo.controller;

import dev.giovanniromano.museo.api.ArtistiApi;
import dev.giovanniromano.museo.model.ArtistaDto;
import dev.giovanniromano.museo.service.ArtistaService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ArtistaController implements ArtistiApi {

    @Autowired
    ArtistaService service;

    public ResponseEntity<List<ArtistaDto>> artistiGet() {
        List<ArtistaDto> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<Void> artistiIdArtistaDelete(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Integer idArtista
    ) {
        service.deleteById(idArtista);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<ArtistaDto> artistiIdArtistaGet(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Integer idArtista
    ) {
        return new ResponseEntity<>(service.findById(idArtista), HttpStatus.OK);
    }

    public ResponseEntity<ArtistaDto> artistiIdArtistaPut(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Integer idArtista,
            @Parameter(name = "ArtistaDto", description = "Dati aggiornati dell'artista", required = true) @Valid @RequestBody ArtistaDto artistaDto
    ) {
        ArtistaDto dto = service.update(idArtista, artistaDto);
        return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> artistiPost(
            @Parameter(name = "ArtistaDto", description = "Dati del nuovo artista", required = true) @Valid @RequestBody ArtistaDto artistaDto
    ) {
        service.save(artistaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
