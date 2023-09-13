package com.discos.tienda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idartista")
    private Integer idArtista;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "genero",length = 45)
    private String genero;

    @Column(name = "pais_origen",length = 45)
    private String paisOrigen;

    @OneToMany(mappedBy = "artista")
    private List<ArtistaDisco> artistasDiscos;
}
