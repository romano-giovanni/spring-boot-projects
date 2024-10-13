package dev.giovanniromano.artists_api.service;

import dev.giovanniromano.artist_api.model.ArtistDto;
import dev.giovanniromano.artists_api.entity.ArtistEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArtistService {
    public ArtistDto findById(Long id);
    public ArtistDto save(ArtistDto artist);
    public boolean deleteById(Long id);
    public ArtistDto update(Long id, ArtistDto artist);
    public List<ArtistDto> findByNationalityOrYear(String nationality, Long year);

}
