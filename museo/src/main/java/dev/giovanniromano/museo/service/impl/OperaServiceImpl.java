package dev.giovanniromano.museo.service.impl;
import dev.giovanniromano.museo.entity.OperaEntity;
import dev.giovanniromano.museo.mapper.OperaMapper;
import dev.giovanniromano.museo.model.OperaDto;
import dev.giovanniromano.museo.repository.OperaRepository;
import dev.giovanniromano.museo.service.OperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperaServiceImpl implements OperaService {

    @Autowired
    OperaRepository repo;

    @Autowired
    OperaMapper mapper;

    @Override
    public List<OperaDto> findAll() {
        Iterable<OperaEntity> iterable = repo.findAll();
        return Streamable.of(iterable)
                .map(a -> mapper.entityToDto(a))
                .toList();
    }

    @Override
    public void save(OperaDto dto) {
        OperaEntity entity = mapper.dtoToEntity(dto);
        repo.save(entity);
    }

    @Override
    public OperaDto findById(Integer id) {
        Optional<OperaEntity> entity = repo.findById(id);
        return entity.map(operaEntity -> mapper.entityToDto(operaEntity)).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public OperaDto update(Integer id, OperaDto dto) {
        OperaEntity entity = mapper.dtoToEntity(dto);
        entity.setIdOpera(id);
        OperaEntity savedEntity = repo.save(entity);
        return mapper.entityToDto(savedEntity);
    }
}
