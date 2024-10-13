package dev.giovanniromano.museo.entity;

import dev.giovanniromano.museo.model.ArtistaDto;
import jakarta.persistence.*;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.Objects;

@Entity
@Table(name = "artista")
public class ArtistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArtista;

    private String nomeArtista;

    private Integer annoNascita;

    private JsonNullable<Integer> annoMorte;

    private String biografia;

    private String nazionalita;

    @Enumerated(EnumType.STRING)
    private ArtistaDto.TipologiaArtistaEnum tipologiaArtista;

    public ArtistaEntity() {
    }

    public ArtistaEntity(Integer idArtista, String nomeArtista, Integer annoNascita, JsonNullable<Integer> annoMorte, String biografia, String nazionalita, ArtistaDto.TipologiaArtistaEnum tipologiaArtista) {
        this.idArtista = idArtista;
        this.nomeArtista = nomeArtista;
        this.annoNascita = annoNascita;
        this.annoMorte = annoMorte;
        this.biografia = biografia;
        this.nazionalita = nazionalita;
        this.tipologiaArtista = tipologiaArtista;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public Integer getAnnoNascita() {
        return annoNascita;
    }

    public void setAnnoNascita(Integer annoNascita) {
        this.annoNascita = annoNascita;
    }

    public JsonNullable<Integer> getAnnoMorte() {
        return annoMorte;
    }

    public void setAnnoMorte(JsonNullable<Integer> annoMorte) {
        this.annoMorte = annoMorte;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public ArtistaDto.TipologiaArtistaEnum getTipologiaArtista() {
        return tipologiaArtista;
    }

    public void setTipologiaArtista(ArtistaDto.TipologiaArtistaEnum tipologiaArtista) {
        this.tipologiaArtista = tipologiaArtista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtistaEntity that)) return false;
        return Objects.equals(idArtista, that.idArtista) && Objects.equals(nomeArtista, that.nomeArtista) && Objects.equals(annoNascita, that.annoNascita) && Objects.equals(annoMorte, that.annoMorte) && Objects.equals(biografia, that.biografia) && Objects.equals(nazionalita, that.nazionalita) && tipologiaArtista == that.tipologiaArtista;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArtista, nomeArtista, annoNascita, annoMorte, biografia, nazionalita, tipologiaArtista);
    }

    @Override
    public String toString() {
        return "ArtistaEntity{" +
                "idArtista=" + idArtista +
                ", nomeArtista='" + nomeArtista + '\'' +
                ", annoNascita=" + annoNascita +
                ", annoMorte=" + annoMorte +
                ", biografia='" + biografia + '\'' +
                ", nazionalità='" + nazionalita + '\'' +
                ", tipologiaArtista=" + tipologiaArtista +
                '}';
    }
}
