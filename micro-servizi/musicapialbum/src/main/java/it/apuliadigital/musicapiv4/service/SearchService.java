package it.apuliadigital.musicapiv4.service;

import java.util.List;


import org.springframework.stereotype.Service;

import it.apuliadigital.musicapiv4.model.AlbumDTO;
import it.apuliadigital.musicapiv4.model.AlbumDTO.GenreEnum;

@Service
public interface SearchService  {
    public List<AlbumDTO> albumByTitle(String title);
    public List<AlbumDTO> albumByGenre(GenreEnum genre);
    public List<AlbumDTO> albumByArtistId(Long idArtist);
}
