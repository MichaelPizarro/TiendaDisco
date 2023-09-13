package com.discos.tienda;

import com.discos.tienda.model.DetalleVenta;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TiendaDiscosApplicationTests {

	private List<DetalleVenta> detalleVentaList;
	private CalculoDescuentoImpl1 calculoDescuentoImpl1;

	public TiendaDiscosApplicationTests() {
		detalleVentaList = new ArrayList<>();
		calculoDescuentoImpl1 = new CalculoDescuentoImpl1();
	}


	@Test
	public void testObtenerDescuentoDescuento5Porciento() {
		detalleVentaList.add(new DetalleVenta(1, 5, 10.0)); // 5% de descuento

		double descuento = calculoDescuentoImpl1.obtenerDescuento(detalleVentaList);

		assertEquals(2.5, descuento, 0.001);
	}

	@Test
	public void testObtenerDescuentoDescuento7Porciento() {
		detalleVentaList.add(new DetalleVenta(1, 7, 20.0));

		double descuento = calculoDescuentoImpl1.obtenerDescuento(detalleVentaList);

		assertEquals(9.8, descuento, 0.001);
	}

	@Test
	public void testObtenerDescuentoDescuento10Porciento() {

		detalleVentaList.add(new DetalleVenta(1, 10, 30.0));

		double descuento = calculoDescuentoImpl1.obtenerDescuento(detalleVentaList);

		assertEquals(30.0, descuento, 0.001);
	}

	@Test
	public void testObtenerDescuento() {

		DetalleVenta rock1 = new DetalleVenta(1, 2, 10.0, "Rock", "Artista1");
		DetalleVenta rock2 = new DetalleVenta(2, 3, 12.0, "Rock", "Artista2");
		DetalleVenta baladas1 = new DetalleVenta(3, 3, 15.0, "Baladas", "Artista3");
		DetalleVenta arjona1 = new DetalleVenta(4, 1, 20.0, "OtroGénero", "Ricardo Arjona");


		List<DetalleVenta> detalleVentaList = new ArrayList<>();
		detalleVentaList.add(rock1);
		detalleVentaList.add(rock2);
		detalleVentaList.add(baladas1);
		detalleVentaList.add(arjona1);

		CalculoDescuentoImpl2 calculoDescuentoImpl2 = new CalculoDescuentoImpl2();

		double descuento = calculoDescuentoImpl2.obtenerDescuento(detalleVentaList);

		assertEquals(0.06 * 5 + 0.05 * 3 + 0.08 * 1, descuento, 0.001);
	}

}
