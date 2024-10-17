package dev.giovanniromano.esercitazione_esame.mapper;

import dev.giovanniromano.esercitazione_esame.entity.PetEntity;
import dev.giovanniromano.esercitazione_esame.server.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DtoToEntity {
    @Mapping(target = "identificatore", source = "source.id")
    @Mapping(target = "nome", source = "source.name")
    @Mapping(target = "etichetta", source = "source.tag")
    PetEntity pet(Pet source);
    // List<PetEntity> petList(List<Pet> source);
}
