package dev.giovanniromano.museo.mapper;

import org.mapstruct.Mapper;
import dev.giovanniromano.museo.entity.ArtistaEntity;
import dev.giovanniromano.museo.model.ArtistaDto;


@Mapper(componentModel = "spring")
public interface ArtistaMapper  {
    ArtistaEntity dtoToEntity(ArtistaDto artistaDto);
    ArtistaDto entityToDto(ArtistaEntity artistaEntity);
}
