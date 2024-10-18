package it.its.formazione.springboot_esercizio2_giovanni_romano.service.impl;

import it.its.formazione.springboot_esercizio2_giovanni_romano.entity.BookingEntity;
import it.its.formazione.springboot_esercizio2_giovanni_romano.mapper.DtoToEntity;
import it.its.formazione.springboot_esercizio2_giovanni_romano.mapper.EntityToDto;
import it.its.formazione.springboot_esercizio2_giovanni_romano.repository.BookingRepository;
import it.its.formazione.springboot_esercizio2_giovanni_romano.server.model.BookingDTO;
import it.its.formazione.springboot_esercizio2_giovanni_romano.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    DtoToEntity dtoToEntity;
    @Autowired
    EntityToDto entityToDto;
    @Autowired
    BookingRepository repository;

    @Override
    public BookingDTO save(BookingDTO bookingDTO) {
        BookingEntity entity = repository.save(dtoToEntity.booking(bookingDTO));
        return entityToDto.booking(entity);
    }

    @Override
    public void deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public List<BookingDTO> getAll() {
        Iterable<BookingEntity> list = repository.findAll();
        return entityToDto.bookingList((List<BookingEntity>) list);
    }

    @Override
    public BookingDTO getById(Integer id) {
        Optional<BookingEntity> opt = repository.findById(id);
        return opt.map(bookingEntity -> entityToDto.booking(bookingEntity)).orElse(null);
    }

    @Override
    public BookingDTO update(Integer id, BookingDTO bookingDTO) {
        bookingDTO.setId(id);
        BookingEntity result = repository.save(dtoToEntity.booking(bookingDTO));
        return entityToDto.booking(result);
    }
}
