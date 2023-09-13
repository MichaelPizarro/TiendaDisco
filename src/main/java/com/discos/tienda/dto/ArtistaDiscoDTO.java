package com.discos.tienda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ArtistaDiscoDTO {

    private String tituloDisco;
    private String nombreArtista;
    private String anioLanzamiento;
    private Long cantPistas;

    public ArtistaDiscoDTO(String tituloDisco, String nombreArtista) {
        this.tituloDisco = tituloDisco;
        this.nombreArtista = nombreArtista;
    }
}
