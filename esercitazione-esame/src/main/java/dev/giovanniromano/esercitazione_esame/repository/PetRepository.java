package dev.giovanniromano.esercitazione_esame.repository;

import dev.giovanniromano.esercitazione_esame.entity.PetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Long> {

}
