package dev.giovanniromano.anagrafica.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="anagrafica")
public class AnagraficaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnagrafica;

    private String nome;

    private String cognome;

    private String telefono;

    private List<String> elencoEmail;

    private LocalDate dataNascita;

    public AnagraficaEntity() {
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getIdAnagrafica() {
        return idAnagrafica;
    }

    public void setIdAnagrafica(Long idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<String> getElencoEmail() {
        return elencoEmail;
    }

    public void setElencoEmail(List<String> elencoEmail) {
        this.elencoEmail = elencoEmail;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }
}
