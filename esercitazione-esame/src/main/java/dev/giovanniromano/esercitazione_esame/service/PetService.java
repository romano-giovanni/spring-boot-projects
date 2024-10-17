package dev.giovanniromano.esercitazione_esame.service;

import dev.giovanniromano.esercitazione_esame.server.model.Pet;

import java.util.List;

public interface PetService {
    Pet save(Pet dto);
    List<Pet> getAll(Integer limit);
}
