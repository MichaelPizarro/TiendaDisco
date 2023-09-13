package com.discos.tienda.repository;

import com.discos.tienda.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IArtistaRepository extends JpaRepository<Artista,Integer> {

    @Query("SELECT NEW com.discos.tienda.dto.ArtistaDiscoDTO(d.titulo AS tituloDisco, a.nombre AS nombreArtista, d.anioLanzamiento AS anioLanzamiento, COUNT(c) AS cantPistas) " +
            "FROM Artista a " +
            "INNER JOIN a.artistasDiscos ad " +
            "INNER JOIN ad.disco d " +
            "LEFT JOIN d.canciones c " +
            "GROUP BY d.titulo, a.nombre, d.anioLanzamiento")
    public List<com.discos.tienda.dto.ArtistaDiscoDTO> findAllArtistas();

    @Query("SELECT NEW com.discos.tienda.dto.ArtistaDiscoDTO(disco.titulo as tituloDisco, artista.nombre as nombreArtista, disco.anioLanzamiento as anioLanzamiento, COUNT(c) as cantPistas) " +
            "FROM Artista artista " +
            "INNER JOIN artista.artistasDiscos artistasDiscos " +
            "INNER JOIN artistasDiscos.disco disco " +
            "LEFT JOIN disco.canciones c " +
            "WHERE CONCAT(disco.titulo, artista.nombre) LIKE %:palabraClave% " +
            "GROUP BY disco.titulo, artista.nombre, disco.anioLanzamiento")
    public List<com.discos.tienda.dto.ArtistaDiscoDTO> findAllArtistsByPalabraClave(@Param("palabraClave") String palabraClave);

    @Query("SELECT DISTINCT a.genero FROM Artista a ORDER BY a.genero")
    public List<String> findAllGeneros();
}
