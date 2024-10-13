package dev.giovanniromano.museo.repository;

import dev.giovanniromano.museo.entity.ArtistaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends CrudRepository<ArtistaEntity, Integer> {
}
