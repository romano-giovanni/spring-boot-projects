package dev.giovanniromano.esercitazione_esame.controller;

import dev.giovanniromano.esercitazione_esame.server.api.PetsApi;
import dev.giovanniromano.esercitazione_esame.server.model.Pet;
import dev.giovanniromano.esercitazione_esame.service.PetService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController implements PetsApi {
    @Autowired
    PetService service;

    @Override
    public ResponseEntity<Void> createPets(
            @Parameter(name = "Pet", description = "", required = true) @Valid @RequestBody Pet pet
    ) {
        service.save(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<List<Pet>> listPets(
            @Max(100) @Parameter(name = "limit", description = "How many items to return at one time (max 100)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit
    ) {
        List<Pet> result = service.getAll(limit);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
