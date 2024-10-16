package dev.giovanniromano.mongo_example.controller;

import dev.giovanniromano.mongo_example.api.ApiUtil;
import dev.giovanniromano.mongo_example.api.GroceryItemApi;
import dev.giovanniromano.mongo_example.model.GroceryItemDto;
import dev.giovanniromano.mongo_example.service.GroceryService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroceryController implements GroceryItemApi {

    @Autowired
    GroceryService service;

//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello";
//    }

    @Override
    public ResponseEntity<GroceryItemDto> groceryItemIdGet(
            @Parameter(name = "id", description = "L'ID dell'elemento di generi alimentari", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        GroceryItemDto dto = service.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> groceryItemPost(
            @Parameter(name = "GroceryItemDto", description = "", required = true) @Valid @RequestBody GroceryItemDto groceryItemDto
    ) {
        service.save(groceryItemDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<GroceryItemDto>> groceryItemGet(

    ) {
        List<GroceryItemDto> result = service.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GroceryItemDto> groceryItemIdPut(
            @Parameter(name = "id", description = "L'ID dell'elemento di generi alimentari", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
            @Parameter(name = "GroceryItemDto", description = "", required = true) @Valid @RequestBody GroceryItemDto groceryItemDto
    ) {
        return new ResponseEntity<>(service.update(id, groceryItemDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> groceryItemIdDelete(
            @Parameter(name = "id", description = "L'ID dell'elemento di generi alimentari", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}