package it.apuliadigital.Artist.service;

import java.util.List;
import it.apuliadigital.Artist.model.Artist;


public interface ArtistService {
    List<Artist> getAllArtists();
    Artist getArtistById(Long idArtist);
    Artist createArtist(Artist artist);
    boolean updateArtist(Long id, Artist artist);
    boolean deleteArtist(Long id);
    List<Artist> searchArtistsByNationality(String nationality);
    List<Artist> searchArtistsByBirthYear(Integer birthYear);
}
