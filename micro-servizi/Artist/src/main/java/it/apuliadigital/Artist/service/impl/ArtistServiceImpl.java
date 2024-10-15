package it.apuliadigital.Artist.service.impl;

import it.apuliadigital.Artist.entity.ArtistEntity;
import it.apuliadigital.Artist.model.Artist;
import it.apuliadigital.Artist.repository.ArtistRepository;
import it.apuliadigital.Artist.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public Artist getArtistById(Long idArtist) {
        Optional<ArtistEntity> entity = artistRepository.findById(idArtist);

        Artist a = new Artist();
        a.setId(idArtist);
        a.setName(entity.get().getName());
        a.setSurname(entity.get().getSurname());
        a.setStageName(entity.get().getStageName());
        a.setBirthYear(entity.get().getBirthYear());
        a.setBiography(entity.get().getBiography());
        a.setGenre(entity.get().getGenre());
        a.setType(entity.get().getType());
        a.setNationality(entity.get().getNationality());
        return a;
    }

    @Override
    public Artist createArtist(Artist artist) {
        ArtistEntity entity = new ArtistEntity();
        entity.setName(artist.getName());
        entity.setSurname(artist.getSurname());
        entity.setStageName(artist.getStageName());
        entity.setBirthYear(artist.getBirthYear());
        entity.setBiography(artist.getBiography());
        entity.setGenre(artist.getGenre());
        entity.setType(artist.getType());
        entity.setNationality(artist.getNationality());
        artistRepository.save(entity);
        artist.setId(entity.getId());
        return artist;
    }

    @Override
    public boolean updateArtist(Long id, Artist artist) {
        if (artistRepository.existsById(id)) {
            ArtistEntity entity = new ArtistEntity();
            entity.setId(id);
            entity.setName(artist.getName());
            entity.setSurname(artist.getSurname());
            entity.setStageName(artist.getStageName());
            entity.setBirthYear(artist.getBirthYear());
            entity.setBiography(artist.getBiography());
            entity.setGenre(artist.getGenre());
            entity.setType(artist.getType());
            entity.setNationality(artist.getNationality());
            artistRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteArtist(Long id) {
        if (artistRepository.existsById(id)) {
            artistRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Artist> searchArtistsByNationality(String nationality) {
        List<ArtistEntity> entities = artistRepository.findByNationality(nationality);
        List<Artist> artists = new ArrayList<>();
        for (ArtistEntity entity : entities) {
            Artist a = new Artist();
            a.setId(entity.getId());
            a.setName(entity.getName());
            a.setSurname(entity.getSurname());
            a.setStageName(entity.getStageName());
            a.setBirthYear(entity.getBirthYear());
            a.setBiography(entity.getBiography());
            a.setGenre(entity.getGenre());
            a.setType(entity.getType());
            a.setNationality(entity.getNationality());
            artists.add(a);
        }
        return artists;
    }

    @Override
    public List<Artist> searchArtistsByBirthYear(Integer birthYear) {
        List<ArtistEntity> entities = artistRepository.findByBirthYear(birthYear);
        List<Artist> artists = new ArrayList<>();
        for (ArtistEntity entity : entities) {
            Artist a = new Artist();
            a.setId(entity.getId());
            a.setName(entity.getName());
            a.setSurname(entity.getSurname());
            a.setStageName(entity.getStageName());
            a.setBirthYear(entity.getBirthYear());
            a.setBiography(entity.getBiography());
            a.setGenre(entity.getGenre());
            a.setType(entity.getType());
            a.setNationality(entity.getNationality());
            artists.add(a);
        }
        return artists;
    }


    @Override
    public List<Artist> getAllArtists() {
        List<ArtistEntity> entities = (List<ArtistEntity>) artistRepository.findAll();
        List<Artist> artists = new ArrayList<>();
        for (ArtistEntity entity : entities) {
            Artist a = new Artist();
            a.setId(entity.getId());
            a.setName(entity.getName());
            a.setSurname(entity.getSurname());
            a.setStageName(entity.getStageName());
            a.setBirthYear(entity.getBirthYear());
            a.setBiography(entity.getBiography());
            a.setGenre(Artist.GenreEnum.valueOf(entity.getGenre().name()));
            a.setType(Artist.TypeEnum.valueOf(entity.getType().name()));
            a.setNationality(entity.getNationality());
            artists.add(a);
        }
        return artists;
    }

}
