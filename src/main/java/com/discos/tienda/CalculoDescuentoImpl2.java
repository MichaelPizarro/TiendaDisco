package com.discos.tienda;

import com.discos.tienda.model.DetalleVenta;

import java.util.List;

public class CalculoDescuentoImpl2 implements CalculoDescuento{
    @Override
    public double obtenerDescuento(List<DetalleVenta> detalleVentaList) {
        double descuentoTotal = 0;

        int cantidadDiscosRock = 0;
        int cantidadDiscosBaladas = 0;
        int cantidadDiscosRicardoArjona = 0;

        for (DetalleVenta detalle : detalleVentaList) {
            if ("Rock".equals(detalle.getGenero())) {
                cantidadDiscosRock += detalle.getCantidad();
            } else if ("Baladas".equals(detalle.getGenero())) {
                cantidadDiscosBaladas += detalle.getCantidad();
            }

            if ("Ricardo Arjona".equals(detalle.getArtista())) {
                cantidadDiscosRicardoArjona += detalle.getCantidad();
            }
        }

        // Aplicar descuento para género "Rock"
        if (cantidadDiscosRock >= 2) {
            descuentoTotal += 0.06 * cantidadDiscosRock;
        }

        // Aplicar descuento para género "Baladas"
        if (cantidadDiscosBaladas >= 3) {
            descuentoTotal += 0.05 * cantidadDiscosBaladas;
        }

        // Aplicar descuento para artista "Ricardo Arjona"
        if (cantidadDiscosRicardoArjona > 0) {
            descuentoTotal += 0.08 * cantidadDiscosRicardoArjona;
        }

        return descuentoTotal;
    }
}
