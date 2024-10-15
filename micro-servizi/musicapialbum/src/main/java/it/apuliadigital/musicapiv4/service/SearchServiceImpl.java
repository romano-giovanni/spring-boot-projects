package it.apuliadigital.musicapiv4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import it.apuliadigital.musicapiv4.mapper.DTOToEntityMapper;
import it.apuliadigital.musicapiv4.mapper.EntityToDTOMapper;
import it.apuliadigital.musicapiv4.model.AlbumDTO;
import it.apuliadigital.musicapiv4.model.AlbumDTO.GenreEnum;
import it.apuliadigital.musicapiv4.repository.AlbumRepository;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    AlbumRepository albumRepository;

	@Autowired
    DTOToEntityMapper fromDTO;

    @Autowired
    EntityToDTOMapper fromEntity;

	@Override
	public List<AlbumDTO> albumByTitle(String title) {
        return Streamable.of(albumRepository.findByTitle(title))
			.map(album -> fromEntity.toDTO(album)).toList();
	}

	@Override
	public List<AlbumDTO> albumByGenre(GenreEnum genre) {
		return Streamable.of(albumRepository.findByGenre(genre))
			.map(album -> fromEntity.toDTO(album)).toList();
	}

	@Override
	public List<AlbumDTO> albumByArtistId(Long idArtist) {
		return Streamable.of(albumRepository.findByIdArtist(idArtist))
			.map(album -> fromEntity.toDTO(album)).toList();
	}

}
