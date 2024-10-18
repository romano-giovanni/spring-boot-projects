package it.its.formazione.springboot_esercizio2_giovanni_romano.service;

import it.its.formazione.springboot_esercizio2_giovanni_romano.server.model.BookingDTO;

import java.util.List;

public interface BookingService {
    BookingDTO save(BookingDTO bookingDTO);
    void deleteById(Integer id);
    List<BookingDTO> getAll();
    BookingDTO getById(Integer id);
    BookingDTO update(Integer id, BookingDTO bookingDTO);
}
