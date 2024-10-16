package dev.giovanniromano.anagrafica.mapper;

import dev.giovanniromano.anagrafica.entity.AnagraficaEntity;
import dev.giovanniromano.anagrafica.model.AnagraficaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoToEntity {
    AnagraficaEntity anagrafica(AnagraficaDTO dto);
    List<AnagraficaEntity> anagraficaList(List<AnagraficaDTO> dtoList);
}
