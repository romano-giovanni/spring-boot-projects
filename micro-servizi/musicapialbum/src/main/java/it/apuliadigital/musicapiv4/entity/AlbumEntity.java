package it.apuliadigital.musicapiv4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import it.apuliadigital.musicapiv4.model.AlbumDTO.GenreEnum;

@Entity
@Table(name="ALBUM")
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long idAlbum;

    @Column(name = "titolo")
    private String title;

    @Column(name = "artista")
    private String artist;

    @Column(name = "anno_pubblicazione")
    private Integer year;

    @Column(name = "genere")
    private GenreEnum genre;

    @Column(name = "id_artista")
    private Long idArtist;

    @Valid
    @Column(name = "tracce")
    private List<String> tracks = new ArrayList<>();

    public Long getIdAlbum() {
        return idAlbum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public Long getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(Long idArtist) {
        this.idArtist = idArtist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

}
