package dev.giovanniromano.mongo_example.service;

import dev.giovanniromano.mongo_example.document.GroceryItem;
import dev.giovanniromano.mongo_example.model.GroceryItemDto;

import java.util.List;

public interface GroceryService {
    void save(GroceryItemDto dto);
    GroceryItemDto findById(String id);
    List<GroceryItemDto> findAll();
    void delete(String id);
    GroceryItemDto update(String id, GroceryItemDto dto);
}
