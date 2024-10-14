package dev.giovanniromano.ristorante.service.impl;

import dev.giovanniromano.ristorante.entity.PiattoEntity;
import dev.giovanniromano.ristorante.mapper.PiattoMapper;
import dev.giovanniromano.ristorante.model.PiattoDto;
import dev.giovanniromano.ristorante.repository.PiattoRepository;
import dev.giovanniromano.ristorante.service.PiattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PiattoServiceImpl implements PiattoService {

    @Autowired
    PiattoRepository repo;

    @Autowired
    PiattoMapper mapper;

    @Override
    public PiattoDto save(PiattoDto dto) {
        PiattoEntity entity = mapper.dtoToEntity(dto);
        PiattoEntity saved = repo.save(entity);
        return mapper.entityToDto(saved);
    }

    @Override
    public List<PiattoDto> searchByType(PiattoDto.TipologiaEnum tipo) {
        List<PiattoEntity> entityList = repo.findByTipoPietanza(tipo);
        List<PiattoDto> dtoList = mapper.mapList(entityList);
        System.out.println(dtoList);
        return dtoList;
    }

    @Override
    public PiattoDto getById(Integer id) {
        Optional<PiattoEntity> opt = repo.findById(id);
        return opt.map(piattoEntity -> mapper.entityToDto(piattoEntity)).orElse(null);
    }
}
