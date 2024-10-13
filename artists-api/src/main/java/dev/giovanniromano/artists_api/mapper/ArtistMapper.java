package dev.giovanniromano.artists_api.mapper;

import dev.giovanniromano.artist_api.model.ArtistDto;
import dev.giovanniromano.artists_api.entity.ArtistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    ArtistEntity dtoToEntity(ArtistDto artistDto);
    ArtistDto entityToDto(ArtistEntity artistEntity);
}