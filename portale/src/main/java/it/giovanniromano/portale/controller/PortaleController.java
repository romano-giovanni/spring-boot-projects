package it.giovanniromano.portale.controller;

import dev.giovanniromano.portale.api.PortaleApi;
import dev.giovanniromano.portale.model.AlbumDto;
import dev.giovanniromano.portale.model.AlbumInfo;
import dev.giovanniromano.portale.model.ArtistWithAlbums;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PortaleController implements PortaleApi {

    @Override
    public ResponseEntity<AlbumInfo> portaleAlbumIdAlbumGet(
            @Parameter(name = "idAlbum", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Integer idAlbum
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ArtistWithAlbums> portaleArtistIdArtistaGet(
            @Parameter(name = "idArtista", description = "", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Integer idArtista
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<AlbumDto>> portaleGenreGenreGet(
            @Parameter(name = "genre", description = "", required = true, in = ParameterIn.PATH) @PathVariable("genre") String genre
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
