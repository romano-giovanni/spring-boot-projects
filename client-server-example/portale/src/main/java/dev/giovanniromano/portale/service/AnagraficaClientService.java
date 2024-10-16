package dev.giovanniromano.portale.service;

import dev.giovanniromano.portale.server.model.AnagraficaDTO;

import java.util.List;

public interface AnagraficaClientService {
    List<AnagraficaDTO> getAll();
    AnagraficaDTO getById(Long id);
}
