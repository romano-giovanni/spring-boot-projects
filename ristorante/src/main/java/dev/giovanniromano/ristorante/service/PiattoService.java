package dev.giovanniromano.ristorante.service;

import dev.giovanniromano.ristorante.model.PiattoDto;

import java.util.List;

public interface PiattoService {
    public PiattoDto save(PiattoDto dto);
    public List<PiattoDto> searchByType(PiattoDto.TipologiaEnum tipo);
    public PiattoDto getById(Integer id);
}
