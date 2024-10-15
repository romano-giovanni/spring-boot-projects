package it.apuliadigital.musicapiv4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigital.musicapiv4.api.AlbumApi;
import it.apuliadigital.musicapiv4.model.AlbumDTO;
import it.apuliadigital.musicapiv4.service.AlbumService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
public class AlbumController implements AlbumApi{

    @Autowired
    AlbumService albumService;

    @Override
    public ResponseEntity<AlbumDTO> createAlbum(@Valid AlbumDTO albumDTO) {
        var nuovoAlbum = albumService.createAlbum(albumDTO);
        return new ResponseEntity<>(nuovoAlbum, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AlbumDTO> deleteAlbum(@Min(0) Long id) {
        var albumCancellato = albumService.deleteAlbum(id);
        return new ResponseEntity<>(albumCancellato, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AlbumDTO> getAlbum(@Min(0) Long id) {
        var albumTrovato = albumService.getAlbum(id);
        return new ResponseEntity<>(albumTrovato, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AlbumDTO> updateAlbum(@Min(0) Long id, @Valid AlbumDTO albumDTO) {
        var albumAggiornato = albumService.updateAlbum(id, albumDTO);
        return new ResponseEntity<>(albumAggiornato, HttpStatus.OK);
    }
    
}
