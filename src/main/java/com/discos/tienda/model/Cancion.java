package com.discos.tienda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcancion")
    private Integer idCancion;

    @Column(name = "titulo",length = 50)
    private String titulo;

    @Column(name = "duracion")
    private Integer duracion;

    @ManyToOne
    @JoinColumn(name = "discos_iddisco")
    private Disco disco;
}
