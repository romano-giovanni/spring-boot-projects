package dev.giovanniromano.artists_api.entity;

import dev.giovanniromano.artist_api.model.ArtistDto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="artists")
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ArtistDto.TypeEnum type;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "stage_name")
    private String stageName;

    @Column(name = "birth_year")
    private Long birthYear;

    @Column(name = "biography")
    private String biography;

    @Column(name = "nationality")
    private String nationality;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private ArtistDto.GenreEnum genre;

    public ArtistEntity() {
    }

    public ArtistEntity(Long id, ArtistDto.TypeEnum type, String name, String surname, String stageName, Long birthYear, String biography, String nationality, ArtistDto.GenreEnum genre) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.stageName = stageName;
        this.birthYear = birthYear;
        this.biography = biography;
        this.nationality = nationality;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArtistDto.TypeEnum getType() {
        return type;
    }

    public void setType(ArtistDto.TypeEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Long getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public ArtistDto.GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(ArtistDto.GenreEnum genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtistEntity that)) return false;
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(stageName, that.stageName) && Objects.equals(birthYear, that.birthYear) && Objects.equals(biography, that.biography) && Objects.equals(nationality, that.nationality) && genre == that.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, surname, stageName, birthYear, biography, nationality, genre);
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", stageName='" + stageName + '\'' +
                ", birthYear=" + birthYear +
                ", biography='" + biography + '\'' +
                ", nationality='" + nationality + '\'' +
                ", genre=" + genre +
                '}';
    }

}
