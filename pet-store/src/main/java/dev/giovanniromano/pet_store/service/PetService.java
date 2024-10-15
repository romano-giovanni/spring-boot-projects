package dev.giovanniromano.pet_store.service;

import dev.giovanniromano.pet_store.model.Pet;

import java.util.List;

public interface PetService {
    void save(Pet pet);
    List<Pet> getAll(Integer limit);
    Pet getById(String id);
}
