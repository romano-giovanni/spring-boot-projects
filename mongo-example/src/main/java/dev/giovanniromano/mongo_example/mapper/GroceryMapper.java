package dev.giovanniromano.mongo_example.mapper;

import dev.giovanniromano.mongo_example.document.GroceryItem;
import dev.giovanniromano.mongo_example.model.GroceryItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroceryMapper {
    GroceryItem dtoToItem(GroceryItemDto source);
    GroceryItemDto itemToDto(GroceryItem destination);
    //List<GroceryItem> listDtoToItem(List<GroceryItemDto> source);
    List<GroceryItemDto> listItemToDto(List<GroceryItem> source);
    void updateDtoToItem(GroceryItemDto dto, @MappingTarget GroceryItem item);
}
