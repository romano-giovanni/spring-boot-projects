package dev.giovanniromano.ristorante.entity;

import dev.giovanniromano.ristorante.model.PiattoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
}
