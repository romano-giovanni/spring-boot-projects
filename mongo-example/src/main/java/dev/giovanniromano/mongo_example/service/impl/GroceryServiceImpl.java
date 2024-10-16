package dev.giovanniromano.mongo_example.service.impl;

import dev.giovanniromano.mongo_example.document.GroceryItem;
import dev.giovanniromano.mongo_example.mapper.GroceryMapper;
import dev.giovanniromano.mongo_example.model.GroceryItemDto;
import dev.giovanniromano.mongo_example.repository.GroceryRepository;
import dev.giovanniromano.mongo_example.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryServiceImpl implements GroceryService {
    @Autowired
    GroceryRepository repo;
    @Autowired
    GroceryMapper mapper;

    @Override
    public void save(GroceryItemDto dto) {
        GroceryItem item = mapper.dtoToItem(dto);
        repo.save(item);
    }

    @Override
    public GroceryItemDto findById(String id) {
        Optional<GroceryItem> opt = repo.findById(id);
        return opt.map(groceryItem -> mapper.itemToDto(groceryItem)).orElse(null);
    }

    @Override
    public List<GroceryItemDto> findAll() {
        List<GroceryItem> result = repo.findAll();
        return mapper.listItemToDto(result);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }

    @Override
    public GroceryItemDto update(String id, GroceryItemDto dto) {
       // Optional <GroceryItem> item = repo.findById(id);
        dto.setId(id);
        GroceryItem item = mapper.dtoToItem(dto);
        return mapper.itemToDto(repo.save(item));
    }
}
