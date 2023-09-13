package com.discos.tienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "discos")
public class Disco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddisco")
    private Integer idDisco;

    @Column(name = "titulo",length = 50)
    private String titulo;

    @Column(name = "anio_lanzamiento",length = 5)
    private String anioLanzamiento;

    @OneToMany(mappedBy = "disco")
    private List<ArtistaDisco> artistasDiscos;

    @OneToMany(mappedBy = "disco")
    private List<Cancion> canciones;
}


