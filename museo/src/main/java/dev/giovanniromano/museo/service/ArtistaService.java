package dev.giovanniromano.museo.service;

import dev.giovanniromano.museo.model.ArtistaDto;

import java.util.List;

public interface ArtistaService {
    public List<ArtistaDto> findAll();
    public void save(ArtistaDto dto);
    public ArtistaDto findById(Integer id);
    public void deleteById(Integer id);
    public ArtistaDto update(Integer id, ArtistaDto dto);

}
