package dev.giovanniromano.pet_store.service.impl;

import dev.giovanniromano.pet_store.entity.PetEntity;
import dev.giovanniromano.pet_store.mapper.PetMapper;
import dev.giovanniromano.pet_store.model.Pet;
import dev.giovanniromano.pet_store.repository.PetRepository;
import dev.giovanniromano.pet_store.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetMapper mapper;

    @Autowired
    PetRepository repo;

    @Autowired
    private PetRepository petRepository;

    @Override
    public void save(Pet pet) {
        PetEntity entity = mapper.dtoToEntity(pet);
        repo.save(entity);
    }

    @Override
    public List<Pet> getAll(Integer limit) {
        Optional<Integer> limitOptional = Optional.ofNullable(limit);
        return Streamable.of(petRepository.findAll())
                .stream()
                .map(pet -> mapper.entityToDto(pet))
                .limit(limitOptional.orElse(100))
                .toList();
    }

    @Override
    public Pet getById(String id) {
        Optional<PetEntity> entity = repo.findById(Long.valueOf(id));
        return entity.map(petEntity -> mapper.entityToDto(petEntity)).orElse(null);
    }
}
