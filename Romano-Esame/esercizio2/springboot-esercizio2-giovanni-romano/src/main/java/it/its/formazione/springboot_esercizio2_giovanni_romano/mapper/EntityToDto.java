package it.its.formazione.springboot_esercizio2_giovanni_romano.mapper;

import it.its.formazione.springboot_esercizio2_giovanni_romano.entity.BookingEntity;
import it.its.formazione.springboot_esercizio2_giovanni_romano.server.model.BookingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.awt.print.Book;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityToDto {
    @Mapping(target = "guestName", source = "source.guest")
    BookingDTO booking(BookingEntity source);
    List<BookingDTO> bookingList(List<BookingEntity> sourceList);
}
