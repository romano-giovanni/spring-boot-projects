package dev.giovanniromano.artists_api.service.impl;

import dev.giovanniromano.artist_api.model.ArtistDto;
import dev.giovanniromano.artists_api.entity.ArtistEntity;
import dev.giovanniromano.artists_api.mapper.ArtistMapper;
import dev.giovanniromano.artists_api.repository.ArtistRepository;
import dev.giovanniromano.artists_api.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    ArtistMapper artistMapper;

    @Override
    public ArtistDto findById(Long id) {
        Optional<ArtistEntity> entity = artistRepository.findById(id);
        if (entity.isPresent()) {
            return artistMapper.entityToDto(entity.get());
        }
        return null;
    }

    @Override
    public ArtistDto save(ArtistDto artist) {
        ArtistEntity entity = artistMapper.dtoToEntity(artist);
        ArtistEntity savedEntity = artistRepository.save(entity);
        return artistMapper.entityToDto(savedEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        if (artistRepository.existsById(id)) {
            artistRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArtistDto update(Long id, ArtistDto artist) {
        ArtistEntity entity = artistMapper.dtoToEntity(artist);
        entity.setId(id);
        ArtistEntity savedEntity = artistRepository.save(entity);
        return artistMapper.entityToDto(savedEntity);
    }

    @Override
    public List<ArtistDto> findByNationalityOrYear(String nationality, Long year) {
        return List.of();
    }
}
