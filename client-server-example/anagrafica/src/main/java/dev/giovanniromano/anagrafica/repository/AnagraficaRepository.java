package dev.giovanniromano.anagrafica.repository;

import dev.giovanniromano.anagrafica.entity.AnagraficaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaRepository extends CrudRepository<AnagraficaEntity, Long> {
}
