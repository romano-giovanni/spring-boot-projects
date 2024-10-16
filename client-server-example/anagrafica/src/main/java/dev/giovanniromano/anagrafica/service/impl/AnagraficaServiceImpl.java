package dev.giovanniromano.anagrafica.service.impl;

import dev.giovanniromano.anagrafica.entity.AnagraficaEntity;
import dev.giovanniromano.anagrafica.mapper.DtoToEntity;
import dev.giovanniromano.anagrafica.mapper.EntityToDto;
import dev.giovanniromano.anagrafica.model.AnagraficaDTO;
import dev.giovanniromano.anagrafica.repository.AnagraficaRepository;
import dev.giovanniromano.anagrafica.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnagraficaServiceImpl implements AnagraficaService {

    @Autowired
    AnagraficaRepository repo;
    @Autowired
    DtoToEntity dtoToEntity;
    @Autowired
    EntityToDto entityToDto;

    @Override
    public AnagraficaDTO save(AnagraficaDTO dto) {
        AnagraficaEntity entity = repo.save(dtoToEntity.anagrafica(dto));
        return entityToDto.anagrafica(entity);
    }

    @Override
    public String delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Eliminato con successo";
        } return "Elemento non trovato";
    }

    @Override
    public AnagraficaDTO findById(Long id) {
        Optional<AnagraficaEntity> opt = repo.findById(id);
        return opt.map(entity -> entityToDto.anagrafica(entity)).orElse(null);
    }

    @Override
    public List<AnagraficaDTO> getAll() {
        List<AnagraficaEntity> entityList = (List<AnagraficaEntity>) repo.findAll();
        return entityToDto.anagraficaList(entityList);
    }

    @Override
    public AnagraficaDTO update(Long id, AnagraficaDTO dto) {
        if (repo.existsById(id)) {
            dto.setIdAnagrafica(id);
            AnagraficaEntity entity = repo.save(dtoToEntity.anagrafica(dto));
            return entityToDto.anagrafica(entity);
        } return null;
    }
}
