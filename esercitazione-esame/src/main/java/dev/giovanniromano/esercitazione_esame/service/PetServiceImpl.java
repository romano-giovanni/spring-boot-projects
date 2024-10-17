package dev.giovanniromano.esercitazione_esame.service;

import dev.giovanniromano.esercitazione_esame.entity.PetEntity;
import dev.giovanniromano.esercitazione_esame.mapper.DtoToEntity;
import dev.giovanniromano.esercitazione_esame.mapper.EntityToDto;
import dev.giovanniromano.esercitazione_esame.repository.PetRepository;
import dev.giovanniromano.esercitazione_esame.server.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService{
    @Autowired
    PetRepository repository;
    @Autowired
    DtoToEntity dtoToEntity;
    @Autowired
    EntityToDto entityToDto;


    @Override
    public Pet save(Pet dto) {
        PetEntity entity = repository.save(dtoToEntity.pet(dto));
        return entityToDto.pet(entity);
    }

    @Override
    public List<Pet> getAll(Integer limit) {
        Optional<Integer> limitOptional = Optional.ofNullable(limit);
        return Streamable.of(repository.findAll())
                .stream()
                .map(pet -> entityToDto.pet(pet))
                .limit(limitOptional.orElse(100))
                .toList();
    }
}
