package dev.giovanniromano.anagrafica.service;

import dev.giovanniromano.anagrafica.model.AnagraficaDTO;

import java.util.List;

public interface AnagraficaService {
    AnagraficaDTO save(AnagraficaDTO dto);
    String delete(Long id);
    AnagraficaDTO findById(Long id);
    List<AnagraficaDTO> getAll();
    AnagraficaDTO update(Long id, AnagraficaDTO dto);
}
