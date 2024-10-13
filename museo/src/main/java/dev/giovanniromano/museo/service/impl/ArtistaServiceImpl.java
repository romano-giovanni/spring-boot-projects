package dev.giovanniromano.museo.service.impl;
import dev.giovanniromano.museo.entity.ArtistaEntity;
import dev.giovanniromano.museo.mapper.ArtistaMapper;
import dev.giovanniromano.museo.model.ArtistaDto;
import dev.giovanniromano.museo.repository.ArtistaRepository;
import dev.giovanniromano.museo.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaServiceImpl implements ArtistaService {

    @Autowired
    ArtistaRepository repo;

    @Autowired
    ArtistaMapper mapper;

    @Override
    public List<ArtistaDto> findAll() {
        Iterable<ArtistaEntity> iterable = repo.findAll();
        return Streamable.of(iterable)
                .map(a -> mapper.entityToDto(a))
                .toList();
    }

    @Override
    public void save(ArtistaDto dto) {
        ArtistaEntity entity = mapper.dtoToEntity(dto);
        repo.save(entity);
    }

    @Override
    public ArtistaDto findById(Integer id) {
        Optional<ArtistaEntity> entity = repo.findById(id);
        return entity.map(operaEntity -> mapper.entityToDto(operaEntity)).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public ArtistaDto update(Integer id, ArtistaDto dto) {
        ArtistaEntity entity = mapper.dtoToEntity(dto);
        entity.setIdArtista(id);
        ArtistaEntity savedEntity = repo.save(entity);
        return mapper.entityToDto(savedEntity);
    }
}
