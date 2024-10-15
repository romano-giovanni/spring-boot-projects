package it.apuliadigital.musicapiv4.mapper;

import org.mapstruct.Mapper;

import it.apuliadigital.musicapiv4.entity.AlbumEntity;
import it.apuliadigital.musicapiv4.model.AlbumDTO;

@Mapper(componentModel = "spring")
public interface DTOToEntityMapper {
    AlbumEntity toEntity(AlbumDTO dto);

    /*
    @Mapping(target = "entityId", source = "entity.id")
    @Mapping(target="entityDate", source = "entity.dateString", dateFormat = "dd-MM-yyyy HH:mm:ss")
    
    @Mapping(target = "contatto", ignore = true)
    EsempioEntity toEntity(EsempioDTO dto);

    @AfterMapping
    default void setContatto(@MappingTarget EsempioDTO dto, EsempioEntity entity) {
        entity.setContatto(new Contatto(dto.getContattoTipo(), dto.getContattoValore()));
    }
    */

}
