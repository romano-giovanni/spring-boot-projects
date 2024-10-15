package it.apuliadigital.musicapiv4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.musicapiv4.entity.AlbumEntity;
import it.apuliadigital.musicapiv4.mapper.DTOToEntityMapper;
import it.apuliadigital.musicapiv4.mapper.EntityToDTOMapper;
import it.apuliadigital.musicapiv4.model.AlbumDTO;
import it.apuliadigital.musicapiv4.repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService {
    
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    DTOToEntityMapper fromDTO;

    @Autowired
    EntityToDTOMapper fromEntity;

    @Override
    public AlbumDTO createAlbum(AlbumDTO albumDTO) {
        AlbumEntity nuovoAlbum = fromDTO.toEntity(albumDTO);
        nuovoAlbum = albumRepository.save(nuovoAlbum);
        
        return fromEntity.toDTO(nuovoAlbum);
    }

    @Override
    public AlbumDTO updateAlbum(Long id, AlbumDTO albumDTO) {
        
        var albumTrovato = albumRepository.findById(id);

        if (albumTrovato.isPresent()) {
            albumTrovato.get().setArtist(albumDTO.getArtist());
            albumTrovato.get().setYear(albumDTO.getYear());
            albumTrovato.get().setGenre(albumDTO.getGenre());
            albumTrovato.get().setTracks(albumDTO.getTracks());
            albumTrovato.get().setTitle(albumDTO.getTitle());
            albumTrovato.get().setIdArtist(albumDTO.getIdArtist());

            albumRepository.save(albumTrovato.get());
            
            return fromEntity.toDTO(albumTrovato.get());
        }

        return null;
    }

    @Override
    public AlbumDTO getAlbum(Long id) {
        var albumTrovato = albumRepository.findById(id);

        if (albumTrovato.isPresent()) {
            return fromEntity.toDTO(albumTrovato.get());
        }

        return null;
    }

    @Override
    public AlbumDTO deleteAlbum(Long id) {
        var albumTrovato = albumRepository.findById(id);

        if (albumTrovato.isPresent()) {
            albumRepository.deleteById(id);
            return fromEntity.toDTO(albumTrovato.get());
        }

        return null;
    }

}
