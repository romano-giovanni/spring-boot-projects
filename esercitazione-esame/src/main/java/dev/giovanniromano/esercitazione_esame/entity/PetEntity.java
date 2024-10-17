package dev.giovanniromano.esercitazione_esame.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificatore;
    private String nome;
    private String etichetta;

    public PetEntity() {
    }

    public PetEntity(Long identifictore, String nome, String etichetta) {
        this.identificatore = identifictore;
        this.nome = nome;
        this.etichetta = etichetta;
    }

    public Long getIdentificatore() {
        return identificatore;
    }

    public void setIdentificatore(Long identifictore) {
        this.identificatore = identifictore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEtichetta() {
        return etichetta;
    }

    public void setEtichetta(String etichetta) {
        this.etichetta = etichetta;
    }
}
