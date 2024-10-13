package dev.giovanniromano.museo.mapper;

import dev.giovanniromano.museo.entity.OperaEntity;
import dev.giovanniromano.museo.model.OperaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperaMapper {
    OperaEntity dtoToEntity(OperaDto artistaDto);
    OperaDto entityToDto(OperaEntity artistaEntity);
}
