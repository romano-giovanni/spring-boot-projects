package dev.giovanniromano.ristorante.repository;

import dev.giovanniromano.ristorante.entity.PiattoEntity;
import dev.giovanniromano.ristorante.model.PiattoDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PiattoRepository extends CrudRepository<PiattoEntity, Integer> {
    List<PiattoEntity> findByTipoPietanza(PiattoDto.TipologiaEnum tipoPietanza);
}
