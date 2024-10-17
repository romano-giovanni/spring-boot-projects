package dev.giovanniromano.esercitazione_esame.mapper;

import dev.giovanniromano.esercitazione_esame.entity.PetEntity;
import dev.giovanniromano.esercitazione_esame.server.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityToDto {
    @Mapping(target = "id", source = "source.identificatore")
    @Mapping(target = "name", source = "source.nome")
    @Mapping(target = "tag", source = "source.etichetta")
    Pet pet(PetEntity source);
    // List<Pet> petList(List<PetEntity> source);
}
