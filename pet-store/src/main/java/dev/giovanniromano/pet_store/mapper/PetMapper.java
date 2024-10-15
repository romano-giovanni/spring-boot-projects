package dev.giovanniromano.pet_store.mapper;

import dev.giovanniromano.pet_store.entity.PetEntity;
import dev.giovanniromano.pet_store.model.Pet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {
    PetEntity dtoToEntity(Pet source);
    Pet entityToDto(PetEntity destination);
//    List<Pet> listEntityToDto(List<PetEntity> employees);
}
