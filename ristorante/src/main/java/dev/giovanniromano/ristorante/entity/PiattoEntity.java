package dev.giovanniromano.ristorante.entity;

import dev.giovanniromano.ristorante.model.PiattoDto;
import jakarta.persistence.*;

@Entity
@Table(name="piatto")
public class PiattoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="ingredienti")
    private String ingredienti;

    @Column(name="costo_cliente")
    private Float costoCliente;

    @Column(name="tipo_pietanza")
    @Enumerated(EnumType.STRING)
    private PiattoDto.TipologiaEnum tipoPietanza;

    @Column(name="costo_produzione")
    private Float costoProduzione;

    @Column(name="file_foto")
    private String fileFoto;

    public PiattoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public Float getCostoCliente() {
        return costoCliente;
    }

    public void setCostoCliente(Float costoCliente) {
        this.costoCliente = costoCliente;
    }

    public PiattoDto.TipologiaEnum getTipoPietanza() {
        return tipoPietanza;
    }

    public void setTipoPietanza(PiattoDto.TipologiaEnum tipoPietanza) {
        this.tipoPietanza = tipoPietanza;
    }

    public Float getCostoProduzione() {
        return costoProduzione;
    }

    public void setCostoProduzione(Float costoProduzione) {
        this.costoProduzione = costoProduzione;
    }

    public String getFileFoto() {
        return fileFoto;
    }

    public void setFileFoto(String fileFoto) {
        this.fileFoto = fileFoto;
    }


}
