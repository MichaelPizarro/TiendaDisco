package com.discos.tienda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiscoDTO {

    private Integer idDisco;

    private String titulo;

    private String anioLanzamiento;
}
