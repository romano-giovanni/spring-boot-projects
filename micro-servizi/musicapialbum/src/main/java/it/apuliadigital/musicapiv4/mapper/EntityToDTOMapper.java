package it.apuliadigital.musicapiv4.mapper;

import org.mapstruct.Mapper;

import it.apuliadigital.musicapiv4.entity.AlbumEntity;
import it.apuliadigital.musicapiv4.model.AlbumDTO;

@Mapper(componentModel = "spring")
public interface EntityToDTOMapper {
    AlbumDTO toDTO(AlbumEntity entity);

    // @Mapping(target = "contattoTipo", source = "entity.contatto.tipo")
    // @Mapping(target = "contattoValore", source = "entity.contatto.valore")
    // EsempioDTO toDto(EsempioEntity entity);

}
