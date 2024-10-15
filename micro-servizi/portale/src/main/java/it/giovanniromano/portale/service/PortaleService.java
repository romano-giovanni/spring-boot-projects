package it.giovanniromano.portale.service;

import dev.giovanniromano.portale.model.AlbumDto;
import dev.giovanniromano.portale.model.AlbumInfo;
import dev.giovanniromano.portale.model.ArtistWithAlbums;
import it.giovanniromano.portale.client.album.model.AlbumDTO;

import java.util.List;

public interface PortaleService {
    AlbumInfo albumAndArtist(Long idAlbum);

    ArtistWithAlbums artistAndAlbum(Long idArtista);

    List<AlbumDto> getAlbumsByGenre(String genre);
}
