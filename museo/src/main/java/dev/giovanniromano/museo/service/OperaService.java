package dev.giovanniromano.museo.service;

import dev.giovanniromano.museo.model.OperaDto;

import java.util.List;

public interface OperaService {
    public List<OperaDto> findAll();
    public void save(OperaDto dto);
    public OperaDto findById(Integer id);
    public void deleteById(Integer id);
    public OperaDto update(Integer id, OperaDto dto);
}
