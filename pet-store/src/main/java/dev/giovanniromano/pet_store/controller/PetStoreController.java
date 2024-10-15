package dev.giovanniromano.pet_store.controller;

import dev.giovanniromano.pet_store.api.PetsApi;
import dev.giovanniromano.pet_store.model.Pet;
import dev.giovanniromano.pet_store.service.PetService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetStoreController implements PetsApi {

    @Autowired
    PetService service;

    @Override
    public ResponseEntity<Void> createPets(
            @Parameter(name = "Pet", description = "", required = true) @Valid @RequestBody Pet pet
    ) {
        service.save(pet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Pet>> listPets(
            @Max(100) @Parameter(name = "limit", description = "How many items to return at one time (max 100)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit
    ) {
        List<Pet> result = service.getAll(limit);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Pet> showPetById(
            @Parameter(name = "petId", description = "The id of the pet to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("petId") String petId
    ) {
        Pet result = service.getById(petId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}