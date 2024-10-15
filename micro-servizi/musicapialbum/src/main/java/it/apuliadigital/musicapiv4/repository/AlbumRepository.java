package it.apuliadigital.musicapiv4.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import it.apuliadigital.musicapiv4.entity.AlbumEntity;
import it.apuliadigital.musicapiv4.model.AlbumDTO.GenreEnum;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {
    public List<AlbumEntity> findByTitle(String title);
    public List<AlbumEntity> findByIdArtist(Long idArtist);
    public List<AlbumEntity> findByGenre(GenreEnum genre);
} 