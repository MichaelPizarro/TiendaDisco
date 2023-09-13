package com.discos.tienda;

import com.discos.tienda.model.DetalleVenta;

import java.util.List;

public class CalculoDescuentoImpl1 implements CalculoDescuento{
    @Override
    public double obtenerDescuento(List<DetalleVenta> detalleVentaList) {
        int totalDiscosComprados = 0;
        double descuentoTotal = 0;

        for (DetalleVenta detalleVenta : detalleVentaList) {
            int cantidad = detalleVenta.getCantidad();
            totalDiscosComprados += cantidad;
        }

        // Aplicar descuento según las reglas
        if (totalDiscosComprados >= 10) {
            descuentoTotal = calcularDescuento(totalDiscosComprados, 10, detalleVentaList);
        } else if (totalDiscosComprados >= 7) {
            descuentoTotal = calcularDescuento(totalDiscosComprados, 7, detalleVentaList);
        } else if (totalDiscosComprados >= 5) {
            descuentoTotal = calcularDescuento(totalDiscosComprados, 5, detalleVentaList);
        }

        return descuentoTotal;
    }

    private double calcularDescuento(int totalDiscosComprados, int cantidadMinima, List<DetalleVenta> detalleVentaList) {
        double descuentoTotal = 0;

        for (DetalleVenta detalleVenta : detalleVentaList) {
            int cantidad = detalleVenta.getCantidad();

            // Aplicar descuento solo a los elementos que tengan una cantidad igual o mayor a la cantidad mínima requerida.
            if (cantidad >= cantidadMinima) {
                double descuento = 0;
                double precioUnitario = detalleVenta.getPrecioUnitario();

                // Aplicar el descuento correspondiente según la cantidad comprada.
                if (cantidad >= 10) {
                    descuento = 0.10; // 10% de descuento
                } else if (cantidad >= 7) {
                    descuento = 0.07; // 7% de descuento
                } else if (cantidad >= 5) {
                    descuento = 0.05; // 5% de descuento
                }

                // Calcular el descuento aplicado al elemento y sumarlo al descuento total.
                double descuentoAplicado = descuento * precioUnitario * cantidad;
                descuentoTotal += descuentoAplicado;
            }
        }

        return descuentoTotal;
    }
}
