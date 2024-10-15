package it.apuliadigital.Artist.repository;

import it.apuliadigital.Artist.entity.ArtistEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<ArtistEntity, Long> {
    List<ArtistEntity> findByBirthYear(Integer birthYear);
    List<ArtistEntity> findByNationality(String nationality);
}
