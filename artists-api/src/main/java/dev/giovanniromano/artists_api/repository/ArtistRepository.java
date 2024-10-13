package dev.giovanniromano.artists_api.repository;

import dev.giovanniromano.artists_api.entity.ArtistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

public interface ArtistRepository extends CrudRepository<ArtistEntity, Long> {

}
