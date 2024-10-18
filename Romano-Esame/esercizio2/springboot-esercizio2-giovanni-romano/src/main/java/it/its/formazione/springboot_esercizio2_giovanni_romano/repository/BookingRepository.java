package it.its.formazione.springboot_esercizio2_giovanni_romano.repository;

import it.its.formazione.springboot_esercizio2_giovanni_romano.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {
}
