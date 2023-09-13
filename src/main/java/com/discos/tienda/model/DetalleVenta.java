package com.discos.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleVenta {

    private Integer idDetalleVenta;
    private Integer cantidad;
    private Double precioUnitario;
    private String genero;
    private String artista;

    public DetalleVenta(Integer idDetalleVenta, Integer cantidad, Double precioUnitario) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
}
