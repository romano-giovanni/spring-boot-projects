package it.its.formazione.springboot_esercizio2_giovanni_romano.mapper;

import it.its.formazione.springboot_esercizio2_giovanni_romano.entity.BookingEntity;
import it.its.formazione.springboot_esercizio2_giovanni_romano.server.model.BookingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoToEntity {
    @Mapping(target = "guest", source = "source.guestName")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BookingEntity booking(BookingDTO source);
    List<BookingEntity> bookingList(List<BookingDTO> source);
}
