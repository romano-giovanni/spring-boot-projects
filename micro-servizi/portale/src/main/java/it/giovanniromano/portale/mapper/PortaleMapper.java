package it.giovanniromano.portale.mapper;

import dev.giovanniromano.portale.model.AlbumDto;
import dev.giovanniromano.portale.model.ArtistDto;
import it.giovanniromano.portale.client.album.model.AlbumDTO;
import it.giovanniromano.portale.client.artista.model.Artist;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PortaleMapper {
    ArtistDto clientArtistToServer(Artist source);
//    AlbumDto clientAlbumToServer(AlbumDTO source);
    AlbumDto clientToServer(AlbumDTO source);
    List<AlbumDto> map(List<AlbumDTO> source);

}
