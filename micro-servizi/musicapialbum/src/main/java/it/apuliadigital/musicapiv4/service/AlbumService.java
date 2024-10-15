package it.apuliadigital.musicapiv4.service;

import org.springframework.stereotype.Service;

import it.apuliadigital.musicapiv4.model.AlbumDTO;

@Service
public interface AlbumService {
    public AlbumDTO createAlbum(AlbumDTO albumDTO);
    public AlbumDTO getAlbum(Long id);
    public AlbumDTO updateAlbum(Long id, AlbumDTO albumDTO);
    public AlbumDTO deleteAlbum(Long id);
}
