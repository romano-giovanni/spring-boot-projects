package dev.giovanniromano.museo.entity;

import dev.giovanniromano.museo.model.OperaDto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "opera")
public class OperaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpera;

    private String nomeOpera;

    private Integer idAutore;

    private String nomeAutore;

    private Integer annoProduzione;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private OperaDto.TipologiaEnum tipologia;

    public OperaEntity() {
    }

    public OperaEntity(Integer idOpera, String nomeOpera, Integer idAutore, String nomeAutore, Integer annoProduzione, String descrizione, OperaDto.TipologiaEnum tipologia) {
        this.idOpera = idOpera;
        this.nomeOpera = nomeOpera;
        this.idAutore = idAutore;
        this.nomeAutore = nomeAutore;
        this.annoProduzione = annoProduzione;
        this.descrizione = descrizione;
        this.tipologia = tipologia;
    }

    public Integer getIdOpera() {
        return idOpera;
    }

    public void setIdOpera(Integer idOpera) {
        this.idOpera = idOpera;
    }

    public String getNomeOpera() {
        return nomeOpera;
    }

    public void setNomeOpera(String nomeOpera) {
        this.nomeOpera = nomeOpera;
    }

    public Integer getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(Integer idAutore) {
        this.idAutore = idAutore;
    }

    public String getNomeAutore() {
        return nomeAutore;
    }

    public void setNomeAutore(String nomeAutore) {
        this.nomeAutore = nomeAutore;
    }

    public Integer getAnnoProduzione() {
        return annoProduzione;
    }

    public void setAnnoProduzione(Integer annoProduzione) {
        this.annoProduzione = annoProduzione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public OperaDto.TipologiaEnum getTipologia() {
        return tipologia;
    }

    public void setTipologia(OperaDto.TipologiaEnum tipologia) {
        this.tipologia = tipologia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperaEntity that)) return false;
        return Objects.equals(idOpera, that.idOpera) && Objects.equals(nomeOpera, that.nomeOpera) && Objects.equals(idAutore, that.idAutore) && Objects.equals(nomeAutore, that.nomeAutore) && Objects.equals(annoProduzione, that.annoProduzione) && Objects.equals(descrizione, that.descrizione) && tipologia == that.tipologia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOpera, nomeOpera, idAutore, nomeAutore, annoProduzione, descrizione, tipologia);
    }

    @Override
    public String toString() {
        return "OperaEntity{" +
                "idOpera=" + idOpera +
                ", nomeOpera='" + nomeOpera + '\'' +
                ", idAutore=" + idAutore +
                ", nomeAutore='" + nomeAutore + '\'' +
                ", annoProduzione=" + annoProduzione +
                ", descrizione='" + descrizione + '\'' +
                ", tipologia=" + tipologia +
                '}';
    }
}
