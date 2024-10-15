package dev.giovanniromano.pet_store.repository;

import dev.giovanniromano.pet_store.entity.PetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Long> {
}
