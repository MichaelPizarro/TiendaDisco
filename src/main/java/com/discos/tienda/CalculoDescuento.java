package com.discos.tienda;

import com.discos.tienda.model.DetalleVenta;

import java.util.List;

public interface CalculoDescuento {

    public double obtenerDescuento(List<DetalleVenta> detalleVentaList);
}
