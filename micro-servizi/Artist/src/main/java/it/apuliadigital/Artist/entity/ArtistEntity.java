package it.apuliadigital.Artist.entity;

import jakarta.persistence.*;

import java.util.Objects;
import it.apuliadigital.Artist.model.Artist.TypeEnum;
import it.apuliadigital.Artist.model.Artist.GenreEnum;
@Entity
@Table(name="artist")
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
    private String name;
    private String surname;
    private String stageName;
    private Integer birthYear;
    private String biography;
    @Enumerated(EnumType.STRING)
    private GenreEnum genre;
    private String nationality;

    public ArtistEntity() {
    }

    public ArtistEntity(Long id, TypeEnum type, String name, String surname, String stageName, Integer birthYear, String biography, GenreEnum genre, String nationality) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.stageName = stageName;
        this.birthYear = birthYear;
        this.biography = biography;
        this.genre = genre;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistEntity that = (ArtistEntity) o;
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(stageName, that.stageName) && Objects.equals(birthYear, that.birthYear) && Objects.equals(biography, that.biography) && genre == that.genre && Objects.equals(nationality, that.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, surname, stageName, birthYear, biography, genre, nationality);
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
                ", genre=" + genre +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
