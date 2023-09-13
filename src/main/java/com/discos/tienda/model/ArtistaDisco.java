package com.discos.tienda.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "artistas_discos")
public class ArtistaDisco {

    @Id
    @ManyToOne
    @JoinColumn(name = "artistas_idartista")
    private Artista artista;

    @Id
    @ManyToOne
    @JoinColumn(name = "discos_iddisco")
    private Disco disco;
}
