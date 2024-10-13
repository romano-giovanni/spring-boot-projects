package dev.giovanniromano.museo.repository;

import dev.giovanniromano.museo.entity.ArtistaEntity;
import dev.giovanniromano.museo.entity.OperaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperaRepository extends CrudRepository<OperaEntity, Integer> {
}
