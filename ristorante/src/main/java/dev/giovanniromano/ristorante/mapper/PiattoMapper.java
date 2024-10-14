package dev.giovanniromano.ristorante.mapper;

import dev.giovanniromano.ristorante.entity.PiattoEntity;
import dev.giovanniromano.ristorante.model.PiattoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PiattoMapper {

    @Mapping(target = "id", source = "source.idPiatto")
    @Mapping(target = "nome", source = "source.nomePiatto")
    @Mapping(target = "costoCliente", source = "source.prezzo")
    @Mapping(target = "tipoPietanza", source = "source.tipologia")
    PiattoEntity dtoToEntity(PiattoDto source);

    @Mapping(target = "idPiatto", source = "destination.id")
    @Mapping(target = "nomePiatto", source = "destination.nome")
    @Mapping(target = "prezzo", source = "destination.costoCliente")
    @Mapping(target = "tipologia", source = "destination.tipoPietanza")
    PiattoDto entityToDto(PiattoEntity destination);

    List<PiattoDto> mapList(List<PiattoEntity> employees);
}
