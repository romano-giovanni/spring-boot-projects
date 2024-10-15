package it.giovanniromano.portale.service.impl;

import dev.giovanniromano.portale.model.AlbumDto;
import dev.giovanniromano.portale.model.AlbumInfo;
import dev.giovanniromano.portale.model.ArtistDto;
import dev.giovanniromano.portale.model.ArtistWithAlbums;
import it.giovanniromano.portale.client.album.api.AlbumApi;
import it.giovanniromano.portale.client.album.api.SearchApi;
import it.giovanniromano.portale.client.album.model.AlbumDTO;
import it.giovanniromano.portale.client.artista.api.ArtistApi;
import it.giovanniromano.portale.client.artista.model.Artist;
import it.giovanniromano.portale.mapper.PortaleMapper;
import it.giovanniromano.portale.service.PortaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortaleServiceImpl implements PortaleService {

    @Autowired
    private AlbumApi albumApiClient;

    @Autowired
    private ArtistApi artistApiClient;

    @Autowired
    private SearchApi searchApiClient;

    @Autowired
    PortaleMapper mapper;

    @Override
    public AlbumInfo albumAndArtist(Long idAlbum) {

        AlbumDTO client = albumApiClient.getAlbum(idAlbum);
        AlbumDto server = mapper.clientToServer(client);
        Artist artist = artistApiClient.getArtistById(server.getIdArtist());
        ArtistDto artistServer = mapper.clientArtistToServer(artist);
        AlbumInfo result = new AlbumInfo();
        result.setAlbum(server);
        result.setArtista(artistServer);
        return result;
    }

    @Override
    public ArtistWithAlbums artistAndAlbum(Long idArtista) {
        Artist artist = artistApiClient.getArtistById(idArtista);
        ArtistDto artistDto = mapper.clientArtistToServer(artist);
        List<AlbumDTO> albumList = searchApiClient.searchAlbums(null, idArtista.toString(), null);
        List<AlbumDto> convertedList = mapper.map(albumList);
        ArtistWithAlbums result = new ArtistWithAlbums();
        result.setArtista(artistDto);
        result.setListaAlbum(convertedList);
        return result;
    }

    @Override
    public List<AlbumDto> getAlbumsByGenre(String genre) {
        List<AlbumDTO> albumDTOList = searchApiClient.searchAlbums(null, null, genre);
        List<AlbumDto> albumDtoList = mapper.map(albumDTOList);
        return albumDtoList;
    }
}
